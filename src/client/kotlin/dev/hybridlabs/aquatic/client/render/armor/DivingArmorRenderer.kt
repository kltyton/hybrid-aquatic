package dev.hybridlabs.aquatic.client.render.armor;

import dev.hybridlabs.aquatic.HybridAquatic;
import dev.hybridlabs.aquatic.item.DivingArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public final class DivingArmorRenderer extends GeoArmorRenderer<DivingArmorItem> {
	public DivingArmorRenderer() {
		super(new DefaultedItemGeoModel<>(new Identifier(HybridAquatic.MOD_ID, "armor/diving_armor")));
	}
}
