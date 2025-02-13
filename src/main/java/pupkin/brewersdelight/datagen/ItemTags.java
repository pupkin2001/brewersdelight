package pupkin.brewersdelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.item.BrewersItems;
import pupkin.brewersdelight.tag.BrewersTags;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BCItems;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider
{
	public ItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider,
	                CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider,
	                @Nullable ExistingFileHelper existingFileHelper)
	{
		super(output, provider, blockTagProvider, BrewersDelight.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider)
	{
		// Mod Tags
		BCItems.ITEMS.getEntries().forEach(item -> {
			assert item.getKey() != null;
			if (item.get() instanceof BoozeItem) {
				tag(BrewersTags.BEVERAGES).add(item.getKey());
			}
		});
		
		BrewersItems.ITEMS.getEntries().forEach(item -> {
			assert item.getKey() != null;
			tag(BrewersTags.BEVERAGES).add(item.getKey());
		});
	}
}
