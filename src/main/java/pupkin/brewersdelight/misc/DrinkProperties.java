package pupkin.brewersdelight.misc;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class DrinkProperties
{
	public static final int
			BRIEF_DURATION = 600,           // 30 seconds
			VERY_SHORT_DURATION = 1200,     // 1 minute
			SHORT_DURATION = 2400,          // 2 minutes
			MEDIUM_DURATION = 3600,         // 3 minutes
			MODERATE_DURATION = 6000,       // 5 minutes
			EXTENDED_DURATION = 9600,       // 8 minutes
			LONG_DURATION = 12000,          // 10 minutes
			PROLONGED_DURATION = 14400,     // 12 minutes
			VERY_LONG_DURATION = 24000;     // 20 minutes
	
	// Core
	public static final FoodProperties
			BRAGA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, VERY_SHORT_DURATION, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, SHORT_DURATION, 0), 1.0f)
			.build(), // This definitely does look weird
			BRANDY = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, MEDIUM_DURATION, 0), 1.0f)
					.build(),
			CIDER = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, VERY_SHORT_DURATION, 1), 1.0f)
					.build(),
			COMPOTE = new FoodProperties.Builder()
					.alwaysEat() // Golden apple, but without the gold?...
					.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, MEDIUM_DURATION, 0), 1.0f)
					.build(),    //                                                 ...fair enough.
			GIN = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 4800, 1), 1.0f)
					.build(),
			KVASS = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1.0f)
					.nutrition(3).saturationMod(0.1F)
					.build(),
			LIQUEUR = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, MEDIUM_DURATION, 1), 1.0f)
					.build(),
			MARTINI = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MODERATE_DURATION, 1), 1.0f)
					.build(),
			MELON_SCHNAPPS = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, VERY_SHORT_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, BRIEF_DURATION, 0), 1.0f)
					.build(),
			OLD_FASHION = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 8400, 1), 0.5f)
					.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, EXTENDED_DURATION, 0), 0.5f)
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 7200, 1), 0.5f)
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 7200, 1), 0.5f)
					.build(),
			RUM = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 26400, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, EXTENDED_DURATION, 2), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 21600, 0), 1.0f)
					.build(),
			SAKE = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 7200, 1), 1.0f)
					.build(),
			TEQUILA = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 7200, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 7200, 1), 1.0f)
					.build(),
			WHISKY = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, VERY_SHORT_DURATION, 1), 1.0f)
					.build(),
	
	// Bloat
	//	ABSINTHE = new FoodProperties.Builder()
	//			.alwaysEat()
	//			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, EXTENDED_DURATION, 0), 1.0f)
	//			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 8400, 0), 1.0f)
	//			.build(),
	//			AMARO = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, PROLONGED_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, MODERATE_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, VERY_LONG_DURATION, 0), 1.0f)
	//					.build(),
	//			AMONTILLADO = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 16800, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15600, 1), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, PROLONGED_DURATION, 0), 1.0f)
	//					.build(),
	//			APEROL = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, SHORT_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, LONG_DURATION, 0), 1.0f)
	//					.build(),
	//			ARMAGNAC = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, BRIEF_DURATION, 0), 1.0f)
	//					.build(),
	//			BAIJIU = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, BRIEF_DURATION, 0), 1.0f)
	//					.build(),
	//			BECHEROVKA = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 43200, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 33600, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 37200, 0), 1.0f)
	//					.build(),
	//			BITTER = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 25200, 0), 1.0f)
	//					.build(),
	//			CALVADOS = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 21600, 0), 1.0f)
	//					.build(),
	//			CAMPARI = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 33600, 0), 1.0f)
	//					.build(),
	//			CHACHA = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 16800, 2), 1.0f)
	//					.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 18000, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 0.5f)
	//					.build(),
	//			FERNET = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 21600, 0), 1.0f)
	//					.build(),
	//			GLUHWEIN = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 21600, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 21600, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 22800, 0), 1.0f)
	//					.build(),
	//			GROG = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 28800, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, EXTENDED_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 20400, 0), 1.0f)
	//					.build(),
	//			KASHASA = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 45600, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20400, 0), 1.0f)
	//					.build(),
	//			MEZCAL = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 22800, 0), 1.0f)
	//					.build(),
	//			NEGRONI = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.LEVITATION, PROLONGED_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, PROLONGED_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, VERY_LONG_DURATION, 0), 1.0f)
	//					.build(),
	//			OUZO = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 37200, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 21600, 0), 1.0f)
	//					.build(),
	//			PASTIS = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 34800, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 27600, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 19200, 1), 1.0f)
	//					.build(),
	//			PUNCH = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 28800, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 33600, 0), 1.0f)
	//					.build(),
	//			RAKIA = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 37200, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 46800, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 16800, 0), 1.0f)
	//					.build(),
	//			SAMBUCA = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), EXTENDED_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MODERATE_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, MEDIUM_DURATION, 0), 1.0f)
	//					.build(),
	//			SHERRY = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.JUMP, MEDIUM_DURATION, 0), 1.0f)
	//					.build(),
	//			SOCATA = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.JUMP, MEDIUM_DURATION, 0), 1.0f)
	//					.build(),
	//			SOJU = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.JUMP, MEDIUM_DURATION, 0), 1.0f)
	//					.build(),
	//			SOTOL = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.JUMP, MEDIUM_DURATION, 0), 1.0f)
	//					.build(),
	//			TODDY = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, MEDIUM_DURATION, 0), 1.0f)
	//					.build(),
	//			TRIPLE_SEC = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, MEDIUM_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, MEDIUM_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.HUNGER, MEDIUM_DURATION, 0), 1.0f)
	//					.build(),
	//			TSIPURO = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 38400, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, SHORT_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 33600, 0), 1.0f)
	//					.build(),
	//			TSUIKE = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, MEDIUM_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, MEDIUM_DURATION, 0), 1.0f)
	//					.effect(() -> new MobEffectInstance(MobEffects.LEVITATION, MEDIUM_DURATION, 0), 1.0f)
	//					.build(),
	//			VERMOUTH = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.JUMP, MEDIUM_DURATION, 0), 1.0f)
	//					.build(),
	//			VISHINATA = new FoodProperties.Builder()
	//					.alwaysEat()
	//					.effect(() -> new MobEffectInstance(MobEffects.JUMP, MEDIUM_DURATION, 0), 1.0f)
	//					.build(),
	
	// Corn
	BOURBON = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, EXTENDED_DURATION, 0), 1.0f)
			.build(),
			CORN_WHISKY = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.LEVITATION, VERY_SHORT_DURATION, 1), 1.0f)
					.build(),
			MOONSHINE = new FoodProperties.Builder() // Should it require corn?...
			                                         .alwaysEat()
			                                         .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, MODERATE_DURATION, 2), 1.0f)
			                                         .build(),
	
	// Grapes
	CAHORS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, SHORT_DURATION, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 2), 1.0f)
			.build(),
			CHAMPAGNE = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.JUMP, SHORT_DURATION, 1), 1.0f)
					.build(),
			COGNAC = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 4800, 2), 1.0f)
					.build(),
	
	// Vintage
	SBITEN = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, EXTENDED_DURATION, 1), 1.0f)
			.nutrition(6).saturationMod(0.3F)
			.build(),
			SYTA = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MODERATE_DURATION, 0), 1.0f)
					.build(),
			VZVAR = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 6400, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 6400, 0), 1.0f)
					.build(),
	
	// Challenge
	FLAXEN_CHEESE_STOUT = new FoodProperties.Builder()
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
			.build(),
			SCARLET_CHEESE_STOUT = new FoodProperties.Builder()
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
					.build(),
			FLYING_DUTCHMAN = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, LONG_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, LONG_DURATION, 0), 1.0f)
					.build(),
			GUT_WRECKER = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, LONG_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, MODERATE_DURATION, 2), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, MODERATE_DURATION, 0), 0.5f)
					.nutrition(6).saturationMod(2.0F)
					.build();
}
