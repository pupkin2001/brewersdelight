package pupkin.brewersdelight.misc;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class BeverageProperties
{
	// Basic (Farmers Delight)
	public static final FoodProperties BRANDY = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 3600, 0), 1.0f)
			.build();
	
	public static final FoodProperties CIDER = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200, 1), 1.0f)
			.build();
	
	public static final FoodProperties GIN = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 4800, 2), 1.0f)
			.build();
	
	public static final FoodProperties KVASS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1.0f)
			.nutrition(3).saturationMod(0.1F)
			.build();
	
	public static final FoodProperties LIQUEUR = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties MELON_SCHNAPPS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 3600, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties SAKE = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 9600, 2), 1.0f)
			.build();
	
	public static final FoodProperties SBITEN = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 1), 1.0f)
			.nutrition(6).saturationMod(0.3F)
			.build();
	
	public static final FoodProperties TEQUILA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 7200, 1), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 7200, 1), 1.0f)
			.build();
	
	public static final FoodProperties WHISKY = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 8400, 1), 1.0f)
			.build();
	
	public static final FoodProperties ABSINTHE = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties AMARO = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties AMONTILLADO = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties APEROL = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties ARMAGNAC = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties BAIJIU = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties BECHEROVKA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties BITTER = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties CALVADOS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties CAMPARI = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties CHACHA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties COMPOTE = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties FERNET = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties GLUHWEIN = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties GROG = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties KASHASA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties MEZCAL = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties NEGRONI = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties OUZO = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties PASTIS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties PUNCH = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties RAKIA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties RUM = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties SAMBUCA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties SHERRY = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties SOCATA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties SOJU = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties SOTOL = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties SYTA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties TODDY = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties TRIPLESEC = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties TSIPURO = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties TSUIKE = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties VERMOUTH = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties VISHINATA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties VZVAR = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
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
			.effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 12000, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, 12000, 0), 1.0f)
			.nutrition(4).saturationMod(0.4F)
			.build();
	
	// Corn
	public static final FoodProperties BOURBON = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0), 1.0f)
			.build();
	public static final FoodProperties CORN_WHISKY = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 1200, 1), 1.0f)
			.build();
	public static final FoodProperties MOONSHINE = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 2), 1.0f)
			.build();
	
	// Grapes (Italian Delight)
	public static final FoodProperties CAHORS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 2400, 1), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2400, 2), 1.0f)
			.build();
	
	public static final FoodProperties CHAMPAGNE = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 3600, 1), 1.0f)
			.build();
	
	public static final FoodProperties COGNAC = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 4800, 2), 1.0f)
			.build();
	
	public static final FoodProperties MARTINI = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 2400, 0), 1.0f)
			.build();
}
