package me.mcblueparrot.spade;

import java.io.File;
import java.util.List;

import me.mcblueparrot.spade.command.Command;
import me.mcblueparrot.spade.event.Event;
import me.mcblueparrot.spade.event.EventListener;
import me.mcblueparrot.spade.event.EventPriority;

/**
 * Handles plugin management
 */
public interface PluginManager {

	/**
	 * @see Server#getPluginManager()
	 */
	public static PluginManager getInstance() {
		return Spade.getPluginManager();
	}

	/**
	 * Loads all plugins in the plugins folder and enables them
	 */
	public void enable();

	/**
	 * Enables a specific plugin
	 * @param plugin The plugin
	 */
	public void enable(Plugin plugin);

	/**
	 * Loads all plugins in the plugins folder ({@link Spade#getPluginFolder()}) without enabling them
	 */
	public void load();

	/**
	 * Loads a specific plugin
	 * @param pluginFile The plugin's jar file
	 */
	public void load(File pluginFile);

	/**
	 * Disables and unloads all plugins
	 */
	public void disable();

	/**
	 * Disables a specific plugin
	 * @param plugin The plugin
	 */
	public void disable(Plugin plugin);

	/**
	 * Unloads all loaded plugins
	 */
	public void unload();

	/**
	 * Unloads a specific plugin
	 * @param plugin The plugin
	 */
	public void unload(Plugin plugin);

	/**
	 * Gets a list of all loaded plugins
	 * @return The list
	 */
	public List<Plugin> getPlugins();

	/**
	 * Registers an event listener
	 * @param <E>
	 * @param plugin The plugin
	 * @param event The event's class
	 * @param listener The listener
	 * @param priority The listener's priority
	 */
	public <E extends Event> void registerListener(Plugin plugin, Class<E> event, EventListener<E> listener, EventPriority priority);

	/**
	 * Registers an event listener
	 * @param <E>
	 * @param event The event's class
	 * @param plugin The plugin
	 * @param listener The listener
	 */
	public default <E extends Event> void registerListener(Plugin plugin, Class<E> event, EventListener<E> listener) {
		registerListener(plugin, event, listener, EventPriority.NORMAL);
	}

	/**
	 * Unregisters an event listener
	 * @param plugin The plugin
	 * @param listener The listener
	 */
	public void unregisterListener(Plugin plugin, EventListener<?> listener);

	/**
	 * Gets the listeners for a plugin
	 * @param plugin The plugin
	 * @return
	 */
	public List<EventListener<?>> getListeners(Plugin plugin);

	/**
	 * Calls an event
	 * @param <E>
	 * @param event The event
	 */
	public <E extends Event> void callEvent(E event);

	/**
	 * Reloads all plugins
	 */
	public default void reload() {
		disable();
		enable();
	}

	/**
	 * Registers a command
	 * @param name The name of the command
	 * @param command The command
	 */
	public void registerCommand(String name, Command command);

}
