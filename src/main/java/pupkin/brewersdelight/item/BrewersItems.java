package pupkin.brewersdelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.misc.BeverageProperties;
import pupkin.brewersdelight.misc.BrewersFluids;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BnCFluids;
import umpaz.brewinandchewin.common.registry.BnCFoods;
import umpaz.brewinandchewin.common.registry.BnCItems;

@SuppressWarnings("unused")
public class BrewersItems
{
	public static final DeferredRegister<Item> BEVERAGES = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	public static final DeferredRegister<Item> CHALLENGE_BEVERAGES = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	public static final DeferredRegister<Item> VINTAGE_BEVERAGES = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	public static final DeferredRegister<Item> COMPAT_BEVERAGES = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	
	// Basic (Farmers Delight)
	public static final RegistryObject<Item> BRAGA = BEVERAGES.register("braga",
	            // The .source() gets the RegistryObject<FlowingFluid> from the record, and then .get() gets the actual fluid instance.
	            () -> new BoozeItem(BrewersFluids.BRAGA.source().get(), foodItem(BeverageProperties.BRAGA)));
	public static final RegistryObject<Item> BRANDY = BEVERAGES.register("brandy",
                () -> new BoozeItem(BrewersFluids.BRANDY.source().get(), foodItem(BeverageProperties.BRANDY)));
	public static final RegistryObject<Item> CIDER = BEVERAGES.register("cider",
			() -> new BoozeItem(BrewersFluids.CIDER.source().get(), foodItem(BeverageProperties.CIDER)));
	public static final RegistryObject<Item> COMPOTE = BEVERAGES.register("compote",
			() -> new BoozeItem(BrewersFluids.COMPOTE.source().get(), foodItem(BeverageProperties.COMPOTE)));
	public static final RegistryObject<Item> GIN = BEVERAGES.register("gin",
			() -> new BoozeItem(BrewersFluids.GIN.source().get(), foodItem(BeverageProperties.GIN)));
	public static final RegistryObject<Item> KVASS = BEVERAGES.register("kvass",
			() -> new BoozeItem(BrewersFluids.KVASS.source().get(), foodItem(BeverageProperties.KVASS)));
	public static final RegistryObject<Item> LIQUEUR = BEVERAGES.register("liqueur",
			() -> new BoozeItem(BrewersFluids.LIQUEUR.source().get(), foodItem(BeverageProperties.LIQUEUR)));
	public static final RegistryObject<Item> MELON_SCHNAPPS = BEVERAGES.register("melon_schnapps",
			() -> new BoozeItem(BrewersFluids.MELON_SCHNAPPS.source().get(), foodItem(BeverageProperties.MELON_SCHNAPPS)));
	public static final RegistryObject<Item> OLD_FASHION = BEVERAGES.register("old_fashion",
			() -> new BoozeItem(BrewersFluids.OLD_FASHION.source().get(), foodItem(BeverageProperties.OLD_FASHION)));
	public static final RegistryObject<Item> SAKE = BEVERAGES.register("sake",
			() -> new BoozeItem(BrewersFluids.SAKE.source().get(), foodItem(BeverageProperties.SAKE)));
	public static final RegistryObject<Item> TEQUILA = BEVERAGES.register("tequila",
			() -> new BoozeItem(BrewersFluids.TEQUILA.source().get(), foodItem(BeverageProperties.TEQUILA)));
	public static final RegistryObject<Item> WHISKY = BEVERAGES.register("whisky",
			() -> new BoozeItem(BrewersFluids.WHISKY.source().get(), foodItem(BeverageProperties.WHISKY)));
	
	// Bloat TODO: Commented out due to poor balancing and low texture variety.
    public static final RegistryObject<Item> ABSINTHE = BEVERAGES.register("absinthe",
            () -> new BoozeItem(BrewersFluids.ABSINTHE.source().get(), foodItem(BeverageProperties.ABSINTHE)));
    public static final RegistryObject<Item> AMARO = BEVERAGES.register("amaro",
            () -> new BoozeItem(BrewersFluids.AMARO.source().get(), foodItem(BeverageProperties.AMARO)));
    public static final RegistryObject<Item> AMONTILLADO = BEVERAGES.register("amontillado",
            () -> new BoozeItem(BrewersFluids.AMONTILLADO.source().get(), foodItem(BeverageProperties.AMONTILLADO)));
    public static final RegistryObject<Item> APEROL = BEVERAGES.register("aperol",
            () -> new BoozeItem(BrewersFluids.APEROL.source().get(), foodItem(BeverageProperties.APEROL)));
    public static final RegistryObject<Item> ARMAGNAC = BEVERAGES.register("armagnac",
            () -> new BoozeItem(BrewersFluids.ARMAGNAC.source().get(), foodItem(BeverageProperties.ARMAGNAC)));
    public static final RegistryObject<Item> BAIJIU = BEVERAGES.register("baijiu",
            () -> new BoozeItem(BrewersFluids.BAIJIU.source().get(), foodItem(BeverageProperties.BAIJIU)));
    public static final RegistryObject<Item> BECHEROVKA = BEVERAGES.register("becherovka",
            () -> new BoozeItem(BrewersFluids.BECHEROVKA.source().get(), foodItem(BeverageProperties.BECHEROVKA)));
    public static final RegistryObject<Item> BITTER = BEVERAGES.register("bitter",
            () -> new BoozeItem(BrewersFluids.BITTER.source().get(), foodItem(BeverageProperties.BITTER)));
    public static final RegistryObject<Item> CALVADOS = BEVERAGES.register("calvados",
            () -> new BoozeItem(BrewersFluids.CALVADOS.source().get(), foodItem(BeverageProperties.CALVADOS)));
    public static final RegistryObject<Item> CAMPARI = BEVERAGES.register("campari",
            () -> new BoozeItem(BrewersFluids.CAMPARI.source().get(), foodItem(BeverageProperties.CAMPARI)));
    public static final RegistryObject<Item> CHACHA = BEVERAGES.register("chacha",
            () -> new BoozeItem(BrewersFluids.CHACHA.source().get(), foodItem(BeverageProperties.CHACHA)));
    public static final RegistryObject<Item> FERNET = BEVERAGES.register("fernet",
            () -> new BoozeItem(BrewersFluids.FERNET.source().get(), foodItem(BeverageProperties.FERNET)));
    public static final RegistryObject<Item> GLUHWEIN = BEVERAGES.register("gluhwein",
            () -> new BoozeItem(BrewersFluids.GLUHWEIN.source().get(), foodItem(BeverageProperties.GLUHWEIN)));
    public static final RegistryObject<Item> GROG = BEVERAGES.register("grog",
            () -> new BoozeItem(BrewersFluids.GROG.source().get(), foodItem(BeverageProperties.GROG)));
    public static final RegistryObject<Item> KASHASA = BEVERAGES.register("kashasa",
            () -> new BoozeItem(BrewersFluids.KASHASA.source().get(), foodItem(BeverageProperties.KASHASA)));
    public static final RegistryObject<Item> MEZCAL = BEVERAGES.register("mezcal",
            () -> new BoozeItem(BrewersFluids.MEZCAL.source().get(), foodItem(BeverageProperties.MEZCAL)));
    public static final RegistryObject<Item> NEGRONI = BEVERAGES.register("negroni",
            () -> new BoozeItem(BrewersFluids.NEGRONI.source().get(), foodItem(BeverageProperties.NEGRONI)));
    public static final RegistryObject<Item> OUZO = BEVERAGES.register("ouzo",
            () -> new BoozeItem(BrewersFluids.OUZO.source().get(), foodItem(BeverageProperties.OUZO)));
    public static final RegistryObject<Item> PASTIS = BEVERAGES.register("pastis",
            () -> new BoozeItem(BrewersFluids.PASTIS.source().get(), foodItem(BeverageProperties.PASTIS)));
    public static final RegistryObject<Item> PUNCH = BEVERAGES.register("punch",
            () -> new BoozeItem(BrewersFluids.PUNCH.source().get(), foodItem(BeverageProperties.PUNCH)));
    public static final RegistryObject<Item> RAKIA = BEVERAGES.register("rakia",
            () -> new BoozeItem(BrewersFluids.RAKIA.source().get(), foodItem(BeverageProperties.RAKIA)));
    public static final RegistryObject<Item> RUM = BEVERAGES.register("rum",
            () -> new BoozeItem(BrewersFluids.RUM.source().get(), foodItem(BeverageProperties.RUM)));
    public static final RegistryObject<Item> SAMBUCA = BEVERAGES.register("sambuca",
            () -> new BoozeItem(BrewersFluids.SAMBUCA.source().get(), foodItem(BeverageProperties.SAMBUCA)));
    public static final RegistryObject<Item> SHERRY = BEVERAGES.register("sherry",
            () -> new BoozeItem(BrewersFluids.SHERRY.source().get(), foodItem(BeverageProperties.SHERRY)));
    public static final RegistryObject<Item> SOCATA = BEVERAGES.register("socata",
            () -> new BoozeItem(BrewersFluids.SOCATA.source().get(), foodItem(BeverageProperties.SOCATA)));
    public static final RegistryObject<Item> SOJU = BEVERAGES.register("soju",
            () -> new BoozeItem(BrewersFluids.SOJU.source().get(), foodItem(BeverageProperties.SOJU)));
    public static final RegistryObject<Item> SOTOL = BEVERAGES.register("sotol",
            () -> new BoozeItem(BrewersFluids.SOTOL.source().get(), foodItem(BeverageProperties.SOTOL)));
    public static final RegistryObject<Item> TODDY = BEVERAGES.register("toddy",
            () -> new BoozeItem(BrewersFluids.TODDY.source().get(), foodItem(BeverageProperties.TODDY)));
    public static final RegistryObject<Item> TRIPLE_SEC = BEVERAGES.register("triple-sec",
            () -> new BoozeItem(BrewersFluids.TRIPLE_SEC.source().get(), foodItem(BeverageProperties.TRIPLE_SEC)));
    public static final RegistryObject<Item> TSIPURO = BEVERAGES.register("tsipuro",
            () -> new BoozeItem(BrewersFluids.TSIPURO.source().get(), foodItem(BeverageProperties.TSIPURO)));
    public static final RegistryObject<Item> VERMOUTH = BEVERAGES.register("vermouth",
            () -> new BoozeItem(BrewersFluids.VERMOUTH.source().get(), foodItem(BeverageProperties.VERMOUTH)));
    public static final RegistryObject<Item> TSUIKE = BEVERAGES.register("tsuike",
            () -> new BoozeItem(BrewersFluids.TSUIKE.source().get(), foodItem(BeverageProperties.TSUIKE)));
    public static final RegistryObject<Item> VISHINATA = BEVERAGES.register("vishinata",
            () -> new BoozeItem(BrewersFluids.VISHINATA.source().get(), foodItem(BeverageProperties.VISHINATA)));
	
	// Challenge beverages
	public static final RegistryObject<Item> FLAXEN_CHEESE_STOUT = CHALLENGE_BEVERAGES.register("flaxen_cheese_stout",
			() -> new BoozeItem(BrewersFluids.FLAXEN_CHEESE_STOUT.source().get(), foodItem(BeverageProperties.FLAXEN_CHEESE_STOUT)));
	public static final RegistryObject<Item> SCARLET_CHEESE_STOUT = CHALLENGE_BEVERAGES.register("scarlet_cheese_stout",
			() -> new BoozeItem(BrewersFluids.SCARLET_CHEESE_STOUT.source().get(), foodItem(BeverageProperties.SCARLET_CHEESE_STOUT)));
	public static final RegistryObject<Item> FLYING_DUTCHMAN = CHALLENGE_BEVERAGES.register("flying_dutchman",
			() -> new BoozeItem(BrewersFluids.FLYING_DUTCHMAN.source().get(), foodItem(BeverageProperties.FLYING_DUTCHMAN)));
	public static final RegistryObject<Item> GUT_WRECKER = CHALLENGE_BEVERAGES.register("gut_wrecker",
			() -> new BoozeItem(BrewersFluids.GUT_WRECKER.source().get(), foodItem(BeverageProperties.GUT_WRECKER)));
	
	// Vintage beverages
	public static final RegistryObject<Item> SBITEN = VINTAGE_BEVERAGES.register("sbiten",
			() -> new BoozeItem(BrewersFluids.SBITEN.source().get(), foodItem(BeverageProperties.SBITEN)));
	public static final RegistryObject<Item> SYTA = VINTAGE_BEVERAGES.register("syta",
			() -> new BoozeItem(BrewersFluids.SYTA.source().get(), foodItem(BeverageProperties.SYTA)));
	public static final RegistryObject<Item> VZVAR = VINTAGE_BEVERAGES.register("vzvar",
			() -> new BoozeItem(BrewersFluids.VZVAR.source().get(), foodItem(BeverageProperties.VZVAR)));
	
	// Compatibility
	// BnC 3.0 does have a function for registering items with mod dependency: registerWithTab(String name, Item item, @Nullable String requiredMod)
	// However, mods adding corn or grapes are frequent, and you can't account for all of them manually.
	
	// Corn
	public static final RegistryObject<Item> BOURBON = COMPAT_BEVERAGES.register("bourbon",
			() -> new BoozeItem(BrewersFluids.BOURBON.source().get(), foodItem(BeverageProperties.BOURBON)));
	public static final RegistryObject<Item> CORN_WHISKY = COMPAT_BEVERAGES.register("corn_whisky",
			() -> new BoozeItem(BrewersFluids.CORN_WHISKY.source().get(), foodItem(BeverageProperties.CORN_WHISKY)));
	public static final RegistryObject<Item> MOONSHINE = COMPAT_BEVERAGES.register("moonshine",
			() -> new BoozeItem(BrewersFluids.MOONSHINE.source().get(), foodItem(BeverageProperties.MOONSHINE)));
	
	// Grapes
	public static final RegistryObject<Item> CAHORS = COMPAT_BEVERAGES.register("cahors",
			() -> new BoozeItem(BrewersFluids.CAHORS.source().get(), foodItem(BeverageProperties.CAHORS)));
	public static final RegistryObject<Item> CHAMPAGNE = COMPAT_BEVERAGES.register("champagne",
			() -> new BoozeItem(BrewersFluids.CHAMPAGNE.source().get(), foodItem(BeverageProperties.CHAMPAGNE)));
	public static final RegistryObject<Item> COGNAC = COMPAT_BEVERAGES.register("cognac",
			() -> new BoozeItem(BrewersFluids.COGNAC.source().get(), foodItem(BeverageProperties.COGNAC)));
	public static final RegistryObject<Item> MARTINI = COMPAT_BEVERAGES.register("martini",
			() -> new BoozeItem(BrewersFluids.MARTINI.source().get(), foodItem(BeverageProperties.MARTINI)));
	
	public static Item.@NotNull Properties foodItem(FoodProperties food)
	{
		return new Item.Properties().food(food).stacksTo(16).craftRemainder(BnCItems.TANKARD.get());
	}
	
	public static void register(IEventBus eventBus)
	{
		BEVERAGES.register(eventBus);
		CHALLENGE_BEVERAGES.register(eventBus);
		VINTAGE_BEVERAGES.register(eventBus);
		COMPAT_BEVERAGES.register(eventBus);
	}
}
