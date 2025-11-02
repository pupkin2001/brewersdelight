package pupkin.brewersdelight.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

// Of course BnC datagen is made for neoforge and is incompatible with forge, so I have to reimplement it at 2 AM
public class BDKegFermentingRecipeProvider extends RecipeProvider implements IConditionBuilder
{
	public static final int FAST_FERMENTING = 4800;      // 4 minutes
	public static final int NORMAL_FERMENTING = 9600;    // 8 minutes
	public static final int LONG_FERMENTING = 12000;    // 16 minutes
	
	public static final float MEDIUM_EXP = 1.0F;
	public static final float LARGE_EXP = 2.0F;
	
	public BDKegFermentingRecipeProvider(DataGenerator generator)
	{
		super(generator.getPackOutput());
	}
	
	@Override
	protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer)
	{
		fermentingDrinks(consumer);
		fermentingMeals(consumer);
	}
	
	private void createFermentingRecipe(Consumer<FinishedRecipe> consumer, String recipeName,
	                                    Fluid baseFluid, int baseFluidCount,
	                                    ResourceLocation resultFluid, int resultCount,
	                                    int fermentingTime, float experience, String recipeBookTab, int temperature,
	                                    Item... ingredients)
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
				
				// Experience
				json.addProperty("experience", experience);
				
				// Fermenting time
				json.addProperty("fermentingtime", fermentingTime);
				
				// Ingredients array
				JsonArray ingredientsJson = new JsonArray();
				for (Item ingredient : ingredients) {
					JsonObject ingredientJson = new JsonObject();
					ingredientJson.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(ingredient)).toString());
					ingredientsJson.add(ingredientJson);
				}
				json.add("ingredients", ingredientsJson);
				
				// Recipe book tab
				json.addProperty("recipe_book_tab", recipeBookTab);
				
				// Result fluid
				JsonObject resultJson = new JsonObject();
				resultJson.addProperty("count", resultCount);
				resultJson.addProperty("fluid", resultFluid.toString());
				json.add("result", resultJson);
				
				// Temperature
				json.addProperty("temperature", temperature);
			}
			
			@Override
			public @NotNull ResourceLocation getId()
			{
				return new ResourceLocation("brewersdelight", "fermenting/" + recipeName);
			}
			
			@Override
			public net.minecraft.world.item.crafting.@NotNull RecipeSerializer<?> getType()
			{
				// This should match the serializer ID in your mod
				return ForgeRegistries.RECIPE_SERIALIZERS.getValue(
						new ResourceLocation("brewersdelight", "fermenting"));
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
	
	private void fermentingDrinks(Consumer<FinishedRecipe> consumer)
	{
		// Beer recipe
		createFermentingRecipe(consumer, "braga_lol",
		                       Fluids.WATER, 1000,
		                       new ResourceLocation("brewersdelight", "braga"), 1000,
		                       NORMAL_FERMENTING, MEDIUM_EXP, "drinks", 3,
		                       Items.WHEAT, Items.WHEAT_SEEDS, Items.BROWN_MUSHROOM);
		
		// Vodka recipe
		createFermentingRecipe(consumer, "braga_l",
		                       Fluids.WATER, 1000,
		                       new ResourceLocation("brewersdelight", "braga"), 1000,
		                       NORMAL_FERMENTING, MEDIUM_EXP, "drinks", 3,
		                       Items.POTATO, Items.WHEAT, Items.WHEAT_SEEDS);
	}
	
	private void fermentingMeals(Consumer<FinishedRecipe> consumer)
	{
		// Hi
	}
}