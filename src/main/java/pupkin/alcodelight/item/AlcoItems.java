package pupkin.alcodelight.item;

import me.itzme1on.alcocraftplus.items.MugItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import pupkin.alcodelight.AlcoDelight;
import pupkin.alcodelight.block.AlcoBlocks;
import pupkin.alcodelight.misc.AlcoBeerProperties;

public class AlcoItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AlcoDelight.MOD_ID);
	
	public static final RegistryObject<Item> MUG_OF_WINE = ITEMS.register("mug_of_wine",
			() -> new MugItem(AlcoBlocks.MUG_OF_WINE.get(), new Item.Properties()
					.stacksTo(16)
					.food(AlcoBeerProperties.WINE)));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
