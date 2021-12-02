package me.mcblueparrot.spade.vanilla.entity;

import me.mcblueparrot.spade.Location;
import me.mcblueparrot.spade.entity.Entity;
import me.mcblueparrot.spade.entity.EntityType;
import me.mcblueparrot.spade.vanilla.VanillaBased;
import me.mcblueparrot.spade.vanilla.VanillaWorld;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.world.ServerWorld;

public class VanillaEntityType implements VanillaBased<net.minecraft.entity.EntityType<?>>, EntityType {

	protected net.minecraft.entity.EntityType<?> entityType;
	private String id;

	public VanillaEntityType(net.minecraft.entity.EntityType<?> entityType, String id) {
		this.entityType = entityType;
		this.id = id;
	}

	@Override
	public net.minecraft.entity.EntityType<?> getVanilla() {
		return entityType;
	}

	@Override
	public Entity spawn(Location location) {
		ServerWorld serverWorld = ((VanillaWorld) location.getWorld()).getVanilla();
		CompoundTag tag = new CompoundTag();
		tag.putString("id", "minecraft:" + getId());
		net.minecraft.entity.Entity entity = net.minecraft.entity.EntityType.loadEntityWithPassengers(tag, serverWorld, (entity2) -> {
			entity2.refreshPositionAndAngles(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
			return entity2;
		});
		serverWorld.spawnEntity(entity);
		return new VanillaEntity(entity);
	}

	@Override
	public String getId() {
		return id;
	}

}
