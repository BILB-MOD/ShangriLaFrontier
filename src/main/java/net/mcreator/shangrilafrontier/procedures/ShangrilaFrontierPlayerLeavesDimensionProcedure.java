package net.mcreator.shangrilafrontier.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.shangrilafrontier.network.ShangrilaFrontierModVariables;

public class ShangrilaFrontierPlayerLeavesDimensionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.InGame = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
