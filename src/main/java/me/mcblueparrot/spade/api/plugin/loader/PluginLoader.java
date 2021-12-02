package me.mcblueparrot.spade.api.plugin.loader;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

import me.mcblueparrot.spade.api.plugin.Plugin;

/**
 * Represents a plugin loader.
 */
public interface PluginLoader extends Closeable {

	/**
	 * Loads a plugin from a file.
	 * @param file the file
	 * @return the plugin, or <code>null</code> if the plugin is not applicable (the loader doesn't recognise the plugin as its format)
	 * @throws IOException
	 * @throws PluginLoadException if there is an error that occurs after that plugin is recognised
	 */
	public Plugin loadPlugin(File file) throws IOException, PluginLoadException;

	/**
	 * Closes the plugin loader
	 */
	@Override
	public void close() throws IOException;

	/**
	 * Gets the plugin loader's name.
	 * @return the name
	 */
	public String getName();

}
