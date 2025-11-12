package pupkin.brewersdelight.misc;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class BeverageProperties
{
	public static final int BRIEF_DURATION = 600;           // 30 seconds
	public static final int VERY_SHORT_DURATION = 1200;     // 1 minute
	public static final int SHORT_DURATION = 2400;          // 2 minutes
	public static final int MEDIUM_DURATION = 3600;         // 3 minutes
	public static final int MODERATE_DURATION = 6000;       // 5 minutes
	public static final int EXTENDED_DURATION = 9600;       // 8 minutes
	public static final int LONG_DURATION = 12000;          // 10 minutes
	public static final int PROLONGED_DURATION = 14400;     // 12 minutes
	public static final int VERY_LONG_DURATION = 24000;     // 20 minutes
	
	// Basic (Farmers Delight)
	public static final FoodProperties BRAGA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, VERY_SHORT_DURATION, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, SHORT_DURATION, 0), 1.0f)
			.build();
	public static final FoodProperties BRANDY = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, MEDIUM_DURATION, 0), 1.0f)
			.build();
	public static final FoodProperties CIDER = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, VERY_SHORT_DURATION, 1), 1.0f)
			.build();
	public static final FoodProperties COMPOTE = new FoodProperties.Builder() // Golden apple, but without the gold?...   ...fair enough.
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, MEDIUM_DURATION, 0), 1.0f)
			.build();
	public static final FoodProperties GIN = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 4800, 1), 1.0f)
			.build();
	public static final FoodProperties KVASS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1.0f)
			.nutrition(3).saturationMod(0.1F)
			.build();
	public static final FoodProperties LIQUEUR = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, MEDIUM_DURATION, 1), 1.0f)
			.build();
	public static final FoodProperties MARTINI = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MODERATE_DURATION, 1), 1.0f)
			.build();
	public static final FoodProperties MELON_SCHNAPPS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, VERY_SHORT_DURATION, 1), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, BRIEF_DURATION, 0), 1.0f)
			.build();
	public static final FoodProperties OLD_FASHION = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 8400, 1), 0.5f)
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, EXTENDED_DURATION, 0), 0.5f)
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 7200, 1), 0.5f)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 7200, 1), 0.5f)
			.build();
	public static final FoodProperties RUM = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 26400, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, EXTENDED_DURATION, 2), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 21600, 0), 1.0f)
			.build();
	public static final FoodProperties SAKE = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 7200, 1), 1.0f)
			.build();
	public static final FoodProperties TEQUILA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 7200, 1), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 7200, 1), 1.0f)
			.build();
	public static final FoodProperties WHISKY = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, VERY_SHORT_DURATION, 1), 1.0f)
			.build();
	
	// Bloat
//	public static final FoodProperties ABSINTHE = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, EXTENDED_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 8400, 0), 1.0f)
//			.build();
//	public static final FoodProperties AMARO = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, PROLONGED_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, MODERATE_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, VERY_LONG_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties AMONTILLADO = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 16800, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15600, 1), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, PROLONGED_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties APEROL = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, SHORT_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, LONG_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties ARMAGNAC = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, BRIEF_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties BAIJIU = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, BRIEF_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties BECHEROVKA = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 43200, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 33600, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 37200, 0), 1.0f)
//			.build();
//	public static final FoodProperties BITTER = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 25200, 0), 1.0f)
//			.build();
//	public static final FoodProperties CALVADOS = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 21600, 0), 1.0f)
//			.build();
//	public static final FoodProperties CAMPARI = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 33600, 0), 1.0f)
//			.build();
//	public static final FoodProperties CHACHA = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 16800, 2), 1.0f)
//			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 18000, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 0.5f)
//			.build();
//	public static final FoodProperties FERNET = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 21600, 0), 1.0f)
//			.build();
//	public static final FoodProperties GLUHWEIN = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 21600, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 21600, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 22800, 0), 1.0f)
//			.build();
//	public static final FoodProperties GROG = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 28800, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, EXTENDED_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 20400, 0), 1.0f)
//			.build();
//	public static final FoodProperties KASHASA = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 45600, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20400, 0), 1.0f)
//			.build();
//	public static final FoodProperties MEZCAL = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 22800, 0), 1.0f)
//			.build();
//	public static final FoodProperties NEGRONI = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.LEVITATION, PROLONGED_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, PROLONGED_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, VERY_LONG_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties OUZO = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 37200, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 21600, 0), 1.0f)
//			.build();
//	public static final FoodProperties PASTIS = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 34800, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 27600, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 19200, 1), 1.0f)
//			.build();
//	public static final FoodProperties PUNCH = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 28800, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 33600, 0), 1.0f)
//			.build();
//	public static final FoodProperties RAKIA = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 37200, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 46800, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 16800, 0), 1.0f)
//			.build();
//	public static final FoodProperties SAMBUCA = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), EXTENDED_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MODERATE_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, MEDIUM_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties SHERRY = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.JUMP, MEDIUM_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties SOCATA = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.JUMP, MEDIUM_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties SOJU = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.JUMP, MEDIUM_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties SOTOL = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.JUMP, MEDIUM_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties TODDY = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, MEDIUM_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties TRIPLE_SEC = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, MEDIUM_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, MEDIUM_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, MEDIUM_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties TSIPURO = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 38400, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, SHORT_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 33600, 0), 1.0f)
//			.build();
//	public static final FoodProperties TSUIKE = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, MEDIUM_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, MEDIUM_DURATION, 0), 1.0f)
//			.effect(() -> new MobEffectInstance(MobEffects.LEVITATION, MEDIUM_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties VERMOUTH = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.JUMP, MEDIUM_DURATION, 0), 1.0f)
//			.build();
//	public static final FoodProperties VISHINATA = new FoodProperties.Builder()
//			.alwaysEat()
//			.effect(() -> new MobEffectInstance(MobEffects.JUMP, MEDIUM_DURATION, 0), 1.0f)
//			.build();
	
	// Compatibility
		// Corn
	public static final FoodProperties BOURBON = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, EXTENDED_DURATION, 0), 1.0f)
			.build();
	public static final FoodProperties CORN_WHISKY = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.LEVITATION, VERY_SHORT_DURATION, 1), 1.0f)
			.build();
	public static final FoodProperties MOONSHINE = new FoodProperties.Builder() // Should it require corn?...
            .alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, MODERATE_DURATION, 2), 1.0f)
            .build();
	
		// Grapes
	public static final FoodProperties CAHORS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, SHORT_DURATION, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 2), 1.0f)
			.build();
	public static final FoodProperties CHAMPAGNE = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, SHORT_DURATION, 1), 1.0f)
			.build();
	public static final FoodProperties COGNAC = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 4800, 2), 1.0f)
			.build();
	
	// Vintage beverages
	public static final FoodProperties SBITEN = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, EXTENDED_DURATION, 1), 1.0f)
			.nutrition(6).saturationMod(0.3F)
			.build();
	public static final FoodProperties SYTA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MODERATE_DURATION, 0), 1.0f)
			.build();
	public static final FoodProperties VZVAR = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 6400, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 6400, 0), 1.0f)
			.build();
	
	// Challenge beverages
	public static final FoodProperties FLAXEN_CHEESE_STOUT = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.UNLUCK, 8400, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 8400, 5), 0.8f)
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 2100, 1), 0.8f)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4200, 0), 0.5f)
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 4200, 0), 0.5f)
			.effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 0.25f)
			.effect(() -> new MobEffectInstance(MobEffects.POISON, 2100, 0), 0.25f)
			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 4200, 0), 0.1f)
			.nutrition(4).saturationMod(0.4F)
			.build();
	public static final FoodProperties SCARLET_CHEESE_STOUT = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 19200, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.UNLUCK, 8400, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 8400, 5), 0.8f)
			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 4200, 0), 0.8f)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4200, 0), 0.5f)
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 4200, 0), 0.5f)
			.effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 0.25f)
			.effect(() -> new MobEffectInstance(MobEffects.WITHER, 2100, 0), 0.25f)
			.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 2100, 1), 0.1f)
			.nutrition(4).saturationMod(0.4F)
			.build();
	public static final FoodProperties FLYING_DUTCHMAN = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, LONG_DURATION, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, LONG_DURATION, 0), 1.0f)
			.build();
	public static final FoodProperties GUT_WRECKER = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, LONG_DURATION, 1), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, MODERATE_DURATION, 2), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, MODERATE_DURATION, 0), 0.5f)
			.nutrition(6).saturationMod(2.0F)
			.build();
}
