package com.fpvdrone.client;

import com.fpvdrone.DroneEntity;
import com.fpvdrone.FpvDroneMod;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class DroneEntityRenderer extends MobRenderer<DroneEntity, DroneEntityRenderState, DroneEntityModel> {
	private static final Identifier TEXTURE = FpvDroneMod.id("textures/entity/drone.png");

	public DroneEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new DroneEntityModel(context.bakeLayer(DroneModelLayers.DRONE)), 0.25f);
	}

	@Override
	public DroneEntityRenderState createRenderState() {
		return new DroneEntityRenderState();
	}

	@Override
	public Identifier getTextureLocation(DroneEntityRenderState state) {
		return TEXTURE;
	}
}
