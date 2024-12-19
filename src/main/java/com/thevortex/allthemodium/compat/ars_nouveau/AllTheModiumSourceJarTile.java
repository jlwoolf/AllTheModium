package com.thevortex.allthemodium.compat.ars_nouveau;

import com.hollingsworth.arsnouveau.common.block.SourceJar;
import com.hollingsworth.arsnouveau.common.block.tile.SourceJarTile;
import com.hollingsworth.arsnouveau.common.capability.SourceStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class AllTheModiumSourceJarTile extends SourceJarTile {

    public AllTheModiumSourceJarTile(BlockPos pos, BlockState state) {
        super(ArsCompat.ALLTHEMODIUM_SOURCE_JAR_TILE.get(), pos, state);
    }

    @Override
    protected @NotNull SourceStorage createDefaultStorage() {
        return new SourceStorage(100000, 100000){
            public void onContentsChanged() {
                AllTheModiumSourceJarTile.this.updateBlock();
            }
        };
    }

    @Override
    public boolean updateBlock() {
        //super.updateBlock();
        BlockState state = level.getBlockState(worldPosition);
        int fillState = 0;
        if (this.getSource() > 0 && this.getSource() < 10000)
            fillState = 1;
        else if (this.getSource() != 0) {
            fillState = (this.getSource() / 10000) + 1;
        }
        if (state.hasProperty(SourceJar.fill)) {
            level.setBlock(worldPosition, state.setValue(SourceJar.fill, Math.min(fillState, 11)), 3);
        } else {
            System.out.println("BlockState does not have property SourceJar.fill");
        };
        return true;
    }

    @Override
    public void getTooltip(List<Component> tooltip) {
        tooltip.add(Component.translatable("ars_nouveau.source_jar.fullness", (getSource() * 100) / this.getMaxSource()));
    }
}
