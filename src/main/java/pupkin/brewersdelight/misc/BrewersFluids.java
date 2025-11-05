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
	
	public static final FluidRegistryObject BRAGA = registerAlcoholFluid("braga", 0xdeddb0d1);
	public static final FluidRegistryObject BRANDY = registerAlcoholFluid("brandy", 0xdb6a00cf);
	public static final FluidRegistryObject CIDER = registerAlcoholFluid("cider", 0xffe86aa1);
	public static final FluidRegistryObject COMPOTE = registerAlcoholFluid("compote", 0xffe03cc2);
	public static final FluidRegistryObject GIN = registerAlcoholFluid("gin", 0xdcfaffc2);
	public static final FluidRegistryObject KVASS = registerAlcoholFluid("kvass", 0x694800);
	public static final FluidRegistryObject LIQUEUR = registerAlcoholFluid("liqueur", 0xf20000d6);
	public static final FluidRegistryObject MELON_SCHNAPPS = registerAlcoholFluid("melon_schnapps", 0xff000047);
	public static final FluidRegistryObject OLD_FASHION = registerAlcoholFluid("old_fashion", 0xee80008f);
	public static final FluidRegistryObject SAKE = registerAlcoholFluid("sake", 0xe8e8e870);
	public static final FluidRegistryObject TEQUILA = registerAlcoholFluid("tequila", 0xb9d6aab5);
	public static final FluidRegistryObject WHISKY = registerAlcoholFluid("whisky", 0xc44a16d4);
	
	public static final FluidRegistryObject FLAXEN_CHEESE_STOUT = registerAlcoholFluid("flaxen_cheese_stout", 0xFFFFFFFF);
	public static final FluidRegistryObject SCARLET_CHEESE_STOUT = registerAlcoholFluid("scarlet_cheese_stout", 0xFFFFFFFF);
	public static final FluidRegistryObject FLYING_DUTCHMAN = registerAlcoholFluid("flying_dutchman", 0xFFFFFFFF);
	public static final FluidRegistryObject GUT_WRECKER = registerAlcoholFluid("gut_wrecker", 0xFFFFFFFF);
	
	public static final FluidRegistryObject SBITEN = registerAlcoholFluid("sbiten", 0xf27c1bc7);
	public static final FluidRegistryObject SYTA = registerAlcoholFluid("syta", 0xf27c1bc7);
	public static final FluidRegistryObject VZVAR = registerAlcoholFluid("vzvar", 0x914a20bd);
	
	public static final FluidRegistryObject BOURBON = registerAlcoholFluid("bourbon", 0xcfb70059);
	public static final FluidRegistryObject CORN_WHISKY = registerAlcoholFluid("corn_whisky", 0x85480573);
	public static final FluidRegistryObject MOONSHINE = registerAlcoholFluid("moonshine", 0xc1c27fe3);
	public static final FluidRegistryObject CAHORS = registerAlcoholFluid("cahors", 0x820c0cfc);
	public static final FluidRegistryObject CHAMPAGNE = registerAlcoholFluid("champagne", 0xf5ff003d);
	public static final FluidRegistryObject COGNAC = registerAlcoholFluid("cognac", 0xbf77108c);
	public static final FluidRegistryObject MARTINI = registerAlcoholFluid("martini", 0xca6d53e3);
	
	// Bloat
	public static final FluidRegistryObject ABSINTHE = registerAlcoholFluid("absinthe", 0xFFFFFFFF);
	public static final FluidRegistryObject AMARO = registerAlcoholFluid("amaro", 0xFFFFFFFF);
	public static final FluidRegistryObject AMONTILLADO = registerAlcoholFluid("amontillado", 0xFFFFFFFF);
	public static final FluidRegistryObject APEROL = registerAlcoholFluid("aperol", 0xFFFFFFFF);
	public static final FluidRegistryObject ARMAGNAC = registerAlcoholFluid("armagnac", 0xFFFFFFFF);
	public static final FluidRegistryObject BAIJIU = registerAlcoholFluid("baijiu", 0xFFFFFFFF);
	public static final FluidRegistryObject BECHEROVKA = registerAlcoholFluid("becherovka", 0xFFFFFFFF);
	public static final FluidRegistryObject BITTER = registerAlcoholFluid("bitter", 0xFFFFFFFF);
	public static final FluidRegistryObject CALVADOS = registerAlcoholFluid("calvados", 0xFFFFFFFF);
	public static final FluidRegistryObject CAMPARI = registerAlcoholFluid("campari", 0xFFFFFFFF);
	public static final FluidRegistryObject CHACHA = registerAlcoholFluid("chacha", 0xFFFFFFFF);
	public static final FluidRegistryObject FERNET = registerAlcoholFluid("fernet", 0xFFFFFFFF);
	public static final FluidRegistryObject GLUHWEIN = registerAlcoholFluid("gluhwein", 0xFFFFFFFF);
	public static final FluidRegistryObject GROG = registerAlcoholFluid("grog", 0xFFFFFFFF);
	public static final FluidRegistryObject KASHASA = registerAlcoholFluid("kashasa", 0xFFFFFFFF);
	public static final FluidRegistryObject MEZCAL = registerAlcoholFluid("mezcal", 0xFFFFFFFF);
	public static final FluidRegistryObject NEGRONI = registerAlcoholFluid("negroni", 0xFFFFFFFF);
	public static final FluidRegistryObject OUZO = registerAlcoholFluid("ouzo", 0xFFFFFFFF);
	public static final FluidRegistryObject PASTIS = registerAlcoholFluid("pastis", 0xFFFFFFFF);
	public static final FluidRegistryObject PUNCH = registerAlcoholFluid("punch", 0xFFFFFFFF);
	public static final FluidRegistryObject RAKIA = registerAlcoholFluid("rakia", 0xFFFFFFFF);
	public static final FluidRegistryObject RUM = registerAlcoholFluid("rum", 0xFFFFFFFF);
	public static final FluidRegistryObject SAMBUCA = registerAlcoholFluid("sambuca", 0xFFFFFFFF);
	public static final FluidRegistryObject SHERRY = registerAlcoholFluid("sherry", 0xFFFFFFFF);
	public static final FluidRegistryObject SOCATA = registerAlcoholFluid("socata", 0xFFFFFFFF);
	public static final FluidRegistryObject SOJU = registerAlcoholFluid("soju", 0xFFFFFFFF);
	public static final FluidRegistryObject SOTOL = registerAlcoholFluid("sotol", 0xFFFFFFFF);
	public static final FluidRegistryObject TODDY = registerAlcoholFluid("toddy", 0xFFFFFFFF);
	public static final FluidRegistryObject TRIPLE_SEC = registerAlcoholFluid("triple-sec", 0xFFFFFFFF);
	public static final FluidRegistryObject TSIPURO = registerAlcoholFluid("tsipuro", 0xFFFFFFFF);
	public static final FluidRegistryObject VERMOUTH = registerAlcoholFluid("vermouth", 0xFFFFFFFF);
	public static final FluidRegistryObject TSUIKE = registerAlcoholFluid("tsuike", 0xFFFFFFFF);
	public static final FluidRegistryObject VISHINATA = registerAlcoholFluid("vishinata", 0xFFFFFFFF);
	
	// Compatibility
	public static final FluidRegistryObject WINE = registerAlcoholFluid("wine", 0xFFFFFFFF);
	
	
	
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