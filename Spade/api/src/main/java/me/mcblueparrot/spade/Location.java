package me.mcblueparrot.spade;

/**
 * Represents a 3d position and orientation
 */
public class Location {

	private World world;
	private double x;
	private double y;
	private double z;
	private float yaw;
	private float pitch;

	/**
	 * Creates a {@link Location}
	 * @param world The world
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @param z The z coordinate
	 */
	public Location(World world, double x, double y, double z) {
		this(world, x, y, z, 0, 0);
	}

	/**
	 * Creates a {@link Location}
	 * @param world The world
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @param z The z coordinate
	 * @param yaw The yaw
	 * @param pitch The pitch
	 */
	public Location(World world, double x, double y, double z, float yaw, float pitch) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
		this.world = world;
	}

	/**
	 * Gets the world
	 * @return The world
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * Gets the x coordinate
	 * @return The x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets the y coordinate
	 * @return The y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Gets the z coordinate
	 * @return The z
	 */
	public double getZ() {
		return z;
	}

	/**
	 * Gets the yaw
	 * @return The yaw
	 */
	public float getYaw() {
		return yaw;
	}

	/**
	 * Gets the pitch
	 * @return The pitch
	 */
	public float getPitch() {
		return pitch;
	}

	/**
	 * Sets the world
	 * @param world The world
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * Sets the x coordinate
	 * @param x The x
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Sets the y coordinate
	 * @param y The y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Sets the z coordinate
	 * @param z The z
	 */
	public void setZ(double z) {
		this.z = z;
	}

	/**
	 * Sets the yaw
	 * @param yaw The yaw
	 */
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	/**
	 * Sets the pitch
	 * @param pitch The pitch
	 */
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

}
