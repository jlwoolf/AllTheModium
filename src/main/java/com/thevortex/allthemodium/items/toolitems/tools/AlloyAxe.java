package com.thevortex.allthemodium.items.toolitems.tools;

import com.thevortex.allthemodium.material.ToolTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.server.command.TextComponentHelper;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AlloyAxe extends AxeItem {

    public AlloyAxe(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_AXE))
            return speed;
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean isEnchantable(@Nonnull ItemStack stack) {
        return true;
    }

    @Override
    public boolean canBeDepleted() {
        return false;
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn, @Nonnull List<Component> tooltip,
            @Nonnull TooltipFlag flagIn) {
        tooltip.add(TextComponentHelper.createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                .withStyle(ChatFormatting.GOLD));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_AXE))
            return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLOY_TIER, state);
        if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
            return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLOY_TIER, state);
        return false;
    }
}
