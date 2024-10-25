package pupkin.brewersdelight.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import pupkin.brewersdelight.BrewersDelight;

public class BrewersItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	
	public static void register(IEventBus eventBus)
	{
		ITEMS.register(eventBus);
	}
}
