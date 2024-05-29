//The MIT License (MIT)
//
//Copyright (c) 2023
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in
//all copies or substantial portions of the Software.

package dev.hybridlabs.aquatic.mixin;

import dev.hybridlabs.aquatic.goals.BoidGoal;
import dev.hybridlabs.aquatic.goals.LimitSpeedAndLookInVelocityDirectionGoal;
import dev.hybridlabs.aquatic.goals.StayInWaterGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SchoolingFishEntity.class)
public abstract class SchoolingFishEntityMixin extends FishEntity {
    public SchoolingFishEntityMixin(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals", at = @At("HEAD"), cancellable = true)
    protected void registerGoals(CallbackInfo ci) {

        this.goalSelector.add(5, new BoidGoal(this, 0.5f, 0.9f, 8 / 20f, 10 / 20f));
        this.goalSelector.add(3, new StayInWaterGoal(this));
        this.goalSelector.add(2, new LimitSpeedAndLookInVelocityDirectionGoal(this, 0.2f, 0.4f));

        ci.cancel();
    }
}
