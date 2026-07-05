package pupkin.brewersdelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CattailBlock extends DoublePlantBlock implements SimpleWaterloggedBlock {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	public CattailBlock(Properties props) {
		super(props);
		this.registerDefaultState(this.stateDefinition.any()
		                                              .setValue(HALF, DoubleBlockHalf.LOWER)
		                                              .setValue(WATERLOGGED, false));
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(WATERLOGGED);
	}
	
	// No water here on purpose — this is what restricts gen to depth-1 edges.
	@Override
	protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
		return state.is(BlockTags.DIRT) || state.is(Blocks.SAND)
				|| state.is(Blocks.CLAY) || state.is(Blocks.GRAVEL) || state.is(Blocks.MUD);
	}
	
	@Override
	public @NotNull FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	@Override
	@Nullable
	public BlockState getStateForPlacement(@NotNull BlockPlaceContext ctx) {
		BlockState state = super.getStateForPlacement(ctx); // null if no room above
		if (state == null) return null;
		boolean water = ctx.getLevel().getFluidState(ctx.getClickedPos()).getType() == Fluids.WATER;
		return state.setValue(WATERLOGGED, water);
	}
	
	// DoublePlantBlock.setPlacedBy places the UPPER half but doesn't set waterlogged.
	// Re-derive it from the upper position's fluid (in air → false).
	@Override
	public void setPlacedBy(Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull LivingEntity placer, @NotNull ItemStack stack) {
		if (level.isClientSide) return;
		BlockPos above = pos.above();
		boolean water = level.getFluidState(above).getType() == Fluids.WATER;
		level.setBlock(above, this.defaultBlockState()
		                          .setValue(HALF, DoubleBlockHalf.UPPER)
		                          .setValue(WATERLOGGED, water), 3);
	}
	
	@Override
	public @NotNull BlockState updateShape(BlockState state, @NotNull Direction dir, @NotNull BlockState neighbor,
	                                       @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
		if (state.getValue(WATERLOGGED)) {
			level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}
		return super.updateShape(state, dir, neighbor, level, pos, neighborPos);
	}
}
