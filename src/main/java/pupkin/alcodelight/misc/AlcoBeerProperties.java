package pupkin.alcodelight.misc;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class AlcoBeerProperties
{
	public static final FoodProperties WINE = new FoodProperties.Builder()
			.nutrition(5)
			.saturationMod(0.6f)
			.alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 0), 1.0f)
			.effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400, 0), 1.0f)
			.build();
}
