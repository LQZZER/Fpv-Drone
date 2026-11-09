package com.fpvdrone.client;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

/**
 * FPV-Drohne aus Quadern. Masse in 1/16 Block. Vorne ist -Z (Kamera), hinten +Z (Antenne).
 * Textur 64x64: Farbregionen siehe Kommentar oben.
 */
public class DroneEntityModel extends EntityModel<DroneEntityRenderState> {
	private static final float[][] MOTORS = {
			{-2.5f, -2.5f}, {2.5f, -2.5f}, {-2.5f, 2.5f}, {2.5f, 2.5f}
	};
	private static final float[] ARM_YAW = {45f, 135f, 225f, 315f};

	public DroneEntityModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		PartPose ground = PartPose.offset(0, 24, 0);

		// schwarz: Rahmen, Elektronik, Akku, Arme
		root.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-2f, -1.5f, -2.5f, 4, 1, 5), ground);
		root.addOrReplaceChild("stack", CubeListBuilder.create().texOffs(0, 8)
				.addBox(-1.5f, -2.5f, -2f, 3, 1, 4), ground);
		root.addOrReplaceChild("battery", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-1.5f, -4f, -2.5f, 3, 1.5f, 5), ground);
		root.addOrReplaceChild("camera", CubeListBuilder.create().texOffs(0, 24)
				.addBox(-1f, -2.5f, -3.5f, 2, 2, 1), ground);
		for (int i = 0; i < 4; i++) {
			root.addOrReplaceChild("arm" + i, CubeListBuilder.create().texOffs(0, 0)
							.addBox(-0.5f, -1.5f, 0.5f, 1, 1, 3),
					PartPose.offsetAndRotation(0, 24, 0, 0, (float) Math.toRadians(ARM_YAW[i]), 0));
		}

		// gelb: Akku-Streifen (obenauf), cyan: Linse (vorne an der Kamera)
		root.addOrReplaceChild("battery_stripe", CubeListBuilder.create().texOffs(32, 32)
				.addBox(-0.5f, -4.1f, -2.5f, 1, 0.1f, 5), ground);
		root.addOrReplaceChild("lens", CubeListBuilder.create().texOffs(32, 48)
				.addBox(-0.5f, -2f, -3.6f, 1, 1, 0.1f), ground);

		// grau: Motoren + Propeller, rot: Antenne
		for (int i = 0; i < 4; i++) {
			PartPose at = PartPose.offset(MOTORS[i][0], 24, MOTORS[i][1]);
			root.addOrReplaceChild("motor" + i, CubeListBuilder.create().texOffs(32, 0)
					.addBox(-0.75f, -2.5f, -0.75f, 1.5f, 1.5f, 1.5f), at);
			root.addOrReplaceChild("prop" + i, CubeListBuilder.create().texOffs(32, 8)
					.addBox(-2f, -3f, -0.5f, 4, 0.25f, 1), at);
		}
		root.addOrReplaceChild("antenna", CubeListBuilder.create().texOffs(0, 32)
				.addBox(-0.25f, -6f, 1.5f, 0.5f, 3, 0.5f), ground);

		return LayerDefinition.create(mesh, 64, 64);
	}
}
