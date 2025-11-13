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
	
	// Farmer's delight
	public static final FluidRegistryObject BRAGA = registerAlcoholFluid("braga", 0xD1B48C5A);
	public static final FluidRegistryObject BRANDY = registerAlcoholFluid("brandy", 0xCFB56B2A);
	public static final FluidRegistryObject CIDER = registerAlcoholFluid("cider", 0xA1F5D56B);
	public static final FluidRegistryObject COMPOTE = registerAlcoholFluid("compote", 0xC2B19C3D);
	public static final FluidRegistryObject GIN = registerAlcoholFluid("gin", 0xC2EBF0D1);
	public static final FluidRegistryObject KVASS = registerAlcoholFluid("kvass", 0xFF8B4513);
	public static final FluidRegistryObject LIQUEUR = registerAlcoholFluid("liqueur", 0xD6C42B1A);
	public static final FluidRegistryObject MARTINI = registerAlcoholFluid("martini", 0xE3E6D6B5);
	public static final FluidRegistryObject MELON_SCHNAPPS = registerAlcoholFluid("melon_schnapps", 0x95C75949);
	public static final FluidRegistryObject OLD_FASHION = registerAlcoholFluid("old_fashion", 0x8FB3592A);
	public static final FluidRegistryObject RUM = registerAlcoholFluid("rum", 0xFFA8661E);
	public static final FluidRegistryObject SAKE = registerAlcoholFluid("sake", 0x70F5F0D7); // Isn't that just rice wine from BnC?
	public static final FluidRegistryObject TEQUILA = registerAlcoholFluid("tequila", 0xB5E6D6A0);
	public static final FluidRegistryObject WHISKY = registerAlcoholFluid("whisky", 0xD4A8661E);
	
	// Bloat
	public static final FluidRegistryObject ABSINTHE = registerAlcoholFluid("absinthe", 0xFF7CFC00);
	public static final FluidRegistryObject AMARO = registerAlcoholFluid("amaro", 0xFF8B4513);
	public static final FluidRegistryObject AMONTILLADO = registerAlcoholFluid("amontillado", 0xFFD2B48C);
	public static final FluidRegistryObject APEROL = registerAlcoholFluid("aperol", 0xFFFF4500);
	public static final FluidRegistryObject ARMAGNAC = registerAlcoholFluid("armagnac", 0xFFA8661E);
	public static final FluidRegistryObject BAIJIU = registerAlcoholFluid("baijiu", 0x87F0E6D1);
	public static final FluidRegistryObject BECHEROVKA = registerAlcoholFluid("becherovka", 0xFFDAA520);
	public static final FluidRegistryObject BITTER = registerAlcoholFluid("bitter", 0xFF8B0000);
	public static final FluidRegistryObject CALVADOS = registerAlcoholFluid("calvados", 0xFFE6A866);
	public static final FluidRegistryObject CAMPARI = registerAlcoholFluid("campari", 0xFFDC143C);
	public static final FluidRegistryObject CHACHA = registerAlcoholFluid("chacha", 0xFFDFFF00);
	public static final FluidRegistryObject FERNET = registerAlcoholFluid("fernet", 0xFF2F4F4F);
	public static final FluidRegistryObject GLUHWEIN = registerAlcoholFluid("gluhwein", 0xFF8B1A1A);
	public static final FluidRegistryObject GROG = registerAlcoholFluid("grog", 0xFFD2691E);
	public static final FluidRegistryObject KASHASA = registerAlcoholFluid("kashasa", 0xFFF0E6D1);
	public static final FluidRegistryObject MEZCAL = registerAlcoholFluid("mezcal", 0xFFE6D6A0);
	public static final FluidRegistryObject NEGRONI = registerAlcoholFluid("negroni", 0xFF8B0000);
	public static final FluidRegistryObject OUZO = registerAlcoholFluid("ouzo", 0xFFF5F0D7);
	public static final FluidRegistryObject PASTIS = registerAlcoholFluid("pastis", 0xFFF5F0A0);
	public static final FluidRegistryObject PUNCH = registerAlcoholFluid("punch", 0xFFFF6347);
	public static final FluidRegistryObject RAKIA = registerAlcoholFluid("rakia", 0xFFF0E6D1);
	public static final FluidRegistryObject SAMBUCA = registerAlcoholFluid("sambuca", 0xFFF5F0D7);
	public static final FluidRegistryObject SHERRY = registerAlcoholFluid("sherry", 0xFFD2B48C);
	public static final FluidRegistryObject SOCATA = registerAlcoholFluid("socata", 0xFFE6D63C);
	public static final FluidRegistryObject SOJU = registerAlcoholFluid("soju", 0xFFF0E6D1);
	public static final FluidRegistryObject SOTOL = registerAlcoholFluid("sotol", 0xFFE6D6A0);
	public static final FluidRegistryObject TODDY = registerAlcoholFluid("toddy", 0xFFD2691E);
	public static final FluidRegistryObject TRIPLE_SEC = registerAlcoholFluid("triple-sec", 0xFFFFF0A0);
	public static final FluidRegistryObject TSIPURO = registerAlcoholFluid("tsipuro", 0xFFF5F0D7);
	public static final FluidRegistryObject VERMOUTH = registerAlcoholFluid("vermouth", 0xFFA020F0);
	public static final FluidRegistryObject TSUIKE = registerAlcoholFluid("tsuike", 0xFF228B22);
	public static final FluidRegistryObject VISHINATA = registerAlcoholFluid("vishinata", 0xFFAA4A44);
	
	// Compatibility
		// Farmer's Delight
	public static final FluidRegistryObject MELON_JUICE = registerAlcoholFluid("melon_juice", 0xFFD20000);
	//public static final FluidRegistryObject TOMATO_SAUCE = registerAlcoholFluid("tomato_sauce", 0xFFD20000);
	
		// Corn
	public static final FluidRegistryObject BOURBON = registerAlcoholFluid("bourbon", 0x59B56B1A);
	public static final FluidRegistryObject CORN_WHISKY = registerAlcoholFluid("corn_whisky", 0x739C6B1A);
	public static final FluidRegistryObject MOONSHINE = registerAlcoholFluid("moonshine", 0xE3F0E6D1);
	
		// Grapes
	public static final FluidRegistryObject CAHORS = registerAlcoholFluid("cahors", 0xFC5A1E1E);
	public static final FluidRegistryObject CHAMPAGNE = registerAlcoholFluid("champagne", 0x3DFFEC8B);
	public static final FluidRegistryObject COGNAC = registerAlcoholFluid("cognac", 0x8CD4A13C);
	
		// Other
	public static final FluidRegistryObject RED_WINE = registerAlcoholFluid("red_wine", 0xBE990012);
	public static final FluidRegistryObject WINE = registerAlcoholFluid("wine", 0xBE722f37);
	public static final FluidRegistryObject WHITE_WINE = registerAlcoholFluid("white_wine", 0xBEEEEDC4);
	
	// Vintage beverages
	public static final FluidRegistryObject SBITEN = registerAlcoholFluid("sbiten", 0xC7B3471A);
	public static final FluidRegistryObject SYTA = registerAlcoholFluid("syta", 0xC7D4A13C);
	public static final FluidRegistryObject VZVAR = registerAlcoholFluid("vzvar", 0xBD9C5A2D);
	
	// Challenge beverages
	public static final FluidRegistryObject FLAXEN_CHEESE_STOUT = registerAlcoholFluid("flaxen_cheese_stout", 0xFFf1c232);
	public static final FluidRegistryObject SCARLET_CHEESE_STOUT = registerAlcoholFluid("scarlet_cheese_stout", 0xFF990000);
	public static final FluidRegistryObject FLYING_DUTCHMAN = registerAlcoholFluid("flying_dutchman", 0xDA93c47d);
	public static final FluidRegistryObject GUT_WRECKER = registerAlcoholFluid("gut_wrecker", 0xFF38761d);
	
	
	
	// I really should've copied the fluid registration code from BnC, but I'm in the middle of the sunk cost fallacy
	// also I don't really want to register each beverage one by one
	private static FluidRegistryObject registerAlcoholFluid(String name, int tintColor) {
		RegistryObject<FluidType> fluidType = FLUID_TYPES.register(name, () -> new AlcoholFluidType(tintColor));
		
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