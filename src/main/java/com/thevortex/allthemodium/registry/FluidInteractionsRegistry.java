package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry;
import net.neoforged.neoforge.fluids.FluidType;

@EventBusSubscriber(modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class FluidInteractionsRegistry {

    @SubscribeEvent
    public static void register(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            addInteraction(FluidTypeRegistry.SOULLAVA.get());
        });
    }

    // Lava + Water = Obsidian (Source Lava) / Cobblestone (Flowing Lava)
    private static void addInteraction(FluidType fluidType) {
        FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new FluidInteractionRegistry.InteractionInformation(fluidType, fluidState -> fluidState.isSource() ? Blocks.GILDED_BLACKSTONE.defaultBlockState() : Blocks.BLACKSTONE.defaultBlockState()));
        FluidInteractionRegistry.addInteraction(NeoForgeMod.WATER_TYPE.value(), new FluidInteractionRegistry.InteractionInformation(fluidType, fluidState -> fluidState.isSource() ? Blocks.CRYING_OBSIDIAN.defaultBlockState() : Blocks.OBSIDIAN.defaultBlockState()));

    }
}
