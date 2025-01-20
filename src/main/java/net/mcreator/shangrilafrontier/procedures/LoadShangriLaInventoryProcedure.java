package net.mcreator.shangrilafrontier.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.shangrilafrontier.network.ShangrilaFrontierModVariables;

public class LoadShangriLaInventoryProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double Count = 0;
		Count = 0;
		for (int index0 = 0; index0 < 36; index0++) {
			{
				final int _slotid = (int) Count;
				final ItemStack _setstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(
						((((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).ShangriLaInventory).getOrCreateTag().getString(("Slot" + Count))))
								.toLowerCase(java.util.Locale.ENGLISH))))
						.copy();
				_setstack.setCount((int) ((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).ShangriLaInventory).getOrCreateTag()
						.getDouble(("Slotamount" + Count)));
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
						_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
				});
			}
			Count = Count + 1;
		}
	}
}
