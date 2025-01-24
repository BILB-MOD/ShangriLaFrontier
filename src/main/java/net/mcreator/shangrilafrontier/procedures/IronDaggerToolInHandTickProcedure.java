package net.mcreator.shangrilafrontier.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.shangrilafrontier.network.ShangrilaFrontierModVariables;

public class IronDaggerToolInHandTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).ItemRequirements).getOrCreateTag().putDouble("DEX", 15);
		((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).ItemRequirements).getOrCreateTag().putDouble("AGI", 10);
		((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).ItemRequirements).getOrCreateTag().putDouble("STR", 0);
	}
}
