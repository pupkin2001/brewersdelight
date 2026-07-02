package pupkin.brewersdelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import pupkin.brewersdelight.BrewersDelight;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = BrewersDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event)
	{
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		
		BDBlockTagProvider blockTags = new BDBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
		generator.addProvider(event.includeServer(), blockTags);
		generator.addProvider(event.includeClient(), new BDItemModelProvider(packOutput, existingFileHelper));
		generator.addProvider(event.includeServer(), new BDItemTagProvider(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
		generator.addProvider(event.includeServer(), new BDAdvancementProvider(packOutput, lookupProvider, existingFileHelper));
		generator.addProvider(event.includeServer(), new BDRecipeProvider(packOutput));
		generator.addProvider(event.includeServer(), new BDFluidDisplayProvider(packOutput));
	}
}
