package pupkin.brewersdelight.misc;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistries.Keys;
import net.minecraftforge.registries.RegistryObject;
import pupkin.brewersdelight.BrewersDelight;
import umpaz.brewinandchewin.common.fluid.AlcoholFluidType;

public class BrewersFluids
{
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(Keys.FLUID_TYPES, BrewersDelight.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, BrewersDelight.MOD_ID);
	
	// Braga fluid
	public static final FluidRegistryObject BRAGA = registerAlcoholFluid("braga", 0x00FF0000);
	
	// I really should've copied the fluid registration code from BnC, but I'm in the middle of the sunk cost fallacy
	// also I don't really want to register each beverage one by one
	private static FluidRegistryObject registerAlcoholFluid(String name, int tintColor) {
		RegistryObject<FluidType> fluidType = FLUID_TYPES.register(name + "_type",
		                                                           () -> new AlcoholFluidType(tintColor));
		
		// Use RegistryObject references that will be filled later
		final RegistryObject<FlowingFluid>[] sourceHolder = new RegistryObject[1];
		final RegistryObject<FlowingFluid>[] flowingHolder = new RegistryObject[1];
		
		// Create properties that reference the holders
		ForgeFlowingFluid.Properties properties = new ForgeFlowingFluid.Properties(
				fluidType,
				() -> sourceHolder[0].get(),
				() -> flowingHolder[0].get()
		);
		
		// Register fluids and store in holders
		sourceHolder[0] = FLUIDS.register(name,
		                                  () -> new ForgeFlowingFluid.Source(properties));
		flowingHolder[0] = FLUIDS.register("flowing_" + name,
		                                   () -> new ForgeFlowingFluid.Flowing(properties));
		
		return new FluidRegistryObject(fluidType, sourceHolder[0], flowingHolder[0]);
	}
	
	private static ForgeFlowingFluid.Properties createFluidProperties(
			RegistryObject<FluidType> type,
			RegistryObject<FlowingFluid> source,
			RegistryObject<FlowingFluid> flowing)
	{
		return new ForgeFlowingFluid.Properties(type, source, flowing);
	}
	
	public static void register(IEventBus eventBus)
	{
		FLUID_TYPES.register(eventBus);
		FLUIDS.register(eventBus);
	}
	
	public record FluidRegistryObject(
			RegistryObject<FluidType> type,
			RegistryObject<FlowingFluid> source,
			RegistryObject<FlowingFluid> flowing
	) {}
}