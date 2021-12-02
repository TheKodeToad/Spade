package me.mcblueparrot.spade.api;

import me.mcblueparrot.spade.api.entity.Arrow;
import me.mcblueparrot.spade.api.entity.Egg;
import me.mcblueparrot.spade.api.entity.Projectile;
import me.mcblueparrot.spade.api.entity.Snowball;

/**
 * Represents a source of projectile.
 */
public interface ProjectileSource {

	/**
	 * Launches a projectile out of the source.
	 * @param projectile the projectile class
	 * @return the projectile
	 */
	public default <P extends Projectile> P launchProjectile(Class<P> projectile) {
		return launchProjectile(projectile, null);
	}

	/**
	 * Launches a projectile out of the source.
	 * @param projectile the projectile class
	 * @param velocity the velocity (<code>null</code> for the default velocity)
	 * @return the projectile
	 */
	public <P extends Projectile> P launchProjectile(Class<P> projectile, Vector velocity);

	/**
	 * Launches a snowball out of the source.
	 * @return the snowball
	 */
	public default Snowball launchSnowball() {
		return launchProjectile(Snowball.class);
	}

	/**
	 * Launches a snowball out of the source.
	 * @param velocity the velocity (<code>null</code> for the default velocity)
	 * @return the snowball
	 */
	public default Snowball launchSnowball(Vector velocity) {
		return launchProjectile(Snowball.class, velocity);
	}

	/**
	 * Launches an egg out of the source.
	 * @return the egg
	 */
	public default Egg launchEgg() {
		return launchProjectile(Egg.class);
	}

	/**
	 * Launches an egg out of the source.
	 * @param velocity the velocity (<code>null</code> for the default velocity)
	 * @return the egg
	 */
	public default Egg launchEgg(Vector velocity) {
		return launchProjectile(Egg.class, velocity);
	}

	/**
	 * Launches an arrow out of the source.
	 * @return the arrow
	 */
	public default Arrow launchArrow() {
		return launchProjectile(Arrow.class);
	}

	/**
	 * Launches an arrow out of the source.
	 * @param velocity the velocity (<code>null</code> for the default velocity)
	 * @return the arrow
	 */
	public default Arrow launchArrow(Vector velocity) {
		return launchProjectile(Arrow.class, velocity);
	}

}
