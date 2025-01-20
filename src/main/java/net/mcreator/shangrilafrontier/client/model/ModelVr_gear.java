package net.mcreator.shangrilafrontier.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelVr_gear<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("shangrila_frontier", "model_vr_gear"), "main");
	public final ModelPart bone;

	public ModelVr_gear(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 5).addBox(-4.5F, -5.5F, -4.5F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 0).addBox(2.525F, -5.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(19, 0)
						.addBox(2.75F, -3.5F, 0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 18).mirror().addBox(2.6F, -6.0F, 0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 18)
						.addBox(-4.6F, -6.0F, 0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 0).mirror().addBox(-4.75F, -3.5F, 0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(18, 7)
						.addBox(-4.525F, -5.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(18, 14).addBox(-4.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(9, 20).addBox(-4.8F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.9F, -6.8702F, 4.855F, 1.9199F, 0.0F, 0.0F));
		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 12).addBox(-3.8F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4F, -5.4805F, 2.6749F, 0.8727F, 0.0F, 0.0F));
		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(15, 18).addBox(-1.0F, -0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 20).addBox(6.0F, -0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -4.3655F, -0.3896F, 0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(11, 24).addBox(-5.2F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.6F, -5.6797F, 3.0381F, 0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 9).addBox(-4.0F, -2.0F, -1.0F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -2.11F, -2.7485F, 0.4363F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
