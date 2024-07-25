package dev.hybridlabs.aquatic.utils;

import net.minecraft.entity.SpawnGroup;

public enum HybridAquaticSpawnGroup {
    FISH("ha_fish", 8, true, false, 64),
    FISH_UNDERGROUND("ha_fish_underground", 8, true, false, 64),
    CEPHALOPOD("ha_cephalopod", 4, true, true, 64),
    CEPHALOPOD_UNDERGROUND("ha_cephalopod_underground", 4, true, false, 64),
    JELLY("ha_jelly", 6, true, false, 64),
    JELLY_UNDERGROUND("ha_jelly_underground", 2, true, false, 64),
    SHARK("ha_shark", 6, true, true, 64),
    CRUSTACEAN("crustacean", 6, true, false, 64),
    CRUSTACEAN_UNDERGROUND("crustacean_underground", 6, true, false, 64),
    CRITTER("ha_critter", 6, true, false, 64);

    public SpawnGroup spawnGroup;
    public final String name;
    public final int spawnCap;
    public final boolean peaceful;
    public final boolean rare;
    public final int immediateDespawnRange;

    HybridAquaticSpawnGroup(String name, int spawnCap, boolean peaceful, boolean rare, int immediateDespawnRange) {
        this.name = name;
        this.spawnCap = spawnCap;
        this.peaceful = peaceful;
        this.rare = rare;
        this.immediateDespawnRange = immediateDespawnRange;
    }
}
