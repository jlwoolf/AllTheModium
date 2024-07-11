package com.thevortex.allthemodium.blocks;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.SpecialPlantable;

public class AncientDirt extends Block implements SpecialPlantable {
    public AncientDirt(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public boolean canPlacePlantAtPosition(ItemStack arg0, LevelReader arg1, BlockPos arg2, @Nullable Direction arg3) { return true; }
    

    @Override
    public void spawnPlantAtPosition(ItemStack arg0, LevelReader arg1, BlockPos arg2, @Nullable Direction arg3) {
       
    }


 
}
