package com.thevortex.allthemodium.material;

import com.thevortex.allthemodium.registry.TagRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;


public class ToolTiers {


    public static final TagKey<Block> ALLTHEMODIUM_TOOL_TAG = BlockTags.create(ResourceLocation.withDefaultNamespace("mineable/pickaxe"));
    public static final TagKey<Block> VIBRANIUM_TOOL_TAG = BlockTags.create(ResourceLocation.withDefaultNamespace("mineable/pickaxe"));

    public static final TagKey<Block> UNOBTAINIUM_TOOL_TAG = BlockTags.create(ResourceLocation.withDefaultNamespace("mineable/pickaxe"));
    public static final TagKey<Block> ALLTHEMODIUM_TIER_TAG = TagRegistry.NEEDS_ALLTHEMODIUM_TOOL;

    public static final TagKey<Block> VIBRANIUM_TIER_TAG = TagRegistry.NEEDS_VIBRANIUM_TOOL;
    public static final TagKey<Block> UNOBTAINIUM_TIER_TAG = TagRegistry.NEEDS_UNOBTAINIUM_TOOL;
    public static final TagKey<Block> ALLOY_TIER_TAG = TagRegistry.NEEDS_ALLOY_TOOL;


   

}
