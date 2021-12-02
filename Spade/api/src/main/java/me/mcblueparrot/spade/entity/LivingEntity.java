package me.mcblueparrot.spade.entity;

public interface LivingEntity extends Entity {

	/**
	 * Kills the entity
	 */
	public void kill();

	/**
	 * Gets the entity's health
	 * @return The health
	 */
	public float getHealth();

	/**
	 * Sets the entity's health
	 * @param health The health
	 */
	public void setHealth(float health);

	/**
	 * Damages the entity
	 * @param amount How much health to take
	 */
	public void damage(float amount);

	/**
	 * Heals the entity
	 * @param amount How much health to restore
	 */
	public void heal(float amount);

}
