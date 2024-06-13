package dev.hybridlabs.aquatic.entity.fish

import dev.hybridlabs.aquatic.tag.HybridAquaticBiomeTags
import dev.hybridlabs.aquatic.tag.HybridAquaticEntityTags
import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.util.Identifier
import net.minecraft.world.World

class SurgeonfishEntity(entityType: EntityType<out SurgeonfishEntity>, world: World) :
    HybridAquaticFishEntity(entityType, world, variants = hashMapOf(
        "sohal" to FishVariant.biomeVariant("sohal", HybridAquaticBiomeTags.SURGEONFISH_SPAWN_BIOMES),
        "lined" to FishVariant.biomeVariant("lined", HybridAquaticBiomeTags.SURGEONFISH_SPAWN_BIOMES),
        "orangeshoulder" to FishVariant.biomeVariant("orangeshoulder", HybridAquaticBiomeTags.SURGEONFISH_SPAWN_BIOMES),
        "unicornfish" to FishVariant.biomeVariant("unicornfish", HybridAquaticBiomeTags.SURGEONFISH_SPAWN_BIOMES),
        "bluetang" to FishVariant.biomeVariant("bluetang", HybridAquaticBiomeTags.SURGEONFISH_SPAWN_BIOMES)),
        HybridAquaticEntityTags.NONE, HybridAquaticEntityTags.SURGEONFISH_PREDATOR) {

    public override fun getLootTableId(): Identifier {
        return when (this.variant?.variantName) {
            "bluetang" -> Identifier("hybrid-aquatic", "gameplay/blue_tang")
            "unicornfish" -> Identifier("hybrid-aquatic", "gameplay/unicornfish")
            else -> super.getLootTableId()
        }
    }

    companion object {
        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 4.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12.0)
        }
    }
}