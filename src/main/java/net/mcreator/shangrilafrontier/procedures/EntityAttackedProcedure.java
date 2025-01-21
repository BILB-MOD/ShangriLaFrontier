package net.mcreator.shangrilafrontier.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.shangrilafrontier.network.ShangrilaFrontierModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntityAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack weapon = ItemStack.EMPTY;
		double damage = 0;
		double stage = 0;
		double crit = 0;
		damage = Math.ceil((sourceentity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).STR * 0.1);
		crit = Mth.nextInt(RandomSource.create(), 1, 100);
		if (crit <= (sourceentity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).CritChance) {
			damage = Math.ceil(damage + ((sourceentity.getCapability(ShangrilaFrontierModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ShangrilaFrontierModVariables.PlayerVariables())).CritDmg * damage) / 100);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Critical!"), false);
		}
		weapon = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		weapon = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
		if (weapon.is(ItemTags.create(new ResourceLocation("dualwield")))) {
			damage = damage * 1.5;
		}
		if (sourceentity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("DMG: ##").format(damage))), true);
		entity.getPersistentData().putBoolean("hit", true);
		entity.getPersistentData().putDouble("deal", damage);
	}
}
