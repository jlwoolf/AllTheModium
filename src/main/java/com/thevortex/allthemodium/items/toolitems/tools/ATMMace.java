package com.thevortex.allthemodium.items.toolitems.tools;


import java.util.List;

import com.thevortex.allthemodium.material.ATMTier;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;

public class ATMMace extends MaceItem {

    private Tier tier = ATMTier.ALLTHEMODIUM;
    public ATMMace(Tier tier, Properties p_333796_) {
        super(p_333796_);
        this.tier = tier;
    }
    public static ItemAttributeModifiers createAttributes(Tier tier) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, tier.getAttackDamageBonus(), Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, tier.getSpeed(), Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
     }
  

     public static Tool createToolProperties(Tier tier) {
        return new Tool(List.of(), tier.getSpeed(), 2);
     }
  
   
    @Override
    public int getEnchantmentValue() {
    return this.tier.getEnchantmentValue();
 }
}
