package pupkin.brewersdelight.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pupkin.brewersdelight.item.BrewersItems;
import pupkin.brewersdelight.misc.BrewersFluids;
import umpaz.brewinandchewin.common.registry.BnCFluids;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static net.minecraft.data.recipes.RecipeBuilder.ROOT_RECIPE_ADVANCEMENT;

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
	
	public BDRecipeProvider(PackOutput output)
	{
		super(output);
	}
	
	private static ResourceLocation glassVariant(ResourceLocation drinkId)
	{
		return ResourceLocation.fromNamespaceAndPath(drinkId.getNamespace(), drinkId.getPath() + "_glass");
	}
	
	// Shared ingredient serializer used by fermenting, cooking, and shaped key entries.
	private static void writeIngredient(JsonObject ingredientJson, Object ingredient)
	{
		if (ingredient instanceof Item item) {
			// Regular item
			ingredientJson.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).toString());
		} else if (ingredient instanceof net.minecraft.tags.TagKey<?> tagKey) {
			// Item tag
			ingredientJson.addProperty("tag", tagKey.location().toString());
		} else if (ingredient instanceof String s) {
			// String representation of a tag
			ingredientJson.addProperty("tag", s);
		} else if (ingredient instanceof RegistryObject<?> regObj) {
			// RegistryObject for Item
			Item item = (Item) regObj.get();
			ingredientJson.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).toString());
		} else {
			throw new IllegalArgumentException("Ingredient must be an Item, TagKey<Item>, String tag representation, or RegistryObject<Item>: " + ingredient);
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
		if (ingredient instanceof Item item) {
			return ItemPredicate.Builder.item().of(item).build();
		} else if (ingredient instanceof net.minecraft.tags.TagKey<?> tagKey) {
			return ItemPredicate.Builder.item().of((net.minecraft.tags.TagKey<Item>) tagKey).build();
		} else if (ingredient instanceof String s) {
			// "namespace:path"
			String[] parts = s.split(":", 2);
			ResourceLocation tagId = parts.length == 2
					? ResourceLocation.fromNamespaceAndPath(parts[0], parts[1])
					: ResourceLocation.fromNamespaceAndPath("minecraft", parts[0]);
			return ItemPredicate.Builder.item().of(net.minecraft.tags.TagKey.create(Registries.ITEM, tagId)).build();
		} else if (ingredient instanceof RegistryObject<?> regObj) {
			return ItemPredicate.Builder.item().of((Item) regObj.get()).build();
		} else {
			throw new IllegalArgumentException(
					"Criterion item must be an Item, TagKey<Item>, String tag representation, or RegistryObject<Item>: " + ingredient);
		}
	}
	
	private static Advancement.Builder buildAdvancement(ResourceLocation recipeId, List<UnlockCriterion> unlocks)
	{
		Advancement.Builder advancement = Advancement.Builder.recipeAdvancement()
		                                                     .parent(ROOT_RECIPE_ADVANCEMENT)
		                                                     .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
		                                                     .rewards(AdvancementRewards.Builder.recipe(recipeId))
		                                                     .requirements(RequirementsStrategy.OR);
		for (UnlockCriterion unlock : unlocks) {
			advancement.addCriterion(unlock.name(), unlock.trigger());
		}
		return advancement;
	}
	
	private static ResourceLocation recipeAdvancementId(String category, String recipeName)
	{
		return ResourceLocation.fromNamespaceAndPath("brewersdelight", "recipes/" + category + "/" + recipeName);
	}
	
	@Override
	protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer)
	{
		generateFermentingRecipes(consumer);
		generatePouringRecipes(consumer);
	}
	
	private void generateFermentingRecipes(Consumer<FinishedRecipe> consumer)
	{
		// Fermenting drinks
		// Bases / fillers
		createFermentingRecipe(consumer, "braga", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BRAGA.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "grog", "drinks",
		                       BrewersFluids.RUM.id(), 500, // watered-down rum
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.GROG.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.SUGAR);
		createFermentingRecipe(consumer, "punch", "drinks",
		                       Fluids.WATER, 1000,
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.PUNCH.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:fruits", "forge:fruits", "forge:fruits", Items.SUGAR);
		createFermentingRecipe(consumer, "toddy", "drinks",
		                       BnCFluids.MEAD, 500,
		                       FAST_FERMENTING, WARM_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.TODDY.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:crops/cinnamon", Items.HONEY_BOTTLE);
		createFermentingRecipe(consumer, "wine", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.WINE.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:fruits/grape", "forge:fruits/grape", "forge:fruits/grape", "forge:fruits/grape");
		//		createFermentingRecipe(consumer, "red_wine", "drinks", // TODO
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		//		                       BrewersFluids.RED_WINE.id(), 1000,
		//		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		//		                       "forge:fruits/grape");
		//		createFermentingRecipe(consumer, "white_wine", "drinks", // TODO
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		//		                       BrewersFluids.WHITE_WINE.id(), 1000,
		//		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		//		                       "forge:fruits/grape");
		
		// Utility
		createFermentingRecipe(consumer, "kvass", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.KVASS.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:grain/wheat", "forge:grain/wheat", Items.HONEYCOMB);
		createFermentingRecipe(consumer, "melon_schnapps_from_melon_juice", "drinks",
		                       BrewersFluids.MELON_JUICE.id(), 500,
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.MELON_SCHNAPPS.id(), 750,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:grain/wheat");
		createFermentingRecipe(consumer, "melon_schnapps_from_water", "drinks",
		                       Fluids.WATER, 500,
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.MELON_SCHNAPPS.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.MELON_SLICE, Items.MELON_SLICE, "forge:grain/wheat", "forge:grain/wheat");
		
		// Cheap convenience
		createFermentingRecipe(consumer, "brandy", "drinks",
		                       BrewersFluids.CIDER.id(), 750,
		                       LONG_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BRANDY.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:berries", "forge:berries", Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "cider", "drinks",
		                       Fluids.WATER, 500,
		                       LONG_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.CIDER.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.APPLE, Items.APPLE, Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "corn_whisky", "drinks",
		                       Fluids.WATER, 1000,
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.CORN_WHISKY.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:crops/corn", "forge:crops/corn", "forge:crops/corn", "forge:crops/corn");
		createFermentingRecipe(consumer, "elderflower", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, COLD_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.ELDERFLOWER.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "minecraft:flowers", "minecraft:flowers", Items.SUGAR, Items.SUGAR);
		createFermentingRecipe(consumer, "gin", "drinks",
		                       BnCFluids.VODKA, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.GIN.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:seeds/wheat", "forge:seeds/wheat", "forge:berries", "forge:berries");
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
		                       "forge:mushrooms", "forge:mushrooms", Items.SUGAR, Items.SUGAR);
		
		// Tradeoff
		createFermentingRecipe(consumer, "absinthe", "drinks",
		                       BnCFluids.VODKA, 1000,
		                       LONG_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.ABSINTHE.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.FERN, Items.FERN, Items.GRASS, Items.GRASS);
		createFermentingRecipe(consumer, "moonshine", "drinks",
		                       BrewersFluids.BRAGA.id(), 500,
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MOONSHINE.id(), 750,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:crops/corn", "forge:crops/corn", Items.SUGAR, Items.SUGAR);
		createFermentingRecipe(consumer, "tequila", "drinks",
		                       Fluids.WATER, 500,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.TEQUILA.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.CACTUS, Items.CACTUS, Items.CACTUS, Items.CACTUS);
		
		// Clean buff
		createFermentingRecipe(consumer, "bitter", "drinks",
		                       BrewersFluids.LIQUEUR.id(), 500,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BITTER.source().getId(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:crops/ginger", "forge:raisins");
		createFermentingRecipe(consumer, "bourbon", "drinks",
		                       Fluids.WATER, 1000,
		                       LONG_FERMENTING, WARM_TEMPERATURE,
		                       MEDIUM_EXP, // the cellar/oak abstraction as the only thing separating bourbon from corn whiskey is aging in charred oak
		                       BrewersFluids.BOURBON.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:crops/corn", "forge:crops/corn", "forge:crops/corn", "forge:crops/corn");
		createFermentingRecipe(consumer, "cahors", "drinks",
		                       BrewersFluids.WINE.id(), 250,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CAHORS.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:fruits/grape", "forge:fruits/grape", Items.SUGAR, Items.SUGAR);
		createFermentingRecipe(consumer, "cognac", "drinks",
		                       BrewersFluids.WINE.id(), 500,
		                       LONG_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP, // oak aging abstractions, see bourbon comment
		                       BrewersFluids.COGNAC.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:fruits/grape", "forge:fruits/grape");
		createFermentingRecipe(consumer, "liqueur", "drinks",
		                       BnCFluids.HONEY_FLUID, 500,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.LIQUEUR.id(), 750,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       ModItems.MELON_JUICE, ModItems.MELON_JUICE, "forge:berries", "forge:berries");
		createFermentingRecipe(consumer, "rum", "drinks",
		                       Fluids.WATER, 1000,
		                       LONG_FERMENTING, HOT_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.RUM.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.SUGAR_CANE, Items.SUGAR_CANE, Items.SUGAR_CANE, Items.SUGAR_CANE);
		createFermentingRecipe(consumer, "rum_from_molasses", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, SMALL_EXP, // Croptopia molasses is produced by cooking sugar cane, so molasses doesn't need as high temp
		                       BrewersFluids.RUM.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:molasses", "forge:molasses", "forge:molasses");
		createFermentingRecipe(consumer, "sake", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, COLD_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.SAKE.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:grain/rice", "forge:grain/rice", "forge:grain/rice", "forge:grain/rice");
		createFermentingRecipe(consumer, "whisky", "drinks",
		                       Fluids.WATER, 1000,
		                       LONG_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.WHISKY.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:grain/wheat", "forge:grain/wheat", "forge:grain/wheat", "forge:grain/wheat");
		createFermentingRecipe(consumer, "whisky_from_barley", "drinks",
		                       Fluids.WATER, 1000,
		                       LONG_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.WHISKY.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:crops/barley", "forge:crops/barley", "forge:crops/barley");
		
		// Vintage
		createFermentingRecipe(consumer, "sbiten", "drinks",
		                       BnCFluids.BEER, 500,
		                       LONG_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.SBITEN.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.HONEY_BLOCK, "forge:grain/wheat");
		createFermentingRecipe(consumer, "sbiten_from_cinnamon", "drinks",
		                       BnCFluids.BEER, 500,
		                       LONG_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.SBITEN.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:crops/cinnamon", "forge:crops/ginger");
		createFermentingRecipe(consumer, "syta", "drinks",
		                       Fluids.WATER, 500,
		                       FAST_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.SYTA.id(), 1000,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.HONEY_BOTTLE, Items.HONEY_BOTTLE);
		
		// Challenge
		createFermentingRecipe(consumer, "flaxen_cheese_stout", "drinks",
		                       BnCFluids.VODKA, 250,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.FLAXEN_CHEESE_STOUT.id(), 250,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       BnCItems.FLAXEN_CHEESE_WEDGE, BnCItems.FLAXEN_CHEESE_WEDGE, "forge:grain", "forge:mushrooms");
		createFermentingRecipe(consumer, "scarlet_cheese_stout", "drinks",
		                       BnCFluids.BEER, 500,
		                       NORMAL_FERMENTING, HOT_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.SCARLET_CHEESE_STOUT.id(), 250, // evaporation or something
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       BnCItems.SCARLET_CHEESE_WEDGE, BnCItems.SCARLET_CHEESE_WEDGE, Items.NETHER_WART, "forge:mushrooms");
		//		createFermentingRecipe(consumer, "froststone_stout", "drinks",
		//		                       Fluids.WATER, 250,
		//		                       LONG_FERMENTING, FRIGID_TEMPERATURE, LARGE_EXP,
		//		                       BrewersFluids.FROSTSTONE_STOUT.source().getId(), 250,
		//		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		//		                       BrewersItems.FROSTSTONE_CHEESE_WEDGE, BrewersItems.FROSTSTONE_CHEESE_WEDGE, Items.CHARCOAL, "forge:mushrooms"); // TODO: snow fungus
		createFermentingRecipe(consumer, "flying_dutchman", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, COLD_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.FLYING_DUTCHMAN.id(), 500,
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       Items.APPLE, Items.SUGAR, Items.GLOW_INK_SAC, Items.KELP);
		createFermentingRecipe(consumer, "gut_wrecker", "drinks",
		                       ForgeMod.MILK.get(), 250,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.GUT_WRECKER.id(), 500, // open cattails take up a lot more volume
		                       List.of(unlock("has_tankard", BnCItems.TANKARD)),
		                       "forge:raw_fishes", "forge:cattail", Items.SPIDER_EYE, "forge:vegetables");
		
		// Fermenting meals
	}
	
	private void generatePouringRecipes(Consumer<FinishedRecipe> consumer)
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
	
	private void createFermentingRecipe(@NotNull Consumer<FinishedRecipe> consumer, String recipeName, String recipeBookTab,
	                                    Object baseFluid, int baseFluidCount,
	                                    int fermentingTime, int temperature, float experience,
	                                    ResourceLocation resultFluid, int resultFluidCount,
	                                    List<UnlockCriterion> unlocks,
	                                    Object... ingredients)
	{
		consumer.accept(new FinishedRecipe()
		{
			@Override
			public void serializeRecipeData(@NotNull JsonObject json)
			{
				JsonObject baseFluidJson = new JsonObject();
				baseFluidJson.addProperty("count", baseFluidCount);
				
				if (baseFluid instanceof Fluid) {
					// Regular fluid
					baseFluidJson.addProperty("fluid", Objects.requireNonNull(ForgeRegistries.FLUIDS.getKey((Fluid) baseFluid)).toString());
				} else if (baseFluid instanceof net.minecraft.tags.TagKey) {
					// Fluid tag
					net.minecraft.tags.TagKey<Fluid> tagKey = (net.minecraft.tags.TagKey<Fluid>) baseFluid;
					baseFluidJson.addProperty("tag", tagKey.location().toString());
				} else if (baseFluid instanceof String) {
					// String representation of fluid tag
					baseFluidJson.addProperty("tag", (String) baseFluid);
				} else if (baseFluid instanceof ResourceLocation) {
					// Direct ResourceLocation for fluid
					baseFluidJson.addProperty("fluid", baseFluid.toString());
				} else if (baseFluid instanceof RegistryObject<?> regObj) {
					// RegistryObject for Fluid or FlowingFluid
					Fluid fluid = (Fluid) regObj.get();
					baseFluidJson.addProperty("fluid", Objects.requireNonNull(ForgeRegistries.FLUIDS.getKey(fluid)).toString());
				} else {
					throw new IllegalArgumentException(
							"Unable to serialize recipe for " + recipeName + ". Base fluid must be a Fluid, TagKey<Fluid>, String tag representation, ResourceLocation, or "
									+ "RegistryObject<Fluid>: " + baseFluid.toString());
				}
				
				json.add("basefluid", baseFluidJson);
				
				JsonArray ingredientsJson = new JsonArray();
				for (Object ingredient : ingredients) {
					JsonObject ingredientJson = new JsonObject();
					if (ingredient instanceof Item) {
						// Regular item
						ingredientJson.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey((Item) ingredient)).toString());
					} else if (ingredient instanceof net.minecraft.tags.TagKey) {
						// Item tag
						net.minecraft.tags.TagKey<Item> tagKey = (net.minecraft.tags.TagKey<Item>) ingredient;
						ingredientJson.addProperty("tag", tagKey.location().toString());
					} else if (ingredient instanceof String) {
						// String representation of tag
						ingredientJson.addProperty("tag", (String) ingredient);
					} else if (ingredient instanceof RegistryObject<?> regObj) {
						// RegistryObject for Item
						Item item = (Item) regObj.get();
						ingredientJson.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).toString());
					} else {
						if (baseFluid instanceof RegistryObject<?> regObj) {
							throw new IllegalArgumentException("Unable to serialize recipe for " + recipeName
									                                   + ". Ingredient must be an Item, TagKey<Item>, String tag representation, or RegistryObject<Item>: "
									                                   + regObj);
						}
					}
					ingredientsJson.add(ingredientJson);
				}
				json.add("ingredients", ingredientsJson);
				
				json.addProperty("fermentingtime", fermentingTime);
				json.addProperty("temperature", temperature);
				
				JsonObject resultJson = new JsonObject();
				resultJson.addProperty("count", resultFluidCount);
				resultJson.addProperty("fluid", resultFluid.toString());
				json.add("result", resultJson);
				
				json.addProperty("experience", experience);
				json.addProperty("recipe_book_tab", recipeBookTab);
			}
			
			@Override
			public @NotNull ResourceLocation getId()
			{
				return ResourceLocation.fromNamespaceAndPath("brewersdelight", "fermenting/" + recipeName);
			}
			
			@Override
			public net.minecraft.world.item.crafting.@NotNull RecipeSerializer<?> getType()
			{
				return Objects.requireNonNull(ForgeRegistries.RECIPE_SERIALIZERS.getValue(
						ResourceLocation.fromNamespaceAndPath("brewinandchewin", "fermenting")));
			}
			
			@Override
			public JsonObject serializeAdvancement()
			{
				if (unlocks == null || unlocks.isEmpty()) {
					return null; // No advancement
				}
				return buildAdvancement(getId(), unlocks).serializeToJson();
			}
			
			@Override
			public ResourceLocation getAdvancementId()
			{
				if (unlocks == null || unlocks.isEmpty()) {
					return null; // No advancement
				}
				return recipeAdvancementId("fermenting", recipeName);
			}
		});
	}
	
	// Wrapper
	private void createFermentingRecipe(Consumer<FinishedRecipe> consumer, String recipeName, String recipeBookTab,
	                                    Object baseFluid, int baseFluidCount,
	                                    int fermentingTime, int temperature, float experience,
	                                    Fluid resultFluid, int resultFluidCount,
	                                    List<UnlockCriterion> unlocks,
	                                    Object... ingredients)
	{
		ResourceLocation resultFluidId = ForgeRegistries.FLUIDS.getKey(resultFluid);
		if (resultFluidId == null) {
			throw new IllegalStateException("Unable to create fermenting recipe for fluid " + resultFluid + " as it does not exist.");
		}
		
		createFermentingRecipe(consumer, recipeName, recipeBookTab,
		                       baseFluid, baseFluidCount,
		                       fermentingTime, temperature, experience,
		                       resultFluidId, resultFluidCount,
		                       unlocks,
		                       ingredients);
	}
	
	// Wrapper
	private void createFermentingRecipe(Consumer<FinishedRecipe> consumer, String recipeName, String recipeBookTab,
	                                    Object baseFluid, int baseFluidCount,
	                                    int fermentingTime, int temperature, float experience,
	                                    RegistryObject<? extends Fluid> resultFluid, int resultFluidCount,
	                                    List<UnlockCriterion> unlocks,
	                                    Object... ingredients)
	{
		ResourceLocation resultFluidId = ForgeRegistries.FLUIDS.getKey(resultFluid.get());
		if (resultFluidId == null) {
			throw new IllegalStateException("Unable to create fermenting recipe for fluid " + resultFluid + " as it does not exist.");
		}
		
		createFermentingRecipe(consumer, recipeName, recipeBookTab,
		                       baseFluid, baseFluidCount,
		                       fermentingTime, temperature, experience,
		                       resultFluidId, resultFluidCount,
		                       unlocks,
		                       ingredients);
	}
	
	private void createPouringRecipe(@NotNull Consumer<FinishedRecipe> consumer, String recipeName,
	                                 ResourceLocation fluid, int fluidAmount,
	                                 ResourceLocation container, ResourceLocation output,
	                                 boolean filling, boolean strict)
	{
		consumer.accept(new FinishedRecipe()
		{
			@Override
			public void serializeRecipeData(@NotNull JsonObject json)
			{
				json.addProperty("type", "brewinandchewin:keg_pouring");
				json.addProperty("amount", fluidAmount);
				
				// Container
				JsonObject containerJson = new JsonObject();
				containerJson.addProperty("item", container.toString());
				json.add("container", containerJson);
				
				json.addProperty("filling", filling);
				json.addProperty("fluid", fluid.toString());
				
				// Output
				JsonObject outputJson = new JsonObject();
				outputJson.addProperty("item", output.toString());
				json.add("output", outputJson);
				
				json.addProperty("strict", strict);
			}
			
			@Override
			public @NotNull ResourceLocation getId()
			{
				return ResourceLocation.fromNamespaceAndPath("brewersdelight", "pouring/" + recipeName);
			}
			
			@Override
			public net.minecraft.world.item.crafting.@NotNull RecipeSerializer<?> getType()
			{
				return Objects.requireNonNull(ForgeRegistries.RECIPE_SERIALIZERS.getValue(
						ResourceLocation.fromNamespaceAndPath("brewinandchewin", "keg_pouring")));
			}
			
			@Override
			public JsonObject serializeAdvancement()
			{
				return null; // No advancement
			}
			
			@Override
			public ResourceLocation getAdvancementId()
			{
				return null; // No advancement
			}
		});
	}
	
	public void createPouringRecipes(Consumer<FinishedRecipe> consumer, String recipeName,
	                                 Fluid fluid, int fluidAmount,
	                                 @Nullable RegistryObject<Item> containerItem,
	                                 @Nullable RegistryObject<Item> tankardOutput,
	                                 @Nullable Item glassContainerItem,
	                                 boolean filling, boolean strict)
	{
		ResourceLocation fluidId = ForgeRegistries.FLUIDS.getKey(fluid);
		if (fluidId == null) {
			throw new IllegalStateException("Unable to create pouring recipes for fluid " + fluid + " as it does not exist.");
		}
		
		// Tankard variant
		if (tankardOutput != null) {
			Objects.requireNonNull(containerItem, "tankard variant needs a container item");
			assert tankardOutput.getId() != null;
			createPouringRecipe(consumer, tankardOutput.getId().getPath(),
			                    fluidId, fluidAmount,
			                    containerItem.getId(),
			                    tankardOutput.getId(),
			                    filling, strict);
		}
		
		// TODO Re-enable for when glass variants are added back
		// Glass variant — no RegistryObject exists for it, so derive its id
		//		if (glassContainerItem != null) {
		//			ResourceLocation glassContainerId = ForgeRegistries.ITEMS.getKey(glassContainerItem);
		//			ResourceLocation glassOutputId = (tankardOutput != null)
		//					? glassVariant(tankardOutput.getId())
		//					: ResourceLocation.fromNamespaceAndPath(BrewersDelight.MOD_ID, recipeName + "_glass");
		//
		//			createPouringRecipe(consumer, glassOutputId.getPath(),
		//			                    fluidId, fluidAmount,
		//			                    glassContainerId,
		//			                    glassOutputId,
		//			                    filling, strict);
		//		}
	}
	
	// Wrapper
	public void createPouringRecipe(Consumer<FinishedRecipe> consumer, String recipeName,
	                                Fluid fluid, int fluidAmount,
	                                @NotNull RegistryObject<Item> containerItem, @NotNull RegistryObject<Item> outputItem,
	                                boolean filling, boolean strict)
	{
		ResourceLocation fluidId = ForgeRegistries.FLUIDS.getKey(fluid);
		ResourceLocation containerId = containerItem.getId();
		ResourceLocation outputId = outputItem.getId();
		
		if (fluidId == null) {
			throw new IllegalStateException("Unable to create pouring recipes for fluid " + fluid + " as it does not exist.");
		}
		
		Objects.requireNonNull(containerItem, "pouring recipe needs a container item");
		assert outputItem.getId() != null;
		createPouringRecipe(consumer, outputItem.getId().getPath(),
		                    fluidId, fluidAmount,
		                    containerItem.getId(),
		                    outputItem.getId(),
		                    filling, strict);
	}
	
	private void createCookingRecipe(@NotNull Consumer<FinishedRecipe> consumer, String recipeName, String recipeBookTab,
	                                 ResourceLocation container, int cookingTime, float experience,
	                                 ResourceLocation result, int resultCount,
	                                 List<UnlockCriterion> unlocks,
	                                 Object... ingredients)
	{
		consumer.accept(new FinishedRecipe()
		{
			@Override
			public void serializeRecipeData(@NotNull JsonObject json)
			{
				// container is optional in Farmer's Delight cooking recipes
				if (container != null) {
					JsonObject containerJson = new JsonObject();
					containerJson.addProperty("item", container.toString());
					json.add("container", containerJson);
				}
				
				json.addProperty("cookingtime", cookingTime);
				json.addProperty("experience", experience);
				
				JsonArray ingredientsJson = new JsonArray();
				for (Object ingredient : ingredients) {
					JsonObject ingredientJson = new JsonObject();
					writeIngredient(ingredientJson, ingredient);
					ingredientsJson.add(ingredientJson);
				}
				json.add("ingredients", ingredientsJson);
				
				json.addProperty("recipe_book_tab", recipeBookTab);
				
				JsonObject resultJson = new JsonObject();
				resultJson.addProperty("item", result.toString());
				if (resultCount > 1) {
					resultJson.addProperty("count", resultCount);
				}
				json.add("result", resultJson);
			}
			
			@Override
			public @NotNull ResourceLocation getId()
			{
				return ResourceLocation.fromNamespaceAndPath("brewersdelight", "cooking/" + recipeName);
			}
			
			@Override
			public net.minecraft.world.item.crafting.@NotNull RecipeSerializer<?> getType()
			{
				return Objects.requireNonNull(ForgeRegistries.RECIPE_SERIALIZERS.getValue(
						ResourceLocation.fromNamespaceAndPath("farmersdelight", "cooking")));
			}
			
			@Override
			public JsonObject serializeAdvancement()
			{
				if (unlocks == null || unlocks.isEmpty()) {
					return null; // No advancement
				}
				return buildAdvancement(getId(), unlocks).serializeToJson();
			}
			
			@Override
			public ResourceLocation getAdvancementId()
			{
				if (unlocks == null || unlocks.isEmpty()) {
					return null; // No advancement
				}
				return recipeAdvancementId("cooking", recipeName);
			}
		});
	}
	
	// Wrapper
	private void createCookingRecipe(Consumer<FinishedRecipe> consumer, String recipeName, String recipeBookTab,
	                                 RegistryObject<Item> container, int cookingTime, float experience,
	                                 RegistryObject<Item> result, int resultCount,
	                                 List<UnlockCriterion> unlocks,
	                                 Object... ingredients)
	{
		createCookingRecipe(consumer, recipeName, recipeBookTab,
		                    container == null ? null : container.getId(), cookingTime, experience,
		                    result.getId(), resultCount,
		                    unlocks,
		                    ingredients);
	}
	
	private record UnlockCriterion(String name, CriterionTriggerInstance trigger) {}
}