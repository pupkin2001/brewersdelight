package pupkin.brewersdelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.item.BrewersItems;
import pupkin.brewersdelight.tag.BrewersTags;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BCItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider,
                              CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider,
                              @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, BrewersDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        List<? extends DeferredRegister> beverageRegistries = List.of(
                BCItems.ITEMS,
                BrewersItems.BEVERAGES,
                BrewersItems.CHALLENGE_BEVERAGES,
                BrewersItems.VINTAGE_BEVERAGES,
                BrewersItems.COMPAT_BEVERAGES
        );

        beverageRegistries.forEach(registry ->
                addBoozeItems(registry, BrewersTags.BEVERAGES)
        );

        addBoozeItems(BrewersItems.CHALLENGE_BEVERAGES, BrewersTags.CHALLENGE_BEVERAGES);
        addBoozeItems(BrewersItems.VINTAGE_BEVERAGES, BrewersTags.VINTAGE_BEVERAGES);
    }

    private void addBoozeItems(DeferredRegister<Item> registry, TagKey tagKey) {
        registry.getEntries().forEach(item -> {
            assert item.getKey() != null;
            if (item.get() instanceof BoozeItem) {
                tag(tagKey).add(item.getKey());
            }
        });
    }
}
