package com.thevortex.allthemodium.blocks;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviderType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.FakePlayer;


public class Unobtainium_Ore extends DropExperienceBlock {
private final static IntProvider xpRange = new IntProvider() {
		@Override
		public int getMaxValue() {
			return 50;
		}

		@Override
		public int getMinValue() {
			return 25;
		}

		@Override
		public IntProviderType<?> getType() {
			return IntProviderType.CONSTANT;
			
		}

		@Override
		public int sample(RandomSource arg0) {
			return arg0.nextIntBetweenInclusive(this.getMinValue(), this.getMaxValue());
		}
	};
	public Unobtainium_Ore() {//func_235861_h_ = setRequiresTool
		super(xpRange, Properties.of().requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE).strength(-1.0f,5000f));
	}
		@Override
	public boolean canEntityDestroy(BlockState state, BlockGetter world, BlockPos pos, Entity player) {
		if((player instanceof FakePlayer) && (state.getBlock() == ModRegistry.UNOBTAINIUM_ORE.get())) { return false; }
		return super.canEntityDestroy(state,world,pos,player) && (distanceTo(pos,player.blockPosition()) < 16.0F);
	}

	private double distanceTo(BlockPos block,BlockPos player) {
		return Math.sqrt(Math.pow(block.getX() - player.getX(), 2) + Math.pow(block.getY() - player.getY(), 2) + Math.pow(block.getZ() - player.getZ(), 2));
	}


}
