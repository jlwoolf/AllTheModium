package com.thevortex.allthemodium.blocks;

import javax.annotation.Nonnull;

import com.thevortex.allthemodium.AllTheModium;

import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.reference.TweakProxy;
import com.thevortex.allthemodium.registry.LevelRegistry;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TeleportPad extends Block {
    protected static final VoxelShape TELEPORTPAD_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D);

    public TeleportPad(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos,
            @Nonnull CollisionContext context) {
        return TELEPORTPAD_AABB;
    }

    @Override
    public VoxelShape getCollisionShape(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos,
            @Nonnull CollisionContext context) {

        return TELEPORTPAD_AABB;
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos,
            @Nonnull Player player,
            @Nonnull InteractionHand handIn, @Nonnull BlockHitResult hit) {
        if ((player instanceof ServerPlayer) && (player.isCrouching() == true)) {

            transferPlayer((ServerPlayer) player, pos);
            worldIn.addAlwaysVisibleParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY() + 1, pos.getZ(), 0,
                    1, 0);
        }
        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
        if (player.level().dimension().registry().getNamespace().contains(Reference.MOD_ID)) {
            return false;
        } else {
            return true;
        }
    }

    public void transferPlayer(ServerPlayer player, BlockPos pos) {
        int config = TweakProxy.packMode();
        if (player.level().dimension().equals(LevelRegistry.Mining)) {
            ServerLevel targetWorld = player.server.getLevel(AllTheModium.OverWorld);

            if (targetWorld == null)
                return;

            int y = 256;
            boolean located = false;
            while (y >= 1) {
                BlockPos posA = new BlockPos(Math.round(pos.getX()), y, Math.round(pos.getZ()));
                Block potential = targetWorld.getBlockState(posA).getBlock();
                if (potential.getName().toString().contains("teleport_pad")) {
                    located = true;
                    break;

                } else {
                    y--;
                }
            }
            if (located) {
                targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
                player.teleportTo(targetWorld, pos.getX() + 0.5D, y + 0.25D, pos.getZ() + 0.5D, player.rotA,
                        player.yya);

                return;
            } else {

                if ((!targetWorld.getBlockState(pos).hasBlockEntity())
                        && (targetWorld.getBlockState(pos).canEntityDestroy(targetWorld, pos, player))) {
                    //targetWorld.setBlockState(pos, ModBlocks.TELEPORT_PAD.getDefaultState());
                }

                targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
                player.teleportTo(targetWorld, pos.getX() + 0.5D, pos.getY() + 0.25D, pos.getZ() + 0.5D, player.rotA,
                        player.yya);
            }

        } else if (player.level().dimension().equals(AllTheModium.Nether)) {
            ServerLevel targetWorld = player.server.getLevel(LevelRegistry.THE_OTHER);

            if (targetWorld == null)
                return;

            BlockPos targetPos = new BlockPos(Math.round(pos.getX()), Math.round(pos.getY()), Math.round(pos.getZ()));

            if (!targetWorld.getBlockState(targetPos).hasBlockEntity()) {

                LevelHeightAccessor accessor = targetWorld.getChunk(pos).getHeightAccessorForGeneration();
                int y = targetWorld.getChunkSource().getGenerator().getSpawnHeight(accessor);
                targetWorld.setBlockAndUpdate(new BlockPos(targetPos.getX(), y, targetPos.getZ()),
                        ModRegistry.TELEPORT_PAD.get().defaultBlockState());

                targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
                player.teleportTo(targetWorld, targetPos.getX() + 0.5D, y + 0.25D, targetPos.getZ() + 0.5D, 0, 0);

            }
        } else if (player.level().dimension().equals(LevelRegistry.THE_OTHER)) {
            ServerLevel targetWorld = player.server.getLevel(AllTheModium.Nether);

            if (targetWorld == null)
                return;

            int y = 128;
            boolean located = false;
            while (y >= 1) {
                BlockPos posA = new BlockPos(Math.round(pos.getX()), y, Math.round(pos.getZ()));
                Block potential = targetWorld.getBlockState(posA).getBlock();
                if (potential.getName().toString().contains("teleport_pad")) {
                    located = true;
                    break;

                } else {
                    y--;
                }
            }
            if (located) {
                targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
                player.teleportTo(targetWorld, pos.getX() + 0.5D, y + 0.25D, pos.getZ() + 0.5D, player.rotA,
                        player.yya);

                return;
            } else {
                BlockPos newPos = new BlockPos(pos.getX(), 90, pos.getZ());
                if ((!targetWorld.getBlockState(newPos).hasBlockEntity())
                        && (targetWorld.getBlockState(newPos).canEntityDestroy(targetWorld, newPos, player))) {
                    targetWorld.setBlockAndUpdate(newPos, ModRegistry.TELEPORT_PAD.get().defaultBlockState());
                }

                targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, newPos.getX(), newPos.getY(), newPos.getZ(), 0,
                        1, 0);
                player.teleportTo(targetWorld, newPos.getX() + 0.5D, newPos.getY() + 0.25D, newPos.getZ() + 0.5D,
                        player.rotA,
                        player.yya);

            }
        } else if (player.level().dimension().equals(AllTheModium.The_End)) {
            ServerLevel targetWorld = player.server.getLevel(LevelRegistry.THE_BEYOND);

            if (targetWorld == null)
                return;

            BlockPos targetPos = new BlockPos(Math.round(pos.getX() * 50), Math.round(pos.getY()),
                    Math.round(pos.getZ() * 50));

            if (!targetWorld.getBlockState(targetPos).hasBlockEntity()) {

                LevelHeightAccessor accessor = targetWorld.getChunk(pos).getHeightAccessorForGeneration();
                int y = targetWorld.getChunkSource().getGenerator().getSpawnHeight(accessor);
                targetWorld.setBlockAndUpdate(new BlockPos(targetPos.getX(), y, targetPos.getZ()),
                        ModRegistry.TELEPORT_PAD.get().defaultBlockState());
                if (targetWorld.getBlockState(new BlockPos(targetPos.getX(), y - 1, targetPos.getZ())).is(Blocks.AIR)) {
                    targetWorld.setBlockAndUpdate(new BlockPos(targetPos.getX(), y - 1, targetPos.getZ()),
                            ModRegistry.ANCIENT_POLISHED_STONE.get().defaultBlockState());
                }
                targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
                player.teleportTo(targetWorld, targetPos.getX() + 0.5D, y + 0.25D, targetPos.getZ() + 0.5D, 0, 0);

            }
        } else if (player.level().dimension().equals(LevelRegistry.THE_BEYOND)) {
            ServerLevel targetWorld = player.server.getLevel(AllTheModium.The_End);

            if (targetWorld == null)
                return;

            int y = 384;
            boolean located = false;
            while (y >= -63) {
                BlockPos posA = new BlockPos(Math.round(pos.getX() / 50), y, Math.round(pos.getZ()) / 50);
                Block potential = targetWorld.getBlockState(posA).getBlock();
                if (potential.getName().toString().contains("teleport_pad")) {
                    located = true;
                    break;

                } else {
                    y--;
                }
            }
            if (located) {
                targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
                player.teleportTo(targetWorld, pos.getX() / 50 + 0.5D, y + 0.25D, pos.getZ() / 50 + 0.5D, player.rotA,
                        player.yya);

                return;
            } else {
                BlockPos newPos = new BlockPos(pos.getX() / 50, 90, pos.getZ() / 50);
                if ((!targetWorld.getBlockState(newPos).hasBlockEntity())
                        && (targetWorld.getBlockState(newPos).canEntityDestroy(targetWorld, newPos, player))) {
                    targetWorld.setBlockAndUpdate(newPos, ModRegistry.TELEPORT_PAD.get().defaultBlockState());
                }

                targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, newPos.getX(), newPos.getY(), newPos.getZ(), 0,
                        1, 0);
                player.teleportTo(targetWorld, newPos.getX() + 0.5D, newPos.getY() + 0.25D, newPos.getZ() + 0.5D,
                        player.rotA,
                        player.yya);

            }
        } else if (player.level().dimension().equals(AllTheModium.OverWorld) && (config != 5)) {
            ServerLevel targetWorld = player.server.getLevel(LevelRegistry.Mining);

            if (targetWorld == null)
                return;

            BlockPos targetPos = new BlockPos(Math.round(pos.getX()), 253, Math.round(pos.getZ()));
            if (!targetWorld.getBlockState(targetPos).hasBlockEntity()) {
                targetWorld.setBlockAndUpdate(targetPos, ModRegistry.TELEPORT_PAD.get().defaultBlockState());
                targetWorld.addParticle(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 1, 0);
                player.teleportTo(targetWorld, targetPos.getX() + 0.5D, targetPos.getY() + 0.25D,
                        targetPos.getZ() + 0.5D, 0, 0);

            }
        }

    }

}
