package me.mcblueparrot.spade;

import com.google.gson.JsonObject;

import net.md_5.bungee.api.chat.BaseComponent;

/**
 * Represents anything that can send commands
 */
public interface CommandSender {

	/**
	 * Sends a message
	 * @param message The message to send as a string
	 */
	public void sendMessage(String message);

	/**
	 * Sends a message
	 * @param message The message to send
	 */
	public void sendMessage(BaseComponent message);

	/**
	 * Sends a JSON message
	 * @param json The message to send as a JSON object
	 */
	public default void sendJsonMessage(JsonObject json) {
		sendJsonMessage(json.toString());
	}

	/**
	 * Sends a JSON message
	 * @param json The message to send as a JSON string
	 */
	public void sendJsonMessage(String json);

	/**
	 * Gets whether the sender is an operator
	 * @return Whether the sender is an operator
	 */
	public boolean isOperator();

	/**
	 * Gets whether the sender is the server console
	 * @return Whether the sender is the server console
	 */
	public default boolean isConsole() {
		return false;
	}

}
