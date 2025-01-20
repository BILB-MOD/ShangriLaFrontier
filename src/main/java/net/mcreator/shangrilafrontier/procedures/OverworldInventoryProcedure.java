package net.mcreator.shangrilafrontier.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.shangrilafrontier.network.ShangrilaFrontierModVariables;

import java.util.concurrent.atomic.AtomicReference;

public class OverworldInventoryProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double Count = 0;
		Count = 0;
		for (int index0 = 0; index0 < 36; index0++) {
			((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).OverworldInventory).getOrCreateTag().putDouble(("Slotamount" + Count), ((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) Count, entity)).getCount()));
			((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).OverworldInventory).getOrCreateTag().putString(("Slot" + Count),
					(ForgeRegistries.ITEMS.getKey((new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
							return _retval.get();
						}
					}.getItemStack((int) Count, entity)).getItem()).toString()));
			Count = Count + 1;
		}
	}
}
