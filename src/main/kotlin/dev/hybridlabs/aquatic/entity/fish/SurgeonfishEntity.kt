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
        "powder_blue_tang" to FishVariant.biomeVariant("powder_blue_tang", HybridAquaticBiomeTags.SURGEONFISH_SPAWN_BIOMES),
        "yellow_tang" to FishVariant.biomeVariant("yellow_tang", HybridAquaticBiomeTags.SURGEONFISH_SPAWN_BIOMES),
        "blue_tang" to FishVariant.biomeVariant("blue_tang", HybridAquaticBiomeTags.SURGEONFISH_SPAWN_BIOMES)),
        HybridAquaticEntityTags.NONE, HybridAquaticEntityTags.SURGEONFISH_PREDATOR) {

    public override fun getLootTableId(): Identifier {
        return when (this.variant?.variantName) {
            "blue_tang" -> Identifier("hybrid-aquatic", "gameplay/blue_tang")
            "sohal" -> Identifier("hybrid-aquatic", "gameplay/sohal")
            "orangeshoulder" -> Identifier("hybrid-aquatic", "gameplay/orangeshoulder")
            "unicornfish" -> Identifier("hybrid-aquatic", "gameplay/unicornfish")
            else -> super.getLootTableId()
        }
    }

    override fun tick() {
        super.tick()

        return when (this.variant?.variantName) {
            "powder_blue_tang" -> attributes.getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH)?.baseValue = 1.5
            "yellow_tang" -> attributes.getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH)?.baseValue = 1.5

            else -> attributes.getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH)?.baseValue = 4.0
        }
    }

    override fun getLimitPerChunk(): Int {
        return 4
    }

    companion object {
        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 4.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12.0)
        }
    }
}