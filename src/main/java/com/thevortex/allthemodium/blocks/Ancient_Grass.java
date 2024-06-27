package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;

public class Ancient_Grass extends GrassBlock {
    public Ancient_Grass(Properties p_49795_) {
        super(p_49795_);
    }
    

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(!level.getBlockState(pos.above()).isAir()) {
            level.setBlock(pos, ModRegistry.ANCIENT_DIRT.get().defaultBlockState(),1 );
        }
    }
}
