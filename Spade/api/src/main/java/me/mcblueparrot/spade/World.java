package me.mcblueparrot.spade;

import java.util.Set;

import me.mcblueparrot.spade.entity.Entity;
import me.mcblueparrot.spade.entity.EntityType;
import me.mcblueparrot.spade.entity.Player;

/**
 * Represents a world
 */
public interface World {

	/**
	 * Gets the name of the world
	 * @return The name
	 */
	public String getName();

	/**
	 * Gets the time of the world
	 * @return The time
	 */
	public long getTime();

	/**
	 * Sets the time of the world
	 * @param time The time
	 */
	public void setTime(long time);

	/**
	 * Gets the time of day of the world
	 * @return The time
	 */
	public long getTimeOfDay();

	/**
	 * Sets the time of day of the world
	 * @param time The time
	 */
	public void setTimeOfDay(long time);

	/**
	 * Gets the day
	 * @return The day
	 */
	public long getDay();

	/**
	 * Sets the time to the beginning of a day
	 * @param day The day
	 */
	public void setDay(long day);

	/**
	 * Gets a set of all entities in the world
	 * @return The set
	 */
	public Set<? extends Entity> getEntities();

	/**
	 * Gets a set of all players in the world
	 * @return The set
	 */
	public Set<? extends Player> getPlayers();

	/**
	 * Spawn an entity in the world
	 * @param <T>
	 * @param type The entity type
	 * @return The entity
	 */
	public Entity spawnEntity(EntityType type, Location location);

}
