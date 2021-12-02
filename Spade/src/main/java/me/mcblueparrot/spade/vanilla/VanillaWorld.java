package me.mcblueparrot.spade.vanilla;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import me.mcblueparrot.spade.Location;
import me.mcblueparrot.spade.World;
import me.mcblueparrot.spade.entity.Entity;
import me.mcblueparrot.spade.entity.EntityType;
import me.mcblueparrot.spade.entity.Player;
import me.mcblueparrot.spade.vanilla.entity.VanillaEntity;
import me.mcblueparrot.spade.vanilla.entity.VanillaPlayer;
import net.minecraft.server.world.ServerWorld;

public class VanillaWorld implements VanillaBased<ServerWorld>, World {

	protected ServerWorld world;

	public VanillaWorld(ServerWorld world) {
		this.world = world;
	}

	@Override
	public ServerWorld getVanilla() {
		return world;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{name = " + getName() + "}";
	}

	@Override
	public String getName() {
		if(getVanilla().equals(VanillaServer.getInstance().getVanilla().getOverworld())) {
			return "overworld";
		}
		else if(world.getRegistryKey().equals(ServerWorld.NETHER)) {
			return "the_nether";
		}
		else if(world.getRegistryKey().equals(ServerWorld.END)) {
			return "the_end";
		}
		return null;
	}

	@Override
	public long getTime() {
		return world.getTimeOfDay();
	}

	@Override
	public void setTime(long time) {
		world.setTimeOfDay(time);
	}

	@Override
	public long getTimeOfDay() {
		return getTime() - (getDay() * 24000);
	}

	@Override
	public void setTimeOfDay(long time) {
		setTime((getDay() * 24000) + time);
	}

	@Override
	public long getDay() {
		return getTime() / 24000;
	}

	@Override
	public void setDay(long day) {
		setTime(day * 24000);
	}

	@Override
	public Set<? extends Entity> getEntities() {
		return StreamSupport.stream(world.iterateEntities().spliterator(), false).map(VanillaEntity::new).collect(Collectors.toSet());
	}

	@Override
	public Set<? extends Player> getPlayers() {
		return world.getPlayers().stream().map(VanillaPlayer::new).collect(Collectors.toSet());
	}

	@Override
	public Entity spawnEntity(EntityType type, Location location) {
		if(!location.getWorld().getName().equals(getName())) {
			throw new IllegalArgumentException("Location is not in this world");
		}
		return type.spawn(location);
	}

}
