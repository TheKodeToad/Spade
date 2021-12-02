package me.mcblueparrot.spade.api.config.system;

import java.io.Reader;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import me.mcblueparrot.spade.api.config.Configuration;

/**
 * Represents a configuration system for JSON.
 */
public class JsonConfigurationSystem extends ConfigurationSystem {

	private Gson gson;

	/**
	 * Creates a JSON configuration system with default settings.
	 */
	public JsonConfigurationSystem() {
		super("json");
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}

	/**
	 * Creates a JSON configuration system.
	 * @param gson the {@link Gson} to use
	 */
	public JsonConfigurationSystem(Gson gson) {
		super("json");
		this.gson = gson;
	}

	@Override
	public Configuration load(Reader reader) {
		return new Configuration(gson.fromJson(reader, Map.class));
	}

	@Override
	public String save(Configuration config) {
		return gson.toJson(config.getMap());
	}

}
