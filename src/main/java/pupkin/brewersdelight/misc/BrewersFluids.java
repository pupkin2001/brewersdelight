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

import java.awt.*;

public class BrewersFluids
{
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(Keys.FLUID_TYPES, BrewersDelight.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, BrewersDelight.MOD_ID);
	
	// Farmer's Delight
	public static final FluidRegistryObject
			MELON_JUICE = registerAlcoholFluid("melon_juice", new Color(210, 0, 0, 255)),
	//TOMATO_SAUCE = registerAlcoholFluid("tomato_sauce", new Color(210, 0, 0, 255)),
	
	// Core
	BRAGA = registerAlcoholFluid("braga", new Color(180, 140, 90, 209)),
			BRANDY = registerAlcoholFluid("brandy", new Color(181, 107, 42, 207)),
			CIDER = registerAlcoholFluid("cider", new Color(245, 213, 107, 161)),
			COMPOTE = registerAlcoholFluid("compote", new Color(177, 156, 61, 194)),
			GIN = registerAlcoholFluid("gin", new Color(235, 240, 209, 194)),
			KVASS = registerAlcoholFluid("kvass", new Color(139, 69, 19, 255)),
			LIQUEUR = registerAlcoholFluid("liqueur", new Color(196, 43, 26, 214)),
			MARTINI = registerAlcoholFluid("martini", new Color(230, 214, 181, 227)),
			MELON_SCHNAPPS = registerAlcoholFluid("melon_schnapps", new Color(199, 89, 73, 149)),
			OLD_FASHION = registerAlcoholFluid("old_fashion", new Color(179, 89, 42, 143)),
			RUM = registerAlcoholFluid("rum", new Color(168, 102, 30, 255)),
			SAKE = registerAlcoholFluid("sake", new Color(245, 240, 215, 112)),
			TEQUILA = registerAlcoholFluid("tequila", new Color(230, 214, 160, 181)),
			WHISKY = registerAlcoholFluid("whisky", new Color(168, 102, 30, 212)),
	
	// Bloat
	//		ABSINTHE = registerAlcoholFluid("absinthe", new Color(124, 252, 0, 255)),
	//				AMARO = registerAlcoholFluid("amaro", new Color(139, 69, 19, 255)),
	//				AMONTILLADO = registerAlcoholFluid("amontillado", new Color(210, 180, 140, 255)),
	//				APEROL = registerAlcoholFluid("aperol", new Color(255, 69, 0, 255)),
	//				ARMAGNAC = registerAlcoholFluid("armagnac", new Color(168, 102, 30, 255)),
	//				BAIJIU = registerAlcoholFluid("baijiu", new Color(240, 230, 209, 135)),
	//				BECHEROVKA = registerAlcoholFluid("becherovka", new Color(218, 165, 32, 255)),
	//				BITTER = registerAlcoholFluid("bitter", new Color(139, 0, 0, 255)),
	//				CALVADOS = registerAlcoholFluid("calvados", new Color(230, 168, 102, 255)),
	//				CAMPARI = registerAlcoholFluid("campari", new Color(220, 20, 60, 255)),
	//				CHACHA = registerAlcoholFluid("chacha", new Color(223, 255, 0, 255)),
	//				FERNET = registerAlcoholFluid("fernet", new Color(47, 79, 79, 255)),
	//				GLUHWEIN = registerAlcoholFluid("gluhwein", new Color(139, 26, 26, 255)),
	//				GROG = registerAlcoholFluid("grog", new Color(210, 105, 30, 255)),
	//				KASHASA = registerAlcoholFluid("kashasa", new Color(240, 230, 209, 255)),
	//				MEZCAL = registerAlcoholFluid("mezcal", new Color(230, 214, 160, 255)),
	//				NEGRONI = registerAlcoholFluid("negroni", new Color(139, 0, 0, 255)),
	//				OUZO = registerAlcoholFluid("ouzo", new Color(245, 240, 215, 255)),
	//				PASTIS = registerAlcoholFluid("pastis", new Color(245, 240, 160, 255)),
	//				PUNCH = registerAlcoholFluid("punch", new Color(255, 99, 71, 255)),
	//				RAKIA = registerAlcoholFluid("rakia", new Color(240, 230, 209, 255)),
	//				SAMBUCA = registerAlcoholFluid("sambuca", new Color(245, 240, 215, 255)),
	//				SHERRY = registerAlcoholFluid("sherry", new Color(210, 180, 140, 255)),
	//				SOCATA = registerAlcoholFluid("socata", new Color(230, 214, 60, 255)),
	//				SOJU = registerAlcoholFluid("soju", new Color(240, 230, 209, 255)),
	//				SOTOL = registerAlcoholFluid("sotol", new Color(230, 214, 160, 255)),
	//				TODDY = registerAlcoholFluid("toddy", new Color(210, 105, 30, 255)),
	//				TRIPLE_SEC = registerAlcoholFluid("triple-sec", new Color(255, 240, 160, 255)),
	//				TSIPURO = registerAlcoholFluid("tsipuro", new Color(245, 240, 215, 255)),
	//				VERMOUTH = registerAlcoholFluid("vermouth", new Color(160, 32, 240, 255)),
	//				TSUIKE = registerAlcoholFluid("tsuike", new Color(34, 139, 34, 255)),
	//				VISHINATA = registerAlcoholFluid("vishinata", new Color(170, 74, 68, 255)),
	
	// Corn
	BOURBON = registerAlcoholFluid("bourbon", new Color(181, 107, 26, 89)),
			CORN_WHISKY = registerAlcoholFluid("corn_whisky", new Color(156, 107, 26, 115)),
			MOONSHINE = registerAlcoholFluid("moonshine", new Color(240, 230, 209, 227)),
	
	// Grapes
	CAHORS = registerAlcoholFluid("cahors", new Color(90, 30, 30, 252)),
			CHAMPAGNE = registerAlcoholFluid("champagne", new Color(255, 236, 139, 61)),
			COGNAC = registerAlcoholFluid("cognac", new Color(212, 161, 60, 140)),
	
	// Common
	WINE = registerAlcoholFluid("wine", new Color(114, 47, 55, 190)),
			WHITE_WINE = registerAlcoholFluid("white_wine", new Color(238, 237, 196, 190)),
			RED_WINE = registerAlcoholFluid("red_wine", new Color(153, 0, 18, 190)),
	
	// Vintage
	SBITEN = registerAlcoholFluid("sbiten", new Color(179, 71, 26, 199)),
			SYTA = registerAlcoholFluid("syta", new Color(212, 161, 60, 199)),
			VZVAR = registerAlcoholFluid("vzvar", new Color(156, 90, 45, 189)),
	
	// Challenge
	FLAXEN_CHEESE_STOUT = registerAlcoholFluid("flaxen_cheese_stout", new Color(241, 194, 50, 255)),
			SCARLET_CHEESE_STOUT = registerAlcoholFluid("scarlet_cheese_stout", new Color(153, 0, 0, 255)),
			FLYING_DUTCHMAN = registerAlcoholFluid("flying_dutchman", new Color(147, 196, 125, 218)),
			GUT_WRECKER = registerAlcoholFluid("gut_wrecker", new Color(56, 118, 29, 255));
	
	// I really should've copied the fluid registration code from BnC, but I'm in the middle of the sunk cost fallacy
	// also I don't really want to register each beverage one by one
	private static FluidRegistryObject registerAlcoholFluid(String name, Color tintColor)
	{
		RegistryObject<FluidType> fluidType = FLUID_TYPES.register(name, () -> new AlcoholFluidType(tintColor.getRGB()));
		
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