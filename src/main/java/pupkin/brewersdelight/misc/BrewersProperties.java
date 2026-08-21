package pupkin.brewersdelight.misc;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import umpaz.brewinandchewin.common.registry.BnCEffects;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class BrewersProperties
{
	public static final int
			BRIEF_DURATION = 600, VERY_SHORT_DURATION = 1200, SHORT_DURATION = 2400,
			MEDIUM_DURATION = 3600, MODERATE_DURATION = 6000, EXTENDED_DURATION = 9600,
			LONG_DURATION = 12000, PROLONGED_DURATION = 14400, VERY_LONG_DURATION = 24000;
	
	// Food
	public static final FoodProperties
			FROSTSTONE_CHEESE_WEDGE = (new FoodProperties.Builder())
			.nutrition(2)
			.saturationMod(1.0F)
			.build(),
	
	//  Bases / fillers
	BRAGA = light(new FoodProperties.Builder().alwaysEat().nutrition(4).saturationMod(0.2F)).build(),
			GROG = light(new FoodProperties.Builder().alwaysEat()).build(),
			PUNCH = light(new FoodProperties.Builder().alwaysEat()).build(),
			TODDY = light(new FoodProperties.Builder().alwaysEat()
			                                          .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 0), 1.0F)).build(),
			WINE = light(new FoodProperties.Builder().alwaysEat()).build(),
	//		RED_WINE = light(new FoodProperties.Builder().alwaysEat()).build(), // TODO
	//		WHITE_WINE = light(new FoodProperties.Builder().alwaysEat()).build(), // TODO
	
	//  Utility (no tipsy)
	KVASS = new FoodProperties.Builder().alwaysEat()
	                                    .effect(() -> nourish(MODERATE_DURATION), 1.0F).nutrition(3).saturationMod(0.3F).build(),
			COMPOTE = new FoodProperties.Builder().alwaysEat()
			                                      .effect(() -> nourish(MODERATE_DURATION), 1.0F).nutrition(4).saturationMod(0.3F).build(),
			GLUHWEIN = new FoodProperties.Builder().alwaysEat()
			                                       .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
			                                       .effect(() -> nourish(MEDIUM_DURATION), 1.0F)
			                                       .nutrition(3).saturationMod(0.4F).build(),
			MELON_SCHNAPPS = light(new FoodProperties.Builder().alwaysEat()
			                                                   .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 1, 0), 1.0F)
			                                                   .effect(() -> nourish(SHORT_DURATION), 1.0F).nutrition(3).saturationMod(0.3F)).build(),
	
	//  Cheap convenience (potion-clones)
	BRANDY = medium(new FoodProperties.Builder().alwaysEat()
	                                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, MEDIUM_DURATION, 1), 1.0F)
	                                            .effect(() -> new MobEffectInstance(MobEffects.JUMP, SHORT_DURATION, 0), 1.0F)).build(),
			CIDER = light(new FoodProperties.Builder().alwaysEat()
			                                          .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, VERY_SHORT_DURATION, 0), 1.0F)).build(),
			CORN_WHISKY = medium(new FoodProperties.Builder().alwaysEat()
			                                                 .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, MEDIUM_DURATION, 0), 1.0F)
			                                                 .effect(() -> new MobEffectInstance(MobEffects.HUNGER, SHORT_DURATION, 0), 0.8F)).build(),
			ELDERFLOWER = light(new FoodProperties.Builder().alwaysEat()
			                                                .effect(() -> new MobEffectInstance(MobEffects.JUMP, SHORT_DURATION, 1), 1.0F)
			                                                .effect(() -> new MobEffectInstance(MobEffects.LUCK, MEDIUM_DURATION, 0), 0.3F)
			                                                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, SHORT_DURATION, 0), 0.5F)).build(),
			GIN = medium(new FoodProperties.Builder().alwaysEat()
			                                         .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, MEDIUM_DURATION, 0), 1.0F)
			                                         .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, SHORT_DURATION, 0), 0.8F)).build(),
			VERMOUTH_GLOW = medium(new FoodProperties.Builder().alwaysEat()
			                                                   .effect(() -> new MobEffectInstance(MobEffects.GLOWING, MODERATE_DURATION, 0), 0.3F)
			                                                   .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, MODERATE_DURATION, 0), 0.7F)).build(),
			VERMOUTH_MUSHROOM = medium(new FoodProperties.Builder().alwaysEat()
			                                                       .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, MODERATE_DURATION, 0), 1.0F) // the leftover effect
			                                                       .effect(() -> new MobEffectInstance(MobEffects.POISON, VERY_SHORT_DURATION, 0), 0.3F)
			                                                       .effect(() -> nourish(MODERATE_DURATION), 1.0F)).build(),
	
	//  Tradeoff (strong buff + redirect)
	ABSINTHE = strong(new FoodProperties.Builder().alwaysEat()
	                                              .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, MEDIUM_DURATION, 1), 1.0F)
	                                              .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, SHORT_DURATION, 0), 1.0F)
	                                              .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, BRIEF_DURATION, 0), 0.3F)).build(), // brief wormwood gimmick
			MOONSHINE = spirit(new FoodProperties.Builder().alwaysEat() // tipsy IS the cost
			                                               .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, SHORT_DURATION, 0), 0.9F)
			                                               .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, MEDIUM_DURATION, 0), 1.0F)).build(),
			TEQUILA = strong(new FoodProperties.Builder().alwaysEat()
			                                             .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, MEDIUM_DURATION, 1), 1.0F)
			                                             .effect(() -> new MobEffectInstance(MobEffects.JUMP, SHORT_DURATION, 1), 1.0F)
			                                             .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, MEDIUM_DURATION, 0), 1.0F) // can't fight
			                                             .effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), // cacti don't, in fact, dissolve in water completely. xd
			                                                     0.2F)).build(),
	
	//  Clean buff (no-potion effect + Nourishment)
	BITTER = medium(new FoodProperties.Builder().alwaysEat()
	                                            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, SHORT_DURATION, 0), 1.0F)
	                                            .effect(() -> nourish(MODERATE_DURATION), 1.0F)).build(),
			BOURBON = strong(new FoodProperties.Builder().alwaysEat()
			                                             .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, SHORT_DURATION, 0), 1.0F)
			                                             .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, EXTENDED_DURATION, 0), 1.0F)
			                                             .effect(() -> nourish(MEDIUM_DURATION), 1.0F)).build(),
			CAHORS = strong(new FoodProperties.Builder().alwaysEat()
			                                            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, MEDIUM_DURATION, 0), 1.0F)
			                                            .effect(() -> new MobEffectInstance(MobEffects.LUCK, MEDIUM_DURATION, 0), 0.8F)
			                                            .effect(() -> nourish(MEDIUM_DURATION), 1.0F)).build(),
			COGNAC = strong(new FoodProperties.Builder().alwaysEat()
			                                            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
			                                            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 1, 0), 0.6F)
			                                            .effect(() -> nourish(MEDIUM_DURATION), 1.0F)).build(),
			LIQUEUR = strong(new FoodProperties.Builder().alwaysEat()
			                                             .effect(() -> new MobEffectInstance(BnCEffects.SWEET_HEART.get(), MODERATE_DURATION, 0), 1.0F)
			                                             .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, SHORT_DURATION, 0), 0.7F)
			                                             .effect(() -> nourish(MODERATE_DURATION), 1.0F)).build(),
			RUM = strong(new FoodProperties.Builder().alwaysEat()
			                                         .effect(() -> new MobEffectInstance(BnCEffects.RAGING.get(), MEDIUM_DURATION, 0), 1.0F)
			                                         .effect(() -> nourish(MEDIUM_DURATION), 1.0F)).build(),
			SAKE = strong(new FoodProperties.Builder().alwaysEat()
			                                          .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, MEDIUM_DURATION, 0), 1.0F)
			                                          .effect(() -> nourish(MEDIUM_DURATION), 1.0F)).build(),
			WHISKY = strong(new FoodProperties.Builder().alwaysEat()
			                                            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
			                                            .effect(() -> nourish(MEDIUM_DURATION), 1.0F)).build(),
	
	// Cocktails
	OLD_FASHIONED = strong(new FoodProperties.Builder().alwaysEat()
	                                                   .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
	                                                   .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, SHORT_DURATION, 0), 1.0F)
	                                                   .effect(() -> nourish(MEDIUM_DURATION), 1.0F)).build(),
	
	// Vintage
	SBITEN = strong(new FoodProperties.Builder().alwaysEat()
	                                            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, EXTENDED_DURATION, 1), 1.0F)
	                                            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
	                                            .effect(() -> nourish(EXTENDED_DURATION), 1.0F).nutrition(4).saturationMod(0.5F)).build(),
			SYTA = new FoodProperties.Builder().alwaysEat()
			                                   .effect(() -> nourish(SHORT_DURATION), 1.0F).nutrition(2).saturationMod(0.3F).build(),
			VZVAR = new FoodProperties.Builder().alwaysEat()
			                                    .effect(() -> nourish(MODERATE_DURATION), 1.0F)
			                                    .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 1, 0), 1.0F)
			                                    .nutrition(5).saturationMod(0.7F).build(),
	
	// Challenge
	FLAXEN_CHEESE_STOUT = spirit(new FoodProperties
			.Builder().alwaysEat()
	                  .effect(() -> new MobEffectInstance(MobEffects.UNLUCK, 8400, 0), 1.0F)
	                  .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 1800, 0), 0.8F)
	                  .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 2100, 1), 0.8F)
	                  .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4200, 0), 0.5F)
	                  .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 4200, 0), 0.5F)
	                  .effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 0.25F)
	                  .effect(() -> new MobEffectInstance(MobEffects.POISON, 2100, 0), 0.25F)
	                  .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 1200, 0), 0.1F)
	                  .nutrition(4).saturationMod(0.4F)).build(),
			SCARLET_CHEESE_STOUT = spirit(new FoodProperties
					.Builder().alwaysEat()
			                  .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 19200, 0), 1.0F)
			                  .effect(() -> new MobEffectInstance(MobEffects.UNLUCK, 8400, 0), 1.0F)
			                  .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 1800, 0), 0.8F)
			                  .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 1200, 0), 0.8F)
			                  .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4200, 0), 0.5F)
			                  .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 4200, 0), 0.5F)
			                  .effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 0.25F)
			                  .effect(() -> new MobEffectInstance(MobEffects.WITHER, 2100, 0), 0.25F)
			                  .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 2100, 1), 0.1F)
			                  .nutrition(4).saturationMod(0.4F)).build(),
			FROSTSTONE_CHEESE_STOUT = spirit(new FoodProperties
					.Builder().alwaysEat()
			                  .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 19200, 0), 1.0F)
			                  .effect(() -> new MobEffectInstance(MobEffects.UNLUCK, 8400, 0), 1.0F)
			                  .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 1800, 0), 0.8F)
			                  .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 6000, 1),
			                          0.8F)
			                  .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 6000, 1), 0.5F)
			                  .effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 0.25F)
			                  .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 2100, 1), 0.1F)
			                  .nutrition(4).saturationMod(0.4F)).build(),
			FLYING_DUTCHMAN = strong(new FoodProperties
					.Builder().alwaysEat()
			                  .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, LONG_DURATION, 0), 1.0F)
			                  .effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, LONG_DURATION, 0),
			                          1.0F)).build(),
			GUT_WRECKER = spirit(new FoodProperties
					.Builder().alwaysEat()
			                  .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, LONG_DURATION, 1), 1.0F)
			                  .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, MEDIUM_DURATION, 2), 1.0F)
			                  .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, MODERATE_DURATION, 0), 0.5F)
			                  .nutrition(6).saturationMod(2.0F)).build();
	
	//  Alcohol tiers
	// tipsy (duration, amp) + intox (duration, amp 0 —).
	private static FoodProperties.Builder light(FoodProperties.Builder b)
	{
		return b.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 1800, 0), 1.0F)
		        .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1500, 0, false, false), 1.0F);
	}
	
	private static FoodProperties.Builder medium(FoodProperties.Builder b)
	{
		return b.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 1), 1.0F)
		        .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0, false, false), 1.0F);
	}
	
	private static FoodProperties.Builder strong(FoodProperties.Builder b)
	{
		return b.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 2), 1.0F)
		        .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 3000, 0, false, false), 1.0F);
	}
	
	private static FoodProperties.Builder spirit(FoodProperties.Builder b)
	{
		return b.effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 4800, 3), 1.0F)
		        .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 4200, 0, false, false), 1.0F);
	}
	
	private static MobEffectInstance nourish(int d) { return new MobEffectInstance(ModEffects.NOURISHMENT.get(), d, 0); }
}
