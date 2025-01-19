package net.mcreator.shangrilafrontier.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.shangrilafrontier.network.ShangrilaFrontierModVariables;

import java.util.HashMap;

public class SetClassAndOriginProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			String _setval = guistate.containsKey("text:Origin") ? ((EditBox) guistate.get("text:Origin")).getValue() : "";
			entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Origin = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = guistate.containsKey("text:PlayerClass") ? ((EditBox) guistate.get("text:PlayerClass")).getValue() : "";
			entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerClass = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		PlayerJoinClassStatsProcedure.execute(entity);
	}
}
