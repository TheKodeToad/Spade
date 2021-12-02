package me.mcblueparrot.spade.event.player;

import me.mcblueparrot.spade.entity.Player;

/**
 * Called when a player joins the game
 */
public class PlayerJoinEvent extends PlayerEvent {

	public PlayerJoinEvent(Player player) {
		super(player);
	}

}
