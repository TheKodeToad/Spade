package me.mcblueparrot.spade.config.old;

public interface ConfigurationListNode extends ConfigurationNode {

	public ConfigurationNode get(int index);
	public void set(int index, ConfigurationNode node);
	public default void set(int index, String value) {
		set(index, createNode(value));
	}
	public default void set(int index, Number value) {
		set(index, createNode(value));
	}
	public default void set(int index, Boolean value) {
		set(index, createNode(value));
	}
	public default void set(int index, Character value) {
		set(index, createNode(value));
	}

	public default byte getByte(int index) {
		return get(index).toByte();
	}

	public default short getShort(int index) {
		return get(index).toShort();
	}

	public default int getInt(int index) {
		return get(index).toInt();
	}

	public default long getLong(int index) {
		return get(index).toLong();
	}

	public default float getFloat(int index) {
		return get(index).toFloat();
	}

	public default double getDouble(int index) {
		return get(index).toDouble();
	}

	public default boolean getBoolean(int index) {
		return get(index).toBoolean();
	}

	public default char getChar(int index) {
		return get(index).toChar();
	}

	public default ConfigurationTreeNode getTree(int index) {
		return get(index).toTree();
	}

	public default ConfigurationListNode getList(int index) {
		return get(index).toList();
	}

}
