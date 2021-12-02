package me.mcblueparrot.spade.event.player;

import me.mcblueparrot.spade.entity.Player;
import me.mcblueparrot.spade.event.Event;

public abstract class PlayerEvent implements Event {

	private Player player;

	public PlayerEvent(Player player) {
		this.player = player;
	}

	/**
	 * Gets the player involved in this event
	 * @return The player
	 */
	public Player getPlayer() {
		return player;
	}

}
