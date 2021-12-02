package me.mcblueparrot.spade;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonSyntaxException;

import me.mcblueparrot.spade.config.Configuration;
import me.mcblueparrot.spade.config.ConfigurationSystem;

/**
 * Represents a plugin
 */
public abstract class Plugin {

	private Configuration config = new Configuration();
	private Configuration description;

	@Override
	public String toString() {
		return getName() + " " + getVersion();
	}

	/**
	 * Invoked when the plugin is enabled
	 * This will happen after the worlds are loaded
	 */
	public void onEnable() {}

	/**
	 * Invoked when the plugin is disabled
	 * This will happen as the server shuts down
	 */
	public void onDisable() {}

	/**
	 * Gets the plugin's configuration
	 * @return The configuration
	 */
	public Configuration getConfig() {
		return config;
	}

	/**
	 * Loads the configuration file into a {@link Configuration} which can be obtained using {@link Plugin#getConfig()}
	 * @param encoding The encoding to use
	 * @throws JsonSyntaxException
	 * @throws IOException
	 */
	public void loadConfig(Charset encoding) throws JsonSyntaxException, IOException {
		config = getConfigSystem().load(getConfigFile(), encoding);
	}

	/**
	 * Loads the configuration file into a {@link Configuration} which can be obtained using {@link Plugin#getConfig()}
	 */
	public void loadConfig() throws JsonSyntaxException, IOException {
		loadConfig(StandardCharsets.UTF_8);
	}

	/**
	 * Saves the configuration file
	 * @param encoding The encoding to use
	 * @throws IOException
	 */
	public void saveConfig(Charset encoding) throws IOException {
		if(!getDataFolder().exists()) {
			getDataFolder().mkdirs();
		}
		getConfigSystem().save(config, getConfigFile(), encoding);
	}

	/**
	 * Saves the configuration file
	 * @throws IOException
	 */
	public void saveConfig() throws IOException {
		saveConfig(StandardCharsets.UTF_8);
	}

	/**
	 * Gets the plugin's data folder
	 * @return The folder
	 */
	public File getDataFolder() {
		return new File(Spade.getPluginFolder(), getName());
	}

	/**
	 * Sets the plugin's description
	 * @param description The description
	 * @throws IllegalStateException if the description has already been set
	 */
	public void setDescription(Configuration description) {
		if(this.description != null) {
			throw new IllegalStateException("The description has already been set");
		}
		this.description = description;
	}

	/**
	 * Gets the plugin's description
	 * @return The description
	 */
	public Configuration getDescription() {
		return description;
	}

	/**
	 * Gets the name of the plugin
	 * @return The name
	 */
	public String getName() {
		return getDescription().getString("name");
	}

	/**
	 * Gets the version of the plugin
	 * @return The version
	 */
	public String getVersion() {
		return getDescription().getString("version");
	}

	/**
	 * Gets the configuration file
	 * @return The file
	 */
	public File getConfigFile() {
		return new File(getDataFolder(), "config." + getConfigSystem().getExtension());
	}

	/**
	 * Saves the default configuration file
	 * @throws IOException
	 */
	public void saveDefaultConfig() throws IOException {
		if(!getConfigFile().exists()) {
			try(FileOutputStream output = new FileOutputStream(getConfigFile())){
				IOUtils.copy(getClass().getClassLoader().getResourceAsStream("config." + getConfigSystem().getExtension()), output);
			}
		}
		loadConfig();
	}

	/**
	 * Gets the plugin's logger
	 * @return The logger
	 */
	public Logger getLogger() {
		return LogManager.getLogger();
	}

	/**
	 * Gets the configuration system used by the plugin
	 * Override to customise
	 * @return The configuration system
	 */
	public ConfigurationSystem getConfigSystem() {
		return ConfigurationSystem.getDefault();
	}

}
