package pupkin.brewersdelight.item;

import com.brewinandchewin.common.item.BoozeItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.misc.AlcoholProperties;
import pupkin.brewersdelight.misc.BrewersDelightTab;

public class BrewersItems
{
	@SuppressWarnings("unused")
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);

	// Farmers Delight
	public static final RegistryObject<Item> BRAGA = ITEMS.register("braga",
	                                                                () -> new BoozeItem(1, 4, foodItem(AlcoholProperties.BRAGA)));
	public static final RegistryObject<Item> BRANDY = ITEMS.register("brandy",
	                                                                 () -> new BoozeItem(1, 4, foodItem(AlcoholProperties.BRANDY)));
	public static final RegistryObject<Item> CIDER = ITEMS.register("cider",
	                                                                () -> new BoozeItem(1, 4, foodItem(AlcoholProperties.CIDER)));
	public static final RegistryObject<Item> GIN = ITEMS.register("gin",
	                                                              () -> new BoozeItem(1, 4, foodItem(AlcoholProperties.GIN)));
	public static final RegistryObject<Item> KVASS = ITEMS.register("kvass",
	                                                                () -> new BoozeItem(1, 4, foodItem(AlcoholProperties.KVASS)));
	public static final RegistryObject<Item> LIQUEUR = ITEMS.register("liqueur",
	                                                                  () -> new BoozeItem(1, 4, foodItem(AlcoholProperties.LIQUEUR)));
	public static final RegistryObject<Item> MARTINI = ITEMS.register("martini",
	                                                                  () -> new BoozeItem(1, 4, foodItem(AlcoholProperties.MARTINI)));
	public static final RegistryObject<Item> MELON_SCHNAPPS = ITEMS.register("melon_schnapps",
	                                                                         () -> new BoozeItem(1, 4, foodItem(AlcoholProperties.MELON_SCHNAPPS)));
	public static final RegistryObject<Item> SAKE = ITEMS.register("sake",
	                                                               () -> new BoozeItem(1, 4, foodItem(AlcoholProperties.SAKE)));
	public static final RegistryObject<Item> SBITEN = ITEMS.register("sbiten",
	                                                                 () -> new BoozeItem(3, 4, foodItem(AlcoholProperties.SBITEN)));
	public static final RegistryObject<Item> WHISKY = ITEMS.register("whisky",
	                                                                 () -> new BoozeItem(1, 4, foodItem(AlcoholProperties.WHISKY)));

	// Note to self: Brewin' and Chewin' handles compatibility by... not giving a damn.
	// Kombucha throws an error loading recipe if farmers respite isn't loaded, which disables the recipe.
	// Not the most elegant solution, but good enough?...
	
	// Corn Delight TODO
	//	public static final RegistryObject<Item> BOURBON = ITEMS.register("bourbon",
	//	                  ( ) -> new BoozeItem(1, 4, foodItem(AlcoholProperties.BOURBON)));
	//	public static final RegistryObject<Item> CORN_WHISKY = ITEMS.register("corn_whisky",
	//	                  ( ) -> new BoozeItem(1, 4, foodItem(AlcoholProperties.CORN_WHISKY)));
	//	public static final RegistryObject<Item> MOONSHINE = ITEMS.register("moonshine",
	//	                  ( ) -> new BoozeItem(1, 4, foodItem(AlcoholProperties.MOONSHINE)));

	// Italian Delight TODO
	//	public static final RegistryObject<Item> CAHORS = ITEMS.register("cahors",
	//	                    ( ) -> new BoozeItem(1, 4, foodItem(AlcoholProperties.CAHORS)));
	//	public static final RegistryObject<Item> CHAMPAGNE = ITEMS.register("champagne",
	//	                    ( ) -> new BoozeItem(1, 4, foodItem(AlcoholProperties.CHAMPAGNE)));
	//	public static final RegistryObject<Item> COGNAC = ITEMS.register("cognac",
	//	                    ( ) -> new BoozeItem(1, 4, foodItem(AlcoholProperties.COGNAC)));

	public static Item.Properties foodItem(FoodProperties food)
	{
		return new Item.Properties().tab(BrewersDelightTab.CREATIVE_MODE_TAB);
	}

	public static void register(IEventBus eventBus)
	{
		ITEMS.register(eventBus);
	}
}
