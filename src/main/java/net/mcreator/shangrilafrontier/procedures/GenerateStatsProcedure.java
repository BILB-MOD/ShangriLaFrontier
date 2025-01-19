package net.mcreator.shangrilafrontier.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.shangrilafrontier.network.ShangrilaFrontierModVariables;

public class GenerateStatsProcedure {
	public static void execute(Entity entity, double AGI, double DEX, double LUC, double Magic, double SKILL, double STM, double STR, double VIT) {
		if (entity == null)
			return;
		{
			double _setval = Magic;
			entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MP = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = STM;
			entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.STM = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = STR;
			entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.STR = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = DEX;
			entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.DEX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = VIT;
			entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.VIT = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = AGI;
			entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AGI = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = SKILL;
			entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SKILL = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = LUC;
			entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.LUC = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
