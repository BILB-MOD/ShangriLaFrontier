package net.mcreator.shangrilafrontier.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.shangrilafrontier.network.ShangrilaFrontierModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BeforeEntityHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		double reishi_damage = 0;
		double damage = 0;
		double armor = 0;
		double physical_damage = 0;
		double Crit = 0;
		double current_health = 0;
		double n = 0;
		double dmg = 0;
		dmg = amount;
		if (event != null && event.isCancelable()) {
			event.setCanceled(true);
		} else if (event != null && event.hasResult()) {
			event.setResult(Event.Result.DENY);
		}
		if (entity.getPersistentData().getBoolean("hit")) {
			entity.getPersistentData().putBoolean("hit", false);
			dmg = dmg + entity.getPersistentData().getDouble("deal");
		}
		armor = entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0;
		dmg = dmg * (200 / (200 + (entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).DEX));
		dmg = dmg * (25 / (25 + armor));
		if (entity instanceof Player) {
			current_health = (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / 20;
			current_health = current_health * (entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).MAXHP;
			current_health = current_health - dmg;
			current_health = current_health / (entity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).MAXHP;
			current_health = current_health * 20;
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) current_health);
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - dmg));
		}
	}
}
