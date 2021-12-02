package me.mcblueparrot.spade.config.old;

public interface ConfigurationNode {

	public Object getValue();

	public ConfigurationTreeNode createTreeNode();
	public ConfigurationListNode createListNode();
	public ConfigurationNode createNode(String value);
	public ConfigurationNode createNode(Number value);
	public ConfigurationNode createNode(Boolean value);
	public ConfigurationNode createNode(Character value);

	public byte toByte();
	public short toShort();
	public int toInt();
	public long toLong();
	public float toFloat();
	public double toDouble();
	public boolean toBoolean();
	public char toChar();
	public ConfigurationTreeNode toTree();
	public ConfigurationListNode toList();

}
