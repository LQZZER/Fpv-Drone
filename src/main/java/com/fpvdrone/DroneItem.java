package com.fpvdrone;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

/** Rechtsklick auf einen Block setzt die Drohne dort ab. */
public class DroneItem extends Item {
	public DroneItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		if (!(level instanceof ServerLevel serverLevel)) {
			return InteractionResult.SUCCESS;
		}

		BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
		DroneEntity drone = new DroneEntity(ModEntityTypes.DRONE, serverLevel);
		drone.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
		if (context.getPlayer() != null) {
			drone.setYRot(context.getPlayer().getYRot());
		}
		serverLevel.addFreshEntity(drone);

		if (context.getPlayer() == null || !context.getPlayer().getAbilities().instabuild) {
			context.getItemInHand().shrink(1);
		}
		return InteractionResult.SUCCESS;
	}
}
