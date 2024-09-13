package com.thevortex.allthemodium.entity.shulkers.vib;

import com.google.common.collect.ImmutableList;
import com.thevortex.allthemodium.reference.Reference;
import javax.annotation.Nonnull;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Shulker;

public class VIBShulkerModel<T extends Shulker> extends ListModel<T> {

    // private static final String LID = "lid";
    // private static final String BASE = "base";
    private final ModelPart base;
    private final ModelPart lid;
    private final ModelPart head;
    public static final ModelLayerLocation LAYER_LOCATION =
        new ModelLayerLocation(
            new ResourceLocation(Reference.MOD_ID, "vibranium_shulker"),
            "main"
        );

    public VIBShulkerModel(ModelPart p_170922_, boolean bool) {
        super(RenderType::entityCutoutNoCullZOffset);
        this.lid = p_170922_.getChild("lid");
        this.base = p_170922_.getChild("base");
        this.head = p_170922_.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild(
            "lid",
            CubeListBuilder
                .create()
                .texOffs(0, 0)
                .addBox(-8.0F, -16.0F, -8.0F, 16.0F, 12.0F, 16.0F),
            PartPose.offset(0.0F, 24.0F, 0.0F)
        );
        partDefinition.addOrReplaceChild(
            "base",
            CubeListBuilder
                .create()
                .texOffs(0, 28)
                .addBox(-8.0F, -8.0F, -8.0F, 16.0F, 8.0F, 16.0F),
            PartPose.offset(0.0F, 24.0F, 0.0F)
        );
        partDefinition.addOrReplaceChild(
            "head",
            CubeListBuilder
                .create()
                .texOffs(0, 52)
                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F),
            PartPose.offset(0.0F, 12.0F, 0.0F)
        );
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public void setupAnim(
        @Nonnull T p_103735_,
        float p_103736_,
        float p_103737_,
        float p_103738_,
        float p_103739_,
        float p_103740_
    ) {
        float f = p_103738_ - (float) p_103735_.tickCount;
        float f1 = (0.5F + p_103735_.getClientPeekAmount(f)) * (float) Math.PI;
        float f2 = -1.0F + Mth.sin(f1);
        float f3 = 0.0F;
        if (f1 > (float) Math.PI) {
            f3 = Mth.sin(p_103738_ * 0.1F) * 0.7F;
        }

        this.lid.setPos(0.0F, 16.0F + Mth.sin(f1) * 8.0F + f3, 0.0F);
        if (p_103735_.getClientPeekAmount(f) > 0.3F) {
            this.lid.yRot = f2 * f2 * f2 * f2 * (float) Math.PI * 0.125F;
        } else {
            this.lid.yRot = 0.0F;
        }

        this.head.xRot = p_103740_ * ((float) Math.PI / 180F);
        this.head.yRot =
        (p_103735_.yHeadRot - 180.0F - p_103735_.yBodyRot) *
        ((float) Math.PI / 180F);
    }

    public Iterable<ModelPart> parts() {
        return ImmutableList.of(this.base, this.lid);
    }

    public ModelPart getLid() {
        return this.lid;
    }

    public ModelPart getHead() {
        return this.head;
    }
}
