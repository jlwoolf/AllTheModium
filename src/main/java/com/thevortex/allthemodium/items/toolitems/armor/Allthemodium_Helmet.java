package com.thevortex.allthemodium.items.toolitems.armor;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;


public class Allthemodium_Helmet extends ArmorItem {

	public Allthemodium_Helmet(DeferredHolder<ArmorMaterial, ArmorMaterial> atm, EquipmentSlot slot, Properties builder) {
		super(atm, Type.HELMET, builder);
		
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
