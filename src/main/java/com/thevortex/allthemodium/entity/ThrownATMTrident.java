package com.thevortex.allthemodium.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ThrownATMTrident extends ThrownTrident{

    public ThrownATMTrident(EntityType<? extends ThrownTrident> entityType, Level level) {
        super(entityType, level);
        //TODO Auto-generated constructor stub
    }

    public ThrownATMTrident(Level level, Player player, ItemStack trident) {
        super(level,player,trident);
    }

}
