
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.shangrilafrontier.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.shangrilafrontier.client.model.ModelVr_gear;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ShangrilaFrontierModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelVr_gear.LAYER_LOCATION, ModelVr_gear::createBodyLayer);
	}
}
