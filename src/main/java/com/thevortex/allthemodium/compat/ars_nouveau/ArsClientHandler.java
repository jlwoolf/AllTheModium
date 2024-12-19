package com.thevortex.allthemodium.compat.ars_nouveau;

import com.hollingsworth.arsnouveau.ArsNouveau;
import com.hollingsworth.arsnouveau.common.items.data.BlockFillContents;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.client.renderer.item.ItemProperties;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ArsClientHandler {
    @SubscribeEvent
    public static void init(final FMLClientSetupEvent fmlClientSetupEvent) {
        fmlClientSetupEvent.enqueueWork(() -> ItemProperties.register(ArsCompat.ALLTHEMODIUM_SOURCE_JAR.asItem(), ArsNouveau.prefix("source"), (stack, level, entity, seed) -> {
            int amount = BlockFillContents.get(stack);
            return amount / 100000.0F;
        }));
    }
}