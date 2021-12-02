package me.mcblueparrot.spade.api.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * Represents a configuration (inspired by BungeeCord).
 */
public class Configuration {

	private Map<String, Object> data;

	/**
	 * Creates an empty configuration.
	 */
	public Configuration() {
		this(new HashMap<String, Object>());
	}

	/**
	 * Creates a configuration.
	 * @param map the map to use
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
	 * Gets a section of the configuration.
	 * @param key the key of the section
	 * @return the section, or null if the key's value is not a section
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
	 * Sets the value of a key.
	 * @param key the key
	 * @param value the value
	 */
	public void set(String key, Object value) {
		if(value instanceof Map) {
			value = new Configuration((Map<?, ?>) value);
		}
		data.put(key, value);
	}

	/**
	 * Gets the value of a key.
	 * @param key the key
	 * @return the value
	 */
	public Object get(String key) {
		return data.get(key);
	}

	/**
	 * Gets the value of a key as a byte.
	 * @param key the key
	 * @return the value
	 */
	public byte getByte(String key) {
		return (byte) get(key);
	}

	/**
	 * Gets the value of a key as a short.
	 * @param key the key
	 * @return the value
	 */
	public short getShort(String key) {
		return (short) get(key);
	}

	/**
	 * Gets the value of a key as an integer.
	 * @param key the key
	 * @return the value
	 */
	public int getInt(String key) {
		return (int) get(key);
	}

	/**
	 * Gets the value of a key as a long.
	 * @param key the key
	 * @return the value
	 */
	public long getLong(String key) {
		return (long) get(key);
	}

	/**
	 * Gets the value of a key as a float.
	 * @param key the key
	 * @return the value
	 */
	public float getFloat(String key) {
		return (float) get(key);
	}

	/**
	 * Gets the value of a key as a double.
	 * @param key the key
	 * @return the value
	 */
	public double getDouble(String key) {
		return (double) get(key);
	}

	/**
	 * Gets the value of a key as a boolean.
	 * @param key the key
	 * @return the value
	 */
	public boolean getBoolean(String key) {
		return (boolean) get(key);
	}

	/**
	 * Gets the value of a key as a character.
	 * @param key the key
	 * @return the value
	 */
	public char getChar(String key) {
		return (char) get(key);
	}

	/**
	 * Gets the value of a key as a string.
	 * @param key the key
	 * @return the value
	 */
	public String getString(String key) {
		Object value = get(key);
		if(value == null) {
			return null;
		}
		return value instanceof String ? (String) value : value.toString();
	}

	/**
	 * Gets a value of a key as a list.
	 * @param key the key
	 * @return the value
	 */
	public List<?> getList(String key) {
		return (List<?>) get(key);
	}

	/**
	 * Gets if the configuration contains a key.
	 * @param key the key
	 * @return if the configuration contains the key
	 */
	public boolean containsKey(String key) {
		return data.containsKey(key);
	}

	/**
	 * Gets if the configuration contains a value.
	 * @param value the value
	 * @return if the configuration contains the value
	 */
	public boolean containsValue(Object value) {
		return data.containsValue(value);
	}

	/**
	 * Gets the list of keys of the configuration.
	 * @return The list
	 */
	public Set<String> getKeys() {
		return data.keySet();
	}

	/**
	 * Gets the list of values of the configuration.
	 * @return The list
	 */
	public Collection<Object> getValues() {
		return data.values();
	}

	/**
	 * Iterates over the keys and values of the configuration.
	 * @param action The action to be performed
	 */
	public void forEach(BiConsumer<String, ? super Object> action) {
		data.forEach(action);
	}

	/**
	 * Gets the configuration's map.
	 * @return the map
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

	@Override
	public int hashCode() {
		return Objects.hash(data);
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
		Configuration other = (Configuration) obj;
		return Objects.equals(data, other.data);
	}

	@Override
	public String toString() {
		return getMap().toString();
	}

}
