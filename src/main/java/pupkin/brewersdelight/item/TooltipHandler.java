package pupkin.brewersdelight.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import pupkin.brewersdelight.BrewersDelight;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.utility.BnCTextUtils;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TooltipHandler
{
	// Legacy code
	// This was used to display tipsy with potency of 4 and higher in tooltips, as the original mod before v3.0.0 didn't
	// In BnC v3.0.0 update Tipsy effect was changed to work just as any other effect given by the drink,
	// so tooltip is now handled by Minecraft
	
	//@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event)
	{
		ItemStack stack = event.getItemStack();
		Item item = stack.getItem();
		
		if (item instanceof BoozeItem) {
			try {
				// Use reflection to get 'potency' value
				Field potencyField = BoozeItem.class.getDeclaredField("potency");
				
				potencyField.setAccessible(true);
				
				int potency = (int) potencyField.get(item);
				
				if (potency > 3) {
					MutableComponent textTipsy = BnCTextUtils.getTranslation("tooltip.tipsy" + potency);
					event.getToolTip().add(1, textTipsy.withStyle(ChatFormatting.RED));
				}
			} catch (Exception e) {
				BrewersDelight.LOGGER.error("Failed while trying to modify tooltip for {}", item, e);
			}
		}
	}
}
