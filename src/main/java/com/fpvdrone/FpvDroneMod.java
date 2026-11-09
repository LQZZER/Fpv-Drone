package com.fpvdrone;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

public class FpvDroneMod implements ModInitializer {
	public static final String MOD_ID = "fpvdrone";

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ModEntityTypes.initialize();
		ModItems.initialize();
	}
}
