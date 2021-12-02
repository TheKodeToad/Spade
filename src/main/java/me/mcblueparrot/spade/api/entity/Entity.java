package me.mcblueparrot.spade.api.entity;

import java.util.UUID;

import me.mcblueparrot.spade.api.Vector;
import me.mcblueparrot.spade.api.command.CommandSender;
import me.mcblueparrot.spade.api.world.Location;
import me.mcblueparrot.spade.api.world.World;

/**
 * Represents an entity.
 */
public interface Entity extends CommandSender {

	/**
	 * Teleports the entity.
	 * @param location the destination
	 */
	public void teleport(Location location);

	/**
	 * Teleports the entity.
	 * @param world the world
	 * @param x the X
	 * @param y the Y
	 * @param z the Z
	 * @param yaw the yaw
	 * @param pitch the pitch
	 */
	public default void teleport(World world, double x, double y, double z, float yaw, float pitch) {
		teleport(new Location(world, x, y, z, yaw, pitch));
	}

	/**
	 * Teleports the entity keeping the world, yaw and pitch.
	 * @param position the position
	 */
	public default void teleport(Vector position) {
		Location location = getLocation();
		teleport(location.getWorld(), position.getX(), position.getY(), position.getZ(), location.getYaw(), location.getPitch());
	}

	/**
	 * Teleports the entity, keeping the world, yaw and pitch.
	 * @param x the X
	 * @param y the Y
	 * @param z the Z
	 */
	public default void teleport(double x, double y, double z) {
		teleport(new Vector(x, y, z));
	}

	/**
	 * Teleports the entity, keeping the yaw and pitch.
	 * @param x the X
	 * @param y the Y
	 * @param z the Z
	 */
	public default void teleport(World world, double x, double y, double z) {
		Location location = getLocation();
		teleport(world, x, y, z, location.getYaw(), location.getPitch());
	}

	/**
	 * Teleports the entity, keeping the world.
	 * @param x the X
	 * @param y the Y
	 * @param z the Z
	 * @param yaw the yaw
	 * @param pitch the pitch
	 */
	public default void teleport(double x, double y, double z, float yaw, float pitch) {
		teleport(getLocation().getWorld(), x, y, z, yaw, pitch);
	}

	/**
	 * Gets the world of the entity.
	 * @return the world
	 */
	public default World getWorld() {
		return getLocation().getWorld();
	}

	/**
	 * Gets the x of the entity.
	 * @return the x
	 */
	public default double getX() {
		return getLocation().getX();
	}

	/**
	 * Gets the y of the entity.
	 * @return the y
	 */
	public default double getY() {
		return getLocation().getY();
	}

	/**
	 * Gets the z of the entity.
	 * @return the z
	 */
	public default double getZ() {
		return getLocation().getZ();
	}

	/**
	 * Gets the yaw of the entity.
	 * @return the yaw
	 */
	public default float getYaw() {
		return getLocation().getYaw();
	}

	/**
	 * Gets the pitch of the entity.
	 * @return the pitch
	 */
	public default float getPitch() {
		return getLocation().getPitch();
	}

	/**
	 * Gets the entity's location.
	 * @return the location
	 */
	public Location getLocation();

	/**
	 * Gets the entity's position.
	 * @return the position
	 */
	public default Vector getPosition() {
		Location location = getLocation();
		return new Vector(location.getX(), location.getY(), location.getZ());
	}

	/**
	 * Gets the entity's velocity.
	 * @return the velocity
	 */
	public Vector getVelocity();

	/**
	 * Sets the entity's velocity.
	 * @param velocity the velocity
	 */
	public void setVelocity(Vector velocity);

	/**
	 * Gets the entity's UUID.
	 * @return the UUID
	 */
	public UUID getUniqueId();

	/**
	 * Gets the entity's type.
	 * @return the entity type
	 */
	public EntityType getType();

	/**
	 * Marks the entity's removal.
	 */
	public void remove();

	/**
	 * Gets if the entity has been marked for removal.
	 * @return if the entity has been marked for removal
	 */
	public boolean isRemoved();

	/**
	 * Gets the amount of ticks the entity has been alive for.
	 * @return the amount of ticks
	 */
	public int getAge();

	/**
	 * Sets the amount of ticks the entity has been alive for.
	 * @param age the amount of ticks
	 */
	public void setAge(int age);

	/**
	 * Gets if the entity has gravity enabled.
	 * @return if the entity has gravity enabled
	 */
	public boolean hasGravity();

	/**
	 * Sets if the entity has gravity enabled.
	 * @param gravity if the entity has gravity enabled
	 */
	public void setGravity(boolean gravity);

	/**
	 * Gets if the entity is invulnerable to attacks other than players in creative mode.
	 * @return if the entity is invulnerable
	 */
	public boolean isInvulnerable();

	/**
	 * Sets if the entity is invulnerable to attacks other than players in creative mode.
	 * @param invulnerable if the entity is invulnerable
	 */
	public void setInvulnerable(boolean invulnerable);

}
