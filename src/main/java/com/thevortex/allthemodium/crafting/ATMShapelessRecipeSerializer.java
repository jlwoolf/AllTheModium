package com.thevortex.allthemodium.crafting;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ATMShapelessRecipeSerializer implements RecipeSerializer<ATMShapelessRecipe> {

    @Override
    public ATMShapelessRecipe fromJson(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
        return new ATMShapelessRecipe(RecipeSerializer.SHAPELESS_RECIPE.fromJson(recipeId, json));
    }

    @Override
    public ATMShapelessRecipe fromNetwork(@Nonnull ResourceLocation recipeId, @Nonnull FriendlyByteBuf buffer) {
        try {
            return new ATMShapelessRecipe(RecipeSerializer.SHAPELESS_RECIPE.fromNetwork(recipeId, buffer));
        } catch (Exception e) {
            throw e;
        }
    }

    // private void write(FriendlyByteBuf buffer, ShapelessRecipe recipe) {
    //     try {
    //         RecipeSerializer.SHAPELESS_RECIPE.toNetwork(buffer, recipe);
    //     } catch (Exception e) {
    //         throw e;
    //     }
    // }

    @Override
    public void toNetwork(@Nonnull FriendlyByteBuf buffer, @Nonnull ATMShapelessRecipe recipe) {
        try {
            RecipeSerializer.SHAPELESS_RECIPE.toNetwork(buffer, recipe.getInternal());
        } catch (Exception e) {
            throw e;
        }
    }
}
