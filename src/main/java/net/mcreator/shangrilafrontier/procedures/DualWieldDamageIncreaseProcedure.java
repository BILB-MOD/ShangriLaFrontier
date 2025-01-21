package net.mcreator.shangrilafrontier.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class DualWieldDamageIncreaseProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:dualwield")))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:dualwield")))) {
			entity.getPersistentData().putBoolean("DualWield", true);
		} else {
			entity.getPersistentData().putBoolean("DualWield", false);
		}
	}
}
