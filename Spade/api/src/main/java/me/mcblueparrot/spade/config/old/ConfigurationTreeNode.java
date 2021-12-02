package me.mcblueparrot.spade.config.old;

public interface ConfigurationTreeNode extends ConfigurationNode {

	public ConfigurationNode get(String name);
	public void set(String name, ConfigurationNode node);
	public default void set(String name, String value) {
		set(name, createNode(value));
	}
	public default void set(String name, Number value) {
		set(name, createNode(value));
	}
	public default void set(String name, Boolean value) {
		set(name, createNode(value));
	}
	public default void set(String name, Character value) {
		set(name, createNode(value));
	}

	public default byte getByte(String name) {
		return get(name).toByte();
	}
	public default short getShort(String name) {
		return get(name).toShort();
	}
	public default int getInt(String name) {
		return get(name).toInt();
	}
	public default long getLong(String name) {
		return get(name).toLong();
	}
	public default float getFloat(String name) {
		return get(name).toFloat();
	}
	public default double getDouble(String name) {
		return get(name).toDouble();
	}
	public default boolean getBoolean(String name) {
		return get(name).toBoolean();
	}
	public default char getChar(String name) {
		return get(name).toChar();
	}

	public default ConfigurationTreeNode getTree(String name) {
		return get(name).toTree();
	}

	public default ConfigurationListNode getList(String name) {
		return get(name).toList();
	}

}
