package com.fpvdrone.client;

import com.fpvdrone.ModEntityTypes;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class FpvDroneClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		DroneModelLayers.registerModelLayers();
		EntityRenderers.register(ModEntityTypes.DRONE, DroneEntityRenderer::new);
	}
}
