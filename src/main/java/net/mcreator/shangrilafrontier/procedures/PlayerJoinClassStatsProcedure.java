package net.mcreator.shangrilafrontier.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.shangrilafrontier.network.ShangrilaFrontierModVariables;

public class PlayerJoinClassStatsProcedure {
	public static void execute(Entity entity, double MaxHp) {
		if (entity == null)
			return;
		if (((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).PlayerClass).equals("Mercenary")) {
			GenerateStatsProcedure.execute(entity, 10, 10, 99, 10, MaxHp, 10, 10, 10);
		}
	}
}
