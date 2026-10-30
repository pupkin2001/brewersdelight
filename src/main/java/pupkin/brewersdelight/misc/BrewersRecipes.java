package pupkin.brewersdelight.misc;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import pupkin.brewersdelight.BrewersDelight;

public class BrewersRecipes
{
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, BrewersDelight.MOD_ID);
	
	public static final DeferredHolder<RecipeSerializer<?>, CocktailRecipe.Serializer>
			COCKTAIL = RECIPE_SERIALIZERS.register("cocktail", CocktailRecipe.Serializer::new);
	
	public static void register(IEventBus bus)
	{
		RECIPE_SERIALIZERS.register(bus);
	}
}
