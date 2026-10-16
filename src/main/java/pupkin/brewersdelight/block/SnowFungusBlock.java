package pupkin.brewersdelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.NotNull;

public class SnowFungusBlock extends Block implements BonemealableBlock
{
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	
	public SnowFungusBlock(Properties props)
	{
		super(props);
		this.registerDefaultState(this.stateDefinition.any()
		                                              .setValue(FACING, Direction.UP));
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder)
	{
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context)
	{
		return this.defaultBlockState().setValue(FACING, context.getClickedFace());
	}
	
	@Override
	public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos)
	{
		Direction facing = state.getValue(FACING);
		return level.getBlockState(pos.relative(facing.getOpposite())).is(BlockTags.LOGS);
	}
	
	@Override
	public @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction,
	                                       @NotNull BlockState neighborState, @NotNull LevelAccessor level,
	                                       @NotNull BlockPos pos, @NotNull BlockPos neighborPos)
	{
		return state.canSurvive(level, pos)
				? state
				: Blocks.AIR.defaultBlockState();
	}
	
	@Override
	public @NotNull BlockState rotate(@NotNull BlockState state, @NotNull Rotation rotation)
	{
		return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}
	
	@Override
	public @NotNull BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirror)
	{
		return state.setValue(FACING, mirror.mirror(state.getValue(FACING)));
	}
	
	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader level,
	                                     @NotNull BlockPos pos,
	                                     @NotNull BlockState state,
	                                     boolean isClient)
	{
		return state.canSurvive(level, pos);
	}
	
	@Override
	public boolean isBonemealSuccess(@NotNull Level level,
	                                 @NotNull RandomSource random,
	                                 @NotNull BlockPos pos,
	                                 @NotNull BlockState state)
	{
		return true;
	}
	
	@Override
	public void performBonemeal(@NotNull ServerLevel level,
	                            @NotNull RandomSource random,
	                            @NotNull BlockPos pos,
	                            @NotNull BlockState state)
	{
		// TODO: actual growth/spread logic here.
	}
}