package com.thevortex.allthemodium.items.toolitems.tools;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class Unobow extends CrossbowItem{

    public Unobow(Properties p_40850_) {
        super(p_40850_.rarity(Rarity.EPIC));
        //TODO Auto-generated constructor stub
    }

    @Override
    public int getDefaultProjectileRange() {
        return 30;
    }
}
