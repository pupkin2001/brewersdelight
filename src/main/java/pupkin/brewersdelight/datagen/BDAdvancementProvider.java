package pupkin.brewersdelight.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
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
import java.util.List;
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
			return new ResourceLocation(BrewersDelight.MOD_ID, id);
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
						
						List.of(BrewersItems.BEVERAGES).forEach(reg -> addCriteriaFromRegistry(reg, builder, criteria));
						List.of(BrewersItems.COMPAT_BEVERAGES).forEach(reg -> addCriteriaFromRegistry(reg, builder, criteria));
						List.of(BrewersItems.CHALLENGE_BEVERAGES).forEach(reg -> addCriteriaFromRegistry(reg, builder, criteria));
						List.of(BrewersItems.VINTAGE_BEVERAGES).forEach(reg -> addCriteriaFromRegistry(reg, builder, criteria));
						builder.requirements(new String[][] { criteria.toArray(new String[0]) });
					},
					new ResourceLocation("minecraft", "textures/block/oak_planks.png"),
					FrameType.TASK,
					AdvancementRewards.Builder.experience(100).build()
			                                      );
			
			// every_beverage
			Advancement everyBeverage = generateAdvancement(
					consumer,
					existingFileHelper,
					getNameId("every_beverage"),
					root,
					BrewersItems.WHISKY.get(),
					"every_beverage",
					builder -> {
						addCriteriaFromRegistry(BnCItems.ITEMS, builder, null, "bc_");
						List.of(BrewersItems.BEVERAGES).forEach(reg -> addCriteriaFromRegistry(reg, builder, null));
						List.of(BrewersItems.COMPAT_BEVERAGES).forEach(reg -> addCriteriaFromRegistry(reg, builder, null));
						List.of(BrewersItems.VINTAGE_BEVERAGES).forEach(reg -> addCriteriaFromRegistry(reg, builder, null));
					},
					null,
					FrameType.GOAL,
					AdvancementRewards.Builder.experience(100).build()
			                                               );
			
			// any_challenge_beverage
			Advancement anyChallengeBeverage = generateAdvancement(
					consumer,
					existingFileHelper,
					getNameId("any_challenge_beverage"),
					root,
					BrewersItems.FLAXEN_CHEESE_STOUT.get(),
					"any_challenge_beverage",
					builder -> {
						List<String> criteria = new ArrayList<>();
						addCriteriaFromRegistry(BnCItems.ITEMS, builder, criteria, "bc_");
						List.of(BrewersItems.CHALLENGE_BEVERAGES).forEach(reg -> addCriteriaFromRegistry(reg, builder, criteria));
						builder.requirements(new String[][] { criteria.toArray(new String[0]) });
					},
					null,
					FrameType.CHALLENGE,
					AdvancementRewards.Builder.experience(100).build()
			                                                      );
			
			// every_challenge_beverage
			generateAdvancement(
					consumer,
					existingFileHelper,
					getNameId("every_challenge_beverage"),
					anyChallengeBeverage,
					BrewersItems.GUT_WRECKER.get(),
					"every_challenge_beverage",
					builder -> {
						addCriterion(builder, BnCItems.DREAD_NOG, "bc_");
						addCriterion(builder, BnCItems.STEEL_TOE_STOUT, "bc_");
						addCriterion(builder, BnCItems.WITHERING_DROSS, "bc_");
						addCriteriaFromRegistry(BrewersItems.CHALLENGE_BEVERAGES, builder, null);
					},
					null,
					FrameType.GOAL,
					AdvancementRewards.Builder.experience(100).build()
			                   );
			
			// any_vintage_beverage
			Advancement anyVintageBeverage = generateAdvancement(
					consumer,
					existingFileHelper,
					getNameId("any_vintage_beverage"),
					root,
					BrewersItems.SBITEN.get(),
					"any_vintage_beverage",
					builder -> {
						List<String> criteria = new ArrayList<>();
						addCriteriaFromRegistry(BrewersItems.VINTAGE_BEVERAGES, builder, criteria);
						builder.requirements(new String[][] { criteria.toArray(new String[0]) });
					},
					null,
					FrameType.CHALLENGE,
					AdvancementRewards.Builder.experience(100).build()
			                                                    );
			
			// every_vintage_beverage
			generateAdvancement(
					consumer,
					existingFileHelper,
					getNameId("every_vintage_beverage"),
					anyVintageBeverage,
					BrewersItems.VZVAR.get(),
					"every_vintage_beverage",
					builder -> {
						addCriteriaFromRegistry(BrewersItems.VINTAGE_BEVERAGES, builder, null);
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
		
		private void addCriteriaFromRegistry(DeferredRegister<Item> registry, Advancement.Builder builder, List<String> criteriaList, String prefix)
		{
			registry.getEntries().forEach(entry -> {
				Item item = entry.get();
				if (!(item instanceof BoozeItem)) {
					BrewersDelight.LOGGER.debug("Skipping adding criterion for non-beverage item : {}", item.getName(item.getDefaultInstance()));
					return;
				}
				String key = prefix + entry.getId().getPath();
				BrewersDelight.LOGGER.debug("Adding criterion for item : {} from registry : {} with id : {} as : {}{}", item, registry, key, prefix, key);
				builder.addCriterion(key, InventoryChangeTrigger.TriggerInstance.hasItems(item));
				if (criteriaList != null) {
					criteriaList.add(key);
				}
			});
		}
		
		private void addCriterion(Advancement.Builder builder, RegistryObject<Item> item)
		{
			String key = item.getId().getPath();
			BrewersDelight.LOGGER.debug("Adding criterion for item : {} with id : {} to advancement builder : {}", item, key, builder);
			builder.addCriterion(key, InventoryChangeTrigger.TriggerInstance.hasItems(item.get().asItem()));
		}
		
		private void addCriterion(Advancement.Builder builder, RegistryObject<Item> item, String prefix)
		{
			String key = prefix + item.getId().getPath();
			BrewersDelight.LOGGER.debug("Adding criterion for item : {} with id : {} to advancement builder : {} as : {}{}", item, key, builder, prefix, key);
			builder.addCriterion(key, InventoryChangeTrigger.TriggerInstance.hasItems(item.get().asItem()));
		}
	}
}
