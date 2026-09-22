package pupkin.brewersdelight.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.item.BrewersItems;
import umpaz.brewinandchewin.common.block.CheeseWheelBlock;
import umpaz.brewinandchewin.common.block.UnripeCheeseWheelBlock;

public class BrewersBlocks
{
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, BrewersDelight.MOD_ID);
	
	public static final RegistryObject<Block>
			CATTAIL = BLOCKS.register("cattail",
			                          () -> new CattailBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)
			                                                                          .offsetType(BlockBehaviour.OffsetType.XYZ))),
	
	FROSTSTONE_CHEESE_WHEEL = BLOCKS.register("froststone_cheese_wheel", () -> new
			CheeseWheelBlock(BrewersItems.FROSTSTONE_CHEESE_WEDGE, Block.Properties.copy(Blocks.CAKE))),
	
	UNRIPE_FROSTSTONE_CHEESE_WHEEL = BLOCKS.register("unripe_froststone_cheese_wheel", () -> new
			UnripeCheeseWheelBlock(BrewersBlocks.FROSTSTONE_CHEESE_WHEEL, Block.Properties.copy(Blocks.CAKE)));
	
	public static void register(IEventBus eventBus)
	{
		BLOCKS.register(eventBus);
	}
}
