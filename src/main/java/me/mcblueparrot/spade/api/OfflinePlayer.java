package me.mcblueparrot.spade.api;

import java.util.Date;
import java.util.UUID;

import me.mcblueparrot.spade.api.entity.Player;
import me.mcblueparrot.spade.api.world.Location;

/**
 * Represents a player that is not necessarily online.
 */
public interface OfflinePlayer {

	/**
	 * Gets the player's UUID.
	 * @return the UUID
	 */
	public UUID getUniqueId();

	/**
	 * Gets if the player is banned.
	 * @return if the player is banned
	 */
	public boolean isBanned();

	/**
	 * Gets if the player is whitelisted.
	 * @return if the player is whitelisted
	 */
	public boolean isWhitelisted();

	/**
	 * Sets if the player is whitelisted.
	 * @param whitelisted if the player is whitelisted
	 */
	public void setWhitelisted(boolean whitelisted);

	/**
	 * Gets if the player is online.
	 * @return if the player is online
	 */
	public boolean isOnline();

	/**
	 * Gets the time on which the player joined for the first time.
	 * @return the time
	 */
	public Date getFirstPlayed();

	/**
	 * Gets the time on which the player last joined.
	 * @return the time
	 */
	public Date getLastPlayed();

	/**
	 * Gets if the player has played before.
	 * @return if the player has player before
	 */
	public boolean hasPlayedBefore();

	/**
	 * If online, get the online version of the player.
	 * @return the online player
	 */
	public Player getOnlinePlayer();

	/**
	 * Gets the location of the bed the player last slept in.
	 * @return the location, or <code>null</code> if the bed is missing.
	 */
	public Location getBedLocation();

}
