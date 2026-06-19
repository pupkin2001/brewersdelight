package pupkin.brewersdelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.misc.BrewersFluids;
import pupkin.brewersdelight.misc.DrinkProperties;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BnCItems;

@SuppressWarnings("unused")
public class BrewersItems
{
	public static final DeferredRegister<Item>
			DRINKS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID),
			COMPAT_DRINKS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID),
			VINTAGE_DRINKS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID),
			CHALLENGE_DRINKS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	
	// Core
	public static final RegistryObject<Item>
			BRAGA = registerDrink(DRINKS, "braga", BrewersFluids.BRAGA, DrinkProperties.BRAGA, true),
			BRANDY = registerDrink(DRINKS, "brandy", BrewersFluids.BRANDY, DrinkProperties.BRANDY, true),
			CIDER = registerDrink(DRINKS, "cider", BrewersFluids.CIDER, DrinkProperties.CIDER, false),
			COMPOTE = registerDrink(DRINKS, "compote", BrewersFluids.COMPOTE, DrinkProperties.COMPOTE),
			GIN = registerDrink(DRINKS, "gin", BrewersFluids.GIN, DrinkProperties.GIN, true),
			KVASS = registerDrink(DRINKS, "kvass", BrewersFluids.KVASS, DrinkProperties.KVASS, false),
			LIQUEUR = registerDrink(DRINKS, "liqueur", BrewersFluids.LIQUEUR, DrinkProperties.LIQUEUR, true),
			MARTINI = registerDrink(DRINKS, "martini", BrewersFluids.MARTINI, DrinkProperties.MARTINI, true),
			MELON_SCHNAPPS = registerDrink(DRINKS, "melon_schnapps", BrewersFluids.MELON_SCHNAPPS, DrinkProperties.MELON_SCHNAPPS, true),
			OLD_FASHION = registerDrink(DRINKS, "old_fashion", BrewersFluids.OLD_FASHION, DrinkProperties.OLD_FASHION, true),
			RUM = registerDrink(DRINKS, "rum", BrewersFluids.RUM, DrinkProperties.RUM, false),
			SAKE = registerDrink(DRINKS, "sake", BrewersFluids.SAKE, DrinkProperties.SAKE, true),
			TEQUILA = registerDrink(DRINKS, "tequila", BrewersFluids.TEQUILA, DrinkProperties.TEQUILA, false),
			WHISKY = registerDrink(DRINKS, "whisky", BrewersFluids.WHISKY, DrinkProperties.WHISKY, true),
	
	// Bloat TODO: Commented out due to poor balancing and low texture variety.
	//	ABSINTHE = DRINKS.register("absinthe", () -> new BoozeItem(BrewersFluids.ABSINTHE.source().get(), foodItem(DrinkProperties.ABSINTHE))),
	//			AMARO = DRINKS.register("amaro", () -> new BoozeItem(BrewersFluids.AMARO.source().get(), foodItem(DrinkProperties.AMARO))),
	//			AMONTILLADO = DRINKS.register("amontillado", () -> new BoozeItem(BrewersFluids.AMONTILLADO.source().get(), foodItem(DrinkProperties.AMONTILLADO))),
	//			APEROL = DRINKS.register("aperol", () -> new BoozeItem(BrewersFluids.APEROL.source().get(), foodItem(DrinkProperties.APEROL))),
	//			ARMAGNAC = DRINKS.register("armagnac", () -> new BoozeItem(BrewersFluids.ARMAGNAC.source().get(), foodItem(DrinkProperties.ARMAGNAC))),
	//			BAIJIU = DRINKS.register("baijiu", () -> new BoozeItem(BrewersFluids.BAIJIU.source().get(), foodItem(DrinkProperties.BAIJIU))),
	//			BECHEROVKA = DRINKS.register("becherovka", () -> new BoozeItem(BrewersFluids.BECHEROVKA.source().get(), foodItem(DrinkProperties.BECHEROVKA))),
	//			BITTER = DRINKS.register("bitter", () -> new BoozeItem(BrewersFluids.BITTER.source().get(), foodItem(DrinkProperties.BITTER))),
	//			CALVADOS = DRINKS.register("calvados", () -> new BoozeItem(BrewersFluids.CALVADOS.source().get(), foodItem(DrinkProperties.CALVADOS))),
	//			CAMPARI = DRINKS.register("campari", () -> new BoozeItem(BrewersFluids.CAMPARI.source().get(), foodItem(DrinkProperties.CAMPARI))),
	//			CHACHA = DRINKS.register("chacha", () -> new BoozeItem(BrewersFluids.CHACHA.source().get(), foodItem(DrinkProperties.CHACHA))),
	//			FERNET = DRINKS.register("fernet", () -> new BoozeItem(BrewersFluids.FERNET.source().get(), foodItem(DrinkProperties.FERNET))),
	//			GLUHWEIN = DRINKS.register("gluhwein", () -> new BoozeItem(BrewersFluids.GLUHWEIN.source().get(), foodItem(DrinkProperties.GLUHWEIN))),
	//			GROG = DRINKS.register("grog", () -> new BoozeItem(BrewersFluids.GROG.source().get(), foodItem(DrinkProperties.GROG))),
	//			KASHASA = DRINKS.register("kashasa", () -> new BoozeItem(BrewersFluids.KASHASA.source().get(), foodItem(DrinkProperties.KASHASA))),
	//			MEZCAL = DRINKS.register("mezcal", () -> new BoozeItem(BrewersFluids.MEZCAL.source().get(), foodItem(DrinkProperties.MEZCAL))),
	//			NEGRONI = DRINKS.register("negroni", () -> new BoozeItem(BrewersFluids.NEGRONI.source().get(), foodItem(DrinkProperties.NEGRONI))),
	//			OUZO = DRINKS.register("ouzo", () -> new BoozeItem(BrewersFluids.OUZO.source().get(), foodItem(DrinkProperties.OUZO))),
	//			PASTIS = DRINKS.register("pastis", () -> new BoozeItem(BrewersFluids.PASTIS.source().get(), foodItem(DrinkProperties.PASTIS))),
	//			PUNCH = DRINKS.register("punch", () -> new BoozeItem(BrewersFluids.PUNCH.source().get(), foodItem(DrinkProperties.PUNCH))),
	//			RAKIA = DRINKS.register("rakia", () -> new BoozeItem(BrewersFluids.RAKIA.source().get(), foodItem(DrinkProperties.RAKIA))),
	//			SAMBUCA = DRINKS.register("sambuca", () -> new BoozeItem(BrewersFluids.SAMBUCA.source().get(), foodItem(DrinkProperties.SAMBUCA))),
	//			SHERRY = DRINKS.register("sherry", () -> new BoozeItem(BrewersFluids.SHERRY.source().get(), foodItem(DrinkProperties.SHERRY))),
	//			SOCATA = DRINKS.register("socata", () -> new BoozeItem(BrewersFluids.SOCATA.source().get(), foodItem(DrinkProperties.SOCATA))),
	//			SOJU = DRINKS.register("soju", () -> new BoozeItem(BrewersFluids.SOJU.source().get(), foodItem(DrinkProperties.SOJU))),
	//			SOTOL = DRINKS.register("sotol", () -> new BoozeItem(BrewersFluids.SOTOL.source().get(), foodItem(DrinkProperties.SOTOL))),
	//			TODDY = DRINKS.register("toddy", () -> new BoozeItem(BrewersFluids.TODDY.source().get(), foodItem(DrinkProperties.TODDY))),
	//			TRIPLE_SEC = DRINKS.register("triple-sec", () -> new BoozeItem(BrewersFluids.TRIPLE_SEC.source().get(), foodItem(DrinkProperties.TRIPLE_SEC))),
	//			TSIPURO = DRINKS.register("tsipuro", () -> new BoozeItem(BrewersFluids.TSIPURO.source().get(), foodItem(DrinkProperties.TSIPURO))),
	//			VERMOUTH = DRINKS.register("vermouth", () -> new BoozeItem(BrewersFluids.VERMOUTH.source().get(), foodItem(DrinkProperties.VERMOUTH))),
	//			TSUIKE = DRINKS.register("tsuike", () -> new BoozeItem(BrewersFluids.TSUIKE.source().get(), foodItem(DrinkProperties.TSUIKE))),
	//			VISHINATA = DRINKS.register("vishinata", () -> new BoozeItem(BrewersFluids.VISHINATA.source().get(), foodItem(DrinkProperties.VISHINATA))),
	
	// BnC 3.0 does have a function for registering items with mod dependency: registerWithTab(String name, Item item, @Nullable String requiredMod)
	// However, mods adding corn or grapes are frequent, and you can't account for all of them manually.
	// Corn
	BOURBON = COMPAT_DRINKS.register("bourbon", () -> new BoozeItem(BrewersFluids.BOURBON.source().get(), foodItem(DrinkProperties.BOURBON))),
			CORN_WHISKY = COMPAT_DRINKS.register("corn_whisky", () -> new BoozeItem(BrewersFluids.CORN_WHISKY.source().get(), foodItem(DrinkProperties.CORN_WHISKY))),
			MOONSHINE = COMPAT_DRINKS.register("moonshine", () -> new BoozeItem(BrewersFluids.MOONSHINE.source().get(), foodItem(DrinkProperties.MOONSHINE))),
	
	// Grapes
	CAHORS = COMPAT_DRINKS.register("cahors", () -> new BoozeItem(BrewersFluids.CAHORS.source().get(), foodItem(DrinkProperties.CAHORS))),
			CHAMPAGNE = COMPAT_DRINKS.register("champagne", () -> new BoozeItem(BrewersFluids.CHAMPAGNE.source().get(), foodItem(DrinkProperties.CHAMPAGNE))),
			COGNAC = COMPAT_DRINKS.register("cognac", () -> new BoozeItem(BrewersFluids.COGNAC.source().get(), foodItem(DrinkProperties.COGNAC))),
	
	// Vintage
	SBITEN = VINTAGE_DRINKS.register("sbiten", () -> new BoozeItem(BrewersFluids.SBITEN.source().get(), foodItem(DrinkProperties.SBITEN))),
			SYTA = VINTAGE_DRINKS.register("syta", () -> new BoozeItem(BrewersFluids.SYTA.source().get(), foodItem(DrinkProperties.SYTA))),
			VZVAR = VINTAGE_DRINKS.register("vzvar", () -> new BoozeItem(BrewersFluids.VZVAR.source().get(), foodItem(DrinkProperties.VZVAR))),
	
	// Challenge
	FLAXEN_CHEESE_STOUT = CHALLENGE_DRINKS.register("flaxen_cheese_stout",
	                                                () -> new BoozeItem(BrewersFluids.FLAXEN_CHEESE_STOUT.source().get(), foodItem(DrinkProperties.FLAXEN_CHEESE_STOUT))),
			SCARLET_CHEESE_STOUT = CHALLENGE_DRINKS.register("scarlet_cheese_stout", () -> new BoozeItem(BrewersFluids.SCARLET_CHEESE_STOUT.source().get(),
			                                                                                             foodItem(DrinkProperties.SCARLET_CHEESE_STOUT))),
			FLYING_DUTCHMAN = CHALLENGE_DRINKS.register("flying_dutchman",
			                                            () -> new BoozeItem(BrewersFluids.FLYING_DUTCHMAN.source().get(), foodItem(DrinkProperties.FLYING_DUTCHMAN))),
			GUT_WRECKER = CHALLENGE_DRINKS.register("gut_wrecker", () -> new BoozeItem(BrewersFluids.GUT_WRECKER.source().get(), foodItem(DrinkProperties.GUT_WRECKER)));
	
	/**
	 * @throws IllegalArgumentException if both hasTankardVariant and hasGlassVariant arguments are false
	 */
	public static RegistryObject<Item> registerDrink(DeferredRegister<Item> registry, String name, BrewersFluids.FluidRegistryObject fluid, FoodProperties food,
	                                                    boolean hasTankardVariant, boolean hasGlassVariant)
	{
		if (!hasTankardVariant & hasTankardVariant == hasGlassVariant) {
			throw new IllegalArgumentException("Unable to register item " + name + " as it does not have a tankard or glass variant.");
		}
		
		RegistryObject<Item> DrinkItem;
		if (hasTankardVariant) {
			
			// The .source() gets the RegistryObject<FlowingFluid> from the record, and then .get() gets the actual fluid instance.
			DrinkItem = registry.register(name, () -> new BoozeItem(fluid.source().get(), foodItem(food, BnCItems.TANKARD.get())));
			
			if (hasGlassVariant) {
				registry.register(name + "_glass", () -> new BoozeItem(fluid.source().get(), foodItem(food, Items.GLASS_BOTTLE))
				{
					@Override
					public @NotNull String getDescriptionId()
					{
						return "item." + BrewersDelight.MOD_ID + "." + name;
					}
				});
			}
			
			return DrinkItem;
		}
		
		// If no tankard variant only register the glass one
		DrinkItem = registry.register(name + "_glass", () -> new BoozeItem(fluid.source().get(), foodItem(food, Items.GLASS_BOTTLE))
		{
			@Override
			public @NotNull String getDescriptionId()
			{
				return "item." + BrewersDelight.MOD_ID + "." + name;
			}
		});
		
		return DrinkItem;
	}
	
	public static RegistryObject<Item> registerDrink(DeferredRegister<Item> registry, String name, BrewersFluids.FluidRegistryObject fluid, FoodProperties food,
	                                                    boolean hasGlassVariant)
	{
		return registerDrink(registry, name, fluid, food, true, hasGlassVariant);
	}
	
	public static RegistryObject<Item> registerDrink(DeferredRegister<Item> registry, String name, BrewersFluids.FluidRegistryObject fluid, FoodProperties food)
	{
		return registerDrink(registry, name, fluid, food, true, false);
	}
	
	public static Item.@NotNull Properties foodItem(FoodProperties food, Item containerItem)
	{
		return new Item.Properties().food(food).stacksTo(16).craftRemainder(containerItem);
	}
	
	public static Item.@NotNull Properties foodItem(FoodProperties food)
	{
		return new Item.Properties().food(food).stacksTo(16).craftRemainder(BnCItems.TANKARD.get());
	}
	
	public static void register(IEventBus eventBus)
	{
		DRINKS.register(eventBus);
		CHALLENGE_DRINKS.register(eventBus);
		VINTAGE_DRINKS.register(eventBus);
		COMPAT_DRINKS.register(eventBus);
	}
}
