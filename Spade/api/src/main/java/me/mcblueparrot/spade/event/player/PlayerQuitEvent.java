package me.mcblueparrot.spade.event.player;

import me.mcblueparrot.spade.entity.Player;

/**
 * Called when a player leaves the game
 */
public class PlayerQuitEvent extends PlayerEvent {

	public PlayerQuitEvent(Player player) {
		super(player);
	}

}
