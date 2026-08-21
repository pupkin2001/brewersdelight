package pupkin.brewersdelight.client;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.block.BrewersBlocks;

@Mod.EventBusSubscriber(modid = BrewersDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BrewersColorHandlers {
	
	@SubscribeEvent
	public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
		event.register(
				(state, level, pos, tintIndex) -> level != null && pos != null
						? BiomeColors.getAverageGrassColor(level, pos)
						: GrassColor.getDefaultColor(),
				BrewersBlocks.CATTAIL.get()
		              );
	}
}