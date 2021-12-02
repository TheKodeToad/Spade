package me.mcblueparrot.spade.api.entity;

import java.awt.Color;
import java.util.List;

/**
 * Represents an area effect cloud.
 */
public interface AreaEffectCloud extends Entity {

	/**
	 * Gets the colour of the area effect cloud.
	 * @return the colour
	 */
	public Color getColor();

	/**
	 * Sets the colour of the area effect cloud
	 * @param color the colour
	 */
	public void setColor(Color color);

	/**
	 * Gets a list of status effects of the area effect cloud.
	 * @return the list
	 */
	public List<StatusEffect> getStatusEffects();

}
