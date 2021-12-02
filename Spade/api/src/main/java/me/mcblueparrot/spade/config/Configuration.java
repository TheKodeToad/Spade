package me.mcblueparrot.spade.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * Represents a configuration
 * <p>(inspired by bungeecord's system)</p>
 */
public class Configuration {

	private Map<String, Object> data;

	/**
	 * Creates an empty configuration
	 */
	public Configuration() {
		this(new HashMap<String, Object>());
	}

	/**
	 * Creates a configuration
	 * @param map The map to use
	 */
	public Configuration(Map<?, ?> map) {
		data = new HashMap<String, Object>();
		map.forEach((key, value) -> {
			if(value instanceof Map) {
				data.put(String.valueOf(key), new Configuration((Map<?, ?>) value));
			}
			else {
				data.put(String.valueOf(key), value);
			}
		});
	}

	/**
	 * Gets a section of the configuration
	 * @param key The key of the section
	 * @return The section, or null if the key's value is not a section
	 */
	public Configuration getSection(String key) {
		Object sectionObj = data.get(key);
		if(sectionObj == null) {
			Configuration configuration = new Configuration();
			data.put(key, configuration);
			return configuration;
		}
		else if(sectionObj instanceof Configuration) {
			return (Configuration) sectionObj;
		}
		return null;
	}

	/**
	 * Sets the value of a key
	 * @param key The key
	 * @param value The value
	 */
	public void set(String key, Object value) {
		if(value instanceof Map) {
			value = new Configuration((Map<?, ?>) value);
		}
		data.put(key, value);
	}

	/**
	 * Gets the value of a key
	 * @param key The key
	 * @return The value
	 */
	public Object get(String key) {
		return data.get(key);
	}

	/**
	 * Gets the value of a key as a byte
	 * @param key The key
	 * @return The value
	 */
	public byte getByte(String key) {
		return (byte) get(key);
	}

	/**
	 * Gets the value of a key as a short
	 * @param key The key
	 * @return The value
	 */
	public short getShort(String key) {
		return (short) get(key);
	}

	/**
	 * Gets the value of a key as an integer
	 * @param key The key
	 * @return The value
	 */
	public int getInt(String key) {
		return (int) get(key);
	}

	/**
	 * Gets the value of a key as a long
	 * @param key The key
	 * @return The value
	 */
	public long getLong(String key) {
		return (long) get(key);
	}

	/**
	 * Gets the value of a key as a float
	 * @param key The key
	 * @return The value
	 */
	public float getFloat(String key) {
		return (float) get(key);
	}

	/**
	 * Gets the value of a key as a double
	 * @param key The key
	 * @return The value
	 */
	public double getDouble(String key) {
		return (double) get(key);
	}

	/**
	 * Gets the value of a key as a boolean
	 * @param key The key
	 * @return The value
	 */
	public boolean getBoolean(String key) {
		return (boolean) get(key);
	}

	/**
	 * Gets the value of a key as a character
	 * @param key The key
	 * @return The value
	 */
	public char getChar(String key) {
		return (char) get(key);
	}

	/**
	 * Gets the value of a key as a string
	 * @param key The key
	 * @return The value
	 */
	public String getString(String key) {
		Object value = get(key);
		if(value == null) {
			return null;
		}
		return value instanceof String ? (String) value : value.toString();
	}

	/**
	 * Gets a value of a key as a list
	 * @param key The key
	 * @return The value
	 */
	public List<?> getList(String key) {
		return (List<?>) get(key);
	}

	/**
	 * Gets the list of keys of the configuration
	 * @return The list
	 */
	public Set<String> getKeys() {
		return data.keySet();
	}

	/**
	 * Gets the list of values of the configuration
	 * @return The list
	 */
	public Collection<Object> getValues() {
		return data.values();
	}

	/**
	 * Iterates over the keys and values of the configuration
	 * @param action The action to be performed
	 */
	public void forEach(BiConsumer<String, ? super Object> action) {
		data.forEach(action);
	}

	/**
	 * Gets the configuration's map
	 * @return The map
	 */
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		forEach((key, value) -> {
			if(value instanceof Configuration) {
				map.put(key, ((Configuration) value).getMap());
			}
			else {
				map.put(key, value);
			}
		});
		return map;
	}

}
