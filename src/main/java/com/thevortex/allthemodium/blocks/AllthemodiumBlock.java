package com.thevortex.allthemodium.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class AllthemodiumBlock extends Block {

    public AllthemodiumBlock() {
        super(Properties.of().sound(SoundType.STONE).strength(7.0f));
    }

}
