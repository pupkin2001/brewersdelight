package pupkin.brewersdelight;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import pupkin.brewersdelight.item.ModBoozeItem;

import java.util.List;

@Mod.EventBusSubscriber(modid = BrewersDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BeverageLoader
{
	private static boolean hasLoaded = false;
	
	@SubscribeEvent
	public static void onRegisterEvent(RegisterEvent event)
	{
		if (hasLoaded) { return; }
		hasLoaded = true;
		
		MyMod.considerFiles();
	}
	
	@SubscribeEvent
	public static void onCommonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			MyMod.cacheCurrentlyKnownEffects();
			
			for (RegistryObject<Item> itemRegistryObject : MyMod.ITEM_REGISTRY.getEntries()) {
				Item item = itemRegistryObject.get();
				if (!(item instanceof ModBoozeItem modBoozeItem)) {
					throw new IllegalArgumentException(
							"An item that is not an instance of ModBoozeItem was found in the registry intended only for instances of ModBoozeItem");
				}
				List<MobEffectInstance> effects = MyMod.processEffectsFromJsonArray(
						MyMod.getEffectsFromMapById(MyMod.itemEffectsMap, String.valueOf(item))
				                                                                   );
				modBoozeItem.setFoodProperties(effects);
			}
		});
	}
}
