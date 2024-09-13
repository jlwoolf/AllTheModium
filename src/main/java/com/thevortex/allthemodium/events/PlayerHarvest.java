package com.thevortex.allthemodium.events;

// import com.mojang.datafixers.TypeRewriteRule;
// import com.thevortex.allthemodium.blocks.AllthemodiumOre;
// import com.thevortex.allthemodium.blocks.UnobtainiumOre;
// import com.thevortex.allthemodium.blocks.VibraniumOre;
// import com.thevortex.allthemodium.material.ToolTiers;
// import com.thevortex.allthemodium.registry.ModRegistry;
// import net.minecraft.world.entity.player.Player;
// import net.minecraft.world.item.*;
// import net.minecraft.world.level.block.Block;
// import net.minecraft.world.level.block.state.BlockState;
// import net.minecraftforge.event.entity.player.PlayerEvent;
// import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// TODO: Determine if we should keep this class
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerHarvest {
    // @SubscribeEvent
    // public static void on(PlayerEvent.HarvestCheck event) {
    //     Player player = event.getPlayer();
    //     BlockState blockState = event.getTargetBlock();
    //     ItemStack heldItem = player.getMainHandItem();
    //     if (blockState.getBlock() instanceof Allthemodium_Ore) {
    //         boolean b = net.minecraftforge.common.ForgeHooks.isCorrectToolForDrops(blockState, player);
    //         event.setCanHarvest(b);
    //     }
    //     if(blockState.getBlock() instanceof Vibranium_Ore) {
    //         event.setCanHarvest(net.minecraftforge.common.ForgeHooks.isCorrectToolForDrops(blockState, player));
    //     }
    //     if(blockState.getBlock() instanceof Unobtainium_Ore) {
    //         event.setCanHarvest(net.minecraftforge.common.ForgeHooks.isCorrectToolForDrops(blockState, player));
    //     }
    // }
}
