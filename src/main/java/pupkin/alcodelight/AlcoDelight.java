package pupkin.alcodelight;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import pupkin.alcodelight.block.AlcoBlocks;
import pupkin.alcodelight.item.AlcoItems;

@Mod(AlcoDelight.MOD_ID)
@Mod.EventBusSubscriber(modid = AlcoDelight.MOD_ID)
public class AlcoDelight
{
	public static final String MOD_ID = "alcodelight";

	public AlcoDelight()
	{
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		AlcoItems.register(eventBus);
		AlcoBlocks.register(eventBus);

		MinecraftForge.EVENT_BUS.register(this);
	}
}
