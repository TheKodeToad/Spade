package me.mcblueparrot.spade.event.player;

import java.util.IllegalFormatException;
import java.util.Set;

import me.mcblueparrot.spade.entity.Player;
import me.mcblueparrot.spade.event.CancellableEvent;

/**
 * Called when a player chats
 */
public class PlayerChatEvent extends PlayerEvent implements CancellableEvent {

	private String message;
	private Set<? extends Player> recipients;
	private String format = "<%s> %s";
	private boolean cancelled;
	private boolean visible = true;
	private String displayName;

	public PlayerChatEvent(Player player, String message, Set<? extends Player> recipients) {
		super(player);
		this.message = message;
		this.recipients = recipients;
		displayName = player.getName();
	}

	/**
	 * Gets the message
	 * @return The message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message
	 * @param message The message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the format of the message
	 * @return The format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Sets the format of the message. By default it is <code><%s> %s</code>
	 * @param format The format
	 * @throws IllegalFormatException
	 */
	public void setFormat(String format) throws IllegalFormatException {
		String.format(format, getPlayer().getName(), message);
		this.format = format;
	}

	/**
	 * Gets a set of all players that will receive the message
	 * @return The set
	 */
	public Set<? extends Player> getRecipients() {
		return recipients;
	}

	/**
	 * Gets the sender of this message
	 * @see PlayerEvent#getPlayer()
	 * @return The sender
	 */
	public Player getSender() {
		return getPlayer();
	}

	/**
	 * Sets whether the message will be sent by the server. This allows you to manually send the message
	 * @param visible Whether the message will be sent by the server
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * Gets whether the message will be sent by the server
	 * @return Whether the message will be sent by the server
	 */
	public boolean isVisible() {
		return visible;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	/**
	 * Gets the name used in the message
	 * @return The name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the name used in the message
	 * @param name The name
	 */
	public void setDisplayName(String name) {
		displayName = name;
	}

}
