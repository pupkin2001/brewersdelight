package pupkin.brewersdelight.client;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.misc.AlcoholFluidType;
import pupkin.brewersdelight.misc.BrewersFluids;

// Replaces FluidType#initializeClient, which NeoForge removed: tinted water textures for every alcohol fluid.
@EventBusSubscriber(modid = BrewersDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BrewersFluidRenderers
{
	private static final ResourceLocation
			FLUID_STILL_TEXTURE = ResourceLocation.withDefaultNamespace("block/water_still"),
			FLUID_FLOWING_TEXTURE = ResourceLocation.withDefaultNamespace("block/water_flow");

	@SubscribeEvent
	public static void registerClientExtensions(RegisterClientExtensionsEvent event)
	{
		BrewersFluids.FLUID_TYPES.getEntries().forEach(entry -> {
			FluidType type = entry.get();
			if (type instanceof AlcoholFluidType alcohol) {
				event.registerFluidType(alcoholExtension(alcohol.getTintColor()), type);
			}
		});
	}

	private static IClientFluidTypeExtensions alcoholExtension(int tintColor)
	{
		return new IClientFluidTypeExtensions()
		{
			@Override
			public @NotNull ResourceLocation getStillTexture()
			{
				return FLUID_STILL_TEXTURE;
			}

			@Override
			public @NotNull ResourceLocation getFlowingTexture()
			{
				return FLUID_FLOWING_TEXTURE;
			}

			@Override
			public int getTintColor()
			{
				return tintColor;
			}
		};
	}
}
