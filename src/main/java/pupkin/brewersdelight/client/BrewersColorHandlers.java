package pupkin.brewersdelight.client;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.block.BrewersBlocks;

@EventBusSubscriber(modid = BrewersDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BrewersColorHandlers
{
	
	@SubscribeEvent
	public static void registerBlockColors(RegisterColorHandlersEvent.Block event)
	{
		event.register(
				(state, level, pos, tintIndex) -> level != null && pos != null
						? BiomeColors.getAverageGrassColor(level, pos)
						: GrassColor.getDefaultColor(),
				BrewersBlocks.CATTAIL.get()
		              );
	}
}
