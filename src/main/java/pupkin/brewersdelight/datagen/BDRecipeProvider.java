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
import pupkin.brewersdelight.item.BrewersItems;
import pupkin.brewersdelight.misc.BrewersFluids;
import umpaz.brewinandchewin.common.registry.BnCFluids;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.Objects;
import java.util.function.Consumer;

public class BDRecipeProvider extends RecipeProvider implements IConditionBuilder
{
	public static final int FAST_FERMENTING = 4800;      // 4 minutes
	public static final int NORMAL_FERMENTING = 9600;    // 8 minutes
	public static final int LONG_FERMENTING = 19200;     // 16 minutes
	
	public static final float SMALL_EXP = 0.5F;
	public static final float MEDIUM_EXP = 1.0F;
	public static final float LARGE_EXP = 2.0F;
	
	public static final int HOT_TEMPERATURE = 4;
	public static final int WARM_TEMPERATURE = 3;
	public static final int FRIGID_TEMPERATURE = 2;
	
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
		                       BrewersFluids.BRANDY.source().getId(), 1000,
		                       "forge:berries", "forge:berries", Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "cider", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CIDER.source().getId(), 1000,
		                       Items.APPLE, Items.APPLE, Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "gin", "drinks",
		                       BnCFluids.VODKA, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.GIN.source().getId(), 1000,
		                       "forge:seeds/wheat", "forge:seeds/wheat", "forge:berries", "forge:berries");
		createFermentingRecipe(consumer, "kvass", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.KVASS.source().getId(), 1000,
		                       "forge:grain/wheat", "forge:grain/wheat", Items.HONEYCOMB);
		createFermentingRecipe(consumer, "liqueur", "drinks",
		                       BnCFluids.HONEY_FLUID, 500,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.LIQUEUR.source().getId(), 750,
		                       ModItems.MELON_JUICE, ModItems.MELON_JUICE, "forge:berries", "forge:berries");
		createFermentingRecipe(consumer, "melon_schnapps", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MELON_SCHNAPPS.source().getId(), 1000,
		                       Items.MELON_SLICE, Items.MELON_SLICE, "forge:grain/wheat", "forge:grain/wheat");
		createFermentingRecipe(consumer, "sake", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.SAKE.source().getId(), 1000,
		                       "forge:grain/rice", "forge:grain/rice", "forge:grain/rice", "forge:grain/rice");
		createFermentingRecipe(consumer, "tequila", "drinks",
		                       BnCFluids.VODKA, 500,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.TEQUILA.source().getId(), 1000,
		                       Items.CACTUS, Items.CACTUS, "forge:fruits");
		createFermentingRecipe(consumer, "whisky", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.WHISKY.source().getId(), 1000,
		                       "forge:grain/wheat", "forge:grain/wheat", "forge:grain/wheat", "forge:grain/wheat");
		
		createFermentingRecipe(consumer, "flaxen_cheese_stout", "drinks",
		                       BnCFluids.VODKA, 250,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.FLAXEN_CHEESE_STOUT.source().getId(), 250,
		                       BnCItems.FLAXEN_CHEESE_WEDGE, BnCItems.FLAXEN_CHEESE_WEDGE, "forge:grain", "forge:mushrooms");
		createFermentingRecipe(consumer, "scarlet_cheese_stout", "drinks",
		                       Fluids.WATER, 250,
		                       NORMAL_FERMENTING, HOT_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.SCARLET_CHEESE_STOUT.source().getId(), 250,
		                       BnCItems.SCARLET_CHEESE_WEDGE, BnCItems.SCARLET_CHEESE_WEDGE, Items.NETHER_WART, "forge:mushrooms");
		createFermentingRecipe(consumer, "flying_dutchman", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, FRIGID_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.FLYING_DUTCHMAN.source().getId(), 500,
		                       "forge:fruits/apple", Items.SUGAR, Items.GLOW_INK_SAC, Items.KELP);
		createFermentingRecipe(consumer, "gut_wrecker", "drinks",
		                       ForgeMod.MILK.get(), 500,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.GUT_WRECKER.source().getId(), 1000,
		                       "forge:raw_fishes", "forge:cattail", Items.SPIDER_EYE, "forge:vegetables");
		
		createFermentingRecipe(consumer, "sbiten", "drinks",
		                       BnCFluids.BEER, 500,
		                       LONG_FERMENTING, HOT_TEMPERATURE, LARGE_EXP,
		                       BrewersFluids.SBITEN.source().getId(), 1000,
		                       Items.HONEY_BLOCK, "forge:grain/wheat");
		createFermentingRecipe(consumer, "syta", "drinks",
		                       Fluids.WATER, 500,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, SMALL_EXP,
		                       BrewersFluids.SYTA.source().getId(), 1000,
		                       Items.HONEY_BOTTLE, Items.HONEY_BOTTLE);
		
		createFermentingRecipe(consumer, "bourbon", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BOURBON.source().getId(), 1000,
		                       "forge:seeds/corn", "forge:seeds/corn", Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "corn_whisky", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CORN_WHISKY.source().getId(), 1000,
		                       "forge:vegetables/corn", "forge:vegetables/corn", "forge:vegetables/corn", "forge:vegetables/corn");
		createFermentingRecipe(consumer, "moonshine", "drinks",
		                       BrewersFluids.BRAGA.source().get(), 250,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MOONSHINE.source().getId(), 500,
		                       "forge:vegetables/corn", "forge:vegetables/corn", Items.SUGAR, Items.SUGAR);
		createFermentingRecipe(consumer, "cahors", "drinks",
		                       BrewersFluids.WINE.source().get(), 250,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CAHORS.source().getId(), 500,
		                       "forge:fruits/grape", "forge:fruits/grape", "forge:fruits/grape", "forge:fruits/grape");
		createFermentingRecipe(consumer, "champagne", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CHAMPAGNE.source().getId(), 1000,
		                       "forge:fruits/grape", "forge:fruits/grape", "minecraft:flowers", "minecraft:flowers");
		createFermentingRecipe(consumer, "cognac", "drinks",
		                       BrewersFluids.WINE.source().get(), 250,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.COGNAC.source().getId(), 500,
		                       "forge:fruits/grape", "forge:fruits/grape", Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "martini_glow_berries", "drinks",
		                       BrewersFluids.WINE.source().get(), 250,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MARTINI.source().getId(), 500,
		                       Items.GLOW_BERRIES, Items.GLOW_BERRIES, Items.SUGAR, Items.SUGAR);
		createFermentingRecipe(consumer, "martini_mushrooms", "drinks",
		                       BrewersFluids.WINE.source().get(), 250,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MARTINI.source().getId(), 500,
		                       "forge:mushrooms", "forge:mushrooms", Items.SUGAR, Items.SUGAR);
		
		// Bloat
		createFermentingRecipe(consumer, "absinthe_grass", "drinks",
		                       Fluids.WATER, 1000,
		                       LONG_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.ABSINTHE.source().getId(), 1000,
		                       Items.GRASS, Items.GRASS, Items.GRASS, Items.GRASS);
		createFermentingRecipe(consumer, "absinthe_tall_grass", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.ABSINTHE.source().getId(), 1000,
		                       Items.TALL_GRASS, Items.TALL_GRASS);
		createFermentingRecipe(consumer, "amaro", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.AMARO.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "amontillado", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.AMONTILLADO.source().getId(), 1000,
		                       "forge:seeds/corn", "forge:seeds/corn", Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "aperol", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.APEROL.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "armagnac", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.ARMAGNAC.source().getId(), 1000,
		                       "forge:seeds/corn", "forge:seeds/corn", Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "baijiu", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BAIJIU.source().getId(), 1000,
		                       "forge:seeds/corn", "forge:seeds/corn", Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "becherovka", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BECHEROVKA.source().getId(), 1000,
		                       "forge:seeds/corn", "forge:seeds/corn", Items.APPLE, Items.APPLE);
		createFermentingRecipe(consumer, "bitter", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.BITTER.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "calvados", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CALVADOS.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "campari", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CAMPARI.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "chacha", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.CHACHA.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "fernet", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.FERNET.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "gluhwein", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.GLUHWEIN.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "grog", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.GROG.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "kashasa", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.KASHASA.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "mezcal", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.MEZCAL.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "negroni", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.NEGRONI.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "ouzo", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.OUZO.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "pastis", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.PASTIS.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "punch", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.PUNCH.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "rakia", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.RAKIA.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "rum", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.RUM.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "sambuca", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.SAMBUCA.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "sherry", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.SHERRY.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "socata", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.SOCATA.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "soju", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.SOJU.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "sotol", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.SOTOL.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "toddy", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.TODDY.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "triple-sec", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.TRIPLE_SEC.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "tsipuro", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.TSIPURO.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "vermouth", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.VERMOUTH.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "tsuike", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.TSUIKE.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		createFermentingRecipe(consumer, "vishinata", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.VISHINATA.source().getId(), 1000,
		                       "forge:bread", "forge:bread", "forge:bread", "forge:bread");
		
		// Compatibility
		createFermentingRecipe(consumer, "wine", "drinks",
		                       Fluids.WATER, 1000,
		                       NORMAL_FERMENTING, WARM_TEMPERATURE, MEDIUM_EXP,
		                       BrewersFluids.WINE.source().getId(), 1000,
		                       "forge:fruits/grape", "forge:fruits/grape", "forge:fruits/grape", "forge:fruits/grape");
		
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
		
		// Bloat
		createPouringRecipe(consumer, "absinthe",
		                    BrewersFluids.ABSINTHE.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.ABSINTHE,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "amaro",
		                    BrewersFluids.AMARO.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.AMARO,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "amontillado",
		                    BrewersFluids.AMONTILLADO.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.AMONTILLADO,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "aperol",
		                    BrewersFluids.APEROL.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.APEROL,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "armagnac",
		                    BrewersFluids.ARMAGNAC.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.ARMAGNAC,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "baijiu",
		                    BrewersFluids.BAIJIU.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.BAIJIU,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "becherovka",
		                    BrewersFluids.BECHEROVKA.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.BECHEROVKA,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "bitter",
		                    BrewersFluids.BITTER.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.BITTER,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "calvados",
		                    BrewersFluids.CALVADOS.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.CALVADOS,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "campari",
		                    BrewersFluids.CAMPARI.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.CAMPARI,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "chacha",
		                    BrewersFluids.CHACHA.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.CHACHA,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "fernet",
		                    BrewersFluids.FERNET.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.FERNET,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "grog",
		                    BrewersFluids.GROG.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.GROG,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "kashasa",
		                    BrewersFluids.KASHASA.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.KASHASA,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "mezcal",
		                    BrewersFluids.MEZCAL.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.MEZCAL,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "negroni",
		                    BrewersFluids.NEGRONI.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.NEGRONI,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "ouzo",
		                    BrewersFluids.OUZO.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.OUZO,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "pastis",
		                    BrewersFluids.PASTIS.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.PASTIS,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "punch",
		                    BrewersFluids.PUNCH.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.PUNCH,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "rakia",
		                    BrewersFluids.RAKIA.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.RAKIA,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "rum",
		                    BrewersFluids.RUM.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.RUM,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "sambuca",
		                    BrewersFluids.SAMBUCA.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.SAMBUCA,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "sherry",
		                    BrewersFluids.SHERRY.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.SHERRY,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "socata",
		                    BrewersFluids.SOCATA.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.SOCATA,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "soju",
		                    BrewersFluids.SOJU.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.SOJU,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "sotol",
		                    BrewersFluids.SOTOL.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.SOTOL,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "toddy",
		                    BrewersFluids.TODDY.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.TODDY,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "triple-sec",
		                    BrewersFluids.TRIPLE_SEC.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.TRIPLE_SEC,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "tsipuro",
		                    BrewersFluids.TSIPURO.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.TSIPURO,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "vermouth",
		                    BrewersFluids.VERMOUTH.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.VERMOUTH,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "tsuike",
		                    BrewersFluids.TSUIKE.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.TSUIKE,
		                    false,
		                    false
		                   );
		createPouringRecipe(consumer, "vishinata",
		                    BrewersFluids.VISHINATA.source().get(),
		                    250,
		                    BnCItems.TANKARD,
		                    BrewersItems.VISHINATA,
		                    false,
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
			throw new IllegalStateException("Liquid is null: " + resultFluid);
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
			throw new IllegalStateException("Liquid is null: " + resultFluid.getId());
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
			throw new IllegalStateException("Liquid is null: " + fluid);
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
	
	// Wrapper
	public void createPouringRecipe(Consumer<FinishedRecipe> consumer, String recipeName,
	                                net.minecraftforge.registries.RegistryObject<? extends Fluid> fluid, int fluidAmount,
	                                @NotNull RegistryObject<Item> containerItem, @NotNull RegistryObject<Item> outputItem,
	                                boolean filling, boolean strict)
	{
		ResourceLocation fluidId = ForgeRegistries.FLUIDS.getKey(fluid.get());
		ResourceLocation containerId = containerItem.getId();
		ResourceLocation outputId = outputItem.getId();
		
		if (fluidId == null) {
			throw new IllegalStateException("Liquid is null: " + fluid.getId());
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