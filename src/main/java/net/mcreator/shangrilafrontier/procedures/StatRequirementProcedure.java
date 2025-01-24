package net.mcreator.shangrilafrontier.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.shangrilafrontier.network.ShangrilaFrontierModVariables;

public class StatRequirementProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
				new ShangrilaFrontierModVariables.PlayerVariables())).STR == ((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).ItemRequirements)
						.getOrCreateTag().getDouble("STR"))) {
			entity.getPersistentData().putBoolean("unable", true);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Requirements unmet"), true);
		}
		if (!((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
				new ShangrilaFrontierModVariables.PlayerVariables())).DEX == ((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).ItemRequirements)
						.getOrCreateTag().getDouble("DEX"))) {
			entity.getPersistentData().putBoolean("unable", true);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Requirements unmet"), true);
		}
		if (!((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
				new ShangrilaFrontierModVariables.PlayerVariables())).AGI == ((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).ItemRequirements)
						.getOrCreateTag().getDouble("AGI"))) {
			entity.getPersistentData().putBoolean("unable", true);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Requirements unmet"), true);
		}
	}
}
