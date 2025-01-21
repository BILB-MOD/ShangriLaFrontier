
package net.mcreator.shangrilafrontier.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;

import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class SetStatCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("slf_set").requires(s -> s.hasPermission(1)).then(Commands.argument("Player", EntityArgument.players()).then(Commands.argument("number", DoubleArgumentType.doubleArg(0))
				.then(Commands.literal("Health")).then(Commands.literal("Strength")).then(Commands.literal("Stamina")).then(Commands.literal("Defense")).then(Commands.literal("Agility")).then(Commands.literal("Luck")))));
	}
}
