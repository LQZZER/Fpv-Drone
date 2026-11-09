package com.fpvdrone;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

/**
 * Stufe 1: Die Drohne steht nur auf dem Boden. Kein Flug, keine Steuerung.
 * Wir erben von PathfinderMob, weil der Renderer dafuer in der Fabric-Doku
 * genau so vorgesehen ist (gleiches Muster wie der Mini-Golem).
 */
public class DroneEntity extends PathfinderMob {
	public DroneEntity(EntityType<? extends DroneEntity> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.Builder createDroneAttributes() {
		return PathfinderMob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 4)
				.add(Attributes.MOVEMENT_SPEED, 0.0);
	}

	@Override
	protected void registerGoals() {
		// absichtlich leer: die Drohne hat keine KI
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}
}
