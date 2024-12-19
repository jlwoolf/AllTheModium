package com.thevortex.allthemodium.compat.ars_nouveau;

import com.hollingsworth.arsnouveau.common.block.SourceJar;
import com.hollingsworth.arsnouveau.common.block.TickableModBlock;
import com.hollingsworth.arsnouveau.common.block.tile.SourceJarTile;
import com.hollingsworth.arsnouveau.common.items.data.BlockFillContents;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class AllTheModiumSourceJar extends SourceJar {

    public AllTheModiumSourceJar() {
        super(TickableModBlock.defaultProperties().noOcclusion(), "allthemodium_source_jar");
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AllTheModiumSourceJarTile(pos, state);
    }

    @Override
    protected void onPlace(BlockState p_60566_, Level p_60567_, BlockPos p_60568_, BlockState p_60569_, boolean p_60570_) {
        super.onPlace(p_60566_, p_60567_, p_60568_, p_60569_, p_60570_);
        if (!p_60567_.isClientSide()) {
            BlockEntity blockEntity = p_60567_.getBlockEntity(p_60568_);
            if (blockEntity instanceof SourceJarTile) {
                ((SourceJarTile)blockEntity).updateBlock();
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Item.TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        int mana = BlockFillContents.get(stack);
        tooltip.add(Component.translatable("ars_nouveau.source_jar.fullness",(mana * 100) / 100000));
    }
}
