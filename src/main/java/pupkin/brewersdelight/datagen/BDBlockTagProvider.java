package pupkin.brewersdelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.block.BrewersBlocks;
import umpaz.brewinandchewin.common.tag.BnCTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BDBlockTagProvider extends BlockTagsProvider
{
	public BDBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
	{
		super(output, lookupProvider, BrewersDelight.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider)
	{
		tag(BnCTags.Blocks.CHEESE_WHEELS_RIPE).add(BrewersBlocks.FROSTSTONE_CHEESE_WHEEL.get());
		tag(BnCTags.Blocks.CHEESE_WHEELS_UNRIPE).add(BrewersBlocks.UNRIPE_FROSTSTONE_CHEESE_WHEEL.get());
		tag(ModTags.Blocks.MINEABLE_WITH_KNIFE).add(BrewersBlocks.UNRIPE_FROSTSTONE_CHEESE_WHEEL.get(),
		                                            BrewersBlocks.FROSTSTONE_CHEESE_WHEEL.get());
	}
}
