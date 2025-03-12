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
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.item.BrewersItems;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BCItems;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends ForgeAdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, existingFileHelper, List.of(
                new RootAdvancementGenerator(),
                new EveryBeverageAdvancementGenerator()
        ));
    }
}

// root
class RootAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {
    public static Advancement ROOT_ADVANCEMENT;

    @Override
    public void generate(HolderLookup.@NotNull Provider provider, Consumer<Advancement> consumer, @NotNull ExistingFileHelper existingFileHelper) {
        List<String> criteriaKeys = new ArrayList<>();
        Advancement.Builder builder = Advancement.Builder.advancement()
                .display(
                        BrewersItems.BRAGA.get(),
                        Component.translatable("advancements.root.title"),
                        Component.translatable("advancements.root.description"),
                        new ResourceLocation("minecraft", "textures/block/stone.png"),
                        FrameType.TASK,
                        true,  // announce_to_chat
                        true,  // show_toast
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(50));

        BCItems.ITEMS.getEntries().forEach(entry -> {
            Item item = entry.get();
            String key = entry.getId().getNamespace().equals("brewinandchewin")
                    ? "bc_" + entry.getId().getPath()
                    : entry.getId().getPath();
            criteriaKeys.add(key);
            builder.addCriterion(key, InventoryChangeTrigger.TriggerInstance.hasItems(item));
        });
        List.of(
                BrewersItems.BEVERAGES,
                BrewersItems.CHALLENGE_BEVERAGES,
                BrewersItems.VINTAGE_BEVERAGES,
                BrewersItems.COMPAT_BEVERAGES
        ).forEach(registry ->
                registry.getEntries().forEach(entry -> {
                    Item item = entry.get();
                    String key = entry.getId().getPath();
                    criteriaKeys.add(key);
                    builder.addCriterion(key, InventoryChangeTrigger.TriggerInstance.hasItems(item));
                })
        );
        builder.requirements(new String[][]{criteriaKeys.toArray(new String[0])});

        ROOT_ADVANCEMENT = builder.build(new ResourceLocation(BrewersDelight.MOD_ID, "root"));
        consumer.accept(ROOT_ADVANCEMENT);
    }
}

// every beverage
class EveryBeverageAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.@NotNull Provider provider, @NotNull Consumer<Advancement> consumer, @NotNull ExistingFileHelper existingFileHelper) {
        if (RootAdvancementGenerator.ROOT_ADVANCEMENT == null) {
            throw new IllegalStateException("Root advancement must be generated before beverage advancements!");
        }
        Advancement.Builder builder = Advancement.Builder.advancement()
                .parent(RootAdvancementGenerator.ROOT_ADVANCEMENT)
                .display(
                        BrewersItems.WHISKY.get(),
                        Component.translatable("advancements.every_beverage.title"),
                        Component.translatable("advancements.every_beverage.description"),
                        null,
                        FrameType.GOAL,
                        true,
                        true,
                        false
                );
        BCItems.ITEMS.getEntries().forEach(entry -> {
            Item item = entry.get();
            if (item instanceof BoozeItem) {
                String key = entry.getId().getNamespace().equals("brewinandchewin")
                        ? "bc_" + entry.getId().getPath()
                        : entry.getId().getPath();
                builder.addCriterion(key, InventoryChangeTrigger.TriggerInstance.hasItems(item));
            }
        });
        List.of(
                BrewersItems.BEVERAGES,
                BrewersItems.CHALLENGE_BEVERAGES,
                BrewersItems.VINTAGE_BEVERAGES,
                BrewersItems.COMPAT_BEVERAGES
        ).forEach(registry ->
                registry.getEntries().forEach(entry -> {
                    Item item = entry.get();
                    if (item instanceof BoozeItem) {
                        String key = entry.getId().getPath();
                        builder.addCriterion(key, InventoryChangeTrigger.TriggerInstance.hasItems(item));
                    }
                })
        );
        builder.rewards(AdvancementRewards.Builder.experience(100))
                .save(consumer, ResourceLocation.tryParse(BrewersDelight.MOD_ID + ":every_beverage"), existingFileHelper);
    }
}
