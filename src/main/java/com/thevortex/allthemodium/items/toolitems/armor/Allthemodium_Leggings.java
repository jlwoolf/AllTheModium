package com.thevortex.allthemodium.items.toolitems.armor;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;


public class Allthemodium_Leggings extends ArmorItem {
	
	public Allthemodium_Leggings(DeferredHolder<ArmorMaterial, ArmorMaterial> atm, EquipmentSlot slot, Properties builder) {
		super(atm, Type.LEGGINGS, builder);
	 
	   }
   
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
   }
