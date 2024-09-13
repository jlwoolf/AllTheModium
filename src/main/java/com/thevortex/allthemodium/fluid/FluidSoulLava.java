package com.thevortex.allthemodium.fluid;

import com.thevortex.allthemodium.blocks.SoulLava;
import com.thevortex.allthemodium.registry.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidType;

import javax.annotation.Nullable;

public class FluidSoulLava extends FlowingFluid {
    @Override
    public Fluid getFlowing() {
        return FluidRegistry.FLOWING_SOULLAVA.get();
    }

    @Override
    public Fluid getSource() {
        return FluidRegistry.SOULLAVA.get();
    }

    @Override
    public Item getBucket() {
        return ItemRegistry.SOUL_LAVA_BUCKET.get();
    }

    @Override
    protected void animateTick(Level level, BlockPos blockPos, FluidState state, RandomSource randomSource) {
        super.animateTick(level, blockPos, state, randomSource);
        if (!state.isSource() && !state.getValue(FALLING)) {
            if (randomSource.nextInt(64) == 0) {
                level.playLocalSound((double) blockPos.getX() + 0.5D, (double) blockPos.getY() + 0.5D,
                        (double) blockPos.getZ() + 0.5D, SoundEvents.WATER_AMBIENT, SoundSource.BLOCKS,
                        randomSource.nextFloat() * 0.25F + 0.75F, randomSource.nextFloat() + 0.5F, false);
            }
        } else if (randomSource.nextInt(10) == 0) {
            level.addParticle(ParticleTypes.UNDERWATER, (double) blockPos.getX() + randomSource.nextDouble(),
                    (double) blockPos.getY() + randomSource.nextDouble(),
                    (double) blockPos.getZ() + randomSource.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Nullable
    @Override
    protected ParticleOptions getDripParticle() {
        return ParticleTypes.SOUL_FIRE_FLAME;
    }

    @Override
    protected boolean canConvertToSource(Level level) {
        return false;
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor worldIn, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? worldIn.getBlockEntity(pos) : null;
        Block.dropResources(state, worldIn, pos, blockEntity);
    }

    @Override
    protected int getSlopeFindDistance(LevelReader p_76074_) {
        return 4;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState p_76136_) {
        return BlockRegistry.SOULLAVA_BLOCK.get().defaultBlockState().setValue(SoulLava.LEVEL,
                Integer.valueOf(getLegacyLevel(p_76136_)));
    }

    @Override
    public boolean isSource(FluidState p_76140_) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_164509_) {
        return 4;
    }

    @Override
    public boolean isSame(Fluid fluidIn) {
        return fluidIn == FluidRegistry.SOULLAVA.get() || fluidIn == FluidRegistry.FLOWING_SOULLAVA.get();
    }

    @Override
    protected int getDropOff(LevelReader p_76087_) {
        return 1;
    }

    @Override
    public int getTickDelay(LevelReader p_76120_) {
        return 8;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState p_76127_, BlockGetter p_76128_, BlockPos p_76129_, Fluid p_76130_,
            Direction p_76131_) {
        return p_76131_ == Direction.DOWN && p_76127_.getFluidType() != FluidTypeRegistry.SOULLAVA.get();
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }

    @Override
    public FluidType getFluidType() {
        return FluidTypeRegistry.SOULLAVA.get();
    }

    public static class Flowing extends FluidSoulLava {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> p_76046_) {
            super.createFluidStateDefinition(p_76046_);
            p_76046_.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState p_164509_) {
            return p_164509_.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends FluidSoulLava {
        @Override
        public int getAmount(FluidState p_164509_) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }
}
