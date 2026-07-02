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
import umpaz.brewinandchewin.common.registry.BnCItems;
import umpaz.brewinandchewin.common.tag.BnCTags;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BDItemTagProvider extends ItemTagsProvider
{
	public BDItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider,
	                         CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider,
	                         @Nullable ExistingFileHelper existingFileHelper)
	{
		super(output, provider, blockTagProvider, BrewersDelight.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider)
	{
		List<DeferredRegister<Item>> drinkRegistries = List.of(
				BrewersItems.DRINKS,
				BrewersItems.VINTAGE_DRINKS,
				BrewersItems.CHALLENGE_DRINKS
		                                                      );
		
		drinkRegistries.forEach(registry ->
				                        addBoozeItems(registry, BnCTags.FERMENTED_DRINKS)
		                       );
		
		addBoozeItems(BrewersItems.VINTAGE_DRINKS, BrewersTags.VINTAGE_DRINKS);
		assert BnCItems.DREAD_NOG.getKey() != null;
		tag(BrewersTags.CHALLENGE_DRINKS).add(BnCItems.DREAD_NOG.getKey());
		assert BnCItems.STEEL_TOE_STOUT.getKey() != null;
		tag(BrewersTags.CHALLENGE_DRINKS).add(BnCItems.STEEL_TOE_STOUT.getKey());
		assert BnCItems.WITHERING_DROSS.getKey() != null;
		tag(BrewersTags.CHALLENGE_DRINKS).add(BnCItems.WITHERING_DROSS.getKey());
		addBoozeItems(BrewersItems.CHALLENGE_DRINKS, BrewersTags.CHALLENGE_DRINKS);
	}
	
	private void addBoozeItems(DeferredRegister<Item> registry, TagKey<Item> tagKey)
	{
		registry.getEntries().forEach(item -> {
			assert item.getKey() != null;
			if (item.get() instanceof BoozeItem) {
				tag(tagKey).add(item.getKey());
			}
		});
	}
}
