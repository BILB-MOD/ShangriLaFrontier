package net.mcreator.shangrilafrontier.procedures;

import net.minecraftforge.eventbus.api.Event;

public class GetXpProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "XP: " + new java.text.DecimalFormat("##").format((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).xp) + "/"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).LEVEL
						* (10 + Math.floor((entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).LEVEL / 5)));
	}
}
