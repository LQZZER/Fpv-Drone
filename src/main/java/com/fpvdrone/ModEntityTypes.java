package com.fpvdrone;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntityTypes {
	public static final ResourceKey<EntityType<?>> DRONE_KEY =
			ResourceKey.create(Registries.ENTITY_TYPE, FpvDroneMod.id("drone"));

	public static final EntityType<DroneEntity> DRONE = register(
			EntityType.Builder.<DroneEntity>of(DroneEntity::new, MobCategory.MISC)
					.sized(0.6f, 0.25f)
	);

	private static EntityType<DroneEntity> register(EntityType.Builder<DroneEntity> builder) {
		EntityType<DroneEntity> type = Registry.register(BuiltInRegistries.ENTITY_TYPE, DRONE_KEY, builder.build(DRONE_KEY));
		FabricDefaultAttributeRegistry.register(type, DroneEntity.createDroneAttributes());
		return type;
	}

	public static void initialize() {
	}
}
