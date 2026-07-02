package pupkin.brewersdelight.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.item.BrewersItems;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BnCItems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BDAdvancementProvider extends ForgeAdvancementProvider
{
	public BDAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper)
	{
		super(output, lookupProvider, existingFileHelper, List.of(new BDAdvancementGenerator()));
	}
	
	public static class BDAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator
	{
		private static ResourceLocation getNameId(String id)
		{
			return ResourceLocation.fromNamespaceAndPath(BrewersDelight.MOD_ID, id);
		}
		
		/**
		 * A helper function that generates an advancement.
		 *
		 * @param consumer           The consumer to save the advancement.
		 * @param existingFileHelper The file helper.
		 * @param advancementId      The advancement’s id.
		 * @param parent             The parent advancement. This advancement is a root advancement if null.
		 * @param icon               The item to display as the icon.
		 * @param name               Advancement name.
		 * @param criteriaAdder      A lambda which adds criteria and requirements to the builder.
		 * @param background         Background for use in this advancement. Only used if parent is null.
		 * @param frame              The frame type for this advancement.
		 * @param rewards            Rewards for completing this advancement.
		 * @return The built advancement.
		 */
		private Advancement generateAdvancement(Consumer<Advancement> consumer,
		                                        ExistingFileHelper existingFileHelper,
		                                        ResourceLocation advancementId,
		                                        Advancement parent,
		                                        Item icon,
		                                        String name,
		                                        Consumer<Advancement.Builder> criteriaAdder,
		                                        ResourceLocation background,
		                                        FrameType frame,
		                                        AdvancementRewards rewards)
		{
			BrewersDelight.LOGGER.info("Generating advancement with id: {}", advancementId);
			Advancement.Builder builder = Advancement.Builder.advancement();
			if (parent != null) {
				builder.parent(parent);
			}
			builder.display(icon,
			                Component.translatable("advancements." + name + ".title"),
			                Component.translatable("advancements." + name + ".description"),
			                parent == null ? background : null,
			                frame, true, true, false);
			criteriaAdder.accept(builder);
			builder.rewards(rewards);
			BrewersDelight.LOGGER.info("Saving advancement with id: {}", advancementId);
			builder.save(consumer, advancementId, existingFileHelper);
			return builder.build(advancementId);
		}
		
		@Override
		public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<Advancement> consumer, @NotNull ExistingFileHelper existingFileHelper)
		{
			// root
			Advancement root = generateAdvancement(
					consumer,
					existingFileHelper,
					getNameId("root"),
					null,
					BrewersItems.BRAGA.get(),
					"root",
					builder -> {
						List<String> criteria = new ArrayList<>();
						addCriteriaFromRegistry(BnCItems.ITEMS, builder, criteria, "bc_");
						
						List.of(BrewersItems.DRINKS).forEach(reg -> addCriteriaFromRegistry(reg, builder, criteria));
						List.of(BrewersItems.CHALLENGE_DRINKS).forEach(reg -> addCriteriaFromRegistry(reg, builder, criteria));
						List.of(BrewersItems.VINTAGE_DRINKS).forEach(reg -> addCriteriaFromRegistry(reg, builder, criteria));
						builder.requirements(new String[][] { criteria.toArray(new String[0]) });
					},
					ResourceLocation.withDefaultNamespace("textures/block/oak_planks.png"),
					FrameType.TASK,
					AdvancementRewards.Builder.experience(100).build()
			                                      );
			
			// every_drink
			Advancement everyDrink = generateAdvancement(
					consumer,
					existingFileHelper,
					getNameId("every_drink"),
					root,
					BrewersItems.WHISKY.get(),
					"every_drink",
					builder -> {
						addCriteriaFromRegistry(BnCItems.ITEMS, builder, null, "bc_");
						List.of(BrewersItems.DRINKS).forEach(reg -> addCriteriaFromRegistry(reg, builder, null));
						List.of(BrewersItems.VINTAGE_DRINKS).forEach(reg -> addCriteriaFromRegistry(reg, builder, null));
					},
					null,
					FrameType.GOAL,
					AdvancementRewards.Builder.experience(100).build()
			                                            );
			
			// any_vintage_drink
			Advancement anyVintageDrink = generateAdvancement(
					consumer,
					existingFileHelper,
					getNameId("any_vintage_drink"),
					root,
					BrewersItems.SBITEN.get(),
					"any_vintage_drink",
					builder -> {
						List<String> criteria = new ArrayList<>();
						addCriteriaFromRegistry(BrewersItems.VINTAGE_DRINKS, builder, criteria);
						builder.requirements(new String[][] { criteria.toArray(new String[0]) });
					},
					null,
					FrameType.CHALLENGE,
					AdvancementRewards.Builder.experience(100).build()
			                                                 );
			
			// every_vintage_drink
			generateAdvancement(
					consumer,
					existingFileHelper,
					getNameId("every_vintage_drink"),
					anyVintageDrink,
					BrewersItems.VZVAR.get(),
					"every_vintage_drink",
					builder -> {
						addCriteriaFromRegistry(BrewersItems.VINTAGE_DRINKS, builder, null);
					},
					null,
					FrameType.GOAL,
					AdvancementRewards.Builder.experience(100).build()
			                   );
			
			// any_challenge_drink
			Advancement anyChallengeDrink = generateAdvancement(
					consumer,
					existingFileHelper,
					getNameId("any_challenge_drink"),
					root,
					BrewersItems.FLAXEN_CHEESE_STOUT.get(),
					"any_challenge_drink",
					builder -> {
						List<String> criteria = new ArrayList<>();
						addCriteriaFromRegistry(BnCItems.ITEMS, builder, criteria, "bc_");
						List.of(BrewersItems.CHALLENGE_DRINKS).forEach(reg -> addCriteriaFromRegistry(reg, builder, criteria));
						builder.requirements(new String[][] { criteria.toArray(new String[0]) });
					},
					null,
					FrameType.CHALLENGE,
					AdvancementRewards.Builder.experience(100).build()
			                                                   );
			
			// every_challenge_drink
			generateAdvancement(
					consumer,
					existingFileHelper,
					getNameId("every_challenge_drink"),
					anyChallengeDrink,
					BrewersItems.GUT_WRECKER.get(),
					"every_challenge_drink",
					builder -> {
						addCriterion(builder, BnCItems.DREAD_NOG, "bc_");
						addCriterion(builder, BnCItems.STEEL_TOE_STOUT, "bc_");
						addCriterion(builder, BnCItems.WITHERING_DROSS, "bc_");
						addCriteriaFromRegistry(BrewersItems.CHALLENGE_DRINKS, builder, null);
					},
					null,
					FrameType.GOAL,
					AdvancementRewards.Builder.experience(100).build()
			                   );
		}
		
		private void addCriteriaFromRegistry(DeferredRegister<Item> registry, Advancement.Builder builder, List<String> criteriaList)
		{
			addCriteriaFromRegistry(registry, builder, criteriaList, "");
		}
		
		private void addCriteriaFromRegistry(DeferredRegister<Item> registry, Advancement.Builder builder,
		                                     List<String> criteriaList, String prefix)
		{
			// Merge "<name>" and "<name>_glass" into one criterion
			Map<String, List<ItemLike>> byBaseName = new LinkedHashMap<>();
			
			registry.getEntries().forEach(entry -> {
				Item item = entry.get();
				if (!(item instanceof BoozeItem)) {
					BrewersDelight.LOGGER.debug("Skipping adding criterion for non-drink item : {}",
					                            item.getName(item.getDefaultInstance()));
					return;
				}
				assert entry.getId() != null;
				String path = entry.getId().getPath();
				String base = path.endsWith("_glass")
						? path.substring(0, path.length() - "_glass".length())
						: path;
				byBaseName.computeIfAbsent(base, k -> new ArrayList<>()).add(item);
			});
			
			byBaseName.forEach((base, variants) -> {
				String key = prefix + base;
				BrewersDelight.LOGGER.debug("Adding criterion : {} matching {} variant(s)", key, variants.size());
				builder.addCriterion(key, InventoryChangeTrigger.TriggerInstance.hasItems(
						ItemPredicate.Builder.item().of(variants.toArray(new ItemLike[0])).build()
				                                                                         ));
				if (criteriaList != null) {
					criteriaList.add(key);
				}
			});
		}
		
		private void addCriterion(Advancement.Builder builder, RegistryObject<Item> item)
		{
			assert item.getId() != null;
			String key = item.getId().getPath();
			BrewersDelight.LOGGER.debug("Adding criterion for item : {} with id : {} to advancement builder : {}", item, key, builder);
			builder.addCriterion(key, InventoryChangeTrigger.TriggerInstance.hasItems(item.get().asItem()));
		}
		
		private void addCriterion(Advancement.Builder builder, RegistryObject<Item> item, String prefix)
		{
			assert item.getId() != null;
			String key = prefix + item.getId().getPath();
			BrewersDelight.LOGGER.debug("Adding criterion for item : {} with id : {} to advancement builder : {} as : {}{}", item, key, builder, prefix, key);
			builder.addCriterion(key, InventoryChangeTrigger.TriggerInstance.hasItems(item.get().asItem()));
		}
	}
}
