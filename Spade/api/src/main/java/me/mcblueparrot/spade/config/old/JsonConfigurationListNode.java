package me.mcblueparrot.spade.config.old;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class JsonConfigurationListNode extends JsonConfigurationNode implements ConfigurationListNode {

	public JsonConfigurationListNode() {
		this(new JsonArray());
	}

	public JsonConfigurationListNode(JsonElement element) {
		super(element);
	}

	public JsonArray getJsonArray() {
		return getJsonElement().getAsJsonArray();
	}

	@Override
	public ConfigurationNode get(int index) {
		return new JsonConfigurationNode(getJsonArray().get(index));
	}

	@Override
	public void set(int index, ConfigurationNode node) {
		getJsonArray().set(index, ((JsonConfigurationNode) node).getJsonElement());
	}

}
