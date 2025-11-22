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
import pupkin.brewersdelight.misc.BeverageProperties;
import pupkin.brewersdelight.misc.BrewersFluids;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BnCItems;

@SuppressWarnings("unused")
public class BrewersItems
{
	public static final DeferredRegister<Item> DRINKS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	public static final DeferredRegister<Item> CHALLENGE_DRINKS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	public static final DeferredRegister<Item> VINTAGE_DRINKS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	public static final DeferredRegister<Item> COMPAT_DRINKS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	// Farmer's Delight
	public static final RegistryObject<Item> BRAGA = registerBeverage(DRINKS, "braga", BrewersFluids.BRAGA, BeverageProperties.BRAGA, true);
	public static final RegistryObject<Item> BRANDY = registerBeverage(DRINKS, "brandy", BrewersFluids.BRANDY, BeverageProperties.BRANDY, true);
	public static final RegistryObject<Item> CIDER = registerBeverage(DRINKS, "cider", BrewersFluids.CIDER, BeverageProperties.CIDER, false);
	public static final RegistryObject<Item> COMPOTE = registerBeverage(DRINKS, "compote", BrewersFluids.COMPOTE, BeverageProperties.COMPOTE);
	public static final RegistryObject<Item> GIN = registerBeverage(DRINKS, "gin", BrewersFluids.GIN, BeverageProperties.GIN, true);
	public static final RegistryObject<Item> KVASS = registerBeverage(DRINKS, "kvass", BrewersFluids.KVASS, BeverageProperties.KVASS, false);
	public static final RegistryObject<Item> LIQUEUR = registerBeverage(DRINKS, "liqueur", BrewersFluids.LIQUEUR, BeverageProperties.LIQUEUR, true);
	public static final RegistryObject<Item> MELON_SCHNAPPS = registerBeverage(DRINKS, "melon_schnapps", BrewersFluids.MELON_SCHNAPPS, BeverageProperties.MELON_SCHNAPPS, true);
	public static final RegistryObject<Item> OLD_FASHION = registerBeverage(DRINKS, "old_fashion", BrewersFluids.OLD_FASHION, BeverageProperties.OLD_FASHION, true);
	public static final RegistryObject<Item> RUM = registerBeverage(DRINKS, "rum", BrewersFluids.RUM, BeverageProperties.RUM, false);
	public static final RegistryObject<Item> SAKE = registerBeverage(DRINKS, "sake", BrewersFluids.SAKE, BeverageProperties.SAKE, true);
	public static final RegistryObject<Item> TEQUILA = registerBeverage(DRINKS, "tequila", BrewersFluids.TEQUILA, BeverageProperties.TEQUILA, false);
	public static final RegistryObject<Item> WHISKY = registerBeverage(DRINKS, "whisky", BrewersFluids.WHISKY, BeverageProperties.WHISKY, true);
	// Challenge beverages
	public static final RegistryObject<Item> FLAXEN_CHEESE_STOUT = CHALLENGE_DRINKS.register("flaxen_cheese_stout",
	                                                                                         () -> new BoozeItem(BrewersFluids.FLAXEN_CHEESE_STOUT.source().get(),
	                                                                                                             foodItem(BeverageProperties.FLAXEN_CHEESE_STOUT)));
	public static final RegistryObject<Item> SCARLET_CHEESE_STOUT = CHALLENGE_DRINKS.register("scarlet_cheese_stout",
	                                                                                          () -> new BoozeItem(BrewersFluids.SCARLET_CHEESE_STOUT.source().get(),
	                                                                                                              foodItem(BeverageProperties.SCARLET_CHEESE_STOUT)));
	public static final RegistryObject<Item> FLYING_DUTCHMAN = CHALLENGE_DRINKS.register("flying_dutchman",
	                                                                                     () -> new BoozeItem(BrewersFluids.FLYING_DUTCHMAN.source().get(),
	                                                                                                         foodItem(BeverageProperties.FLYING_DUTCHMAN)));
	// Bloat TODO: Commented out due to poor balancing and low texture variety.
	//    public static final RegistryObject<Item> ABSINTHE = DRINKS.register("absinthe",
	//                                                                        () -> new BoozeItem(BrewersFluids.ABSINTHE.source().get(), foodItem(BeverageProperties.ABSINTHE)));
	//    public static final RegistryObject<Item> AMARO = DRINKS.register("amaro",
	//                                                                     () -> new BoozeItem(BrewersFluids.AMARO.source().get(), foodItem(BeverageProperties.AMARO)));
	//    public static final RegistryObject<Item> AMONTILLADO = DRINKS.register("amontillado",
	//                                                                           () -> new BoozeItem(BrewersFluids.AMONTILLADO.source().get(), foodItem(BeverageProperties.AMONTILLADO)));
	//    public static final RegistryObject<Item> APEROL = DRINKS.register("aperol",
	//                                                                      () -> new BoozeItem(BrewersFluids.APEROL.source().get(), foodItem(BeverageProperties.APEROL)));
	//    public static final RegistryObject<Item> ARMAGNAC = DRINKS.register("armagnac",
	//                                                                        () -> new BoozeItem(BrewersFluids.ARMAGNAC.source().get(), foodItem(BeverageProperties.ARMAGNAC)));
	//    public static final RegistryObject<Item> BAIJIU = DRINKS.register("baijiu",
	//                                                                      () -> new BoozeItem(BrewersFluids.BAIJIU.source().get(), foodItem(BeverageProperties.BAIJIU)));
	//    public static final RegistryObject<Item> BECHEROVKA = DRINKS.register("becherovka",
	//                                                                          () -> new BoozeItem(BrewersFluids.BECHEROVKA.source().get(), foodItem(BeverageProperties.BECHEROVKA)));
	//    public static final RegistryObject<Item> BITTER = DRINKS.register("bitter",
	//                                                                      () -> new BoozeItem(BrewersFluids.BITTER.source().get(), foodItem(BeverageProperties.BITTER)));
	//    public static final RegistryObject<Item> CALVADOS = DRINKS.register("calvados",
	//                                                                        () -> new BoozeItem(BrewersFluids.CALVADOS.source().get(), foodItem(BeverageProperties.CALVADOS)));
	//    public static final RegistryObject<Item> CAMPARI = DRINKS.register("campari",
	//                                                                       () -> new BoozeItem(BrewersFluids.CAMPARI.source().get(), foodItem(BeverageProperties.CAMPARI)));
	//    public static final RegistryObject<Item> CHACHA = DRINKS.register("chacha",
	//                                                                      () -> new BoozeItem(BrewersFluids.CHACHA.source().get(), foodItem(BeverageProperties.CHACHA)));
	//    public static final RegistryObject<Item> FERNET = DRINKS.register("fernet",
	//                                                                      () -> new BoozeItem(BrewersFluids.FERNET.source().get(), foodItem(BeverageProperties.FERNET)));
	//    public static final RegistryObject<Item> GLUHWEIN = DRINKS.register("gluhwein",
	//                                                                        () -> new BoozeItem(BrewersFluids.GLUHWEIN.source().get(), foodItem(BeverageProperties.GLUHWEIN)));
	//    public static final RegistryObject<Item> GROG = DRINKS.register("grog",
	//                                                                    () -> new BoozeItem(BrewersFluids.GROG.source().get(), foodItem(BeverageProperties.GROG)));
	//    public static final RegistryObject<Item> KASHASA = DRINKS.register("kashasa",
	//                                                                       () -> new BoozeItem(BrewersFluids.KASHASA.source().get(), foodItem(BeverageProperties.KASHASA)));
	//    public static final RegistryObject<Item> MEZCAL = DRINKS.register("mezcal",
	//                                                                      () -> new BoozeItem(BrewersFluids.MEZCAL.source().get(), foodItem(BeverageProperties.MEZCAL)));
	//    public static final RegistryObject<Item> NEGRONI = DRINKS.register("negroni",
	//                                                                       () -> new BoozeItem(BrewersFluids.NEGRONI.source().get(), foodItem(BeverageProperties.NEGRONI)));
	//    public static final RegistryObject<Item> OUZO = DRINKS.register("ouzo",
	//                                                                    () -> new BoozeItem(BrewersFluids.OUZO.source().get(), foodItem(BeverageProperties.OUZO)));
	//    public static final RegistryObject<Item> PASTIS = DRINKS.register("pastis",
	//                                                                      () -> new BoozeItem(BrewersFluids.PASTIS.source().get(), foodItem(BeverageProperties.PASTIS)));
	//    public static final RegistryObject<Item> PUNCH = DRINKS.register("punch",
	//                                                                     () -> new BoozeItem(BrewersFluids.PUNCH.source().get(), foodItem(BeverageProperties.PUNCH)));
	//    public static final RegistryObject<Item> RAKIA = DRINKS.register("rakia",
	//                                                                     () -> new BoozeItem(BrewersFluids.RAKIA.source().get(), foodItem(BeverageProperties.RAKIA)));
	//    public static final RegistryObject<Item> SAMBUCA = DRINKS.register("sambuca",
	//                                                                       () -> new BoozeItem(BrewersFluids.SAMBUCA.source().get(), foodItem(BeverageProperties.SAMBUCA)));
	//    public static final RegistryObject<Item> SHERRY = DRINKS.register("sherry",
	//                                                                      () -> new BoozeItem(BrewersFluids.SHERRY.source().get(), foodItem(BeverageProperties.SHERRY)));
	//    public static final RegistryObject<Item> SOCATA = DRINKS.register("socata",
	//                                                                      () -> new BoozeItem(BrewersFluids.SOCATA.source().get(), foodItem(BeverageProperties.SOCATA)));
	//    public static final RegistryObject<Item> SOJU = DRINKS.register("soju",
	//                                                                    () -> new BoozeItem(BrewersFluids.SOJU.source().get(), foodItem(BeverageProperties.SOJU)));
	//    public static final RegistryObject<Item> SOTOL = DRINKS.register("sotol",
	//                                                                     () -> new BoozeItem(BrewersFluids.SOTOL.source().get(), foodItem(BeverageProperties.SOTOL)));
	//    public static final RegistryObject<Item> TODDY = DRINKS.register("toddy",
	//                                                                     () -> new BoozeItem(BrewersFluids.TODDY.source().get(), foodItem(BeverageProperties.TODDY)));
	//    public static final RegistryObject<Item> TRIPLE_SEC = DRINKS.register("triple-sec",
	//                                                                          () -> new BoozeItem(BrewersFluids.TRIPLE_SEC.source().get(), foodItem(BeverageProperties.TRIPLE_SEC)));
	//    public static final RegistryObject<Item> TSIPURO = DRINKS.register("tsipuro",
	//                                                                       () -> new BoozeItem(BrewersFluids.TSIPURO.source().get(), foodItem(BeverageProperties.TSIPURO)));
	//    public static final RegistryObject<Item> VERMOUTH = DRINKS.register("vermouth",
	//                                                                        () -> new BoozeItem(BrewersFluids.VERMOUTH.source().get(), foodItem(BeverageProperties.VERMOUTH)));
	//    public static final RegistryObject<Item> TSUIKE = DRINKS.register("tsuike",
	//                                                                      () -> new BoozeItem(BrewersFluids.TSUIKE.source().get(), foodItem(BeverageProperties.TSUIKE)));
	//    public static final RegistryObject<Item> VISHINATA = DRINKS.register("vishinata",
	//                                                                         () -> new BoozeItem(BrewersFluids.VISHINATA.source().get(), foodItem(BeverageProperties.VISHINATA)));
	public static final RegistryObject<Item> GUT_WRECKER = CHALLENGE_DRINKS.register("gut_wrecker",
	                                                                                 () -> new BoozeItem(BrewersFluids.GUT_WRECKER.source().get(),
	                                                                                                     foodItem(BeverageProperties.GUT_WRECKER)));
	// Vintage beverages
	public static final RegistryObject<Item> SBITEN = VINTAGE_DRINKS.register("sbiten",
	                                                                          () -> new BoozeItem(BrewersFluids.SBITEN.source().get(), foodItem(BeverageProperties.SBITEN)));
	public static final RegistryObject<Item> SYTA = VINTAGE_DRINKS.register("syta",
	                                                                        () -> new BoozeItem(BrewersFluids.SYTA.source().get(), foodItem(BeverageProperties.SYTA)));
	public static final RegistryObject<Item> VZVAR = VINTAGE_DRINKS.register("vzvar",
	                                                                         () -> new BoozeItem(BrewersFluids.VZVAR.source().get(), foodItem(BeverageProperties.VZVAR)));
	// Corn
	public static final RegistryObject<Item> BOURBON = COMPAT_DRINKS.register("bourbon",
	                                                                          () -> new BoozeItem(BrewersFluids.BOURBON.source().get(), foodItem(BeverageProperties.BOURBON)));
	public static final RegistryObject<Item> CORN_WHISKY = COMPAT_DRINKS.register("corn_whisky",
	                                                                              () -> new BoozeItem(BrewersFluids.CORN_WHISKY.source().get(),
	                                                                                                  foodItem(BeverageProperties.CORN_WHISKY)));
	public static final RegistryObject<Item> MOONSHINE = COMPAT_DRINKS.register("moonshine",
	                                                                            () -> new BoozeItem(BrewersFluids.MOONSHINE.source().get(),
	                                                                                                foodItem(BeverageProperties.MOONSHINE)));
	// Compatibility
	// BnC 3.0 does have a function for registering items with mod dependency: registerWithTab(String name, Item item, @Nullable String requiredMod)
	// However, mods adding corn or grapes are frequent, and you can't account for all of them manually.
	// Grapes
	public static final RegistryObject<Item> CAHORS = COMPAT_DRINKS.register("cahors",
	                                                                         () -> new BoozeItem(BrewersFluids.CAHORS.source().get(), foodItem(BeverageProperties.CAHORS)));
	public static final RegistryObject<Item> CHAMPAGNE = COMPAT_DRINKS.register("champagne",
	                                                                            () -> new BoozeItem(BrewersFluids.CHAMPAGNE.source().get(),
	                                                                                                foodItem(BeverageProperties.CHAMPAGNE)));
	public static final RegistryObject<Item> COGNAC = COMPAT_DRINKS.register("cognac",
	                                                                         () -> new BoozeItem(BrewersFluids.COGNAC.source().get(), foodItem(BeverageProperties.COGNAC)));
	public static final RegistryObject<Item> MARTINI = COMPAT_DRINKS.register("martini",
	                                                                          () -> new BoozeItem(BrewersFluids.MARTINI.source().get(), foodItem(BeverageProperties.MARTINI)));
	
	/**
	 * @throws IllegalArgumentException if both hasTankardVariant and hasGlassVariant arguments are false
	 */
	public static RegistryObject<Item> registerBeverage(DeferredRegister<Item> registry, String name, BrewersFluids.FluidRegistryObject fluid, FoodProperties food,
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
				registry.register(name + "_glass", () -> new BoozeItem(fluid.source().get(), foodItem(food, Items.GLASS_BOTTLE)));
			}
			
			return DrinkItem;
		}
		
		// If no tankard variant only register the glass one
		DrinkItem = registry.register(name + "_glass", () -> new BoozeItem(fluid.source().get(), foodItem(food, Items.GLASS_BOTTLE)));
		
		return DrinkItem;
	}

	public static RegistryObject<Item> registerBeverage(DeferredRegister<Item> registry, String name, BrewersFluids.FluidRegistryObject fluid, FoodProperties food,
	                                                    boolean hasGlassVariant)
	{
		return registerBeverage(registry, name, fluid, food, true, hasGlassVariant);
	}

	public static RegistryObject<Item> registerBeverage(DeferredRegister<Item> registry, String name, BrewersFluids.FluidRegistryObject fluid, FoodProperties food)
	{
		return registerBeverage(registry, name, fluid, food, true, false);
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
