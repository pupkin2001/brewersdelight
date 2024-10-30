package pupkin.brewersdelight.misc;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class BeverageProperties
{
	// Farmers Delight
	public static final FoodProperties BRAGA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1600, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1600, 0), 1.0f)
			.build();

	public static final FoodProperties BRANDY = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1600, 0), 1.0f)
			.build();

	public static final FoodProperties CIDER = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1.0f)
			.build();

	public static final FoodProperties GIN = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1600, 0), 1.0f)
			.build();

	public static final FoodProperties KVASS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1600, 0), 1.0f)
			.build();

	public static final FoodProperties LIQUEUR = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1600, 0), 1.0f)
			.build();

	public static final FoodProperties MARTINI = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 1600, 0), 1.0f)
			.build();

	public static final FoodProperties MELON_SCHNAPPS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 1600, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1600, 1), 1.0f)
			.build();

	public static final FoodProperties SAKE = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1600, 0), 1.0f)
			.build();

	public static final FoodProperties SBITEN = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1600, 0), 1.0f)
			.build();

	public static final FoodProperties TEQUILA = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1600, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1600, 0), 1.0f)
			.build();

	public static final FoodProperties WHISKY = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1600, 1), 1.0f)
			.build();

	// Corn
	public static final FoodProperties BOURBON = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1600, 0), 1.0f)
			.build();
	public static final FoodProperties CORN_WHISKY = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1600, 0), 1.0f)
			.build();
	public static final FoodProperties MOONSHINE = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 1600, 0), 1.0f)
			.build();

	// Grapes (Italian Delight)
	public static final FoodProperties CAHORS = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1600, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1600, 0), 1.0f)
			.build();

	public static final FoodProperties CHAMPAGNE = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 1600, 0), 1.0f)
			.build();

	public static final FoodProperties COGNAC = new FoodProperties.Builder()
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1600, 0), 1.0f)
			.build();
}
