package com.thevortex.allthemodium.crafting;

import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.thevortex.allthemodium.AllTheModium;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.codehaus.plexus.util.CachedMap;
import org.jetbrains.annotations.NotNull;

public class ATMShapedRecipe implements IATMShapedRecipe {

    private final ShapedRecipe internal;

    public ATMShapedRecipe(ShapedRecipe internal) {
        this.internal = internal;
    }

    public ShapedRecipe getInternal() {
        return internal;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ATMCraftingSetup.ATM_DATA.get();
    }

    @Override
    public boolean matches(CraftingContainer inv, Level world) {
        // Note: We do not override the matches method if it matches ignoring NBT,
        // to ensure that we return the proper value for if there is a match that gives
        // a proper output
        return internal.matches(inv, world);
    }

    @Override
    public ItemStack assemble(CraftingContainer inv, RegistryAccess blah) {
        if (getResultItem(blah).isEmpty()) {
            return ItemStack.EMPTY;
        }
        ItemStack toReturn = getResultItem(blah).copy();
        Map<Enchantment, Integer> enchant = new HashMap<>();

        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
            if (!stack.isEmpty() && (!stack.getEnchantmentTags().isEmpty())) {
                Map<Enchantment, Integer> temp = EnchantmentHelper.getEnchantments(stack);
                for (Enchantment e : temp.keySet()) {
                    if (enchant.containsKey(e) && (enchant.get(e) == temp.get(e))) {
                        enchant.put(e, temp.get(e) + 1);
                    }
                    if (enchant.containsKey(e) && (enchant.get(e) < temp.get(e))) {
                        enchant.put(e, temp.get(e));
                    }
                    if (enchant.containsKey(e) && (enchant.get(e) > temp.get(e))) {
                        break;
                    } else {
                        enchant.put(e, temp.get(e));
                    }
                }
            }
        }
        EnchantmentHelper.setEnchantments(enchant, toReturn);
        return toReturn;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return internal.canCraftInDimensions(width, height);
    }

    @Override
    public @NotNull ItemStack getResultItem(RegistryAccess blah) {
        return internal.getResultItem(blah);
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer inv) {
        return internal.getRemainingItems(inv);
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return internal.getIngredients();
    }

    @Override
    public boolean isSpecial() {
        return internal.isSpecial();
    }

    @Override
    public String getGroup() {
        return internal.getGroup();
    }

    @Override
    public ItemStack getToastSymbol() {
        return internal.getToastSymbol();
    }

    @Override
    public ResourceLocation getId() {
        return internal.getId();
    }

    @Override
    public CraftingBookCategory category() {
        return CraftingBookCategory.MISC;
    }
}