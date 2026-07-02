package pupkin.brewersdelight;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import pupkin.brewersdelight.block.BrewersBlocks;
import pupkin.brewersdelight.item.BrewersItems;
import pupkin.brewersdelight.misc.BrewersDelightTab;
import pupkin.brewersdelight.misc.BrewersFluids;

@Mod(BrewersDelight.MOD_ID)
@Mod.EventBusSubscriber(modid = BrewersDelight.MOD_ID)
public class BrewersDelight
{
	public static final String MOD_ID = "brewersdelight";
	
	public static final Logger LOGGER = LogUtils.getLogger();
	
	public BrewersDelight(FMLJavaModLoadingContext context)
	{
		IEventBus eventBus = context.getModEventBus();
		
		BrewersBlocks.register(eventBus);
		BrewersFluids.register(eventBus);
		BrewersItems.register(eventBus);
		BrewersDelightTab.CREATIVE_TABS.register(eventBus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
}
