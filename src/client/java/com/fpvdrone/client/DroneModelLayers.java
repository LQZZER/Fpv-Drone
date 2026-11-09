package com.fpvdrone.client;

import com.fpvdrone.FpvDroneMod;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;

public class DroneModelLayers {
	public static final ModelLayerLocation DRONE = new ModelLayerLocation(FpvDroneMod.id("drone"), "main");

	public static void registerModelLayers() {
		ModelLayerRegistry.registerModelLayer(DRONE, DroneEntityModel::getTexturedModelData);
	}
}
