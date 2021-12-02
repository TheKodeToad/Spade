package me.mcblueparrot.spade.api;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import me.mcblueparrot.spade.api.world.Location;

/**
 * Represents a vector consisting of 3 double components.
 */
public class Vector implements Cloneable<Vector> {

	public static final Vector ZERO = new Vector(0, 0, 0);
	private double x;
	private double y;
	private double z;

	/**
	 * Generates a random vector.
	 * @return the vector
	 */
	public static Vector random() {
		return new Vector(ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble());
	}

	/**
	 * Creates a vector.
	 * @param x the x component
	 * @param y the y component
	 * @param z the z component
	 */
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Creates a copy of a vector.
	 * @param vector the vector
	 */
	public Vector(Vector vector) {
		this(vector.x, vector.y, vector.z);
	}

	/**
	 * Creates a vector from a location.
	 * @param location the location
	 */
	public Vector(Location location) {
		this(location.getX(), location.getY(), location.getZ());
	}

	/**
	 * Gets the X component of the vector.
	 * @return the X component
	 */
	public double getX() {
		return x;
	}

	/**
	 * Sets the X component of the vector.
	 * @param x the X component
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Gets the Y component of the vector.
	 * @return the Y component
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the Y component of the vector.
	 * @param y the Y component
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Gets the Z component of the vector.
	 * @return the Z component
	 */
	public double getZ() {
		return z;
	}

	/**
	 * Sets the Z component of the vector.
	 * @param z the Z component
	 */
	public void setZ(double z) {
		this.z = z;
	}

	/**
	 * Adds another vector to this vector.
	 * @param other the vector
	 * @return this vector
	 */
	public Vector add(Vector other) {
		x += other.x;
		y += other.y;
		z += other.z;
		return this;
	}

	/**
	 * Subtracts another vector from this vector.
	 * @param other the vector
	 * @return this vector
	 */
	public Vector subtract(Vector other) {
		x -= other.x;
		y -= other.y;
		z -= other.z;
		return this;
	}

	/**
	 * Multiplies this vector by another vector.
	 * @param other the vector
	 * @return this vector
	 */
	public Vector multiply(Vector other) {
		x *= other.x;
		y *= other.y;
		z *= other.z;
		return this;
	}

	/**
	 * Divides this vector by another vector.
	 * @param other the vector
	 * @return this vector
	 */
	public Vector divide(Vector other) {
		x /= other.x;
		y /= other.y;
		z /= other.z;
		return this;
	}

	/**
	 * Sets a component in the vector.
	 * @param component the component (must be within range 0-2)
	 * @param value the value
	 * @throws IndexOutOfBoundsException if the component isn't within range 0-2
	 */
	public void setComponent(int component, double value) {
		switch(component) {
			case 0:
				x = value;
				break;
			case 1:
				y = value;
				break;
			case 2:
				z = value;
				break;
			default:
				throw new IndexOutOfBoundsException(SpadeExceptionMessages.VECTOR_COMPONENT_RANGE);
		}
	}

	/**
	 * Gets a component in the vector.
	 * @param component the component (must be within range 0-2)
	 * @return the value
	 * @throws IndexOutOfBoundsException if the component isn't within range 0-2
	 */
	public double getComponent(int component) {
		switch(component) {
			case 0:
				return x;
			case 1:
				return y;
			case 2:
				return z;
			default:
				throw new IndexOutOfBoundsException(SpadeExceptionMessages.VECTOR_COMPONENT_RANGE);
		}
	}

	/**
	 * Gets the dot product of the vector with another vector.
	 * @param other the vector
	 * @return the dot product (<code>x*other.x + y*other.y + z*other.z</code>)
	 */
	public double dotProduct(Vector other) {
		return x * other.x + y * other.y + z * other.z;
	}

	@Override
	public Vector clone() {
		return new Vector(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
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
		Vector other = (Vector) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y)
				&& Double.doubleToLongBits(z) == Double.doubleToLongBits(other.z);
	}

	@Override
	public String toString() {
		return "Vector{x=" + x + ", y=" + y + ", z=" + z + "}";
	}

	/**
	 * Converts the vector to a location.
	 * @return the location
	 */
	public Location toLocation() {
		return new Location(this);
	}

}
