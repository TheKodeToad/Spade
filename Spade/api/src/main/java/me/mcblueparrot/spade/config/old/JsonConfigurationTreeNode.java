package me.mcblueparrot.spade.config.old;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonConfigurationTreeNode extends JsonConfigurationNode implements ConfigurationTreeNode {

	public JsonConfigurationTreeNode() {
		this(new JsonObject());
	}

	public JsonConfigurationTreeNode(JsonElement element) {
		super(element);
	}

	public JsonObject getJsonObject() {
		return getJsonElement().getAsJsonObject();
	}

	@Override
	public ConfigurationNode get(String name) {
		return new JsonConfigurationNode(getJsonObject().get(name));
	}

	@Override
	public void set(String name, ConfigurationNode node) {
		getJsonObject().add(name, ((JsonConfigurationNode) node).getJsonElement());
	}

	public static ConfigurationTreeNode load(String json) {
		return new JsonConfigurationTreeNode(new JsonParser().parse(json));
	}

}
