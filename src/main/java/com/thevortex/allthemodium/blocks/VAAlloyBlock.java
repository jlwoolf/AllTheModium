package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;

public class VAAlloyBlock extends Block {

	public VAAlloyBlock() {
		super(
				Properties.of(Material.STONE).sound(SoundType.STONE).strength(7.0f));
	}

	@Deprecated
	@Override
	public List<ItemStack> getDrops(
			@Nonnull BlockState state,
			@Nonnull LootContext.Builder builder) {
		List<ItemStack> list = new ArrayList<ItemStack>();
		list.add(new ItemStack(ModRegistry.VA_ALLOY_ITEM.get()));
		return list;
	}
}
