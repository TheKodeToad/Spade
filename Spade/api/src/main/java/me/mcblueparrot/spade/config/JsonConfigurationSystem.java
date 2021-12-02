package me.mcblueparrot.spade.config;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * A configuration system using JSON
 */
public class JsonConfigurationSystem implements ConfigurationSystem {

	private Gson gson;

	public JsonConfigurationSystem() {
		gson = new GsonBuilder().setPrettyPrinting().create();
	}

	@Override
	public Configuration load(String data) {
		return new Configuration(gson.fromJson(data, Map.class));
	}

	@Override
	public String save(Configuration configuration) {
		return gson.toJson(configuration.getMap());
	}

	@Override
	public String getExtension() {
		return "json";
	}

}
