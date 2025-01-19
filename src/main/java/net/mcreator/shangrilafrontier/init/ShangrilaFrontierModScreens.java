
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.shangrilafrontier.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.shangrilafrontier.client.gui.StatCustomisationScreenScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ShangrilaFrontierModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ShangrilaFrontierModMenus.STAT_CUSTOMISATION_SCREEN.get(), StatCustomisationScreenScreen::new);
		});
	}
}
