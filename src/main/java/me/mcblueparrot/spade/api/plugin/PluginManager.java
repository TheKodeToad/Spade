package me.mcblueparrot.spade.api.plugin;

import java.io.File;
import java.util.List;

import me.mcblueparrot.spade.api.plugin.loader.PluginLoader;

/**
 * Represents a plugin manager.
 */
public interface PluginManager {

	/**
	 * Gets a list of plugin loaders, in order of priority.
	 * @return the list
	 */
	public List<PluginLoader> getLoaders();

	/**
	 * Adds a plugin loader.
	 * @param loader the loader
	 */
	public void addLoader(PluginLoader loader);

	/**
	 * Removes a plugin loader.
	 * @param loader the loader
	 */
	public void removeLoader(PluginLoader loader);

	/**
	 * Loads all plugins in the plugins folder.
	 */
	public void load();

	/**
	 * Loads a plugin from its file.
	 * @param file the file
	 */
	public void load(File file);

	/**
	 * Gets a list of loaded plugins.
	 * @return the list
	 */
	public List<Plugin> getPlugins();

	/**
	 * Enables all loaded plugins.
	 */
	public void enable();

	/**
	 * Enables a plugin.
	 * @param plugin the plugin
	 */
	public void enable(Plugin plugin);

	/**
	 * Disables all loaded plugins.
	 */
	public void disable();

	/**
	 * Disables a plugin.
	 * @param plugin the plugin
	 */
	public void disable(Plugin plugin);

	/**
	 * Reloads all plugins.
	 */
	public default void reload() {
		disable();
		load();
		enable();
	}

}
