package pupkin.brewersdelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.misc.BeverageProperties;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BCItems;

@SuppressWarnings("unused")
public class BrewersItems {
	public static final int BRIEF_DURATION = 1;             // 1 minute
	public static final int VERY_SHORT_DURATION = 3;        // 3 minutes
	public static final int SHORT_DURATION = 4;             // 4 minutes
	public static final int MEDIUM_DURATION = 5;            // 5 minutes
	public static final int EXTENDED_DURATION = 8;          // 8 minutes
	public static final int LONG_DURATION = 10;             // 10 minutes
	public static final int PROLONGED_DURATION = 12;        // 12 minutes
	public static final int VERY_LONG_DURATION = 20;        // 20 minutes
	
	public static final DeferredRegister<Item> BEVERAGES = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	public static final DeferredRegister<Item> CHALLENGE_BEVERAGES = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	public static final DeferredRegister<Item> VINTAGE_BEVERAGES = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	public static final DeferredRegister<Item> COMPAT_BEVERAGES = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	
	// Basic (Farmers Delight)
	public static final RegistryObject<Item> BRAGA = BEVERAGES.register("braga",
			() -> new BoozeItem(2, VERY_SHORT_DURATION, foodItem(BeverageProperties.BRAGA)));
	public static final RegistryObject<Item> BRANDY = BEVERAGES.register("brandy",
			() -> new BoozeItem(2, VERY_SHORT_DURATION, foodItem(BeverageProperties.BRANDY)));
	public static final RegistryObject<Item> CIDER = BEVERAGES.register("cider",
			() -> new BoozeItem(2, VERY_SHORT_DURATION, foodItem(BeverageProperties.CIDER)));
	public static final RegistryObject<Item> COMPOTE = BEVERAGES.register("compote",
			() -> new BoozeItem(0, 0, foodItem(BeverageProperties.COMPOTE)));
	public static final RegistryObject<Item> GIN = BEVERAGES.register("gin",
			() -> new BoozeItem(3, MEDIUM_DURATION, foodItem(BeverageProperties.GIN)));
	public static final RegistryObject<Item> KVASS = BEVERAGES.register("kvass",
			() -> new BoozeItem(0, VERY_SHORT_DURATION, foodItem(BeverageProperties.KVASS)));
	public static final RegistryObject<Item> LIQUEUR = BEVERAGES.register("liqueur",
			() -> new BoozeItem(3, SHORT_DURATION, foodItem(BeverageProperties.LIQUEUR)));
	public static final RegistryObject<Item> MELON_SCHNAPPS = BEVERAGES.register("melon_schnapps",
			() -> new BoozeItem(2, LONG_DURATION, foodItem(BeverageProperties.MELON_SCHNAPPS)));
	public static final RegistryObject<Item> OLD_FASHION = BEVERAGES.register("old_fashion",
			() -> new BoozeItem(4, VERY_LONG_DURATION, foodItem(BeverageProperties.OLD_FASHION)));
	public static final RegistryObject<Item> SAKE = BEVERAGES.register("sake",
			() -> new BoozeItem(3, MEDIUM_DURATION, foodItem(BeverageProperties.SAKE)));
	public static final RegistryObject<Item> TEQUILA = BEVERAGES.register("tequila",
			() -> new BoozeItem(6, VERY_LONG_DURATION, foodItem(BeverageProperties.TEQUILA)));
	public static final RegistryObject<Item> WHISKY = BEVERAGES.register("whisky",
			() -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.WHISKY)));
	
	// Bloat TODO: Commented out due to poor balancing and low texture variety.
	//    public static final RegistryObject<Item> ABSINTHE = BEVERAGES.register("absinthe",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.ABSINTHE)));
	//    public static final RegistryObject<Item> AMARO = BEVERAGES.register("amaro",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.AMARO)));
	//    public static final RegistryObject<Item> AMONTILLADO = BEVERAGES.register("amontillado",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.AMONTILLADO)));
	//    public static final RegistryObject<Item> APEROL = BEVERAGES.register("aperol",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.APEROL)));
	//    public static final RegistryObject<Item> ARMAGNAC = BEVERAGES.register("armagnac",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.ARMAGNAC)));
	//    public static final RegistryObject<Item> BAIJIU = BEVERAGES.register("baijiu",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.BAIJIU)));
	//    public static final RegistryObject<Item> BECHEROVKA = BEVERAGES.register("becherovka",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.BECHEROVKA)));
	//    public static final RegistryObject<Item> BITTER = BEVERAGES.register("bitter",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.BITTER)));
	//    public static final RegistryObject<Item> CALVADOS = BEVERAGES.register("calvados",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.CALVADOS)));
	//    public static final RegistryObject<Item> CAMPARI = BEVERAGES.register("campari",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.CAMPARI)));
	//    public static final RegistryObject<Item> CHACHA = BEVERAGES.register("chacha",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.CHACHA)));
	//    public static final RegistryObject<Item> FERNET = BEVERAGES.register("fernet",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.FERNET)));
	//    public static final RegistryObject<Item> GLUHWEIN = BEVERAGES.register("gluhwein",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.GLUHWEIN)));
	//    public static final RegistryObject<Item> GROG = BEVERAGES.register("grog",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.GROG)));
	//    public static final RegistryObject<Item> KASHASA = BEVERAGES.register("kashasa",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.KASHASA)));
	//    public static final RegistryObject<Item> MEZCAL = BEVERAGES.register("mezcal",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.MEZCAL)));
	//    public static final RegistryObject<Item> NEGRONI = BEVERAGES.register("negroni",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.NEGRONI)));
	//    public static final RegistryObject<Item> OUZO = BEVERAGES.register("ouzo",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.OUZO)));
	//    public static final RegistryObject<Item> PASTIS = BEVERAGES.register("pastis",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.PASTIS)));
	//    public static final RegistryObject<Item> PUNCH = BEVERAGES.register("punch",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.PUNCH)));
	//    public static final RegistryObject<Item> RAKIA = BEVERAGES.register("rakia",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.RAKIA)));
	//    public static final RegistryObject<Item> RUM = BEVERAGES.register("rum",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.RUM)));
	//    public static final RegistryObject<Item> SAMBUCA = BEVERAGES.register("sambuca",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.SAMBUCA)));
	//    public static final RegistryObject<Item> SHERRY = BEVERAGES.register("sherry",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.SHERRY)));
	//    public static final RegistryObject<Item> SOCATA = BEVERAGES.register("socata",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.SOCATA)));
	//    public static final RegistryObject<Item> SOJU = BEVERAGES.register("soju",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.SOJU)));
	//    public static final RegistryObject<Item> SOTOL = BEVERAGES.register("sotol",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.SOTOL)));
	//    public static final RegistryObject<Item> TODDY = BEVERAGES.register("toddy",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.TODDY)));
	//    public static final RegistryObject<Item> TRIPLE_SEC = BEVERAGES.register("triple-sec",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.TRIPLE_SEC)));
	//    public static final RegistryObject<Item> TSIPURO = BEVERAGES.register("tsipuro",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.TSIPURO)));
	//    public static final RegistryObject<Item> VERMOUTH = BEVERAGES.register("vermouth",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.VERMOUTH)));
	//    public static final RegistryObject<Item> TSUIKE = BEVERAGES.register("tsuike",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.TSUIKE)));
	//    public static final RegistryObject<Item> VISHINATA = BEVERAGES.register("vishinata",
	//            () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.VISHINATA)));
	
	// Compatibility
	// Note to self: Brewin' and Chewin' handles compatibility by... not giving a damn.
	// Kombucha throws an error loading recipe if farmers respite isn't loaded, which disables the recipe.
	// Not the most elegant solution, but good enough?...
	
	// Corn
	public static final RegistryObject<Item> BOURBON = COMPAT_BEVERAGES.register("bourbon",
			() -> new BoozeItem(3, LONG_DURATION, foodItem(BeverageProperties.BOURBON)));
	public static final RegistryObject<Item> CORN_WHISKY = COMPAT_BEVERAGES.register("corn_whisky",
			() -> new BoozeItem(2, EXTENDED_DURATION, foodItem(BeverageProperties.CORN_WHISKY)));
	public static final RegistryObject<Item> MOONSHINE = COMPAT_BEVERAGES.register("moonshine",
			() -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.MOONSHINE)));
	
	// Grapes
	public static final RegistryObject<Item> CAHORS = COMPAT_BEVERAGES.register("cahors",
			() -> new BoozeItem(5, BRIEF_DURATION, foodItem(BeverageProperties.CAHORS)));
	public static final RegistryObject<Item> CHAMPAGNE = COMPAT_BEVERAGES.register("champagne",
			() -> new BoozeItem(1, BRIEF_DURATION, foodItem(BeverageProperties.CHAMPAGNE)));
	public static final RegistryObject<Item> COGNAC = COMPAT_BEVERAGES.register("cognac",
			() -> new BoozeItem(5, VERY_LONG_DURATION, foodItem(BeverageProperties.COGNAC)));
	public static final RegistryObject<Item> MARTINI = COMPAT_BEVERAGES.register("martini",
			() -> new BoozeItem(2, BRIEF_DURATION, foodItem(BeverageProperties.MARTINI)));
	
	// Challenge beverages
	public static final RegistryObject<Item> FLAXEN_CHEESE_STOUT = CHALLENGE_BEVERAGES.register("flaxen_cheese_stout",
			() -> new BoozeItem(1, PROLONGED_DURATION, foodItem(BeverageProperties.FLAXEN_CHEESE_STOUT)));
	public static final RegistryObject<Item> SCARLET_CHEESE_STOUT = CHALLENGE_BEVERAGES.register("scarlet_cheese_stout",
			() -> new BoozeItem(1, PROLONGED_DURATION + 2, foodItem(BeverageProperties.SCARLET_CHEESE_STOUT)));
	public static final RegistryObject<Item> FLYING_DUTCHMAN = CHALLENGE_BEVERAGES.register("flying_dutchman",
			() -> new BoozeItem(2, MEDIUM_DURATION, foodItem(BeverageProperties.FLYING_DUTCHMAN)));
	public static final RegistryObject<Item> GUT_WRECKER = CHALLENGE_BEVERAGES.register("gut_wrecker",
			() -> new BoozeItem(5, PROLONGED_DURATION, foodItem(BeverageProperties.GUT_WRECKER)));
	
	// Vintage beverages
	public static final RegistryObject<Item> SBITEN = VINTAGE_BEVERAGES.register("sbiten",
			() -> new BoozeItem(1, BRIEF_DURATION, foodItem(BeverageProperties.SBITEN)));
	public static final RegistryObject<Item> SYTA = VINTAGE_BEVERAGES.register("syta",
			() -> new BoozeItem(1, SHORT_DURATION, foodItem(BeverageProperties.SYTA)));
	public static final RegistryObject<Item> VZVAR = VINTAGE_BEVERAGES.register("vzvar",
			() -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.VZVAR)));
	
	public static Item.@NotNull Properties foodItem(FoodProperties food) {
		return new Item.Properties().food(food).stacksTo(16).craftRemainder(BCItems.TANKARD.get());
	}
	
	public static void register(IEventBus eventBus) {
		BEVERAGES.register(eventBus);
		CHALLENGE_BEVERAGES.register(eventBus);
		VINTAGE_BEVERAGES.register(eventBus);
		COMPAT_BEVERAGES.register(eventBus);
	}
}
