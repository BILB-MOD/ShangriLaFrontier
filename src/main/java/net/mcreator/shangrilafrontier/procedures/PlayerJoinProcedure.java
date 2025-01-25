package net.mcreator.shangrilafrontier.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerJoinProcedure {
	@SubscribeEvent
	public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("shangrila_frontier:shangrila_frontier"))) {
			OverworldInventoryProcedure.execute(entity);
			LoadShangriLaInventoryProcedure.execute(entity);
		}
		if ((entity.level().dimension()) == Level.OVERWORLD) {
			ShangriLaInventoryProcedure.execute(entity);
			LoadInventoryProcedure.execute(entity);
		}
	}
}
