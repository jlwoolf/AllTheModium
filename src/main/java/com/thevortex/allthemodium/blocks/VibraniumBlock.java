package com.thevortex.allthemodium.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class VibraniumBlock extends Block {

    public VibraniumBlock() {
        super(Properties.of().sound(SoundType.STONE).strength(7.0f));
    }

}
