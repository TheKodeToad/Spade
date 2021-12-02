package me.mcblueparrot.spade.api.entity;

import me.mcblueparrot.spade.api.OfflinePlayer;

/**
 * Represents a player.
 */
public interface Player extends LivingEntity, Humanoid, OfflinePlayer {

	/**
	 * @throws UnsupportedOperationException players cannot be removed, use kick instead
	 */
	@Override
	public default void remove() {
		throw new UnsupportedOperationException("Cannot remove player - try using kick");
	}

	/**
	 * Disconnects/kicks the player.
	 * @param message the disconnection message
	 */
	public void disconnect(String message);

	/**
	 * Closes the screen the player has open.
	 */
	public void closeScreen();

	/**
	 * Gets the player's ping.
	 * @return the ping
	 */
	public int getPing();

	/**
	 * @return <code>true</code>
	 */
	@Override
	public default boolean isOnline() {
		return true;
	}

}
