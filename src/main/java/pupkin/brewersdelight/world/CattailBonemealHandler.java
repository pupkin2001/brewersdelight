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
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.block.CattailBlock;

@Mod.EventBusSubscriber(modid = BrewersDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CattailBonemealHandler
{
	
	private static final int GROUND_BONEMEAL_CHANCE = 8; // 1-in-8 per use
	
	@SubscribeEvent
	public static void onBonemeal(BonemealEvent event)
	{
		Level level = event.getLevel();
		if (level.isClientSide()) return;
		
		BlockState ground = event.getBlock();
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
		event.setResult(Event.Result.ALLOW);
	}
}