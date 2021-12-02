package me.mcblueparrot.spade.api.entity;

/**
 * Represents an entity that can be damaged.
 */
public interface DamageableEntity extends Entity {

	/**
	 * Gets the entity's health level.
	 * @return the health level
	 */
	public float getHealth();

	/**
	 * Sets the entity's health level.
	 * @param health the health level
	 */
	public void setHealth(float health);

	/**
	 * Damages the entity.
	 * @param amount the amount of health to take
	 */
	public default void damage(float amount) {
		damage(amount, DamageCause.GENERIC);
	}

	/**
	 * Damages the entity.
	 * @param amount the amount of health to take
	 * @param cause the cause of the damage
	 */
	public void damage(float amount, DamageCause cause);

	/**
	 * Heals the entity.
	 * @param amount the amount of health to restore
	 */
	public void heal(float amount);

	/**
	 * Kills the entity.
	 */
	public default void kill() {
		damage(Float.MAX_VALUE);
	}

}
