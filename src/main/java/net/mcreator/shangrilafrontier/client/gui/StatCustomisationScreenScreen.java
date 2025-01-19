package net.mcreator.shangrilafrontier.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.shangrilafrontier.world.inventory.StatCustomisationScreenMenu;
import net.mcreator.shangrilafrontier.network.StatCustomisationScreenButtonMessage;
import net.mcreator.shangrilafrontier.ShangrilaFrontierMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class StatCustomisationScreenScreen extends AbstractContainerScreen<StatCustomisationScreenMenu> {
	private final static HashMap<String, Object> guistate = StatCustomisationScreenMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	public static EditBox Origin;
	public static EditBox PlayerClass;
	Button button_set_class_and_origin;

	public StatCustomisationScreenScreen(StatCustomisationScreenMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("shangrila_frontier:textures/screens/stat_customisation_screen.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		Origin.render(guiGraphics, mouseX, mouseY, partialTicks);
		PlayerClass.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (Origin.isFocused())
			return Origin.keyPressed(key, b, c);
		if (PlayerClass.isFocused())
			return PlayerClass.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Origin.tick();
		PlayerClass.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String OriginValue = Origin.getValue();
		String PlayerClassValue = PlayerClass.getValue();
		super.resize(minecraft, width, height);
		Origin.setValue(OriginValue);
		PlayerClass.setValue(PlayerClassValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		Origin = new EditBox(this.font, this.leftPos + 27, this.topPos + 17, 118, 18, Component.translatable("gui.shangrila_frontier.stat_customisation_screen.Origin")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.shangrila_frontier.stat_customisation_screen.Origin").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.shangrila_frontier.stat_customisation_screen.Origin").getString());
				else
					setSuggestion(null);
			}
		};
		Origin.setSuggestion(Component.translatable("gui.shangrila_frontier.stat_customisation_screen.Origin").getString());
		Origin.setMaxLength(32767);
		guistate.put("text:Origin", Origin);
		this.addWidget(this.Origin);
		PlayerClass = new EditBox(this.font, this.leftPos + 27, this.topPos + 44, 118, 18, Component.translatable("gui.shangrila_frontier.stat_customisation_screen.PlayerClass")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.shangrila_frontier.stat_customisation_screen.PlayerClass").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.shangrila_frontier.stat_customisation_screen.PlayerClass").getString());
				else
					setSuggestion(null);
			}
		};
		PlayerClass.setSuggestion(Component.translatable("gui.shangrila_frontier.stat_customisation_screen.PlayerClass").getString());
		PlayerClass.setMaxLength(32767);
		guistate.put("text:PlayerClass", PlayerClass);
		this.addWidget(this.PlayerClass);
		button_set_class_and_origin = Button.builder(Component.translatable("gui.shangrila_frontier.stat_customisation_screen.button_set_class_and_origin"), e -> {
			if (true) {
				textstate.put("textin:Origin", Origin.getValue());
				textstate.put("textin:PlayerClass", PlayerClass.getValue());
				ShangrilaFrontierMod.PACKET_HANDLER.sendToServer(new StatCustomisationScreenButtonMessage(0, x, y, z, textstate));
				StatCustomisationScreenButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 22, this.topPos + 134, 129, 20).build();
		guistate.put("button:button_set_class_and_origin", button_set_class_and_origin);
		this.addRenderableWidget(button_set_class_and_origin);
	}
}
