package me.mcblueparrot.spade.api;

import me.mcblueparrot.spade.api.id.Identifier;

/**
 * Represents something that has tags.
 */
public interface Taggable {

	/**
	 * Gets if the block/item/entity type has a tag.
	 * @param tag the tag
	 * @return if the item has a tag
	 */
	public boolean hasTag(Identifier tag);

	/**
	 * Gets if the block/item/entity type has a tag.
	 * @param tag the tag identifier (as a string)
	 * @return if the block/item/entity type has a tag
	 */
	public default boolean hasTag(String tag) {
		return hasTag(Identifier.parse(tag));
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:planks</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isPlanks() {
		return hasTag("planks");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:carpet</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isCarpet() {
		return hasTag("carpets");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:button</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isButton() {
		return hasTag("buttons");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:logs</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isLog() {
		return hasTag("logs");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:doors</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isDoor() {
		return hasTag("doors");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:slabs</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isSlab() {
		return hasTag("slabs");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:stairs</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isStairs() {
		return hasTag("stairs");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:portals</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isPortal() {
		return hasTag("portals");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:ice</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isIce() {
		return hasTag("ice");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:rails</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isRails() {
		return hasTag("rails");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:walls</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isWall() {
		return hasTag("walls");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:wool</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isWool() {
		return hasTag("wool");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:sand</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isSand() {
		return hasTag("sand");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:arrow</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isArrow() {
		return hasTag("arrow");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:coals</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isCoal() {
		return hasTag("coals");
	}

	/**
	 * Gets if the block/item/entity type has the <code>minecraft:anvil</code> tag
	 * @return if the block/item/entity type has the tag
	 */
	public default boolean isAnvil() {
		return hasTag("anvil");
	}

}
