package dev.hybridlabs.aquatic.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.hybridlabs.aquatic.item.HybridAquaticItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {
    @Shadow @Final private MinecraftClient client;

    @ModifyReturnValue(
            method = "hasExtendedReach",
            at = @At("RETURN")
    )
    private boolean extendedReachWithCrabClaw(boolean original) {
        if(client.player == null) return original;

        ItemStack offhandItem = client.player.getOffHandStack();
        return original || (!offhandItem.isEmpty() & offhandItem.getItem().equals(HybridAquaticItems.INSTANCE.getCRAB_CLAW()));
    }
}
