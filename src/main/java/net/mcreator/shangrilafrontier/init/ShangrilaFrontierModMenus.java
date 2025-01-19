
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.shangrilafrontier.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.shangrilafrontier.world.inventory.StatCustomisationScreenMenu;
import net.mcreator.shangrilafrontier.ShangrilaFrontierMod;

public class ShangrilaFrontierModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ShangrilaFrontierMod.MODID);
	public static final RegistryObject<MenuType<StatCustomisationScreenMenu>> STAT_CUSTOMISATION_SCREEN = REGISTRY.register("stat_customisation_screen", () -> IForgeMenuType.create(StatCustomisationScreenMenu::new));
}
