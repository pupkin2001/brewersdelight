package pupkin.brewersdelight;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import pupkin.brewersdelight.block.BrewersBlocks;
import pupkin.brewersdelight.item.BrewersItems;
import pupkin.brewersdelight.misc.BrewersDelightTab;
import pupkin.brewersdelight.misc.BrewersFluids;

@Mod(BrewersDelight.MOD_ID)
public class BrewersDelight
{
	public static final String MOD_ID = "brewersdelight";
	
	public static final Logger LOGGER = LogUtils.getLogger();
	
	public BrewersDelight(IEventBus eventBus)
	{
		BrewersBlocks.register(eventBus);
		BrewersFluids.register(eventBus);
		BrewersItems.register(eventBus);
		BrewersDelightTab.CREATIVE_TABS.register(eventBus);
	}
}
