package com.thevortex.allthemodium.entity;

import com.thevortex.allthemodium.items.toolitems.tools.ATMTrident;
import com.thevortex.allthemodium.reference.Reference;

import net.minecraft.client.model.TridentModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.ThrownTridentRenderer;
import net.minecraft.resources.ResourceLocation;

public class ThrownATMTridentRenderer extends ThrownTridentRenderer{
public static final ResourceLocation TRIDENT_LOCATION = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/entity/alloy_trident.png");
private final ATMTridentModel model;
    public ThrownATMTridentRenderer(Context context) {
        super(context);
        this.model = new ATMTridentModel(context.bakeLayer(alloy_trident.LAYER_LOCATION));

    }

}
