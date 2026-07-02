package pupkin.brewersdelight.misc;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.util.Lazy;
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
	
	// Farmer's Delight compat
	public static final FluidRegistryObject
			MELON_JUICE = alcohol("melon_juice", new Color(210, 0, 0, 255)),
	//TOMATO_SAUCE = alcohol("tomato_sauce", new Color(210, 0, 0, 255)),
	
	// Bases / fillers
	BRAGA = alcohol("braga", new Color(180, 140, 90, 209)),
			GROG = alcohol("grog", new Color(205, 132, 66, 200)),
			PUNCH = alcohol("punch", new Color(220, 60, 70, 230)),
			TODDY = alcohol("toddy", new Color(208, 150, 64, 220)),
			WINE = alcohol("wine", new Color(114, 47, 55, 190)),
	//      RED_WINE = alcohol("red_wine", new Color(153, 0, 18, 190)), // TODO
	//      WHITE_WINE = alcohol("white_wine", new Color(238, 237, 196, 190)), // TODO
	
	// Utility (no tipsy)
	COMPOTE = alcohol("compote", new Color(190, 49, 66, 194)),
			GLUHWEIN = alcohol("gluhwein", new Color(150, 45, 38, 210)),
			KVASS = alcohol("kvass", new Color(139, 69, 19, 255)),
			MELON_SCHNAPPS = alcohol("melon_schnapps", new Color(199, 89, 73, 149)),
	
	// Cheap convenience (potion-clones)
	BRANDY = alcohol("brandy", new Color(181, 107, 42, 207)),
			CIDER = alcohol("cider", new Color(245, 213, 107, 161)),
			CORN_WHISKY = alcohol("corn_whisky", new Color(216, 138, 11, 120)), // corn
			ELDERFLOWER = alcohol("elderflower", new Color(255, 236, 139, 61)),
			GIN = alcohol("gin", new Color(235, 240, 209, 140)),
			VERMOUTH_GLOW_BERRIES = alcohol("vermouth_glow_berries", new Color(223, 206, 169, 227)),
			VERMOUTH_MUSHROOM = alcohol("vermouth_mushroom", new Color(195, 233, 177, 227)),
	
	// Tradeoff (strong buff + cost)
	ABSINTHE = alcohol("absinthe", new Color(124, 252, 0, 255)),
			MOONSHINE = alcohol("moonshine", new Color(240, 232, 210, 130)), // corn
			TEQUILA = alcohol("tequila", new Color(230, 214, 160, 181)),
	
	// Clean buff (no-potion effect + Nourishment)
	BITTER = alcohol("bitter", new Color(139, 0, 0, 255)),
			BOURBON = alcohol("bourbon", new Color(150, 74, 22, 218)), // corn
			CAHORS = alcohol("cahors", new Color(90, 30, 30, 252)), // grape
			COGNAC = alcohol("cognac", new Color(212, 161, 60, 140)), // grape
			LIQUEUR = alcohol("liqueur", new Color(196, 43, 26, 214)),
			RUM = alcohol("rum", new Color(160, 92, 32, 255)),
			SAKE = alcohol("sake", new Color(191, 188, 171, 255)),
			WHISKY = alcohol("whisky", new Color(185, 116, 40, 212)),
	
	// Cocktails
	OLD_FASHIONED = alcohol("old_fashioned", new Color(179, 89, 42, 143)),
	
	// Vintage
	SBITEN = alcohol("sbiten", new Color(179, 71, 26, 199)),
			SYTA = alcohol("syta", new Color(224, 180, 82, 199)),
			VZVAR = alcohol("vzvar", new Color(156, 90, 45, 189)),
	
	// Challenge
	FLAXEN_CHEESE_STOUT = alcohol("flaxen_cheese_stout", new Color(241, 194, 50, 255)),
			SCARLET_CHEESE_STOUT = alcohol("scarlet_cheese_stout", new Color(153, 0, 0, 255)),
	//      FROSTSTONE_CHEESE_STOUT = alcohol("froststone_cheese_stout", new Color(200, 230, 245, 230)), // TODO; placeholder color
	FLYING_DUTCHMAN = alcohol("flying_dutchman", new Color(147, 196, 125, 218)),
			GUT_WRECKER = alcohol("gut_wrecker", new Color(56, 118, 29, 255));
	
	private static FluidRegistryObject alcohol(String name, Color tint)
	{
		RegistryObject<FluidType> type = FLUID_TYPES.register(name, () -> new AlcoholFluidType(tint.getRGB()));
		// Lazy<Properties> resolves on first fluid construction — long after registration,
		// so the source/flowing forward-reference is never touched too early. No array holder.
		Lazy<ForgeFlowingFluid.Properties>[] props = new Lazy[1];
		RegistryObject<FlowingFluid> source = FLUIDS.register(name, () -> new ForgeFlowingFluid.Source(props[0].get()));
		RegistryObject<FlowingFluid> flowing = FLUIDS.register("flowing_" + name, () -> new ForgeFlowingFluid.Flowing(props[0].get()));
		props[0] = Lazy.of(() -> new ForgeFlowingFluid.Properties(type, source, flowing));
		return new FluidRegistryObject(type, source, flowing);
	}
	
	public static void register(IEventBus bus)
	{
		FLUID_TYPES.register(bus);
		FLUIDS.register(bus);
	}
	
	public record FluidRegistryObject(
			RegistryObject<FluidType> type,
			RegistryObject<FlowingFluid> source,
			RegistryObject<FlowingFluid> flowing)
	{
		
		public net.minecraft.resources.ResourceLocation id()
		{
			return source.getId();
		}
	}
}