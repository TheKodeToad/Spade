package me.mcblueparrot.spade.api.entity;

import java.awt.Color;

/**
 * Represents an arrow projectile.
 */
public interface Arrow extends Projectile {

	/**
	 * Gets the colour of the arrow.
	 * @return the colour
	 */
	public Color getColor();

	/**
	 * Sets the colour of the arrow.
	 * @param color the colour
	 */
	public void setColor(Color color);

}
