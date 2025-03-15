package pupkin.brewersdelight.misc;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.item.BrewersItems;

import java.util.Arrays;

public class BrewersDelightTab {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BrewersDelight.MOD_ID);

	@SuppressWarnings("unused")
	public static final RegistryObject<CreativeModeTab> TAB_BREWERSDELIGHT = CREATIVE_TABS.register("brewers_delight_tab", () ->
			CreativeModeTab.builder()
					.title(Component.translatable("itemgroup." + BrewersDelight.MOD_ID + ".BrewersDelightTab"))
					.icon(() -> new ItemStack(BrewersItems.WHISKY.get()))
					.displayItems((displayParams, output) -> {
						Arrays.asList(
								BrewersItems.BEVERAGES,
								BrewersItems.COMPAT_BEVERAGES,
								BrewersItems.CHALLENGE_BEVERAGES,
								BrewersItems.VINTAGE_BEVERAGES
						).forEach(registry ->
								registry.getEntries().forEach(item -> output.accept(item.get()))
						);
					})
					.build()
	);
}
