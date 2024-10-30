package pupkin.brewersdelight.item;

import com.brewinandchewin.common.item.BoozeItem;
import com.brewinandchewin.core.registry.BCItems;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.misc.BeverageProperties;
import pupkin.brewersdelight.misc.BrewersDelightTab;

@SuppressWarnings("unused")
public class BrewersItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);

	// Farmers Delight
	public static final RegistryObject<Item> BRAGA = ITEMS.register("braga",
	       () -> new BoozeItem(1, 4, foodItem(BeverageProperties.BRAGA)));
	public static final RegistryObject<Item> BRANDY = ITEMS.register("brandy",
	       () -> new BoozeItem(3, 4, foodItem(BeverageProperties.BRANDY)));
	public static final RegistryObject<Item> CIDER = ITEMS.register("cider",
	       () -> new BoozeItem(2, 4, foodItem(BeverageProperties.CIDER)));
	public static final RegistryObject<Item> GIN = ITEMS.register("gin",
	       () -> new BoozeItem(3, 4, foodItem(BeverageProperties.GIN)));
	public static final RegistryObject<Item> KVASS = ITEMS.register("kvass",
	       () -> new BoozeItem(0, 0, foodItem(BeverageProperties.KVASS)));
	public static final RegistryObject<Item> LIQUEUR = ITEMS.register("liqueur",
	       () -> new BoozeItem(4, 4, foodItem(BeverageProperties.LIQUEUR)));
	public static final RegistryObject<Item> MARTINI = ITEMS.register("martini",
	       () -> new BoozeItem(2, 4, foodItem(BeverageProperties.MARTINI)));
	public static final RegistryObject<Item> MELON_SCHNAPPS = ITEMS.register("melon_schnapps",
	       () -> new BoozeItem(2, 4, foodItem(BeverageProperties.MELON_SCHNAPPS)));
	public static final RegistryObject<Item> SAKE = ITEMS.register("sake",
	       () -> new BoozeItem(1, 2, foodItem(BeverageProperties.SAKE)));
	public static final RegistryObject<Item> SBITEN = ITEMS.register("sbiten",
	       () -> new BoozeItem(2, 4, foodItem(BeverageProperties.SBITEN)));
	public static final RegistryObject<Item> TEQUILA = ITEMS.register("tequila",
	       () -> new BoozeItem(2, 4, foodItem(BeverageProperties.TEQUILA)));
	public static final RegistryObject<Item> WHISKY = ITEMS.register("whisky",
	       () -> new BoozeItem(5, 4, foodItem(BeverageProperties.WHISKY)));

	// Note to self: Brewin' and Chewin' handles compatibility by... not giving a damn.
	// Kombucha throws an error loading recipe if farmers respite isn't loaded, which disables the recipe.
	// Not the most elegant solution, but good enough?...

	// Corn
	public static final RegistryObject<Item> BOURBON = ITEMS.register("bourbon",
	       () -> new BoozeItem(4, 4, foodItem(BeverageProperties.BOURBON)));
	public static final RegistryObject<Item> CORN_WHISKY = ITEMS.register("corn_whisky",
	       () -> new BoozeItem(3, 4, foodItem(BeverageProperties.CORN_WHISKY)));
	public static final RegistryObject<Item> MOONSHINE = ITEMS.register("moonshine",
	       () -> new BoozeItem(6, 4, foodItem(BeverageProperties.MOONSHINE)));

	// Grapes (Italian Delight)
	public static final RegistryObject<Item> CAHORS = ITEMS.register("cahors",
	       () -> new BoozeItem(1, 3, foodItem(BeverageProperties.CAHORS)));
	public static final RegistryObject<Item> CHAMPAGNE = ITEMS.register("champagne",
	       () -> new BoozeItem(1, 1, foodItem(BeverageProperties.CHAMPAGNE)));
	public static final RegistryObject<Item> COGNAC = ITEMS.register("cognac",
	       () -> new BoozeItem(3, 4, foodItem(BeverageProperties.COGNAC)));

	public static Item.@NotNull Properties foodItem(FoodProperties food)
	{
		return new Item.Properties().food(food).stacksTo(16).craftRemainder(BCItems.TANKARD.get()).tab(BrewersDelightTab.CREATIVE_MODE_TAB);
	}

	public static void register(IEventBus eventBus)
	{
		ITEMS.register(eventBus);
	}
}
