package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.reference.Reference;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Reference.MOD_ID);

    public static final DeferredHolder<Item,BucketItem> SOUL_LAVA_BUCKET = ITEMS.register("soul_lava_bucket", () -> new BucketItem(FluidRegistry.SOULLAVA.value(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item,BucketItem> MOLTEN_ATM_BUCKET = ITEMS.register("molten_allthemodium_bucket", () -> new BucketItem(FluidRegistry.ALLTHEMODIUM.value(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredHolder<Item,BucketItem> MOLTEN_VIB_BUCKET = ITEMS.register("molten_vibranium_bucket", () -> new BucketItem(FluidRegistry.VIBRANIUM.value(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredHolder<Item,BucketItem> MOLTEN_UNOB_BUCKET = ITEMS.register("molten_unobtainium_bucket", () -> new BucketItem(FluidRegistry.UNOBTAINIUM.value(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

   // public static final DeferredHolder<Item,BlockItem> SUS_CLAY_ITEM = ITEMS.register("suspicious_clay", () -> new BlockItem(BlockRegistry.SUS_CLAY.get(),new Item.Properties()));
   }
