package me.mcblueparrot.spade.api.command;

import me.mcblueparrot.spade.api.Spade;

public interface CommandSender {

	/**
	 * Sends a message to the command sender.
	 * @param message the message.
	 */
	public void sendMessage(String message);

	/**
	 * Sends multiple messages to the command sender.
	 * @param messages the messages.
	 */
	public default void sendMessage(String... messages) {
		for(String message : messages) {
			sendMessage(message);
		}
	}

	/**
	 * Executes a command as the command sender.
	 * @param command the command
	 */
	public default void executeCommand(String command) {
		Spade.dispatchCommand(this, command);
	}

}
