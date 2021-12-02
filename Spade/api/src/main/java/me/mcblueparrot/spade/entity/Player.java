package me.mcblueparrot.spade.entity;

import java.util.UUID;

import me.mcblueparrot.spade.CommandSender;
import me.mcblueparrot.spade.Server;
import me.mcblueparrot.spade.Spade;
import me.mcblueparrot.spade.inventory.Inventory;

/**
 * Represents a player entity
 */
public interface Player extends LivingEntity, CommandSender {

	/**
	 * @see Server#getPlayer(UUID)
	 */
	public static Player get(UUID uuid) {
		return Spade.getPlayer(uuid);
	}

	/**
	 * @see Server#getPlayer(String)
	 */
	public static Player get(String username) {
		return Spade.getPlayer(username);
	}

	/**
	 * Kicks the player
	 * @param message The message to display
	 */
	public void kick(String message);

	/**
	 * Sets whether the player can fly
	 * @param allowFlight Whether the player can fly
	 */
	public void setAllowFlight(boolean allowFlight);

	/**
	 * Gets whether the player can fly
	 * @return Whether the player can fly
	 */
	public boolean getAllowFlight();

	/**
	 * Gets the UUID of the player's profile
	 * @return The UUID
	 */
	@Override
	public UUID getUUID();

	/**
	 * Gets the username of the player's profile
	 * @return The username
	 */
	@Override
	public String getName();

	/**
	 * Gets the player's inventory
	 * @return The inventory
	 */
	public Inventory getInventory();

}
