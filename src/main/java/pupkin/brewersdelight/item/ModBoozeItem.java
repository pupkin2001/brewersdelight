package pupkin.brewersdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.MyMod;
import umpaz.brewinandchewin.common.item.BoozeItem;

import java.util.List;

public class ModBoozeItem extends BoozeItem
{
	
	public ModBoozeItem(int potency, int duration, Properties properties)
	{
		super(potency, duration, properties);
	}
	
	public void setFoodProperties(@NotNull List<MobEffectInstance> effects) {
		FoodProperties.Builder foodBuilder = new FoodProperties.Builder();
		for (MobEffectInstance effect : effects) {
			foodBuilder.effect(() -> effect, 1.0F);
		}
		this.foodProperties = foodBuilder.build();
	}
	
	private FoodProperties foodProperties;
	
	@Override
	public FoodProperties getFoodProperties() {
		return this.foodProperties;
	}
}
