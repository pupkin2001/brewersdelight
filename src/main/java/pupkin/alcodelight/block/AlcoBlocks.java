package pupkin.alcodelight.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import pupkin.alcodelight.AlcoDelight;
import pupkin.alcodelight.block.mugs.beer.WineMug;
import pupkin.alcodelight.item.AlcoItems;

import java.util.function.Supplier;

public class AlcoBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AlcoDelight.MOD_ID);
	
	public static final RegistryObject<Block> MUG_OF_WINE = registerBlockWithoutItem("mug_of_wine",
			() -> new WineMug(BlockBehaviour.Properties
					.copy(Blocks.BARREL)
					.noOcclusion()));
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn, tab);
		
		return toReturn;
	}
	
	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,
			RegistryObject<T> block,
			CreativeModeTab tab) {
		return AlcoItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
	
	private static <T extends Block> RegistryObject<Block> registerBlockWithoutItem(String name, Supplier<T> block) {
		return BLOCKS.register(name, block);
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}