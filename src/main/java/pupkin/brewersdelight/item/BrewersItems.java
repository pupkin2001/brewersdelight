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
public class BrewersItems
{
	public static final int BRIEF_DURATION = 1;             // 1 minute
	public static final int VERY_SHORT_DURATION = 3;        // 3 minutes
	public static final int SHORT_DURATION = 4;             // 4 minutes
	public static final int MEDIUM_DURATION = 5;            // 5 minutes
	public static final int EXTENDED_DURATION = 8;          // 8 minutes
	public static final int LONG_DURATION = 10;             // 10 minutes
	public static final int PROLONGED_DURATION = 12;        // 12 minutes
	public static final int VERY_LONG_DURATION = 20;        // 20 minutes
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	
	// Basic (Farmers Delight)
	public static final RegistryObject<Item> BRAGA = ITEMS.register("braga",
	                                                                 () -> new BoozeItem(2, VERY_SHORT_DURATION, foodItem(BeverageProperties.BRAGA)));
	public static final RegistryObject<Item> BRANDY = ITEMS.register("brandy",
	                                                                 () -> new BoozeItem(2, VERY_SHORT_DURATION, foodItem(BeverageProperties.BRANDY)));
	public static final RegistryObject<Item> CIDER = ITEMS.register("cider",
	                                                                () -> new BoozeItem(2, VERY_SHORT_DURATION, foodItem(BeverageProperties.CIDER)));
	public static final RegistryObject<Item> COMPOTE = ITEMS.register("compote",
	                                                                  () -> new BoozeItem(0, 0, foodItem(BeverageProperties.COMPOTE)));
	public static final RegistryObject<Item> GIN = ITEMS.register("gin",
	                                                              () -> new BoozeItem(3, MEDIUM_DURATION, foodItem(BeverageProperties.GIN)));
	public static final RegistryObject<Item> KVASS = ITEMS.register("kvass",
	                                                                () -> new BoozeItem(0, VERY_SHORT_DURATION, foodItem(BeverageProperties.KVASS)));
	public static final RegistryObject<Item> LIQUEUR = ITEMS.register("liqueur",
	                                                                  () -> new BoozeItem(3, SHORT_DURATION, foodItem(BeverageProperties.LIQUEUR)));
	public static final RegistryObject<Item> MELON_SCHNAPPS = ITEMS.register("melon_schnapps",
	                                                                         () -> new BoozeItem(2, LONG_DURATION, foodItem(BeverageProperties.MELON_SCHNAPPS)));
	public static final RegistryObject<Item> OLD_FASHION = ITEMS.register("old_fashion",
	                                                                      () -> new BoozeItem(4, VERY_LONG_DURATION, foodItem(BeverageProperties.OLD_FASHION)));
	public static final RegistryObject<Item> SAKE = ITEMS.register("sake",
	                                                               () -> new BoozeItem(3, MEDIUM_DURATION, foodItem(BeverageProperties.SAKE)));
	public static final RegistryObject<Item> SBITEN = ITEMS.register("sbiten",
	                                                                 () -> new BoozeItem(1, BRIEF_DURATION, foodItem(BeverageProperties.SBITEN)));
	public static final RegistryObject<Item> SYTA = ITEMS.register("syta",
	                                                               () -> new BoozeItem(1, SHORT_DURATION, foodItem(BeverageProperties.SYTA)));
	public static final RegistryObject<Item> TEQUILA = ITEMS.register("tequila",
	                                                                  () -> new BoozeItem(6, VERY_LONG_DURATION, foodItem(BeverageProperties.TEQUILA)));
	public static final RegistryObject<Item> VZVAR = ITEMS.register("vzvar",
	                                                               () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.VZVAR))); // TODO
	public static final RegistryObject<Item> WHISKY = ITEMS.register("whisky",
	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.WHISKY)));
	
	// Bloat TODO: Commented out due to poor balancing and low texture variety.
//	public static final RegistryObject<Item> ABSINTHE = ITEMS.register("absinthe",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.ABSINTHE)));
//	public static final RegistryObject<Item> AMARO = ITEMS.register("amaro",
//	                                                                   () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.AMARO)));
//	public static final RegistryObject<Item> AMONTILLADO = ITEMS.register("amontillado",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.AMONTILLADO)));
//	public static final RegistryObject<Item> APEROL = ITEMS.register("aperol",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.APEROL)));
//	public static final RegistryObject<Item> ARMAGNAC = ITEMS.register("armagnac",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.ARMAGNAC)));
//	public static final RegistryObject<Item> BAIJIU = ITEMS.register("baijiu",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.BAIJIU)));
//	public static final RegistryObject<Item> BECHEROVKA = ITEMS.register("becherovka",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.BECHEROVKA)));
//	public static final RegistryObject<Item> BITTER = ITEMS.register("bitter",
//	                                                                     () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.BITTER)));
//	public static final RegistryObject<Item> CALVADOS = ITEMS.register("calvados",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.CALVADOS)));
//	public static final RegistryObject<Item> CAMPARI = ITEMS.register("campari",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.CAMPARI)));
//	public static final RegistryObject<Item> CHACHA = ITEMS.register("chacha",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.CHACHA)));
//	public static final RegistryObject<Item> FERNET = ITEMS.register("fernet",
//	                                                                  () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.FERNET)));
//	public static final RegistryObject<Item> GLUHWEIN = ITEMS.register("gluhwein",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.GLUHWEIN)));
//	public static final RegistryObject<Item> GROG = ITEMS.register("grog",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.GROG)));
//	public static final RegistryObject<Item> KASHASA = ITEMS.register("kashasa",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.KASHASA)));
//	public static final RegistryObject<Item> MEZCAL = ITEMS.register("mezcal",
//	                                                                  () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.MEZCAL)));
//	public static final RegistryObject<Item> NEGRONI = ITEMS.register("negroni",
//	                                                                  () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.NEGRONI)));
//	public static final RegistryObject<Item> OUZO = ITEMS.register("ouzo",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.OUZO)));
//	public static final RegistryObject<Item> PASTIS = ITEMS.register("pastis",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.PASTIS)));
//	public static final RegistryObject<Item> PUNCH = ITEMS.register("punch",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.PUNCH)));
//	public static final RegistryObject<Item> RAKIA = ITEMS.register("rakia",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.RAKIA)));
//	public static final RegistryObject<Item> RUM = ITEMS.register("rum",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.RUM)));
//	public static final RegistryObject<Item> SAMBUCA = ITEMS.register("sambuca",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.SAMBUCA)));
//	public static final RegistryObject<Item> SHERRY = ITEMS.register("sherry",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.SHERRY)));
//	public static final RegistryObject<Item> SOCATA = ITEMS.register("socata",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.SOCATA)));
//	public static final RegistryObject<Item> SOJU = ITEMS.register("soju",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.SOJU)));
//	public static final RegistryObject<Item> SOTOL = ITEMS.register("sotol",
//	                                                               () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.SOTOL)));
//	public static final RegistryObject<Item> TODDY = ITEMS.register("toddy",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.TODDY)));
//	public static final RegistryObject<Item> TRIPLE_SEC = ITEMS.register("triple-sec",
//	                                                                     () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.TRIPLE_SEC)));
//	public static final RegistryObject<Item> TSIPURO = ITEMS.register("tsipuro",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.TSIPURO)));
//	public static final RegistryObject<Item> VERMOUTH = ITEMS.register("vermouth",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.VERMOUTH)));
//	public static final RegistryObject<Item> TSUIKE = ITEMS.register("tsuike",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.TSUIKE)));
//	public static final RegistryObject<Item> VISHINATA = ITEMS.register("vishinata",
//	                                                                 () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.VISHINATA)));
	
	// Note to self: Brewin' and Chewin' handles compatibility by... not giving a damn.
	// Kombucha throws an error loading recipe if farmers respite isn't loaded, which disables the recipe.
	// Not the most elegant solution, but good enough?...
	
	// Corn
	public static final RegistryObject<Item> BOURBON = ITEMS.register("bourbon",
	                                                                  () -> new BoozeItem(3, LONG_DURATION, foodItem(BeverageProperties.BOURBON)));
	public static final RegistryObject<Item> CORN_WHISKY = ITEMS.register("corn_whisky",
	                                                                      () -> new BoozeItem(2, EXTENDED_DURATION, foodItem(BeverageProperties.CORN_WHISKY)));
	public static final RegistryObject<Item> MOONSHINE = ITEMS.register("moonshine",
	                                                                    () -> new BoozeItem(3, VERY_LONG_DURATION, foodItem(BeverageProperties.MOONSHINE)));
	
	// Grapes
	public static final RegistryObject<Item> CAHORS = ITEMS.register("cahors",
	                                                                 () -> new BoozeItem(5, BRIEF_DURATION, foodItem(BeverageProperties.CAHORS)));
	public static final RegistryObject<Item> CHAMPAGNE = ITEMS.register("champagne",
	                                                                    () -> new BoozeItem(1, BRIEF_DURATION, foodItem(BeverageProperties.CHAMPAGNE)));
	public static final RegistryObject<Item> COGNAC = ITEMS.register("cognac",
	                                                                 () -> new BoozeItem(5, VERY_LONG_DURATION, foodItem(BeverageProperties.COGNAC)));
	public static final RegistryObject<Item> MARTINI = ITEMS.register("martini",
	                                                                  () -> new BoozeItem(2, BRIEF_DURATION, foodItem(BeverageProperties.MARTINI)));
	
	// Challenge beverages
	public static final RegistryObject<Item> FLAXEN_CHEESE_STOUT = ITEMS.register("flaxen_cheese_stout",
	                                                                              () -> new BoozeItem(1, PROLONGED_DURATION, foodItem(BeverageProperties.FLAXEN_CHEESE_STOUT)));
	public static final RegistryObject<Item> SCARLET_CHEESE_STOUT = ITEMS.register("scarlet_cheese_stout",
	                                                                               () -> new BoozeItem(1, PROLONGED_DURATION + 2, foodItem(BeverageProperties.SCARLET_CHEESE_STOUT)));
	public static final RegistryObject<Item> FLYING_DUTCHMAN = ITEMS.register("flying_dutchman",
	                                                                          () -> new BoozeItem(2, MEDIUM_DURATION, foodItem(BeverageProperties.FLYING_DUTCHMAN)));
	public static final RegistryObject<Item> GUT_WRECKER = ITEMS.register("gut_wrecker",
	                                                                          () -> new BoozeItem(5, PROLONGED_DURATION, foodItem(BeverageProperties.GUT_WRECKER)));
	
	public static Item.@NotNull Properties foodItem(FoodProperties food)
	{
		return new Item.Properties().food(food).stacksTo(16).craftRemainder(BCItems.TANKARD.get());
	}
	
	public static void register(IEventBus eventBus)
	{
		ITEMS.register(eventBus);
	}
}
