package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.FakePlayer;

public class AncientStone extends DropExperienceBlock {
    // public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    public AncientStone() {	//func_235861_h_ = setRequiresTool
        super(Properties.of().requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS).lightLevel((state) -> {
            return 0;
        }).strength(-1.0f, 1500.0f));
    }

    @Override
    @SuppressWarnings("java:S1874") // deprecated method from super class
    public float getDestroyProgress(BlockState state, Player player, BlockGetter getter, BlockPos blockPos) {
        BlockEntity blockEntity = getter.getBlockEntity(blockPos);
        if (canEntityDestroy(state, getter, blockPos, player)) {
            int i = net.minecraftforge.common.ForgeHooks.isCorrectToolForDrops(state, player) ? 250 : 1500;
            return player.getDigSpeed(state, blockPos) / 2.0F / i;
        }
        return 0.0F;
    }

    @Override
    public boolean canEntityDestroy(BlockState state, BlockGetter world, BlockPos pos, Entity player) {
        if ((player instanceof FakePlayer)) {
            return false;
        }

        return super.canEntityDestroy(state, world, pos, player) && (distanceTo(pos, player.blockPosition()) < 16.0F);
    }

    private double distanceTo(BlockPos block, BlockPos player) {
        return Math.sqrt(Math.pow(block.getX() - player.getX(), 2) + Math.pow(block.getY() - player.getY(), 2)
                + Math.pow(block.getZ() - player.getZ(), 2));
    }

}
