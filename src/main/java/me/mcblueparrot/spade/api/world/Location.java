package me.mcblueparrot.spade.api.world;

import java.util.Objects;

import me.mcblueparrot.spade.api.Cloneable;
import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.SpadeExceptionMessages;
import me.mcblueparrot.spade.api.Vector;
import me.mcblueparrot.spade.api.block.Block;
import me.mcblueparrot.spade.api.id.Identifier;

/**
 * Represents a location in a world.
 */
public class Location implements Cloneable<Location> {

	private Identifier worldId;
	private double x;
	private double y;
	private double z;
	private float yaw;
	private float pitch;

	/**
	 * Creates a location in the overworld.
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param z the Z coordinate
	 */
	public Location(double x, double y, double z) {
		this(x, y, z, 0, 0);
	}

	/**
	 * Creates a location in the overworld.
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param z the Z coordinate
	 * @param yaw the yaw
	 * @param pitch the pitch
	 */
	public Location(double x, double y, double z, float yaw, float pitch) {
		this(Spade.getOverworld(), x, y, z, yaw, pitch);
	}

	/**
	 * Creates a location.
	 * @param world the world
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param z the Z coordinate
	 */
	public Location(World world, double x, double y, double z) {
		this(world, x, y, z, 0, 0);
	}

	/**
	 * Creates a location.
	 * @param world the world
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 * @param z the Z coordinate
	 * @param yaw the yaw
	 * @param pitch the pitch
	 */
	public Location(World world, double x, double y, double z, float yaw, float pitch) {
		if(world != null) {
			this.worldId = world.getId();
		}
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
	}

	/**
	 * Creates a copy of a location.
	 * @param location the location
	 */
	public Location(Location location) {
		this(location.worldId, location.x, location.y, location.z, location.yaw, location.pitch);
	}

	/**
	 * Creates a location from a vector.
	 */
	public Location(Vector vector) {
		this(null, vector.getX(), vector.getY(), vector.getZ());
	}

	private Location(Identifier worldId, double x, double y, double z, float yaw, float pitch) {
		this.worldId = worldId;
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
	}

	/**
	 * Gets the world the location is located in.
	 * @return the world
	 */
	public World getWorld() {
		if(worldId != null) {
			return Spade.getWorld(worldId);
		}
		else {
			return null;
		}
	}

	/**
	 * Sets the world the location is location in.
	 * @param world the world
	 */
	public void setWorld(World world) {
		if(world != null) {
			worldId = world.getId();
		}
		else {
			worldId = null;
		}
	}

	/**
	 * Gets the X coordinate.
	 * @return the X coordinate
	 */
	public double getX() {
		return x;
	}

	/**
	 * Sets the X coordinate.
	 * @param x the X coordinate
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Gets the Y coordinate.
	 * @return the Y coordinate
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the Y coordinate.
	 * @param y the Y coordinate
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Gets the z coordinate.
	 * @return the z coordinate
	 */
	public double getZ() {
		return z;
	}

	/**
	 * Sets the Z coordinate.
	 * @param z the Z coordinate
	 */
	public void setZ(double z) {
		this.z = z;
	}

	/**
	 * Gets the yaw.
	 * @return the yaw
	 */
	public float getYaw() {
		return yaw;
	}

	/**
	 * Sets the yaw.
	 * @param yaw the yaw
	 */
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	/**
	 * Gets the pitch.
	 * @return the pitch
	 */
	public float getPitch() {
		return pitch;
	}

	/**
	 * Sets the pitch.
	 * @param pitch the pitch
	 */
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	/**
	 * Gets the block at the location.
	 * @return the block
	 */
	public Block getBlock() {
		if(worldId == null) {
			throw new UnsupportedOperationException(SpadeExceptionMessages.WORLD_NULL);
		}
		return getBlock(getWorld());
	}

	/**
	 * Gets the block at the location.
	 * @param world the world
	 * @return the block
	 */
	public Block getBlock(World world) {
		return world.getBlock(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pitch, worldId, x, y, yaw, z);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Location other = (Location) obj;
		return Float.floatToIntBits(pitch) == Float.floatToIntBits(other.pitch)
			&& Objects.equals(worldId, other.worldId)
			&& Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
			&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y)
			&& Float.floatToIntBits(yaw) == Float.floatToIntBits(other.yaw)
			&& Double.doubleToLongBits(z) == Double.doubleToLongBits(other.z);
	}

	@Override
	public String toString() {
		return "Location{world=" + worldId + ", x=" + x + ", y=" + y + ", z=" + z + ", yaw=" + yaw + ", pitch=" + pitch + "}";
	}

	@Override
	public Location clone() {
		return new Location(this);
	}

	/**
	 * Converts the location to a vector.
	 * @return the vector
	 */
	public Vector toVector() {
		return new Vector(this);
	}

}
