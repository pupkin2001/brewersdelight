package pupkin.brewersdelight.misc;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.NotNull;

// Shapeless crafting whose result reuses the containers its drink ingredients leave behind,
// e.g. 2 tankards in -> 2 filled Old Fashioned out, instead of 2 extra empty tankards.
public class CocktailRecipe extends ShapelessRecipe
{
	public CocktailRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients)
	{
		super(group, category, result, ingredients);
	}
	
	private CocktailRecipe(ShapelessRecipe recipe)
	{
		this(recipe.getGroup(), recipe.category(), recipe.getResultItem(RegistryAccess.EMPTY), recipe.getIngredients());
	}
	
	@Override
	public @NotNull NonNullList<ItemStack> getRemainingItems(@NotNull CraftingInput input)
	{
		NonNullList<ItemStack> remaining = super.getRemainingItems(input);
		ItemStack result = getResultItem(RegistryAccess.EMPTY);
		ItemStack container = result.getCraftingRemainingItem();
		if (container.isEmpty()) return remaining;
		
		// One container per result item goes into the result instead of back into the grid
		int toReuse = result.getCount();
		for (int i = 0; i < remaining.size() && toReuse > 0; i++) {
			ItemStack stack = remaining.get(i);
			if (ItemStack.isSameItem(stack, container)) {
				int reused = Math.min(stack.getCount(), toReuse);
				stack.shrink(reused);
				toReuse -= reused;
			}
		}
		return remaining;
	}
	
	@Override
	public @NotNull RecipeSerializer<?> getSerializer()
	{
		return BrewersRecipes.COCKTAIL.get();
	}
	
	// Same JSON and network format as vanilla shapeless crafting
	public static class Serializer implements RecipeSerializer<CocktailRecipe>
	{
		private static final MapCodec<CocktailRecipe> CODEC =
				RecipeSerializer.SHAPELESS_RECIPE.codec().xmap(CocktailRecipe::new, recipe -> recipe);
		private static final StreamCodec<RegistryFriendlyByteBuf, CocktailRecipe> STREAM_CODEC =
				RecipeSerializer.SHAPELESS_RECIPE.streamCodec().map(CocktailRecipe::new, recipe -> recipe);
		
		@Override
		public @NotNull MapCodec<CocktailRecipe> codec()
		{
			return CODEC;
		}
		
		@Override
		public @NotNull StreamCodec<RegistryFriendlyByteBuf, CocktailRecipe> streamCodec()
		{
			return STREAM_CODEC;
		}
	}
}
