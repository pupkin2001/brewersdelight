package pupkin.brewersdelight.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.item.BrewersItems;
import pupkin.brewersdelight.misc.BrewersFluids;
import umpaz.brewinandchewin.common.registry.BnCItems;

import java.util.Objects;
import java.util.function.Consumer;

public class BDRecipeProvider extends RecipeProvider implements IConditionBuilder
{
	// Fermenting constants
	public static final int FAST_FERMENTING = 4800;      // 4 minutes
	public static final int NORMAL_FERMENTING = 9600;    // 8 minutes
	public static final int LONG_FERMENTING = 12000;     // 20 minutes
	
	public static final float MEDIUM_EXP = 1.0F;
	public static final float LARGE_EXP = 2.0F;
	
	public static final int WARM_TEMPERATURE = 3;
	
	public BDRecipeProvider(PackOutput output)
	{
		super(output);
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
		createFermentingRecipe(consumer, "braga", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BRAGA.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "brandy", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BRANDY.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "cider", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CIDER.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "gin", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.GIN.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "kvass", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.KVASS.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "liqueur", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.LIQUEUR.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "melon_schnapps", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MELON_SCHNAPPS.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "sake", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.SAKE.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "tequila", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.TEQUILA.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "whisky", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.WHISKY.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		
		createFermentingRecipe(consumer, "flaxen_cheese_stout", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.FLAXEN_CHEESE_STOUT.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "scarlet_cheese_stout", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.SCARLET_CHEESE_STOUT.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "flying_dutchman", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.FLYING_DUTCHMAN.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "gut_wrecker", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.GUT_WRECKER.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		
		createFermentingRecipe(consumer, "sbiten", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.SBITEN.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "syta", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.SYTA.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "vzvar", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.VZVAR.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		
		createFermentingRecipe(consumer, "bourbon", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BOURBON.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "corn_whisky", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CORN_WHISKY.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "moonshine", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MOONSHINE.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "cahors", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CAHORS.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "champagne", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CHAMPAGNE.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "cognac", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.COGNAC.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		createFermentingRecipe(consumer, "martini", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MARTINI.source().get(), 1000,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
		
		// Fermenting meals
	}
	
	private void generatePouringRecipes(Consumer<FinishedRecipe> consumer)
	{
		// Pouring drinks
		createPouringRecipe(consumer, "braga",
		                    BrewersFluids.BRAGA.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.BRAGA,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "brandy",
		                    BrewersFluids.BRANDY.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.BRANDY,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "cider",
		                    BrewersFluids.CIDER.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.CIDER,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "gin",
		                    BrewersFluids.GIN.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.GIN,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "kvass",
		                    BrewersFluids.KVASS.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.KVASS,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "liqueur",
		                    BrewersFluids.LIQUEUR.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.LIQUEUR,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "melon_schnapps",
		                    BrewersFluids.MELON_SCHNAPPS.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.MELON_SCHNAPPS,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "sake",
		                    BrewersFluids.SAKE.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.SAKE,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "tequila",
		                    BrewersFluids.TEQUILA.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.TEQUILA,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "whisky",
		                    BrewersFluids.WHISKY.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.WHISKY,
		                    false,
		                    false
		                   );
		
		createPouringRecipe(consumer, "flaxen_cheese_stout",
		                    BrewersFluids.FLAXEN_CHEESE_STOUT.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.FLAXEN_CHEESE_STOUT,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "scarlet_cheese_stout",
		                    BrewersFluids.SCARLET_CHEESE_STOUT.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.SCARLET_CHEESE_STOUT,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "flying_dutchman",
		                    BrewersFluids.FLYING_DUTCHMAN.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.FLYING_DUTCHMAN,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "gut_wrecker",
		                    BrewersFluids.GUT_WRECKER.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.GUT_WRECKER,
		                    false,
		                    false
		                   );
		
		createPouringRecipe(consumer, "sbiten",
		                    BrewersFluids.SBITEN.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.SBITEN,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "syta",
		                    BrewersFluids.SYTA.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.SYTA,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "vzvar",
		                    BrewersFluids.VZVAR.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.VZVAR,
		                    false,
		                    false
		                   );
		
		createPouringRecipe(consumer, "bourbon",
		                    BrewersFluids.BOURBON.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.BOURBON,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "corn_whisky",
		                    BrewersFluids.CORN_WHISKY.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.CORN_WHISKY,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "moonshine",
		                    BrewersFluids.MOONSHINE.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.MOONSHINE,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "cahors",
		                    BrewersFluids.CAHORS.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.CAHORS,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "champagne",
		                    BrewersFluids.CHAMPAGNE.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.CHAMPAGNE,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "cognac",
		                    BrewersFluids.COGNAC.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.COGNAC,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "martini",
		                    BrewersFluids.MARTINI.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.MARTINI,
		                    false,
		                    false
		                   );
		
		// Pouring meals
	}
	
	private void createFermentingRecipe(@NotNull Consumer<FinishedRecipe> consumer, String recipeName, String recipeBookTab,
	                                    Fluid baseFluid, int baseFluidCount,
	                                    int fermentingTime, int temperature, float experience,
	                                    ResourceLocation resultFluid, int resultFluidCount,
	                                    Object... ingredients)
	{
		consumer.accept(new FinishedRecipe()
		{
			@Override
			public void serializeRecipeData(@NotNull JsonObject json)
			{
				// Base fluid
				JsonObject baseFluidJson = new JsonObject();
				baseFluidJson.addProperty("count", baseFluidCount);
				baseFluidJson.addProperty("fluid", Objects.requireNonNull(ForgeRegistries.FLUIDS.getKey(baseFluid)).toString());
				json.add("basefluid", baseFluidJson);
				
				// Ingredients
				JsonArray ingredientsJson = new JsonArray();
				for (Object ingredient : ingredients) {
					JsonObject ingredientJson = new JsonObject();
					
					if (ingredient instanceof Item) {
						// Regular item
						ingredientJson.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey((Item) ingredient)).toString());
					} else if (ingredient instanceof net.minecraft.tags.TagKey) {
						// Tag
						net.minecraft.tags.TagKey<Item> tagKey = (net.minecraft.tags.TagKey<Item>) ingredient;
						ingredientJson.addProperty("tag", tagKey.location().toString());
					} else if (ingredient instanceof String) {
						// String representation of tag
						ingredientJson.addProperty("tag", (String) ingredient);
					} else {
						throw new IllegalArgumentException("Ingredient must be an Item, TagKey<Item>, or String tag representation");
					}
					
					ingredientsJson.add(ingredientJson);
				}
				json.add("ingredients", ingredientsJson);
				
				// Rest of the recipe data remains the same
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
				return new ResourceLocation("brewinandchewin", "fermenting/" + recipeName);
			}
			
			@Override
			public net.minecraft.world.item.crafting.@NotNull RecipeSerializer<?> getType()
			{
				return Objects.requireNonNull(ForgeRegistries.RECIPE_SERIALIZERS.getValue(
						new ResourceLocation("brewinandchewin", "fermenting")));
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
	
	// Wrapper
	private void createFermentingRecipe(Consumer<FinishedRecipe> consumer, String recipeName, String recipeBookTab,
	                                    Fluid baseFluid, int baseFluidCount,
	                                    int fermentingTime, int temperature, float experience,
	                                    Fluid resultFluid, int resultFluidCount,
	                                    Item... ingredients)
	{
		// Get the proper resource location for the result fluid
		ResourceLocation resultFluidId = ForgeRegistries.FLUIDS.getKey(resultFluid);
		if (resultFluidId == null) {
			throw new IllegalStateException("Unknown fluid: " + resultFluid);
		}
		
		createFermentingRecipe(consumer, recipeName, recipeBookTab,
		                       baseFluid, baseFluidCount,
		                       fermentingTime, temperature, experience,
		                       resultFluidId, resultFluidCount,
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
				return new ResourceLocation("brewersdelight", "keg_pouring/" + recipeName);
			}
			
			@Override
			public net.minecraft.world.item.crafting.@NotNull RecipeSerializer<?> getType()
			{
				return Objects.requireNonNull(ForgeRegistries.RECIPE_SERIALIZERS.getValue(
						new ResourceLocation("brewinandchewin", "keg_pouring")));
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
	
	// Wrapper
	public void createPouringRecipe(Consumer<FinishedRecipe> consumer, String recipeName,
	                                Fluid fluid, int fluidAmount,
	                                @NotNull RegistryObject<Item> containerItem, @NotNull RegistryObject<Item> outputItem,
	                                boolean filling, boolean strict)
	{
		// Get proper resource locations
		ResourceLocation fluidId = ForgeRegistries.FLUIDS.getKey(fluid);
		ResourceLocation containerId = containerItem.getId();
		ResourceLocation outputId = outputItem.getId();
		
		if (fluidId == null) {
			throw new IllegalStateException("Unknown fluid: " + fluid);
		}
		
		createPouringRecipe(consumer, recipeName,
		                    fluidId,
		                    fluidAmount,
		                    containerId,
		                    outputId,
		                    filling,
		                    strict
		                   );
	}
}