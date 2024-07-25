package com.thevortex.allthemodium.mixins;

import javax.annotation.Nullable;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.entity.ATMTridentModel;
import com.thevortex.allthemodium.registry.ModRegistry;

import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.ClientHooks;

@OnlyIn(Dist.CLIENT)
@Mixin(ItemRenderer.class)
public abstract class MixinItemRenderer implements ResourceManagerReloadListener{

   @Final
   @Shadow
   private final ItemModelShaper itemModelShaper = this.getItemModelShaper();

   private static final ModelResourceLocation ATMTRIDENT_MODEL =  ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath("allthemodium","alloy_trident"));
   public static final ModelResourceLocation TRIDENT_IN_HAND_MODEL = ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath("allthemodium","alloy_trident_in_hand"));;

   @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void render(ItemStack item, ItemDisplayContext context, boolean flag, PoseStack stack, MultiBufferSource buffer, int p_115149_, int p_115150_, BakedModel bakedModel, CallbackInfo ci) {
      AllTheModium.LOGGER.info("Rendering Trident");
        stack.pushPose();
        if (item.is(ModRegistry.ALLOY_TRIDENT.get())) {
            bakedModel = this.itemModelShaper.getModelManager().getModel(ATMTRIDENT_MODEL);
            bakedModel = ClientHooks.handleCameraTransforms(stack, bakedModel, context, flag);
            stack.translate(-0.5F, -0.5F, -0.5F);
            stack.popPose();
            ci.cancel();
            return;
        }
        stack.popPose();
    }
   
    @Inject(method = "getModel", at = @At("HEAD"), cancellable = true)
    private BakedModel getModel(ItemStack item,@Nullable Level level, @Nullable LivingEntity entity, int someInt , CallbackInfoReturnable<BakedModel> cir) {
        BakedModel bakedModel;
        AllTheModium.LOGGER.info("Model Trident");
        if (item.is(ModRegistry.ALLOY_TRIDENT.get())) {
            bakedModel = this.itemModelShaper.getModelManager().getModel(TRIDENT_IN_HAND_MODEL);
            cir.setReturnValue(bakedModel);
            return bakedModel;
        }
        else {
            return this.itemModelShaper.getItemModel(item);
        }
    }
    

    
   

    @Shadow
    public abstract ItemModelShaper getItemModelShaper();
}

