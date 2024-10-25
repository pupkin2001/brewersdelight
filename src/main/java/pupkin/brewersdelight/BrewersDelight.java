package pupkin.brewersdelight;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import pupkin.brewersdelight.item.BrewersItems;

@Mod(BrewersDelight.MOD_ID)
@Mod.EventBusSubscriber(modid = BrewersDelight.MOD_ID)
public class BrewersDelight
{
	public static final String MOD_ID = "brewersdelight";
	
	public BrewersDelight( )
	{
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		BrewersItems.register(eventBus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
}
