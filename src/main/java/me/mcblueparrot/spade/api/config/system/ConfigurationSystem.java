package me.mcblueparrot.spade.api.config.system;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import me.mcblueparrot.spade.api.config.Configuration;

/**
 * Represents a configuration system.
 */
public abstract class ConfigurationSystem {

	private String extension;

	public ConfigurationSystem(String extension) {
		this.extension = extension;
	}

	/**
	 * Gets the default file extension for the configuration system.
	 * @return the file extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * Loads a configuration from a reader.
	 * @param input the reader
	 * @return the configuration
	 */
	public abstract Configuration load(Reader reader);

	/**
	 * Loads a configuration from a string.
	 * @param input the string
	 * @return the configuration
	 * @throws IOException
	 */
	public Configuration load(String input) throws IOException {
		return load(input, StandardCharsets.UTF_8);
	}

	/**
	 * Loads a configuration from a string.
	 * @param input the string
	 * @param charset the encoding
	 * @return the configuration
	 * @throws IOException
	 */
	public Configuration load(String input, Charset charset) throws IOException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(charset));
		InputStreamReader reader = new InputStreamReader(inputStream, charset);
		Configuration config = load(reader);
		reader.close();
		inputStream.close();
		return config;
	}


	/**
	 * Loads a configuration from a file.
	 * @param file the file
	 * @return the configuration
	 * @throws IOException
	 */
	public Configuration load(File file) throws IOException {
		return load(file, StandardCharsets.UTF_8);
	}

	/**
	 * Loads a configuration from a file.
	 * @param file the file
	 * @param charset the encoding
	 * @return the configuration
	 * @throws IOException
	 */
	public Configuration load(File file, Charset charset) throws IOException {
		FileInputStream input = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(input, charset);
		Configuration config = load(reader);
		reader.close();
		input.close();
		return config;
	}

	/**
	 * Saves the configuration to a string.
	 * @return the string
	 * @throws IOException
	 */
	public abstract String save(Configuration config);

	/**
	 * Saves the configuration to a writer.
	 * @param writer the writer
	 * @throws IOException
	 */
	public void save(Configuration config, Writer writer) throws IOException {
		writer.append(save(config));
	}

	/**
	 * Saves the configuration to a file.
	 * @param file the file
	 * @throws IOException
	 */
	public void save(Configuration config, File file) throws IOException {
		save(config, file, StandardCharsets.UTF_8);
	}

	/**
	 * Saves the configuration to a file.
	 * @param file the file
	 * @param charset the encoding
	 * @throws IOException
	 */
	public void save(Configuration config, File file, Charset charset) throws IOException {
		FileUtils.writeStringToFile(file, save(config),charset);
	}

	/**
	 * Gets the default configuration system.
	 * @return {@link ConfigurationSystem#YAML}
	 */
	public static ConfigurationSystem getDefault() {
		return YAML;
	}

	/**
	 * The JSON configuration system with default settings.
	 */
	public static final ConfigurationSystem JSON = new JsonConfigurationSystem();
	/**
	 * The YAML configuration system with default settings.
	 */
	public static final ConfigurationSystem YAML = new YamlConfigurationSystem();

}
