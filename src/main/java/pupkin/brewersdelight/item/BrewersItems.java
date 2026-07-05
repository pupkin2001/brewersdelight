package pupkin.brewersdelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.block.BrewersBlocks;
import pupkin.brewersdelight.misc.BrewersFluids;
import pupkin.brewersdelight.misc.BrewersProperties;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BnCItems;

import static pupkin.brewersdelight.block.BrewersBlocks.CATTAIL;

@SuppressWarnings("unused")
public class BrewersItems
{
	public static final DeferredRegister<Item>
			ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID),
			DRINKS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID),
			VINTAGE_DRINKS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID),
			CHALLENGE_DRINKS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	
	public static final RegistryObject<Item>
			CATTAIL_ITEM = ITEMS.register("cattail", () -> new BlockItem(CATTAIL.get(), new Item.Properties())),
	
	UNRIPE_FROSTSTONE_CHEESE_WHEEL = ITEMS.register("unripe_froststone_cheese_wheel",
	                                                () -> new BlockItem(BrewersBlocks.UNRIPE_FROSTSTONE_CHEESE_WHEEL.get(),
	                                                                    new Item.Properties().stacksTo(16))),
			FROSTSTONE_CHEESE_WHEEL = ITEMS.register("froststone_cheese_wheel",
			                                         () -> new BlockItem(BrewersBlocks.FROSTSTONE_CHEESE_WHEEL.get(),
			                                                             new Item.Properties().stacksTo(16))),
			FROSTSTONE_CHEESE_WEDGE = ITEMS.register("froststone_cheese_wedge",
			                                         () -> new Item(new Item.Properties().food(BrewersProperties.FROSTSTONE_CHEESE_WEDGE))),
	
	// Bases / fillers
	BRAGA = registerDrink(DRINKS, "braga", BrewersFluids.BRAGA, BrewersProperties.BRAGA, false),
			GROG = registerDrink(DRINKS, "grog", BrewersFluids.GROG, BrewersProperties.GROG, false),
			PUNCH = registerDrink(DRINKS, "punch", BrewersFluids.PUNCH, BrewersProperties.PUNCH, false),
			TODDY = registerDrink(DRINKS, "toddy", BrewersFluids.TODDY, BrewersProperties.TODDY, false),
	
	// Utility (no tipsy)
	COMPOTE = registerDrink(DRINKS, "compote", BrewersFluids.COMPOTE, BrewersProperties.COMPOTE, false),
			GLUHWEIN = registerDrink(DRINKS, "gluhwein", BrewersFluids.GLUHWEIN, BrewersProperties.GLUHWEIN, false),
			KVASS = registerDrink(DRINKS, "kvass", BrewersFluids.KVASS, BrewersProperties.KVASS, false),
			MELON_SCHNAPPS = registerDrink(DRINKS, "melon_schnapps", BrewersFluids.MELON_SCHNAPPS, BrewersProperties.MELON_SCHNAPPS, false),
	
	// Cheap convenience (potion-clones)
	BRANDY = registerDrink(DRINKS, "brandy", BrewersFluids.BRANDY, BrewersProperties.BRANDY, false),
			CIDER = registerDrink(DRINKS, "cider", BrewersFluids.CIDER, BrewersProperties.CIDER, false),
			CORN_WHISKY = DRINKS.register("corn_whisky", () -> new BoozeItem(BrewersFluids.CORN_WHISKY.source().get(), foodItem(BrewersProperties.CORN_WHISKY))), // corn
			ELDERFLOWER = DRINKS.register("elderflower", () -> new BoozeItem(BrewersFluids.ELDERFLOWER.source().get(), foodItem(BrewersProperties.ELDERFLOWER))),
			GIN = registerDrink(DRINKS, "gin", BrewersFluids.GIN, BrewersProperties.GIN, false),
			VERMOUTH_GLOW = registerDrink(DRINKS, "vermouth_glow_berries", BrewersFluids.VERMOUTH_GLOW_BERRIES, BrewersProperties.VERMOUTH_GLOW, false),
			VERMOUTH_MUSHROOM = registerDrink(DRINKS, "vermouth_mushroom", BrewersFluids.VERMOUTH_MUSHROOM, BrewersProperties.VERMOUTH_MUSHROOM, false),
	
	// Tradeoff (strong buff + cost)
	ABSINTHE = registerDrink(DRINKS, "absinthe", BrewersFluids.ABSINTHE, BrewersProperties.ABSINTHE, false),
			MOONSHINE = DRINKS.register("moonshine", () -> new BoozeItem(BrewersFluids.MOONSHINE.source().get(), foodItem(BrewersProperties.MOONSHINE))), // corn
			TEQUILA = registerDrink(DRINKS, "tequila", BrewersFluids.TEQUILA, BrewersProperties.TEQUILA, false),
	
	// Clean buff (no-potion effect + Nourishment)
	BITTER = registerDrink(DRINKS, "bitter", BrewersFluids.BITTER, BrewersProperties.BITTER, false),
			BOURBON = DRINKS.register("bourbon", () -> new BoozeItem(BrewersFluids.BOURBON.source().get(), foodItem(BrewersProperties.BOURBON))), // corn
			CAHORS = DRINKS.register("cahors", () -> new BoozeItem(BrewersFluids.CAHORS.source().get(), foodItem(BrewersProperties.CAHORS))), // grape
			COGNAC = DRINKS.register("cognac", () -> new BoozeItem(BrewersFluids.COGNAC.source().get(), foodItem(BrewersProperties.COGNAC))), // grape
			LIQUEUR = registerDrink(DRINKS, "liqueur", BrewersFluids.LIQUEUR, BrewersProperties.LIQUEUR, false),
			RUM = registerDrink(DRINKS, "rum", BrewersFluids.RUM, BrewersProperties.RUM, false),
			SAKE = registerDrink(DRINKS, "sake", BrewersFluids.SAKE, BrewersProperties.SAKE, false),
			WHISKY = registerDrink(DRINKS, "whisky", BrewersFluids.WHISKY, BrewersProperties.WHISKY, false),
	
	// Cocktails
	OLD_FASHIONED = registerDrink(DRINKS, "old_fashioned", BrewersFluids.OLD_FASHIONED, BrewersProperties.OLD_FASHIONED, false),
	
	// Vintage
	SBITEN = VINTAGE_DRINKS.register("sbiten", () -> new BoozeItem(BrewersFluids.SBITEN.source().get(), foodItem(BrewersProperties.SBITEN))),
			SYTA = VINTAGE_DRINKS.register("syta", () -> new BoozeItem(BrewersFluids.SYTA.source().get(), foodItem(BrewersProperties.SYTA))),
			VZVAR = VINTAGE_DRINKS.register("vzvar", () -> new BoozeItem(BrewersFluids.VZVAR.source().get(), foodItem(BrewersProperties.VZVAR))),
	
	// Challenge
	FLAXEN_CHEESE_STOUT = CHALLENGE_DRINKS.register("flaxen_cheese_stout",
	                                                () -> new BoozeItem(BrewersFluids.FLAXEN_CHEESE_STOUT.source().get(), foodItem(BrewersProperties.FLAXEN_CHEESE_STOUT))),
			SCARLET_CHEESE_STOUT = CHALLENGE_DRINKS.register("scarlet_cheese_stout",
			                                                 () -> new BoozeItem(BrewersFluids.SCARLET_CHEESE_STOUT.source().get(),
			                                                                     foodItem(BrewersProperties.SCARLET_CHEESE_STOUT))),
			FROSTSTONE_CHEESE_STOUT = CHALLENGE_DRINKS.register("froststone_cheese_stout",
			                                                    () -> new BoozeItem(BrewersFluids.FROSTSTONE_CHEESE_STOUT.source().get(), foodItem(BrewersProperties
					                                                                                                                                       .FROSTSTONE_CHEESE_STOUT))),
			FLYING_DUTCHMAN = CHALLENGE_DRINKS.register("flying_dutchman",
			                                            () -> new BoozeItem(BrewersFluids.FLYING_DUTCHMAN.source().get(), foodItem(BrewersProperties.FLYING_DUTCHMAN))),
			GUT_WRECKER = CHALLENGE_DRINKS.register("gut_wrecker", () -> new BoozeItem(BrewersFluids.GUT_WRECKER.source().get(), foodItem(BrewersProperties.GUT_WRECKER)));
	
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
		ITEMS.register(eventBus);
		DRINKS.register(eventBus);
		CHALLENGE_DRINKS.register(eventBus);
		VINTAGE_DRINKS.register(eventBus);
	}
}
