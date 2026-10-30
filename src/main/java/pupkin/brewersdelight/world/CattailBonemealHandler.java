package pupkin.brewersdelight.world;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.BonemealEvent;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.block.CattailBlock;

@EventBusSubscriber(modid = BrewersDelight.MOD_ID)
public class CattailBonemealHandler
{
	
	private static final int GROUND_BONEMEAL_CHANCE = 8; // 1-in-8 per use
	
	@SubscribeEvent
	public static void onBonemeal(BonemealEvent event)
	{
		Level level = event.getLevel();
		if (level.isClientSide()) return;
		
		BlockState ground = event.getState();
		boolean validGround = ground.is(BlockTags.DIRT) || ground.is(Blocks.SAND)
				|| ground.is(Blocks.CLAY) || ground.is(Blocks.GRAVEL) || ground.is(Blocks.MUD);
		if (!validGround) return;
		
		BlockPos pos = event.getPos();
		if (level.getBlockState(pos.above()).getBlock() != Blocks.WATER) return;
		if (level.getBlockState(pos.above(2)).getBlock() != Blocks.AIR) return;
		
		Holder<Biome> biome = level.getBiome(pos);
		if (!biome.is(Biomes.SWAMP) && !biome.is(Biomes.MANGROVE_SWAMP)) return;
		
		RandomSource random = level.getRandom();
		if (random.nextInt(GROUND_BONEMEAL_CHANCE) != 0) return;
		
		CattailBlock.trySpreadNearby((ServerLevel) level, random, pos.above());
		// Cancelling skips vanilla handling, so consume the bone meal here like Forge's Result.ALLOW did
		event.getStack().shrink(1);
		event.setSuccessful(true);
	}
}