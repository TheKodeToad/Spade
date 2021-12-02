package me.mcblueparrot.spade.entity;

import java.util.UUID;

public interface BreedableAnimalEntity extends AnimalEntity {

	/**
	 * Gets the player who caused this animal to breed
	 * @return The player
	 */
	public UUID getBreedCause();

	/**
	 * Gets whether the animal is in love mode
	 * @return Whether the animal is in love mode
	 */
	public boolean isInLoveMode();

	/**
	 * Gets the number of ticks the animal is in love mode for
	 * @return The number of ticks the animal is in love mode for
	 */
	public int getLoveModeTicks();

	/**
	 * Sets the number of ticks the animal is in love mode for
	 * @param ticks The number of ticks the animal is in love mode for
	 */
	public void setLoveModeTicks(int ticks);

}
