package com.thevortex.allthemodium.items.toolitems.tools;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;

public class ATMBow extends BowItem {

    public ATMBow(Properties p_40660_) {

        super(p_40660_.rarity(Rarity.EPIC));
        //TODO Auto-generated constructor stub
    }
    
    @Override
        public int getUseDuration(ItemStack p_40680_, LivingEntity p_345962_) {
        return 36000;
    }

    @Override
        public int getDefaultProjectileRange() {
        return 60;
    }
    @Override
        public int getEnchantmentValue() {
        return 85;
    }
}