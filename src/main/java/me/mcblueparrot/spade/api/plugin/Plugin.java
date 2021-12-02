package me.mcblueparrot.spade.api.plugin;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.mcblueparrot.spade.api.config.Configuration;
import me.mcblueparrot.spade.api.plugin.loader.PluginLoadException;

/**
 * Represents a plugin.
 */
public abstract class Plugin {

	private Configuration description;
	private Logger logger;

	/**
	 * Invoked after the plugin is enabled.
	 */
	public void onEnable() {}

	/**
	 * Invoked after the plugin is disabled.
	 */
	public void onDisable() {}

	/**
	 * Gets the plugin's description.
	 * @return the plugin's description
	 */
	public Configuration getDescription() {
		return description;
	}

	/**
	 * Sets the plugin's description.
	 * @param description the plugin's description
	 * @return <code>true</code> if the description was set, <code>false</code> otherwise
	 */
	public boolean setDescription(Configuration description) {
		if(this.description != null) {
			return false;
		}
		if(!description.containsKey("name")) {
			throw new PluginLoadException("No plugin name specified");
		}
		if(!description.containsKey("version")) {
			throw new PluginLoadException("No plugin version specified");
		}
		this.description = description;
		logger = LogManager.getLogger(getName());
		return true;
	}

	/**
	 * Gets the plugin's name.
	 * @return the plugin's name
	 */
	public String getName() {
		return description.getString("name");
	}

	/**
	 * Gets the plugin's version.
	 * @return the plugin's version
	 */
	public String getVersion() {
		return description.getString("version");
	}

	/**
	 * Gets the plugin's logger.
	 * @return the plugin's logger
	 */
	public Logger getLogger() {
		return logger;
	}

	@Override
	public String toString() {
		return getName() + " " + getVersion();
	}

	@Override
	public int hashCode() {
		return Objects.hash(description);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Plugin other = (Plugin) obj;
		return Objects.equals(description, other.description);
	}

}
