package pupkin.brewersdelight.datagen;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.item.BrewersItems;
import pupkin.brewersdelight.misc.BrewersFluids;
import umpaz.brewinandchewin.client.recipebook.FermentingBookCategory;
import umpaz.brewinandchewin.common.registry.BnCItems;
import umpaz.brewinandchewin.common.tag.BnCTags;
import umpaz.brewinandchewin.data.builder.KegFermentingRecipeBuilder;
import umpaz.brewinandchewin.data.builder.KegPouringRecipeBuilder;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class BDRecipeProvider extends RecipeProvider implements IConditionBuilder
{
	public static final int
			// Duration
			FAST_FERMENTING = 4800,      // 4 minutes
			NORMAL_FERMENTING = 9600,    // 8 minutes
			LONG_FERMENTING = 19200,     // 16 minutes
	
	// Temperature
	HOT_TEMPERATURE = 5,
			WARM_TEMPERATURE = 4,
			NORMAL_TEMPERATURE = 3,
			COLD_TEMPERATURE = 2,
			FRIGID_TEMPERATURE = 1;
	
	// Experience
	public static final float
			SMALL_EXP = 0.5F,
			MEDIUM_EXP = 1.0F,
			LARGE_EXP = 2.0F;
	
	private static final Ingredient
			FRUITS = anyTag("c:foods/fruit", "c:fruits"),
			GRAIN = anyTag("c:crops/grain", "c:grain"),
			GRAPES = anyTag("c:fruits/grape", "c:crops/grape", "c:grapes"),
			GINGER = anyTag("c:crops/ginger", "c:vegetables/ginger", "c:gingers"),
			BARLEY = anyTag("c:crops/barley", "c:grain/barley");
	
	public BDRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
	{
		super(output, registries);
	}
	
	private static ResourceLocation glassVariant(ResourceLocation drinkId)
	{
		return ResourceLocation.fromNamespaceAndPath(drinkId.getNamespace(), drinkId.getPath() + "_glass");
	}
	
	private static TagKey<Item> itemTag(String id)
	{
		return TagKey.create(Registries.ITEM, ResourceLocation.parse(id));
	}
	
	private static Ingredient anyTag(String... ids)
	{
		return Ingredient.fromValues(Arrays.stream(ids).map(id -> new Ingredient.TagValue(itemTag(id))));
	}
	
	// Shared ingredient conversion used by fermenting and cooking recipes.
	@SuppressWarnings("unchecked")
	private static Ingredient toIngredient(Object ingredient)
	{
		if (ingredient instanceof Ingredient i) {
			return i;
		} else if (ingredient instanceof ItemLike item) {
			// Regular item, or a DeferredItem
			return Ingredient.of(item);
		} else if (ingredient instanceof TagKey<?> tagKey) {
			// Item tag
			return Ingredient.of((TagKey<Item>) tagKey);
		} else if (ingredient instanceof String s) {
			// String representation of a tag
			return Ingredient.of(itemTag(s));
		} else if (ingredient instanceof Supplier<?> supplier && supplier.get() instanceof ItemLike item) {
			// Supplier<Item>, e.g. Farmer's Delight items
			return Ingredient.of(item);
		} else {
			throw new IllegalArgumentException("Ingredient must be an Item, TagKey<Item>, String tag representation, Supplier<Item> or Ingredient: " + ingredient);
		}
	}
	
	private static UnlockCriterion unlock(String name, Object... items)
	{
		ItemPredicate[] predicates = new ItemPredicate[items.length];
		for (int i = 0; i < items.length; i++) {
			predicates[i] = toItemPredicate(items[i]);
		}
		return new UnlockCriterion(name, InventoryChangeTrigger.TriggerInstance.hasItems(predicates));
	}
	
	@SuppressWarnings("unchecked")
	private static ItemPredicate toItemPredicate(Object ingredient)
	{
		if (ingredient instanceof ItemLike item) {
			return ItemPredicate.Builder.item().of(item).build();
		} else if (ingredient instanceof TagKey<?> tagKey) {
			return ItemPredicate.Builder.item().of((TagKey<Item>) tagKey).build();
		} else if (ingredient instanceof String s) {
			// "namespace:path"
			return ItemPredicate.Builder.item().of(itemTag(s)).build();
		} else if (ingredient instanceof Supplier<?> supplier && supplier.get() instanceof ItemLike item) {
			return ItemPredicate.Builder.item().of(item).build();
		} else {
			throw new IllegalArgumentException(
					"Criterion item must be an Item, TagKey<Item>, String tag representation, or Supplier<Item>: " + ingredient);
		}
	}
	
	private static ResourceLocation recipeId(String category, String recipeName)
	{
		return ResourceLocation.fromNamespaceAndPath(BrewersDelight.MOD_ID, category + "/" + recipeName);
	}
	
	@Override
	protected void buildRecipes(@NotNull RecipeOutput consumer)
	{
		generateFermentingRecipes(consumer);
		generatePouringRecipes(consumer);
	}
	
	private void generateFermentingRecipes(RecipeOutput consumer)
	{
		// Fermenting drinks
		// Bases / fillers
		createFermentingRecipe(consumer, "braga", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BRAGA.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:foods/bread", "c:foods/bread", "c:foods/bread", "c:foods/bread");
		createFermentingRecipe(consumer, "grog", "drinks",
		                       BrewersFluids.RUM.id(), 500, // watered-down rum
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.GROG.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.SUGAR);
		createFermentingRecipe(consumer, "punch", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.PUNCH.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       FRUITS, FRUITS, FRUITS, Items.SUGAR);
		createFermentingRecipe(consumer, "toddy", "drinks",
		                       BnCTags.Fluids.MEAD, 500,
		                       FAST_FERMENTING, WARM_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.TODDY.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:crops/cinnamon", Items.HONEY_BOTTLE);
		createFermentingRecipe(consumer, "wine", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.WINE.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       GRAPES, GRAPES, GRAPES, GRAPES);
		//		createFermentingRecipe(consumer, "red_wine", "drinks", // TODO
		//		                       Tags.Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		//		                       BrewersFluids.RED_WINE.id(), 1000,
		//		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		//		                       "c:fruits/grape");
		//		createFermentingRecipe(consumer, "white_wine", "drinks", // TODO
		//		                       Tags.Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		//		                       BrewersFluids.WHITE_WINE.id(), 1000,
		//		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		//		                       "c:fruits/grape");
		
		// Utility
		createFermentingRecipe(consumer, "kvass", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.KVASS.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:crops/wheat", "c:crops/wheat", Items.HONEYCOMB);
		createFermentingRecipe(consumer, "melon_schnapps_from_melon_juice", "drinks",
		                       BrewersFluids.MELON_JUICE.id(), 500,
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.MELON_SCHNAPPS.id(), 750,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:crops/wheat");
		createFermentingRecipe(consumer, "melon_schnapps_from_water", "drinks",
		                       Tags.Fluids.WATER, 500,
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.MELON_SCHNAPPS.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.MELON_SLICE, Items.MELON_SLICE, "c:crops/wheat", "c:crops/wheat");
		
		// Cheap convenience
		createFermentingRecipe(consumer, "brandy", "drinks",
		                       BrewersFluids.CIDER.id(), 750,
		                       LONG_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BRANDY.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:foods/berry", "c:foods/berry", Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "cider", "drinks",
		                       Tags.Fluids.WATER, 500,
		                       LONG_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.CIDER.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.APPLE, Items.APPLE, Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "corn_whisky", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.CORN_WHISKY.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:crops/corn", "c:crops/corn", "c:crops/corn", "c:crops/corn");
		createFermentingRecipe(consumer, "elderflower", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, COLD_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.ELDERFLOWER.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "minecraft:flowers", "minecraft:flowers", Items.SUGAR, Items.SUGAR);
		createFermentingRecipe(consumer, "gin", "drinks",
		                       BnCTags.Fluids.VODKA, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.GIN.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:seeds/wheat", "c:seeds/wheat", "c:foods/berry", "c:foods/berry");
		createFermentingRecipe(consumer, "vermouth_glow_berries", "drinks",
		                       BrewersFluids.WINE.id(), 500,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.VERMOUTH_GLOW_BERRIES.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.GLOW_BERRIES, Items.GLOW_BERRIES, Items.SUGAR, Items.SUGAR);
		createFermentingRecipe(consumer, "vermouth_mushroom", "drinks",
		                       BrewersFluids.WINE.id(), 500,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.VERMOUTH_MUSHROOM.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:mushrooms", "c:mushrooms", Items.SUGAR, Items.SUGAR);
		
		// Tradeoff
		createFermentingRecipe(consumer, "absinthe", "drinks",
		                       BnCTags.Fluids.VODKA, 1000,
		                       LONG_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.ABSINTHE.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.FERN, Items.FERN, Items.SHORT_GRASS, Items.SHORT_GRASS);
		createFermentingRecipe(consumer, "moonshine", "drinks",
		                       BrewersFluids.BRAGA.id(), 500,
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MOONSHINE.id(), 750,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:crops/corn", "c:crops/corn", Items.SUGAR, Items.SUGAR);
		createFermentingRecipe(consumer, "tequila", "drinks",
		                       Tags.Fluids.WATER, 500,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.TEQUILA.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.CACTUS, Items.CACTUS, Items.CACTUS, Items.CACTUS);
		
		// Clean buff
		createFermentingRecipe(consumer, "bitter", "drinks",
		                       BrewersFluids.LIQUEUR.id(), 500,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BITTER.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       GINGER, "c:raisins");
		createFermentingRecipe(consumer, "bourbon", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       LONG_FERMENTING, WARM_TEMPERATURE,
		                       MEDIUM_EXP, // the cellar/oak abstraction as the only thing separating bourbon from corn whiskey is aging in charred oak
		                       BrewersFluids.BOURBON.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:crops/corn", "c:crops/corn", "c:crops/corn", "c:crops/corn");
		createFermentingRecipe(consumer, "cahors", "drinks",
		                       BrewersFluids.WINE.id(), 250,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CAHORS.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       GRAPES, GRAPES, Items.SUGAR, Items.SUGAR);
		createFermentingRecipe(consumer, "cognac", "drinks",
		                       BrewersFluids.WINE.id(), 500,
		                       LONG_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP, // oak aging abstractions, see bourbon comment
		                       BrewersFluids.COGNAC.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       GRAPES, GRAPES);
		createFermentingRecipe(consumer, "liqueur", "drinks",
		                       Tags.Fluids.HONEY, 500,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.LIQUEUR.id(), 750,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       ModItems.MELON_JUICE, ModItems.MELON_JUICE, "c:foods/berry", "c:foods/berry");
		createFermentingRecipe(consumer, "rum", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       LONG_FERMENTING, HOT_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.RUM.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.SUGAR_CANE, Items.SUGAR_CANE, Items.SUGAR_CANE, Items.SUGAR_CANE);
		createFermentingRecipe(consumer, "rum_from_molasses", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, SMALL_EXP, // Croptopia molasses is produced by cooking sugar cane, so molasses doesn't need as high temp
		                       BrewersFluids.RUM.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:molasses", "c:molasses", "c:molasses");
		createFermentingRecipe(consumer, "sake", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, COLD_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.SAKE.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:crops/rice", "c:crops/rice", "c:crops/rice", "c:crops/rice");
		createFermentingRecipe(consumer, "whisky", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       LONG_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.WHISKY.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:crops/wheat", "c:crops/wheat", "c:crops/wheat", "c:crops/wheat");
		createFermentingRecipe(consumer, "whisky_from_barley", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       LONG_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.WHISKY.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       BARLEY, BARLEY, BARLEY);
		
		// Vintage
		createFermentingRecipe(consumer, "sbiten", "drinks",
		                       BnCTags.Fluids.BEER, 500,
		                       LONG_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.SBITEN.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.HONEY_BLOCK, "c:crops/wheat");
		createFermentingRecipe(consumer, "sbiten_from_cinnamon", "drinks",
		                       BnCTags.Fluids.BEER, 500,
		                       LONG_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.SBITEN.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:crops/cinnamon", GINGER);
		createFermentingRecipe(consumer, "syta", "drinks",
		                       Tags.Fluids.WATER, 500,
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.SYTA.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.HONEY_BOTTLE, Items.HONEY_BOTTLE);
		
		// Challenge
		createFermentingRecipe(consumer, "flaxen_cheese_stout", "drinks",
		                       BnCTags.Fluids.VODKA, 250,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.FLAXEN_CHEESE_STOUT.id(), 250,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       BnCItems.FLAXEN_CHEESE_WEDGE, BnCItems.FLAXEN_CHEESE_WEDGE, GRAIN, "c:mushrooms");
		createFermentingRecipe(consumer, "scarlet_cheese_stout", "drinks",
		                       BnCTags.Fluids.BEER, 500,
		                       NORMAL_FERMENTING, HOT_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.SCARLET_CHEESE_STOUT.id(), 250, // evaporation or something
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       BnCItems.SCARLET_CHEESE_WEDGE, BnCItems.SCARLET_CHEESE_WEDGE, Items.NETHER_WART, "c:mushrooms");
		createFermentingRecipe(consumer, "froststone_cheese_stout", "drinks",
		                       Tags.Fluids.WATER, 250,
		                       LONG_FERMENTING, FRIGID_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.FROSTSTONE_CHEESE_STOUT.id(), 250,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       BrewersItems.FROSTSTONE_CHEESE_WEDGE, BrewersItems.FROSTSTONE_CHEESE_WEDGE, Items.CHARCOAL, BrewersItems.SNOW_FUNGUS_ITEM);
		createFermentingRecipe(consumer, "flying_dutchman", "drinks",
		                       Tags.Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, COLD_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.FLYING_DUTCHMAN.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.APPLE, Items.SUGAR, Items.GLOW_INK_SAC, Items.KELP);
		createFermentingRecipe(consumer, "gut_wrecker", "drinks",
		                       Tags.Fluids.MILK, 250,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.GUT_WRECKER.id(), 500, // open cattails take up a lot more volume
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "c:foods/raw_fish", "c:cattail", Items.SPIDER_EYE, "c:foods/vegetable");
		
		// Fermenting meals
	}
	
	private void generatePouringRecipes(RecipeOutput consumer)
	{
		// Bases / fillers
		createPouringRecipes(consumer, "braga",
		                     BrewersFluids.BRAGA.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.BRAGA,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "grog",
		                     BrewersFluids.GROG.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.GROG,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "punch",
		                     BrewersFluids.PUNCH.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.PUNCH,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "toddy",
		                     BrewersFluids.TODDY.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.TODDY,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		
		// Utility
		createPouringRecipes(consumer, "compote",
		                     BrewersFluids.COMPOTE.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.COMPOTE,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "gluhwein",
		                     BrewersFluids.GLUHWEIN.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.GLUHWEIN,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "kvass",
		                     BrewersFluids.KVASS.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.KVASS,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "melon_schnapps",
		                     BrewersFluids.MELON_SCHNAPPS.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.MELON_SCHNAPPS,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		
		// Cheap convenience
		createPouringRecipes(consumer, "brandy",
		                     BrewersFluids.BRANDY.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.BRANDY,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "cider",
		                     BrewersFluids.CIDER.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.CIDER,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "corn_whisky",
		                     BrewersFluids.CORN_WHISKY.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.CORN_WHISKY,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "elderflower",
		                     BrewersFluids.ELDERFLOWER.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.ELDERFLOWER,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "gin",
		                     BrewersFluids.GIN.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.GIN,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "vermouth_glow",
		                     BrewersFluids.VERMOUTH_GLOW_BERRIES.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.VERMOUTH_GLOW,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "vermouth_mushroom",
		                     BrewersFluids.VERMOUTH_MUSHROOM.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.VERMOUTH_MUSHROOM,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		
		// Tradeoff
		createPouringRecipes(consumer, "absinthe",
		                     BrewersFluids.ABSINTHE.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.ABSINTHE,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "moonshine",
		                     BrewersFluids.MOONSHINE.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.MOONSHINE,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "tequila",
		                     BrewersFluids.TEQUILA.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.TEQUILA,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		
		// Clean buff
		createPouringRecipes(consumer, "bitter",
		                     BrewersFluids.BITTER.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.BITTER,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "bourbon",
		                     BrewersFluids.BOURBON.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.BOURBON,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "cahors",
		                     BrewersFluids.CAHORS.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.CAHORS,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "cognac",
		                     BrewersFluids.COGNAC.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.COGNAC,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "liqueur",
		                     BrewersFluids.LIQUEUR.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.LIQUEUR,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "rum",
		                     BrewersFluids.RUM.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.RUM,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "sake",
		                     BrewersFluids.SAKE.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.SAKE,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "whisky",
		                     BrewersFluids.WHISKY.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.WHISKY,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		
		// Cocktails
		createPouringRecipes(consumer, "old_fashioned",
		                     BrewersFluids.OLD_FASHIONED.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.OLD_FASHIONED,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		
		// Vintage
		createPouringRecipes(consumer, "sbiten",
		                     BrewersFluids.SBITEN.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.SBITEN,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "syta",
		                     BrewersFluids.SYTA.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.SYTA,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		createPouringRecipes(consumer, "vzvar",
		                     BrewersFluids.VZVAR.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.VZVAR,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
		
		// Challenge
		createPouringRecipe(consumer, "flaxen_cheese_stout",
		                    BrewersFluids.FLAXEN_CHEESE_STOUT.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.FLAXEN_CHEESE_STOUT,
		                    true,
		                    false
		                   );
		createPouringRecipe(consumer, "scarlet_cheese_stout",
		                    BrewersFluids.SCARLET_CHEESE_STOUT.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.SCARLET_CHEESE_STOUT,
		                    true,
		                    false
		                   );
		createPouringRecipe(consumer, "froststone_cheese_stout",
		                    BrewersFluids.FROSTSTONE_CHEESE_STOUT.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.FROSTSTONE_CHEESE_STOUT,
		                    true,
		                    false
		                   );
		createPouringRecipe(consumer, "flying_dutchman",
		                    BrewersFluids.FLYING_DUTCHMAN.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.FLYING_DUTCHMAN,
		                    true,
		                    false
		                   );
		createPouringRecipe(consumer, "gut_wrecker",
		                    BrewersFluids.GUT_WRECKER.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.GUT_WRECKER,
		                    true,
		                    false
		                   );
		
		// Pouring meals
	}
	
	@SuppressWarnings("unchecked")
	private void createFermentingRecipe(@NotNull RecipeOutput consumer, String recipeName, String recipeBookTab,
	                                    Object baseFluid, int baseFluidCount,
	                                    int fermentingTime, int temperature, float experience,
	                                    ResourceLocation resultFluid, int resultFluidCount,
	                                    List<UnlockCriterion> unlocks,
	                                    Object... ingredients)
	{
		Fluid result = BuiltInRegistries.FLUID.getOptional(resultFluid).orElseThrow(
				() -> new IllegalStateException("Unable to create fermenting recipe " + recipeName + " for fluid " + resultFluid + " as it does not exist."));
		FermentingBookCategory tab = Arrays.stream(FermentingBookCategory.values())
		                                   .filter(category -> category.getSerializedName().equals(recipeBookTab))
		                                   .findFirst()
		                                   .orElseThrow(() -> new IllegalArgumentException("Unknown recipe book tab " + recipeBookTab + " for recipe " + recipeName));
		
		KegFermentingRecipeBuilder builder = KegFermentingRecipeBuilder.kegFermentingRecipe(tab, result, resultFluidCount,
		                                                                                    fermentingTime, experience, temperature);
		
		if (baseFluid instanceof Fluid fluid) {
			// Regular fluid
			builder.addFluidIngredient(fluid, baseFluidCount);
		} else if (baseFluid instanceof TagKey<?> tagKey) {
			// Fluid tag
			builder.addFluidIngredient((TagKey<Fluid>) tagKey, baseFluidCount);
		} else if (baseFluid instanceof String s) {
			// String representation of fluid tag
			builder.addFluidIngredient(TagKey.create(Registries.FLUID, ResourceLocation.parse(s)), baseFluidCount);
		} else if (baseFluid instanceof ResourceLocation id) {
			// Direct ResourceLocation for fluid
			Fluid fluid = BuiltInRegistries.FLUID.getOptional(id).orElseThrow(
					() -> new IllegalStateException("Unable to create fermenting recipe " + recipeName + " for base fluid " + id + " as it does not exist."));
			builder.addFluidIngredient(fluid, baseFluidCount);
		} else if (baseFluid instanceof Supplier<?> supplier && supplier.get() instanceof Fluid fluid) {
			// DeferredHolder for Fluid or FlowingFluid
			builder.addFluidIngredient(fluid, baseFluidCount);
		} else {
			throw new IllegalArgumentException(
					"Unable to serialize recipe for " + recipeName + ". Base fluid must be a Fluid, TagKey<Fluid>, String tag representation, ResourceLocation, or "
							+ "Supplier<Fluid>: " + baseFluid);
		}
		
		for (Object ingredient : ingredients) {
			builder.addIngredient(toIngredient(ingredient));
		}
		
		if (unlocks != null) {
			for (UnlockCriterion unlock : unlocks) {
				builder.unlockedBy(unlock.name(), unlock.trigger());
			}
		}
		
		// The builder saves the advancement as brewersdelight:recipes/fermenting/<name>
		builder.build(consumer, recipeId("fermenting", recipeName));
	}
	
	// Wrapper
	private void createFermentingRecipe(RecipeOutput consumer, String recipeName, String recipeBookTab,
	                                    Object baseFluid, int baseFluidCount,
	                                    int fermentingTime, int temperature, float experience,
	                                    Fluid resultFluid, int resultFluidCount,
	                                    List<UnlockCriterion> unlocks,
	                                    Object... ingredients)
	{
		createFermentingRecipe(consumer, recipeName, recipeBookTab,
		                       baseFluid, baseFluidCount,
		                       fermentingTime, temperature, experience,
		                       BuiltInRegistries.FLUID.getKey(resultFluid), resultFluidCount,
		                       unlocks,
		                       ingredients);
	}
	
	// Wrapper
	private void createFermentingRecipe(RecipeOutput consumer, String recipeName, String recipeBookTab,
	                                    Object baseFluid, int baseFluidCount,
	                                    int fermentingTime, int temperature, float experience,
	                                    Supplier<? extends Fluid> resultFluid, int resultFluidCount,
	                                    List<UnlockCriterion> unlocks,
	                                    Object... ingredients)
	{
		createFermentingRecipe(consumer, recipeName, recipeBookTab,
		                       baseFluid, baseFluidCount,
		                       fermentingTime, temperature, experience,
		                       resultFluid.get(), resultFluidCount,
		                       unlocks,
		                       ingredients);
	}
	
	private void createPouringRecipe(@NotNull RecipeOutput consumer, String recipeName,
	                                 Fluid fluid, int fluidAmount,
	                                 ItemLike container, ItemLike output,
	                                 boolean filling, boolean strict)
	{
		KegPouringRecipeBuilder.kegPouringRecipe(fluid, fluidAmount, new ItemStack(output), strict, filling)
		                       .withContainer(container)
		                       .build(consumer, recipeId("pouring", recipeName));
	}
	
	public void createPouringRecipes(RecipeOutput consumer, String recipeName,
	                                 Fluid fluid, int fluidAmount,
	                                 @Nullable ItemLike containerItem,
	                                 @Nullable DeferredItem<Item> tankardOutput,
	                                 @Nullable Item glassContainerItem,
	                                 boolean filling, boolean strict)
	{
		// Tankard variant
		if (tankardOutput != null) {
			Objects.requireNonNull(containerItem, "tankard variant needs a container item");
			createPouringRecipe(consumer, tankardOutput.getId().getPath(),
			                    fluid, fluidAmount,
			                    containerItem,
			                    tankardOutput,
			                    filling, strict);
		}
		
		// TODO Re-enable for when glass variants are added back
		// Glass variant — no DeferredItem exists for it, so derive its id
		//		if (glassContainerItem != null) {
		//			ResourceLocation glassOutputId = (tankardOutput != null)
		//					? glassVariant(tankardOutput.getId())
		//					: ResourceLocation.fromNamespaceAndPath(BrewersDelight.MOD_ID, recipeName + "_glass");
		//
		//			createPouringRecipe(consumer, glassOutputId.getPath(),
		//			                    fluid, fluidAmount,
		//			                    glassContainerItem,
		//			                    BuiltInRegistries.ITEM.get(glassOutputId),
		//			                    filling, strict);
		//		}
	}
	
	// Wrapper
	public void createPouringRecipe(RecipeOutput consumer, String recipeName,
	                                Fluid fluid, int fluidAmount,
	                                @NotNull ItemLike containerItem, @NotNull DeferredItem<Item> outputItem,
	                                boolean filling, boolean strict)
	{
		Objects.requireNonNull(containerItem, "pouring recipe needs a container item");
		createPouringRecipe(consumer, outputItem.getId().getPath(),
		                    fluid, fluidAmount,
		                    containerItem,
		                    (ItemLike) outputItem,
		                    filling, strict);
	}
	
	private void createCookingRecipe(@NotNull RecipeOutput consumer, String recipeName, String recipeBookTab,
	                                 @Nullable ItemLike container, int cookingTime, float experience,
	                                 ItemLike result, int resultCount,
	                                 List<UnlockCriterion> unlocks,
	                                 Object... ingredients)
	{
		// container is optional in Farmer's Delight cooking recipes
		CookingPotRecipeBuilder builder = CookingPotRecipeBuilder.cookingPotRecipe(result, resultCount, cookingTime, experience, container);
		for (Object ingredient : ingredients) {
			builder.addIngredient(toIngredient(ingredient));
		}
		builder.setRecipeBookTab(CookingPotRecipeBookTab.findByName(recipeBookTab));
		if (unlocks != null) {
			for (UnlockCriterion unlock : unlocks) {
				builder.unlockedBy(unlock.name(), unlock.trigger());
			}
		}
		builder.save(consumer, recipeId("cooking", recipeName));
	}
	
	private record UnlockCriterion(String name, Criterion<?> trigger) {}
}
