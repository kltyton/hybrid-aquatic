package dev.hybridlabs.aquatic.utils;

import net.minecraft.entity.SpawnGroup;

public enum HybridAquaticSpawnGroup {
    FISH("ha_fish", 20, true, false, 64),
    FISH_UNDERGROUND("ha_fish_underground", 10, true, false, 64),
    CEPHALOPOD("ha_cephalopod", 6, true, false, 64),
    CEPHALOPOD_UNDERGROUND("ha_cephalopod_underground", 6, true, false, 64),
    JELLY("ha_jelly", 6, true, false, 64),
    JELLY_UNDERGROUND("ha_jelly_underground", 3, true, false, 64),
    SHARK("ha_shark", 5, true, false, 64),
    CRUSTACEAN("crustacean", 12, true, false, 64),
    CRUSTACEAN_UNDERGROUND("crustacean_underground", 8, true, false, 64),
    CRITTER("ha_critter", 12, true, false, 64);

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
