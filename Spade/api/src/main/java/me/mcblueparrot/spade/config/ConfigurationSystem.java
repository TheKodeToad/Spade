package me.mcblueparrot.spade.config;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public interface ConfigurationSystem {

	/**
	 * Gets the default configuration system
	 * @return <code>ConfigurationSystem.JSON</code>
	 */
	public static ConfigurationSystem getDefault() {
		return YAML;
	}

	public static final ConfigurationSystem JSON = new JsonConfigurationSystem();
	public static final ConfigurationSystem YAML = new YamlConfigurationSystem();

	/**
	 * Loads a configuration from a file
	 * @param file The file
	 * @return The configuration
	 * @throws IOException
	 */
	public default Configuration load(File file) throws IOException {
		return load(file, StandardCharsets.UTF_8);
	}

	/**
	 * Loads a configuration from a file
	 * @param file The file
	 * @param encoding The encoding
	 * @return The configuration
	 * @throws IOException
	 */
	public default Configuration load(File file, Charset encoding) throws IOException {
		return load(FileUtils.readFileToString(file, encoding));
	}

	/**
	 * Loads a configuration from a string
	 * @param data The string
	 * @return The configuration
	 */
	public Configuration load(String data);

	/**
	 * Saves a configuration to a string
	 * @param configuration The configuration
	 * @return The string
	 */
	public String save(Configuration configuration);

	/**
	 * Saves a configuration to a file
	 * @param configuration The configuration
	 * @param file The file
	 * @throws IOException
	 */
	public default void save(Configuration configuration, File file) throws IOException {
		save(configuration, file, StandardCharsets.UTF_8);
	}

	/**
	 * Saves a configuration to a file
	 * @param configuration The configuration
	 * @param file The file
	 * @param encoding The encoding
	 * @throws IOException
	 */
	public default void save(Configuration configuration, File file, Charset encoding) throws IOException {
		FileUtils.writeStringToFile(file, save(configuration), encoding);
	}

	/**
	 * Gets the configuration system's file extension
	 * @return The file extension
	 */
	public String getExtension();

}
