package pupkin.brewersdelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BDBlockTagProvider extends BlockTagsProvider
{
	public BDBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
	{
		super(output, lookupProvider, BrewersDelight.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider) {}
}
