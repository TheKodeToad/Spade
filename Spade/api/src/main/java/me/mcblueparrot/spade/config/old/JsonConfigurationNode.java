package me.mcblueparrot.spade.config.old;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class JsonConfigurationNode implements ConfigurationNode {

	private JsonElement element;

	public JsonConfigurationNode(String value) {
		this(new JsonPrimitive(value));
	}

	public JsonConfigurationNode(Number value) {
		this(new JsonPrimitive(value));
	}

	public JsonConfigurationNode(Character value) {
		this(new JsonPrimitive(value));
	}

	public JsonConfigurationNode(Boolean value) {
		this(new JsonPrimitive(value));
	}

	public JsonConfigurationNode(JsonElement element) {
		this.element = element;
	}

	public JsonElement getJsonElement() {
		return element;
	}

	@Override
	public Object getValue() {
		if(element.isJsonNull()) {
			return null;
		}
		else if(element.isJsonObject()) {
			return new JsonConfigurationTreeNode(element);
		}
		else if(element.isJsonArray()) {
			return new JsonConfigurationListNode(element);
		}
		else if(element.isJsonPrimitive()) {
			if(element.getAsJsonPrimitive().isString()) {
				return element.getAsString();
			}
			else if(element.getAsJsonPrimitive().isNumber()) {
				return element.getAsNumber();
			}
			else if(element.getAsJsonPrimitive().isBoolean()) {
				return element.getAsBoolean();
			}
			return null;
		}
		return null;
	}

	@Override
	public byte toByte() {
		return element.getAsByte();
	}

	@Override
	public short toShort() {
		return element.getAsShort();
	}

	@Override
	public int toInt() {
		return element.getAsInt();
	}

	@Override
	public long toLong() {
		return element.getAsLong();
	}

	@Override
	public float toFloat() {
		return element.getAsFloat();
	}

	@Override
	public double toDouble() {
		return element.getAsDouble();
	}

	@Override
	public boolean toBoolean() {
		return element.getAsBoolean();
	}

	@Override
	public char toChar() {
		return element.getAsCharacter();
	}

	@Override
	public ConfigurationTreeNode toTree() {
		return new JsonConfigurationTreeNode(element);
	}

	@Override
	public ConfigurationListNode toList() {
		return new JsonConfigurationListNode(element);
	}

	@Override
	public ConfigurationTreeNode createTreeNode() {
		return new JsonConfigurationTreeNode();
	}

	@Override
	public ConfigurationListNode createListNode() {
		return new JsonConfigurationListNode();
	}

	@Override
	public ConfigurationNode createNode(String value) {
		return new JsonConfigurationNode(value);
	}

	@Override
	public ConfigurationNode createNode(Number value) {
		return new JsonConfigurationNode(value);
	}

	@Override
	public ConfigurationNode createNode(Boolean value) {
		return new JsonConfigurationNode(value);
	}

	@Override
	public ConfigurationNode createNode(Character value) {
		return new JsonConfigurationNode(value);
	}

	@Override
	public String toString() {
		return getJsonElement().toString();
	}

}
