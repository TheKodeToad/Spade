package me.mcblueparrot.spade;

import java.io.File;
import java.nio.file.Path;
import java.util.Set;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;

import me.mcblueparrot.spade.block.Block;
import me.mcblueparrot.spade.command.Command;
import me.mcblueparrot.spade.entity.EntityType;
import me.mcblueparrot.spade.entity.Player;
import me.mcblueparrot.spade.event.Event;
import me.mcblueparrot.spade.event.EventListener;
import me.mcblueparrot.spade.event.EventPriority;
import me.mcblueparrot.spade.item.Item;

public final class Spade {

	private static Server server;
	private static Logger logger = LogManager.getLogger();

	// Make sure nobody initialises this class
	private Spade() {}

	/**
	 * Gets the current server
	 * @return The server
	 */
	public static Server getServer() {
		return server;
	}

	/**
	 * Sets the current server
	 * @param server The server
	 * @throws IllegalStateException if the server has already been set
	 */
	public static void setServer(Server server) throws RuntimeException {
		if(Spade.server != null) {
			throw new IllegalStateException("The server has already been set - use override to override the server");
		}
		overrideServer(server);
	}

	/**
	 * Sets or overrides the current server
	 * @param server The server
	 */
	public static void overrideServer(Server server) {
		Spade.server = server;
	}

	/**
	 * Attempts to set the current server
	 * @param server The server
	 */
	public static void trySetServer(Server server) {
		try {
			setServer(server);
		}
		catch(RuntimeException e) {}
	}

	/**
	 * @see Server#getPort()
	 */
	public static int getPort() {
		return server.getPort();
	}

	/**
	 * @see Server#getIp()
	 */
	public static String getIp() {
		return server.getIp();
	}

	/**
	 * @see Server#getVersion()
	 */
	public static ServerVersion getVersion() {
		return server.getVersion();
	}

	/**
	 * @see Server#getFolder()
	 */
	public static File getFolder() {
		return server.getFolder();
	}

	/**
	 * @see Server#getPath()
	 */
	public static Path getPath() {
		return server.getPath();
	}

	/**
	 * @see Server#getPluginFolder()
	 */
	public static File getPluginFolder() {
		return server.getPluginFolder();
	}

	/**
	 * @see Server#getPluginManager()
	 */
	public static PluginManager getPluginManager() {
		return server.getPluginManager();
	}

	/**
	 * @see Server#getPlayer(UUID)
	 */
	public static Player getPlayer(UUID uuid) {
		return server.getPlayer(uuid);
	}

	/**
	 * @see Server#getPlayer(String)
	 */
	public static Player getPlayer(String username) {
		return server.getPlayer(username);
	}

	/**
	 * @see Server#getPlayers()
	 */
	public static Set<? extends Player> getPlayers() {
		return server.getPlayers();
	}

	/**
	 * @see Server#getMaxPlayers()
	 */
	public static int getMaxPlayers() {
		return server.getMaxPlayers();
	}

	/**
	 * @see Server#setMaxPlayers()
	 */
	public static void setMaxPlayers(int maxPlayers) {
		server.setMaxPlayers(maxPlayers);
	}

	/**
	 * @see Server#sendMessage(String)
	 */
	public static void sendMessage(String message) {
		server.sendMessage(message);
	}

	/**
	 * @see Server#sendMessage(String)
	 */
	public static void sendJsonMessage(JsonObject json) {
		server.sendJsonMessage(json);
	}

	/**
	 * @see Server#sendMessage(String)
	 */
	public static void sendJsonMessage(String json) {
		server.sendJsonMessage(json);
	}

	/**
	 * @see Server#getScheduler()
	 */
	public static Scheduler getScheduler() {
		return server.getScheduler();
	}

	/**
	 * @see PluginManager#callEvent(Event)
	 */
	public static <E extends Event> void callEvent(E event) {
		server.callEvent(event);
	}

	/**
	 * @see PluginManager#registerListener(Plugin, Class, EventListener)
	 */
	public static <E extends Event> void registerListener(Plugin plugin, Class<E> event, EventListener<E> listener) {
		server.registerListener(plugin, event, listener);
	}

	/**
	 * @see PluginManager#registerListener(Plugin, Class, EventListener, EventPriority)
	 */
	public static <E extends Event> void registerListener(Plugin plugin, Class<E> event, EventListener<E> listener, EventPriority priority) {
		server.registerListener(plugin, event, listener, priority);
	}

	/**
	 * Gets the logger
	 * @return The logger
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * @see Server#getBlock(String)
	 */
	public static Block getBlock(String id) {
		return server.getBlock(id);
	}

	/**
	 * @see Server#getItem(String)
	 */
	public static Item getItem(String id) {
		return server.getItem(id);
	}

	/**
	 * @see Server#getEntityType(String)
	 */
	public static EntityType getEntityType(String id) {
		return server.getEntityType(id);
	}

	/**
	 * @see PluginManager#registerCommand(Command)
	 */
	public static void registerCommand(String name, Command command) {
		server.registerCommand(name, command);
	}

}
