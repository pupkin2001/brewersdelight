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
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.item.BrewersItems;
import pupkin.brewersdelight.misc.BrewersFluids;
import umpaz.brewinandchewin.common.registry.BnCFluids;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.Objects;
import java.util.function.Consumer;

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
	
	private static ResourceLocation glassVariant(ResourceLocation drinkId) {
		return new ResourceLocation(drinkId.getNamespace(), drinkId.getPath() + "_glass");
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
		// Core
		createFermentingRecipe(consumer, "braga", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BRAGA.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "brandy", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BRANDY.source().getId(), 1000,
		                       "forge:berries", "forge:berries", Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "cider", "drinks",
		                       Fluids.WATER, 500,
		                       LONG_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CIDER.source().getId(), 500,
		                       Items.APPLE, Items.APPLE, Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "gin", "drinks",
		                       BnCFluids.VODKA, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.GIN.source().getId(), 1000,
		                       "forge:seeds/wheat", "forge:seeds/wheat", "forge:berries", "forge:berries");
		createFermentingRecipe(consumer, "kvass", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.KVASS.source().getId(), 1000,
		                       "forge:grain/wheat", "forge:grain/wheat", Items.HONEYCOMB);
		createFermentingRecipe(consumer, "liqueur", "drinks",
		                       BnCFluids.HONEY_FLUID, 500,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.LIQUEUR.source().getId(), 750,
		                       ModItems.MELON_JUICE, ModItems.MELON_JUICE, "forge:berries", "forge:berries");
		createFermentingRecipe(consumer, "martini_glow_berries", "drinks",
		                       BrewersFluids.WINE.source().get(), 250,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MARTINI.source().getId(), 500,
		                       Items.GLOW_BERRIES, Items.GLOW_BERRIES, Items.SUGAR, Items.SUGAR);
		createFermentingRecipe(consumer, "martini_mushrooms", "drinks",
		                       BrewersFluids.WINE.source().get(), 250,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MARTINI.source().getId(), 500,
		                       "forge:mushrooms", "forge:mushrooms", Items.SUGAR, Items.SUGAR);
		createFermentingRecipe(consumer, "melon_schnapps_from_water", "drinks",
		                       Fluids.WATER, 500,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.MELON_SCHNAPPS.source().getId(), 500,
		                       Items.MELON_SLICE, Items.MELON_SLICE, "forge:grain/wheat", "forge:grain/wheat");
		// No clue what to do here - 4 melon slices for 250 mB of melon juice is enough for 1 bucket of melon schnapps
		// where is the water coming from?
		createFermentingRecipe(consumer, "melon_schnapps_from_melon_juice", "drinks",
		                       BrewersFluids.MELON_JUICE.source().getId(), 250,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.MELON_SCHNAPPS.source().getId(), 500,
		                       "forge:grain/wheat");
		createFermentingRecipe(consumer, "rum", "drinks",
		                       Fluids.WATER, 1000,
		                       LONG_FERMENTING, HOT_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.RUM.source().getId(), 1000,
		                       Items.SUGAR_CANE, Items.SUGAR_CANE, Items.SUGAR_CANE);
		createFermentingRecipe(consumer, "sake", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.SAKE.source().getId(), 1000,
		                       "forge:grain/rice", "forge:grain/rice", "forge:grain/rice", "forge:grain/rice");
		createFermentingRecipe(consumer, "tequila", "drinks",
		                       BnCFluids.VODKA, 500,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.TEQUILA.source().getId(), 1000,
		                       Items.CACTUS, Items.CACTUS, "forge:fruits");
		createFermentingRecipe(consumer, "whisky", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.WHISKY.source().getId(), 1000,
		                       "forge:grain/wheat", "forge:grain/wheat", "forge:grain/wheat", "forge:grain/wheat");
		
		// Bloat
		//		createFermentingRecipe(consumer, "absinthe_grass", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       LONG_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.ABSINTHE.source().getId(), 1000,
		//		                       Items.GRASS, Items.GRASS, Items.GRASS, Items.GRASS);
		//		createFermentingRecipe(consumer, "absinthe_tall_grass", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.ABSINTHE.source().getId(), 1000,
		//		                       Items.TALL_GRASS, Items.TALL_GRASS);
		//		createFermentingRecipe(consumer, "amaro", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.AMARO.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "amontillado", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.AMONTILLADO.source().getId(), 1000,
		//		                       "forge:seeds/corn", "forge:seeds/corn", Items.APPLE, Items.APPLE);
		//		createFermentingRecipe(consumer, "aperol", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.APEROL.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "armagnac", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.ARMAGNAC.source().getId(), 1000,
		//		                       "forge:seeds/corn", "forge:seeds/corn", Items.APPLE, Items.APPLE);
		//		createFermentingRecipe(consumer, "baijiu", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.BAIJIU.source().getId(), 1000,
		//		                       "forge:seeds/corn", "forge:seeds/corn", Items.APPLE, Items.APPLE);
		//		createFermentingRecipe(consumer, "becherovka", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.BECHEROVKA.source().getId(), 1000,
		//		                       "forge:seeds/corn", "forge:seeds/corn", Items.APPLE, Items.APPLE);
		//		createFermentingRecipe(consumer, "bitter", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.BITTER.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "calvados", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.CALVADOS.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "campari", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.CAMPARI.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "chacha", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.CHACHA.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "fernet", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.FERNET.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "gluhwein", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.GLUHWEIN.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "grog", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.GROG.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "kashasa", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.KASHASA.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "mezcal", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.MEZCAL.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "negroni", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.NEGRONI.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "ouzo", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.OUZO.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "pastis", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.PASTIS.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "punch", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.PUNCH.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "rakia", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.RAKIA.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "sambuca", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.SAMBUCA.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "sherry", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.SHERRY.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "socata", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.SOCATA.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "soju", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.SOJU.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "sotol", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.SOTOL.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "toddy", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.TODDY.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "triple-sec", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.TRIPLE_SEC.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "tsipuro", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.TSIPURO.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "vermouth", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.VERMOUTH.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "tsuike", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.TSUIKE.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		//		createFermentingRecipe(consumer, "vishinata", "drinks",
		//		                       Fluids.WATER, 1000,
		//		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		//		                       BrewersFluids.VISHINATA.source().getId(), 1000,
		//		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		
		// Corn
		createFermentingRecipe(consumer, "bourbon", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BOURBON.source().getId(), 1000,
		                       "forge:seeds/corn", "forge:seeds/corn", Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "corn_whisky", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CORN_WHISKY.source().getId(), 1000,
		                       "forge:vegetables/corn", "forge:vegetables/corn", "forge:vegetables/corn", "forge:vegetables/corn");
		createFermentingRecipe(consumer, "moonshine", "drinks",
		                       BrewersFluids.BRAGA.source().get(), 250,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MOONSHINE.source().getId(), 500,
		                       "forge:vegetables/corn", "forge:vegetables/corn", Items.SUGAR, Items.SUGAR);
		
		//Grapes
		createFermentingRecipe(consumer, "cahors", "drinks",
		                       BrewersFluids.WINE.source().get(), 250,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CAHORS.source().getId(), 500,
		                       "forge:fruits/grape", "forge:fruits/grape", "forge:fruits/grape", "forge:fruits/grape");
		createFermentingRecipe(consumer, "champagne", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CHAMPAGNE.source().getId(), 1000,
		                       "forge:fruits/grape", "forge:fruits/grape", "minecraft:flowers", "minecraft:flowers");
		createFermentingRecipe(consumer, "cognac", "drinks",
		                       BrewersFluids.WINE.source().get(), 250,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.COGNAC.source().getId(), 500,
		                       "forge:fruits/grape", "forge:fruits/grape", Items.APPLE, Items.APPLE);
		// Common
		createFermentingRecipe(consumer, "wine", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.WINE.source().getId(), 1000,
		                       "forge:fruits/grape", "forge:fruits/grape", "forge:fruits/grape", "forge:fruits/grape");
		
		// Vintage
		createFermentingRecipe(consumer, "sbiten", "drinks",
		                       BnCFluids.BEER, 500,
		                       LONG_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.SBITEN.source().getId(), 1000,
		                       Items.HONEY_BLOCK, "forge:grain/wheat");
		createFermentingRecipe(consumer, "syta", "drinks",
		                       Fluids.WATER, 500,
		                       NORMAL_FERMENTING, NORMAL_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.SYTA.source().getId(), 1000,
		                       Items.HONEY_BOTTLE, Items.HONEY_BOTTLE);
		
		// Challenge
		createFermentingRecipe(consumer, "flaxen_cheese_stout", "drinks",
		                       BnCFluids.VODKA, 250,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.FLAXEN_CHEESE_STOUT.source().getId(), 250,
		                       BnCItems.FLAXEN_CHEESE_WEDGE, BnCItems.FLAXEN_CHEESE_WEDGE, "forge:grain", "forge:mushrooms");
		createFermentingRecipe(consumer, "scarlet_cheese_stout", "drinks",
		                       BnCFluids.BEER, 250,
		                       NORMAL_FERMENTING, HOT_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.SCARLET_CHEESE_STOUT.source().getId(), 250,
		                       BnCItems.SCARLET_CHEESE_WEDGE, BnCItems.SCARLET_CHEESE_WEDGE, Items.NETHER_WART, "forge:mushrooms");
		createFermentingRecipe(consumer, "flying_dutchman", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, COLD_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.FLYING_DUTCHMAN.source().getId(), 500,
		                       Items.APPLE, Items.SUGAR, Items.GLOW_INK_SAC, Items.KELP);
		createFermentingRecipe(consumer, "gut_wrecker", "drinks",
		                       ForgeMod.MILK.get(), 500,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.GUT_WRECKER.source().getId(), 1000,
		                       "forge:raw_fishes", "forge:cattail", Items.SPIDER_EYE, "forge:vegetables");
		
		// Fermenting meals
	}
	
	private void generatePouringRecipes(Consumer<FinishedRecipe> consumer)
	{
		// Pouring drinks
		// Core
		createPouringRecipes(consumer, "braga",
		                     BrewersFluids.BRAGA.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.BRAGA,
		                     Items.GLASS_BOTTLE,
		                     true,
		                     false
		                    );
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
		createPouringRecipes(consumer, "compote",
		                     BrewersFluids.COMPOTE.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.COMPOTE,
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
		createPouringRecipes(consumer, "kvass",
		                     BrewersFluids.KVASS.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.KVASS,
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
		createPouringRecipes(consumer, "martini",
		                     BrewersFluids.MARTINI.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.MARTINI,
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
		createPouringRecipes(consumer, "old_fashion",
		                     BrewersFluids.OLD_FASHION.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.OLD_FASHION,
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
		createPouringRecipes(consumer, "tequila",
		                     BrewersFluids.TEQUILA.source().get(),
		                     250,
		                     BnCItems.TANKARD,
		                     BrewersItems.TEQUILA,
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
		
		// Bloat
		//		createPouringRecipe(consumer, "absinthe",
		//		                    BrewersFluids.ABSINTHE.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.ABSINTHE,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "amaro",
		//		                    BrewersFluids.AMARO.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.AMARO,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "amontillado",
		//		                    BrewersFluids.AMONTILLADO.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.AMONTILLADO,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "aperol",
		//		                    BrewersFluids.APEROL.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.APEROL,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "armagnac",
		//		                    BrewersFluids.ARMAGNAC.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.ARMAGNAC,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "baijiu",
		//		                    BrewersFluids.BAIJIU.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.BAIJIU,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "becherovka",
		//		                    BrewersFluids.BECHEROVKA.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.BECHEROVKA,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "bitter",
		//		                    BrewersFluids.BITTER.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.BITTER,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "calvados",
		//		                    BrewersFluids.CALVADOS.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.CALVADOS,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "campari",
		//		                    BrewersFluids.CAMPARI.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.CAMPARI,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "chacha",
		//		                    BrewersFluids.CHACHA.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.CHACHA,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "fernet",
		//		                    BrewersFluids.FERNET.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.FERNET,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "gluhwein",
		//		                    BrewersFluids.GLUHWEIN.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.GLUHWEIN,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "grog",
		//		                    BrewersFluids.GROG.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.GROG,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "kashasa",
		//		                    BrewersFluids.KASHASA.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.KASHASA,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "mezcal",
		//		                    BrewersFluids.MEZCAL.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.MEZCAL,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "negroni",
		//		                    BrewersFluids.NEGRONI.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.NEGRONI,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "ouzo",
		//		                    BrewersFluids.OUZO.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.OUZO,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "pastis",
		//		                    BrewersFluids.PASTIS.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.PASTIS,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "punch",
		//		                    BrewersFluids.PUNCH.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.PUNCH,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "rakia",
		//		                    BrewersFluids.RAKIA.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.RAKIA,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "sambuca",
		//		                    BrewersFluids.SAMBUCA.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.SAMBUCA,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "sherry",
		//		                    BrewersFluids.SHERRY.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.SHERRY,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "socata",
		//		                    BrewersFluids.SOCATA.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.SOCATA,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "soju",
		//		                    BrewersFluids.SOJU.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.SOJU,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "sotol",
		//		                    BrewersFluids.SOTOL.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.SOTOL,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "toddy",
		//		                    BrewersFluids.TODDY.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.TODDY,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "triple-sec",
		//		                    BrewersFluids.TRIPLE_SEC.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.TRIPLE_SEC,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "tsipuro",
		//		                    BrewersFluids.TSIPURO.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.TSIPURO,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "vermouth",
		//		                    BrewersFluids.VERMOUTH.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.VERMOUTH,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "tsuike",
		//		                    BrewersFluids.TSUIKE.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.TSUIKE,
		//		                    true,
		//		                    false
		//		                   );
		//		createPouringRecipe(consumer, "vishinata",
		//		                    BrewersFluids.VISHINATA.source().get(),
		//		                    250,
		//		                    BnCItems.TANKARD,
		//		                    BrewersItems.VISHINATA,
		//		                    true,
		//		                    false
		//		                   );
		
		// Corn
		createPouringRecipe(consumer, "bourbon",
		                    BrewersFluids.BOURBON.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.BOURBON,
		                    true,
		                    false
		                   );
		createPouringRecipe(consumer, "corn_whisky",
		                    BrewersFluids.CORN_WHISKY.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.CORN_WHISKY,
		                    true,
		                    false
		                   );
		createPouringRecipe(consumer, "moonshine",
		                    BrewersFluids.MOONSHINE.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.MOONSHINE,
		                    true,
		                    false
		                   );
		
		// Grapes
		createPouringRecipe(consumer, "cahors",
		                    BrewersFluids.CAHORS.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.CAHORS,
		                    true,
		                    false
		                   );
		createPouringRecipe(consumer, "champagne",
		                    BrewersFluids.CHAMPAGNE.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.CHAMPAGNE,
		                    true,
		                    false
		                   );
		createPouringRecipe(consumer, "cognac",
		                    BrewersFluids.COGNAC.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.COGNAC,
		                    true,
		                    false
		                   );
		
		// Vintage
		createPouringRecipe(consumer, "sbiten",
		                    BrewersFluids.SBITEN.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.SBITEN,
		                    true,
		                    false
		                   );
		createPouringRecipe(consumer, "syta",
		                    BrewersFluids.SYTA.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.SYTA,
		                    true,
		                    false
		                   );
		createPouringRecipe(consumer, "vzvar",
		                    BrewersFluids.VZVAR.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.VZVAR,
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
							"Base fluid must be a Fluid, TagKey<Fluid>, String tag representation, ResourceLocation, or RegistryObject<Fluid>: " + baseFluid);
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
						throw new IllegalArgumentException("Ingredient must be an Item, TagKey<Item>, String tag representation, or RegistryObject<Item>");
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
				return new ResourceLocation("brewersdelight", "fermenting/" + recipeName);
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
	                                    Object baseFluid, int baseFluidCount,
	                                    int fermentingTime, int temperature, float experience,
	                                    Fluid resultFluid, int resultFluidCount,
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
		                       ingredients);
	}
	
	// Wrapper
	private void createFermentingRecipe(Consumer<FinishedRecipe> consumer, String recipeName, String recipeBookTab,
	                                    Object baseFluid, int baseFluidCount,
	                                    int fermentingTime, int temperature, float experience,
	                                    net.minecraftforge.registries.RegistryObject<? extends Fluid> resultFluid, int resultFluidCount,
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
				return new ResourceLocation("brewersdelight", "pouring/" + recipeName);
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
			createPouringRecipe(consumer, tankardOutput.getId().getPath(),
			                    fluidId, fluidAmount,
			                    containerItem.getId(),
			                    tankardOutput.getId(),
			                    filling, strict);
		}
		
		// Glass variant — no RegistryObject exists for it, so derive its id
		if (glassContainerItem != null) {
			ResourceLocation glassContainerId = ForgeRegistries.ITEMS.getKey(glassContainerItem);
			ResourceLocation glassOutputId = (tankardOutput != null)
					? glassVariant(tankardOutput.getId())
					: new ResourceLocation(BrewersDelight.MOD_ID, recipeName + "_glass");
			
			createPouringRecipe(consumer, glassOutputId.getPath(),
			                    fluidId, fluidAmount,
			                    glassContainerId,
			                    glassOutputId,
			                    filling, strict);
		}
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