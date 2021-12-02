package me.mcblueparrot.spade.entity;

import java.util.UUID;

import me.mcblueparrot.spade.Location;
import me.mcblueparrot.spade.World;

/**
 * Represents an entity
 */
public interface Entity {

	/**
	 * Gets the location of the entity
	 * @return The location
	 */
	public Location getLocation();

	/**
	 * Gets the x coordinate of the entity
	 * @return The x
	 */
	public default double getX() {
		return getLocation().getX();
	}

	/**
	 * Gets the y coordinate of the entity
	 * @return The y
	 */
	public default double getY() {
		return getLocation().getY();
	}

	/**
	 * Gets the z coordinate of the entity
	 * @return The z
	 */
	public default double getZ() {
		return getLocation().getZ();
	}

	/**
	 * Gets the yaw of the entity
	 * @return The yaw
	 */
	public default float getYaw() {
		return getLocation().getYaw();
	}

	/**
	 * Gets the pitch of the entity
	 * @return The pitch
	 */
	public default float getPitch() {
		return getLocation().getPitch();
	}

	public default World getWorld() {
		return getLocation().getWorld();
	}

	/**
	 * Teleports the entity
	 * @param to The destination
	 */
	public void teleport(Location to);

	/**
	 * Removes the entity
	 */
	public void despawn();

	/**
	 * Detects if the entity is touching water
	 * @return <code>true</code> if the entity is touching water
	 */
	public boolean isWet();

	/**
	 * Detects if the entity is inside a block
	 * @return <code>true</code> if the entity is inside a block
	 */
	public boolean isInsideBlock();

	/**
	 * Gets the UUID of the entity
	 * @return The UUID
	 */
	public UUID getUUID();

	/**
	 * Gets the name of the entity
	 * @return The name
	 */
	public String getName();

	/**
	 * Gets the type of the entity
	 * @return The type
	 */
	public EntityType getType();

}
