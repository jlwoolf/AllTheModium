package com.thevortex.allthemodium.events;

import com.thevortex.allthemodium.entity.PiglichModel;
import com.thevortex.allthemodium.entity.PiglichRenderer;
import com.thevortex.allthemodium.entity.ThrownATMTridentRenderer;
import com.thevortex.allthemodium.entity.TridentRenderSetup;
import com.thevortex.allthemodium.entity.alloy_trident;
import com.thevortex.allthemodium.items.toolitems.armor.models.allthemodium_helmet;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BrushableBlockRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientEvents {
   
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
                event.registerEntityRenderer(ModRegistry.PIGLICH.get(), PiglichRenderer::new);
        event.registerBlockEntityRenderer(ModRegistry.BRUSHABLE_BLOCK.get(), BrushableBlockRenderer::new);
        
        event.registerEntityRenderer(ModRegistry.ALLOY_TRIDENT_ENTITY.get(), ThrownATMTridentRenderer::new);

    }

    @SubscribeEvent
    public static void registerTree(FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_HERB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_LEAVES_BOTTOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_DOOR_.get(), RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(ModRegistry.DEMONIC_HERB.get(), RenderType.cutout());
       ItemBlockRenderTypes.setRenderLayer(ModRegistry.DEMONIC_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.DEMONIC_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.DEMONIC_LEAVES_BOTTOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.DEMONIC_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.DEMONIC_DOOR_.get(), RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(ModRegistry.SOUL_HERB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.SOUL_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.SOUL_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.SOUL_LEAVES_BOTTOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.SOUL_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.SOUL_DOOR_.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_CAVEVINES_.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModRegistry.ANCIENT_CAVEVINES_PLANT_.get(), RenderType.cutoutMipped());


    }
    @SubscribeEvent
    public static void registerMesh(EntityRenderersEvent.AddLayers event) {
        event.getEntityModels().bakeLayer(PiglichModel.LAYER_LOCATION);
        event.getEntityModels().bakeLayer(alloy_trident.LAYER_LOCATION);
        event.getEntityModels().bakeLayer(allthemodium_helmet.LAYER_LOCATION);
    }
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(PiglichModel.LAYER_LOCATION, () -> PiglichModel.createBodyLayer());
        event.registerLayerDefinition(allthemodium_helmet.LAYER_LOCATION, allthemodium_helmet::createBodyLayer);
        event.registerLayerDefinition(alloy_trident.LAYER_LOCATION, () -> alloy_trident.createBodyLayer());
    }

}
