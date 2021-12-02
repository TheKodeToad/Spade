package me.mcblueparrot.spade.vanilla.entity;

import java.util.UUID;

import me.mcblueparrot.spade.Location;
import me.mcblueparrot.spade.Spade;
import me.mcblueparrot.spade.entity.Entity;
import me.mcblueparrot.spade.entity.EntityType;
import me.mcblueparrot.spade.vanilla.VanillaBased;
import me.mcblueparrot.spade.vanilla.VanillaWorld;
import net.minecraft.server.world.ServerWorld;

public class VanillaEntity implements VanillaBased<net.minecraft.entity.Entity>, Entity {

	protected net.minecraft.entity.Entity entity;

	public VanillaEntity(net.minecraft.entity.Entity entity) {
		this.entity = entity;
	}

	@Override
	public net.minecraft.entity.Entity getVanilla() {
		return entity;
	}

	@Override
	public Location getLocation() {
		return new Location(new VanillaWorld((ServerWorld) entity.getEntityWorld()), entity.getX(), entity.getY(), entity.getZ(), entity.yaw, entity.pitch);
	}

	@Override
	public void teleport(Location to) {
		entity.teleport(to.getX(), to.getY(), to.getZ());
	}

	@Override
	public void despawn() {
		entity.remove();
	}

	@Override
	public boolean isWet() {
		return entity.isWet();
	}

	@Override
	public boolean isInsideBlock() {
		return entity.isInsideWall();
	}

	@Override
	public UUID getUUID() {
		return entity.getUuid();
	}

	@Override
	public String getName() {
		return entity.getName().getString();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{name = " + getName() + ", uuid = " + getUUID() + "}";
	}

	@Override
	public EntityType getType() {
		return Spade.getEntityType(net.minecraft.entity.EntityType.getId(getVanilla().getType()).getPath());
	}

}
