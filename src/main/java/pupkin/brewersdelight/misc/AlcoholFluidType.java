package pupkin.brewersdelight.misc;

import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;

// Brewin' and Chewin' 4.x no longer ships a tinted fluid type, so this mirrors its 1.20.1 AlcoholFluidType.
// The tint itself is applied client-side in BrewersFluidRenderers.
public class AlcoholFluidType extends FluidType
{
	private final int tintColor;
	
	public AlcoholFluidType(int tintColor)
	{
		super(Properties.create()
		                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
		                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
		                .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
		this.tintColor = tintColor;
	}
	
	public int getTintColor()
	{
		return tintColor;
	}
}
