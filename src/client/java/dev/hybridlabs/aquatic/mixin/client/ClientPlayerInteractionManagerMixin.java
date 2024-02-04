package dev.hybridlabs.aquatic.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.hybridlabs.aquatic.item.HybridAquaticItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.item.ItemStack;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {
    @Shadow @Final private MinecraftClient client;
    @Shadow @Final private static Logger LOGGER;
    
    @ModifyConstant(
            method = "getReachDistance",
            constant = @Constant(floatValue = 4.5f)
    )
    private float test(float original) {
        if(client.player == null) return original;
        ItemStack offhandItem = client.player.getOffHandStack();
        
        return (!offhandItem.isEmpty() & offhandItem.getItem().equals(HybridAquaticItems.INSTANCE.getKARKINOS_CLAW())) ? 5.0f : original;
    }
    
    @ModifyReturnValue(
            method = "hasExtendedReach",
            at = @At("RETURN")
    )
    private boolean extendedReachWithCrabClaw(boolean original) {
        if(client.player == null) return original;
        ItemStack offhandItem = client.player.getOffHandStack();
        
        return original || (!offhandItem.isEmpty() & offhandItem.getItem().equals(HybridAquaticItems.INSTANCE.getKARKINOS_CLAW()));
    }
}
