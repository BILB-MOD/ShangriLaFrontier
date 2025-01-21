package net.mcreator.shangrilafrontier.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.shangrilafrontier.network.ShangrilaFrontierModVariables;

public class PlayerJoinClassStatsProcedure {
	public static void execute(Entity entity, double MaxHp) {
		if (entity == null)
			return;
		if (((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).PlayerClass).equals("Mercenary")) {
			GenerateStatsProcedure.execute(entity, 15, 5, 10, 0, MaxHp, 10, 15, 10);
		}
		if (((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).PlayerClass).equals("Knight")) {
			GenerateStatsProcedure.execute(entity, 5, 5, 5, 0, MaxHp, 15, 15, 15);
		}
		if (((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).PlayerClass).equals("Bandit")) {
			GenerateStatsProcedure.execute(entity, 20, 15, 10, 0, MaxHp, 10, 15, 5);
		}
		if (((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).PlayerClass).equals("Magician")) {
			GenerateStatsProcedure.execute(entity, 10, 0, 5, 20, MaxHp, 15, 10, 5);
		}
		if (((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).PlayerClass).equals("Brawler")) {
			GenerateStatsProcedure.execute(entity, 15, 0, 0, 0, MaxHp, 10, 20, 20);
		}
		if (((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).PlayerClass).equals("Monk")) {
			GenerateStatsProcedure.execute(entity, 10, 0, 0, 15, MaxHp, 15, 10, 15);
		}
		if (((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).PlayerClass).equals("Swordsman")) {
			GenerateStatsProcedure.execute(entity, 10, 10, 10, 0, MaxHp, 10, 10, 15);
		}
		if (((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).PlayerClass).equals("Cleric")) {
			GenerateStatsProcedure.execute(entity, 5, 0, 15, 15, MaxHp, 15, 15, 5);
		}
	}
}
