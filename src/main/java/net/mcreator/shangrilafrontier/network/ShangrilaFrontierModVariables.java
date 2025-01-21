package net.mcreator.shangrilafrontier.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.shangrilafrontier.ShangrilaFrontierMod;

import java.util.function.Supplier;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ShangrilaFrontierModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ShangrilaFrontierMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.HP = original.HP;
			clone.MP = original.MP;
			clone.STM = original.STM;
			clone.STR = original.STR;
			clone.DEX = original.DEX;
			clone.VIT = original.VIT;
			clone.AGI = original.AGI;
			clone.SKILL = original.SKILL;
			clone.LUC = original.LUC;
			clone.LEVEL = original.LEVEL;
			clone.CritDmg = original.CritDmg;
			clone.CritChance = original.CritChance;
			clone.PlayerClass = original.PlayerClass;
			clone.Origin = original.Origin;
			clone.InGame = original.InGame;
			clone.OverworldInventory = original.OverworldInventory;
			clone.ShangriLaInventory = original.ShangriLaInventory;
			clone.xp = original.xp;
			clone.sp = original.sp;
			clone.MAXHP = original.MAXHP;
			if (!event.isWasDeath()) {
			}
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("shangrila_frontier", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double HP = 20.0;
		public double MP = 0;
		public double STM = 0;
		public double STR = 0;
		public double DEX = 0;
		public double VIT = 0;
		public double AGI = 0;
		public double SKILL = 0;
		public double LUC = 0;
		public double LEVEL = 0;
		public double CritDmg = 0;
		public double CritChance = 0;
		public String PlayerClass = "\"\"";
		public String Origin = "\"\"";
		public boolean InGame = false;
		public ItemStack OverworldInventory = ItemStack.EMPTY;
		public ItemStack ShangriLaInventory = ItemStack.EMPTY;
		public double xp = 0;
		public double sp = 0;
		public double MAXHP = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				ShangrilaFrontierMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(entity.level()::dimension), new PlayerVariablesSyncMessage(this, entity.getId()));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("HP", HP);
			nbt.putDouble("MP", MP);
			nbt.putDouble("STM", STM);
			nbt.putDouble("STR", STR);
			nbt.putDouble("DEX", DEX);
			nbt.putDouble("VIT", VIT);
			nbt.putDouble("AGI", AGI);
			nbt.putDouble("SKILL", SKILL);
			nbt.putDouble("LUC", LUC);
			nbt.putDouble("LEVEL", LEVEL);
			nbt.putDouble("CritDmg", CritDmg);
			nbt.putDouble("CritChance", CritChance);
			nbt.putString("PlayerClass", PlayerClass);
			nbt.putString("Origin", Origin);
			nbt.putBoolean("InGame", InGame);
			nbt.put("OverworldInventory", OverworldInventory.save(new CompoundTag()));
			nbt.put("ShangriLaInventory", ShangriLaInventory.save(new CompoundTag()));
			nbt.putDouble("xp", xp);
			nbt.putDouble("sp", sp);
			nbt.putDouble("MAXHP", MAXHP);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			HP = nbt.getDouble("HP");
			MP = nbt.getDouble("MP");
			STM = nbt.getDouble("STM");
			STR = nbt.getDouble("STR");
			DEX = nbt.getDouble("DEX");
			VIT = nbt.getDouble("VIT");
			AGI = nbt.getDouble("AGI");
			SKILL = nbt.getDouble("SKILL");
			LUC = nbt.getDouble("LUC");
			LEVEL = nbt.getDouble("LEVEL");
			CritDmg = nbt.getDouble("CritDmg");
			CritChance = nbt.getDouble("CritChance");
			PlayerClass = nbt.getString("PlayerClass");
			Origin = nbt.getString("Origin");
			InGame = nbt.getBoolean("InGame");
			OverworldInventory = ItemStack.of(nbt.getCompound("OverworldInventory"));
			ShangriLaInventory = ItemStack.of(nbt.getCompound("ShangriLaInventory"));
			xp = nbt.getDouble("xp");
			sp = nbt.getDouble("sp");
			MAXHP = nbt.getDouble("MAXHP");
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ShangrilaFrontierMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	public static class PlayerVariablesSyncMessage {
		private final int target;
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
			this.target = buffer.readInt();
		}

		public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
			this.data = data;
			this.target = entityid;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
			buffer.writeInt(message.target);
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.level().getEntity(message.target).getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.HP = message.data.HP;
					variables.MP = message.data.MP;
					variables.STM = message.data.STM;
					variables.STR = message.data.STR;
					variables.DEX = message.data.DEX;
					variables.VIT = message.data.VIT;
					variables.AGI = message.data.AGI;
					variables.SKILL = message.data.SKILL;
					variables.LUC = message.data.LUC;
					variables.LEVEL = message.data.LEVEL;
					variables.CritDmg = message.data.CritDmg;
					variables.CritChance = message.data.CritChance;
					variables.PlayerClass = message.data.PlayerClass;
					variables.Origin = message.data.Origin;
					variables.InGame = message.data.InGame;
					variables.OverworldInventory = message.data.OverworldInventory;
					variables.ShangriLaInventory = message.data.ShangriLaInventory;
					variables.xp = message.data.xp;
					variables.sp = message.data.sp;
					variables.MAXHP = message.data.MAXHP;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
