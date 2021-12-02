package me.mcblueparrot.spade;

import java.io.File;
import java.nio.file.Path;
import java.util.Set;
import java.util.UUID;

import me.mcblueparrot.spade.block.Block;
import me.mcblueparrot.spade.command.Command;
import me.mcblueparrot.spade.entity.EntityType;
import me.mcblueparrot.spade.entity.Player;
import me.mcblueparrot.spade.event.Event;
import me.mcblueparrot.spade.event.EventListener;
import me.mcblueparrot.spade.event.EventPriority;
import me.mcblueparrot.spade.item.Item;

/**
 * Represents a server
 */
public interface Server extends CommandSender {

	/**
	 * @see Spade#getServer()
	 */
	public static Server getInstance() {
		return Spade.getServer();
	}

	/**
	 * Gets the server's port number
	 * @return The port number
	 */
	public int getPort();

	/**
	 * Gets the server's ip
	 * @return The ip
	 */
	public String getIp();

	/**
	 * Gets the server's version
	 * @return The version
	 */
	public ServerVersion getVersion();

	/**
	 * Gets the folder the server in running in
	 * @return The folder
	 */
	public File getFolder();

	/**
	 * Gets the path the server is running in
	 * @return The path
	 */
	public default Path getPath() {
		return getFolder().toPath();
	}

	/**
	 * Gets the folder which plugins are installed in
	 * @return The folder
	 */
	public File getPluginFolder();

	/**
	 * Gets the plugin manager
	 * @return The plugin manager
	 */
	public PluginManager getPluginManager();

	/**
	 * Gets a player by their UUID
	 * @param uuid The UUID
	 * @return The player, or null if they're not online
	 */
	public Player getPlayer(UUID uuid);

	/**
	 * Gets a player by their username
	 * @param username The username
	 * @return The player, or null if they're not online
	 */
	public Player getPlayer(String username);

	/**
	 * Gets a list of all online players
	 * @return The list
	 */
	public Set<? extends Player> getPlayers();

	/**
	 * Gets the maximum amount of players allowed on the server
	 * @return The maximum amount of players
	 */
	public int getMaxPlayers();

	/**
	 * Sets the maximum amount of players allowed on the server
	 * <p>WARNING: may not be allowed on some servers</p>
	 * @param maxPlayers The maximum amount of players
	 */
	public void setMaxPlayers(int maxPlayers);

	/**
	 * Gets the server's scheduler
	 * @return The scheduler
	 */
	public Scheduler getScheduler();

	/**
	 * Gets a block by its id
	 * @param id The id
	 * @return The block
	 */
	public Block getBlock(String id);

	/**
	 * Gets a item by its id
	 * @param id The id
	 * @return The item
	 */
	public Item getItem(String id);

	/**
	 * Gets an entity type by its id
	 * @param id The id
	 * @return The entity type
	 */
	public EntityType getEntityType(String id);

	/**
	 * @see PluginManager#registerCommand(Command)
	 */
	public default void registerCommand(String name, Command command) {
		getPluginManager().registerCommand(name, command);
	}

	/**
	 * @see PluginManager#callEvent(Event)
	 */
	public default <E extends Event> void callEvent(E event) {
		getPluginManager().callEvent(event);
	}

	/**
	 * @see PluginManager#registerListener(Plugin, Class, EventListener)
	 */
	public default <E extends Event> void registerListener(Plugin plugin, Class<E> event, EventListener<E> listener) {
		getPluginManager().registerListener(plugin, event, listener);
	}

	/**
	 * @see PluginManager#registerListener(Plugin, Class, EventListener, EventPriority)
	 */
	public default <E extends Event> void registerListener(Plugin plugin, Class<E> event, EventListener<E> listener, EventPriority priority) {
		getPluginManager().registerListener(plugin, event, listener, priority);
	}

}
