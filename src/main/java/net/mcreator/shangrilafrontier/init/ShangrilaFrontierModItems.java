
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.shangrilafrontier.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.shangrilafrontier.item.VrHeadsetItem;
import net.mcreator.shangrilafrontier.item.MercenaryDaggersItem;
import net.mcreator.shangrilafrontier.ShangrilaFrontierMod;

public class ShangrilaFrontierModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ShangrilaFrontierMod.MODID);
	public static final RegistryObject<Item> VR_HEADSET_HELMET = REGISTRY.register("vr_headset_helmet", () -> new VrHeadsetItem.Helmet());
	public static final RegistryObject<Item> MERCENARY_DAGGERS = REGISTRY.register("mercenary_daggers", () -> new MercenaryDaggersItem());
	// Start of user code block custom items
	// End of user code block custom items
}
