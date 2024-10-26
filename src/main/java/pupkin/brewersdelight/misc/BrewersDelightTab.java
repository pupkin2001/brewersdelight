package pupkin.brewersdelight.misc;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.item.BrewersItems;

public class BrewersDelightTab
{
	public static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab("BrewersDelightTab")
	{
		@Override
		public @NotNull ItemStack makeIcon()
		{
			return new ItemStack(BrewersItems.WHISKY.get());
		}
	};
}
