package com.thevortex.allthemodium.items.toolitems.armor;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;

import com.thevortex.allthemodium.registry.TagRegistry;


public class Allthemodium_Leggings extends ArmorItem {
	
	public Allthemodium_Leggings(DeferredHolder<ArmorMaterial, ArmorMaterial> atm, EquipmentSlot slot, Properties builder) {
		super(atm, Type.LEGGINGS, builder);
	 
	   }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if((entity instanceof LivingEntity) && (((LivingEntity)entity).hasEffect(MobEffects.WITHER)) && stack.is(TagRegistry.ATM_LEGGINGS)){
            ((LivingEntity)entity).removeEffect(MobEffects.WITHER);
        }
        if((entity instanceof LivingEntity) && (entity.isInWater()) && stack.is(TagRegistry.ATM_LEGGINGS)){
            ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100, 0));
        }
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
