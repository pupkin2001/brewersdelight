package pupkin.brewersdelight.misc;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import umpaz.brewinandchewin.common.registry.BnCEffects;
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
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, SHORT_DURATION, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, SHORT_DURATION * 3 / 4, 0), 1.0f)
			.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 4800, 0), 1.0F)
			.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 3600, 0, true, false), 1.0F)
			.nutrition(6).saturationMod(0.1F)
			.build(), // This definitely does look weird
			BRANDY = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, SHORT_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, SHORT_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 18000, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 13500, 0, true, false), 1.0F)
					.build(),
			CIDER = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, VERY_SHORT_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0, true, false), 1.0F)
					.build(),
			COMPOTE = new FoodProperties.Builder()
					.alwaysEat() // Golden apple, but without the gold?...
					.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, SHORT_DURATION, 0), 0.5f)
					.nutrition(4).saturationMod(0.3F)
					.build(),    //                                                 ...fair enough.
			GIN = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, MEDIUM_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, SHORT_DURATION, 0), 0.8f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 19200, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 14400, 0, true, false), 1.0F)
					.build(),
			KVASS = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, MEDIUM_DURATION, 0), 1.0f)
					.nutrition(3).saturationMod(0.1F)
					.build(),
			LIQUEUR = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, SHORT_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, SHORT_DURATION, 0), 0.5f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 10800, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 8100, 0, true, false), 1.0F)
					.build(),
			MARTINI = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MODERATE_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 7800, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 5850, 0, true, false), 1.0F)
					.build(),
	// I *really* want to split martini depending on the recipe used. The thought of beginning to glow after drinking glow berries is funny to me for some reason.
	MARTINI_GLOW = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.GLOWING, MODERATE_DURATION, 0), 0.3f)
			.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, MODERATE_DURATION, 0), 0.7f)
			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MODERATE_DURATION, 0), 1.0f)
			.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 7800, 0), 1.0F)
			.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 5850, 0, true, false), 1.0F)
			.build(),
			MARTINI_MUSHROOM = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.POISON, VERY_SHORT_DURATION, 0), 0.3f)
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, SHORT_DURATION, 0), 0.7f)
					.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MODERATE_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 7800, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 5850, 0, true, false), 1.0F)
					.build(),
			MELON_SCHNAPPS = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, SHORT_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.HUNGER, BRIEF_DURATION, 0), 0.6f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 18000, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 13500, 0, true, false), 1.0F)
					.build(),
			OLD_FASHION = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, EXTENDED_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, SHORT_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.LUCK, MEDIUM_DURATION, 0), 0.5f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 19200, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 14400, 0, true, false), 1.0F)
					.build(),
			RUM = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, MEDIUM_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, SHORT_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, VERY_SHORT_DURATION, 0), 0.5f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 21600, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 16200, 0, true, false), 1.0F)
					.build(),
			SAKE = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, MEDIUM_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.SATURATION, 1, 0), 1.0f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 8400, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 6300, 0, true, false), 1.0F)
					.build(),
			TEQUILA = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, MEDIUM_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.JUMP, SHORT_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 0.2f) // Cacti don't, in fact, dissolve in water completely. xd
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 19200, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 14400, 0, true, false), 1.0F)
					.build(),
			WHISKY = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MEDIUM_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, SHORT_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, SHORT_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 19200, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 14400, 0, true, false), 1.0F)
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
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, MEDIUM_DURATION, 0), 0.7f)
			.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 20400, 0), 1.0F)
			.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 15300, 0, true, false), 1.0F)
			.build(),
			CORN_WHISKY = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, MEDIUM_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.HUNGER, SHORT_DURATION, 0), 0.8f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 21600, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 16200, 0, true, false), 1.0F)
					.build(),
			MOONSHINE = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, MODERATE_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, SHORT_DURATION, 0), 0.9f) // It's called "moonshine" for a reason
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 26400, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 19800, 0, true, false), 1.0F)
					.build(),
	
	// Grapes
	CAHORS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, MEDIUM_DURATION, 1), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 0.8f) // God heals you, I guess
			.effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, BRIEF_DURATION, 0), 0.2f)
			.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 8640, 0), 1.0F)
			.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 6480, 0, true, false), 1.0F)
			.build(),
			CHAMPAGNE = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.JUMP, SHORT_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.LUCK, MEDIUM_DURATION, 0), 0.3f)
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, SHORT_DURATION, 0), 0.5f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 5760, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 4320, 0, true, false), 1.0F)
					.build(),
			COGNAC = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MEDIUM_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, SHORT_DURATION, 0), 0.8f)
					.effect(() -> new MobEffectInstance(MobEffects.SATURATION, 1, 0), 0.6f)
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, BRIEF_DURATION, 0), 0.3f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 19200, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 14400, 0, true, false), 1.0F)
					.build(),
	
	// Vintage
	SBITEN = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, EXTENDED_DURATION, 1), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, MEDIUM_DURATION, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, SHORT_DURATION, 0), 0.7f)
			.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 4800, 0), 1.0F)
			.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 3600, 0, true, false), 1.0F)
			.nutrition(4).saturationMod(0.5F)
			.build(),
			SYTA = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MODERATE_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 0), 0.6f)
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, SHORT_DURATION, 0), 0.4f)
					.nutrition(2).saturationMod(0.3F)
					.build(),
			VZVAR = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 6400, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 6400, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, MEDIUM_DURATION, 0), 0.5f)
					.effect(() -> new MobEffectInstance(MobEffects.SATURATION, 1, 0), 1.0f)
					.nutrition(5).saturationMod(0.7F)
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
			.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 9600, 1), 1.0F)
			.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 7200, 0, true, false), 1.0F)
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
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 9600, 1), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 7200, 0, true, false), 1.0F)
					.nutrition(4).saturationMod(0.4F)
					.build(),
			FLYING_DUTCHMAN = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, LONG_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, LONG_DURATION, 0), 1.0f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 19200, 0), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 14400, 0, true, false), 1.0F)
					.build(),
			GUT_WRECKER = new FoodProperties.Builder()
					.alwaysEat()
					.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, LONG_DURATION, 1), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, MODERATE_DURATION, 2), 1.0f)
					.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, MODERATE_DURATION, 0), 0.5f)
					.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 38400, 4), 1.0F)
					.effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 28800, 0, true, false), 1.0F)
					.nutrition(6).saturationMod(2.0F)
					.build();
}
