package me.mcblueparrot.spade.api.entity;

import me.mcblueparrot.spade.api.block.WoodType;

/**
 * Represents a boat.
 */
public interface Boat extends Vehicle {

	/**
	 * Gets the wood type the boat is made of.
	 * @return the wood type the boat is made of
	 */
	public WoodType getWoodType();

	/**
	 * Sets the wood type the boat is made of.
	 * @param type the wood type
	 */
	public void setWoodType(WoodType type);

	@Override
	public default EntityType getType() {
		return EntityType.BOAT;
	}

}
