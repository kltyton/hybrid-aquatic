package dev.hybridlabs.aquatic.mixin;

import dev.hybridlabs.aquatic.access.CustomPlayerEntityData;
import dev.hybridlabs.aquatic.effect.HybridAquaticStatusEffects;
import dev.hybridlabs.aquatic.entity.shark.HybridAquaticSharkEntity;
import dev.hybridlabs.aquatic.item.HybridAquaticItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.FluidTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin implements CustomPlayerEntityData {
    @Unique
    private int haHurtTime = 0;

    @Override
    public void hybrid_aquatic$setHurtTime(int value) {
        haHurtTime = value;
    }

    @Override
    public int hybrid_aquatic$getHurtTime() {
        return haHurtTime;
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    private void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        hybrid_aquatic$setHurtTime(nbt.getInt("haHurtTime"));
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    private void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putInt("haHurtTime", hybrid_aquatic$getHurtTime());
    }

    @Inject(
            method = "damage",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;getWorld()Lnet/minecraft/world/World;",
                    ordinal = 0,
                    shift = At.Shift.BEFORE
            )
    )

    private void setCustomHurtTimeOnDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity object = ((PlayerEntity) (Object) this);

        if (object.isTouchingWater()) {
            LivingEntity foundEntity = object.getWorld().getClosestEntity(HybridAquaticSharkEntity.class, TargetPredicate.createNonAttackable().setBaseMaxDistance(32).setPredicate(Entity::isSubmergedInWater), object, object.getX(), object.getEyeY(), object.getZ(), object.getBoundingBox().expand(16));
            if (foundEntity != null) hybrid_aquatic$setHurtTime(200);
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void tickDownCustomHurtTime(CallbackInfo ci) {
        int cHurtTime = hybrid_aquatic$getHurtTime();
        if (cHurtTime > 0) {
            hybrid_aquatic$setHurtTime(cHurtTime - 1);
        }
        // Call updateDivingHelmet method
        updateDivingHelmet();
        //Call updateTurtleChestplate method
        updateTurtleChestplate();
    }

    @Unique
    private void updateDivingHelmet() {
        var player = (PlayerEntity)(Object)this;
        var itemStack = player.getEquippedStack(EquipmentSlot.HEAD);
        if (itemStack.isOf(HybridAquaticItems.INSTANCE.getDIVING_HELMET()) && player.isSubmergedIn(FluidTags.WATER)) {
            player.addStatusEffect(new StatusEffectInstance(HybridAquaticStatusEffects.INSTANCE.getCLARITY(), 200, 0, false, false, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0, false, false, true));
        }
    }

    @Unique
    private void updateTurtleChestplate() {
        var player = (PlayerEntity)(Object)this;
        var itemStack = player.getEquippedStack(EquipmentSlot.CHEST);
        if (itemStack.isOf(HybridAquaticItems.INSTANCE.getTURTLE_CHESTPLATE())) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 1, false, false, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 0, false, false, true));
        }
    }
}
