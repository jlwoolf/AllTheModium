package com.thevortex.allthemodium.events;

import com.thevortex.allthemodium.config.AllthemodiumServerConfigs;
import com.thevortex.allthemodium.registry.TagRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockBreak {

    @SubscribeEvent
    public static void on(BlockEvent.EntityPlaceEvent context) {
        if (context.getLevel() == Level.END) {
            BlockPos pos = context.getPos();
            int x = pos.getX();
            int z = pos.getZ();
            if (Math.abs(x) < 1000 || Math.abs(z) < 1000) {

                context.setCanceled(true);
            }

        }

    }

    @SubscribeEvent
    public static void on(BlockEvent.BreakEvent event) {
        if (event.getPlayer().isCreative()) {
            return;
        }

        boolean fakePlayer = (event.getPlayer() instanceof FakePlayer) ||
                (event.getPlayer() == null);
        boolean emptyHand = event.getPlayer().getMainHandItem().isEmpty();

        if ((event.getState().is(TagRegistry.OTHER_PROTECTION)) &&
                fakePlayer && AllthemodiumServerConfigs.OTHER_PROTECTION.get()) {
            event.setCanceled(true);
            return;
        }
        if ((event.getState().is(TagRegistry.ALLTHEMODIUM_ORE)) &&
                (fakePlayer || emptyHand) &&
                !AllthemodiumServerConfigs.ALLTHEMODIUM_QUARRYABLE.get()) {
            event.setCanceled(true);
            return;
        }

        if ((event.getState().is(TagRegistry.VIBRANIUM_ORE)) &&
                (fakePlayer || emptyHand) &&
                !AllthemodiumServerConfigs.VIBRANIUM_QUARRYABLE.get()) {
            event.setCanceled(true);
            return;
        }
        if ((event.getState().is(TagRegistry.UNOBTAINIUM_ORE)) &&
                (fakePlayer || emptyHand) &&
                !AllthemodiumServerConfigs.UNOBTAINIUM_QUARRYABLE.get()) {
            event.setCanceled(true);
            return;
        }
        if (event.getPlayer() instanceof FakePlayer) {
            return;
        }
    }
}
