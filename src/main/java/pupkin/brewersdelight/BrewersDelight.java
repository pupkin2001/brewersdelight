package pupkin.brewersdelight;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import pupkin.brewersdelight.item.BrewersItems;

@Mod(BrewersDelight.MOD_ID)
@Mod.EventBusSubscriber(modid = BrewersDelight.MOD_ID)
public class BrewersDelight
{
	public static final String MOD_ID = "brewersdelight";
	public static final Logger LOGGER = LogUtils.getLogger();
	
	public BrewersDelight()
	{
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		BrewersItems.register(modEventBus);
		MyMod.register(modEventBus);
		//		BrewersDelightTab.CREATIVE_TABS.register(modEventBus);
		//
		//		MinecraftForge.EVENT_BUS.register(this);
	}
}