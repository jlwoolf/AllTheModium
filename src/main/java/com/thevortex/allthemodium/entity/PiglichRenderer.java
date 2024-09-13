package com.thevortex.allthemodium.entity;

import javax.annotation.Nullable;

import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class PiglichRenderer extends GeoEntityRenderer<PiglichEntity> {

    public PiglichRenderer(EntityRendererProvider.Context context) {
        super(context, new PiglichModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(PiglichEntity instance) {
        return new ResourceLocation(Reference.MOD_ID, "textures/entity/piglich.png");
    }

    @Override
    public RenderType getRenderType(PiglichEntity animatable, ResourceLocation textureLocation,
            @Nullable MultiBufferSource renderTypeBuffer, float partialTicks) {

        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}
