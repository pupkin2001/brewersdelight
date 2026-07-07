package pupkin.brewersdelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CattailBlock extends DoublePlantBlock implements SimpleWaterloggedBlock, BonemealableBlock
{
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	private static final int SPREAD_ATTEMPTS = 32;
	
	public CattailBlock(Properties props)
	{
		super(props);
		this.registerDefaultState(this.stateDefinition.any()
		                                              .setValue(HALF, DoubleBlockHalf.LOWER)
		                                              .setValue(WATERLOGGED, false));
	}
	
	// Shared with CattailBonemealHandler below — scatters new lower-half cattails onto nearby
	// valid shallow-water banks, reusing the exact same canSurvive check as everywhere else.
	public static void trySpreadNearby(ServerLevel level, RandomSource random, BlockPos origin)
	{
		BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
		for (int i = 0; i < SPREAD_ATTEMPTS; i++) {
			mutable.set(origin).move(random.nextInt(5) - 2, random.nextInt(3) - 1, random.nextInt(5) - 2);
			
			if (level.getBlockState(mutable).getBlock() == Blocks.WATER
					&& level.getBlockState(mutable.above()).getBlock() == Blocks.AIR) {
				BlockState newState = BrewersBlocks.CATTAIL.get().defaultBlockState()
				                                           .setValue(HALF, DoubleBlockHalf.LOWER)
				                                           .setValue(WATERLOGGED, true);
				if (newState.canSurvive(level, mutable)) {
					DoublePlantBlock.placeAt(level, newState, mutable, 2);
				}
			}
		}
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder)
	{
		super.createBlockStateDefinition(builder);
		builder.add(WATERLOGGED);
	}
	
	// No water here on purpose — this is what restricts gen to depth-1 edges.
	@Override
	protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos)
	{
		return state.is(BlockTags.DIRT) || state.is(Blocks.SAND)
				|| state.is(Blocks.CLAY) || state.is(Blocks.GRAVEL) || state.is(Blocks.MUD);
	}
	
	@Override
	public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos)
	{
		if (!super.canSurvive(state, level, pos)) return false;
		if (state.getValue(HALF) != DoubleBlockHalf.LOWER) return true;
		
		FluidState here = level.getFluidState(pos);
		FluidState above = level.getFluidState(pos.above());
		return here.getType() == Fluids.WATER && above.getType() != Fluids.WATER;
	}
	
	@Override
	public @NotNull FluidState getFluidState(BlockState state)
	{
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	@Override
	@Nullable
	public BlockState getStateForPlacement(@NotNull BlockPlaceContext ctx)
	{
		BlockState state = super.getStateForPlacement(ctx); // null if no room above
		if (state == null) return null;
		boolean water = ctx.getLevel().getFluidState(ctx.getClickedPos()).getType() == Fluids.WATER;
		return state.setValue(WATERLOGGED, water);
	}
	
	// DoublePlantBlock.setPlacedBy places the UPPER half but doesn't set waterlogged.
	// Re-derive it from the upper position's fluid (in air → false).
	@Override
	public void setPlacedBy(Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull LivingEntity placer, @NotNull ItemStack stack)
	{
		if (level.isClientSide) return;
		BlockPos above = pos.above();
		boolean water = level.getFluidState(above).getType() == Fluids.WATER;
		level.setBlock(above, this.defaultBlockState()
		                          .setValue(HALF, DoubleBlockHalf.UPPER)
		                          .setValue(WATERLOGGED, water), 3);
	}
	
	@Override
	public @NotNull BlockState updateShape(BlockState state, @NotNull Direction dir, @NotNull BlockState neighbor,
	                                       @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos)
	{
		if (state.getValue(WATERLOGGED)) {
			level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}
		return super.updateShape(state, dir, neighbor, level, pos, neighborPos);
	}
	
	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean isClient)
	{
		return true;
	}
	
	@Override
	public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state)
	{
		return true;
	}
	
	@Override
	public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state)
	{
		BlockPos lowerPos = state.getValue(HALF) == DoubleBlockHalf.UPPER ? pos.below() : pos;
		trySpreadNearby(level, random, lowerPos);
	}
}