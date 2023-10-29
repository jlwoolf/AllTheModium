package com.thevortex.allthemodium.items;

import com.thevortex.allthemodium.config.AllthemodiumServerConfigs;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.server.command.TextComponentHelper;

import java.util.List;

public class Vibranium_Ore_Item extends BlockItem {

	public Vibranium_Ore_Item(Block block, Properties properties) {
		super(block, properties);
	}
	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
		tooltip.add(TextComponentHelper.createComponentTranslation(null,"vibranium.loc" , new Object()).withStyle(ChatFormatting.GOLD));
		if(!AllthemodiumServerConfigs.VIBRANIUM_QUARRYABLE.get())
			tooltip.add(TextComponentHelper.createComponentTranslation(null,"allthemodium.mine" , new Object()).withStyle(ChatFormatting.GOLD));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
	}
