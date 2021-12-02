package me.mcblueparrot.spade.api.entity;

import me.mcblueparrot.spade.api.ProjectileSource;

/**
 * Represents a projectile, such as an arrow or snowball.
 */
public interface Projectile extends Entity {

	/**
	 * Gets the source of the projectile.
	 * @return the source
	 */
	public ProjectileSource getSource();

}
