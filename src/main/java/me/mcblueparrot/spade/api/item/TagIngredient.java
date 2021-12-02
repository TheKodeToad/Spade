package me.mcblueparrot.spade.api.item;

import me.mcblueparrot.spade.api.id.Identifier;

/**
 * Represents an ingredient that matches a tag.
 */
public class TagIngredient implements Ingredient {

	private Identifier tag;

	/**
	 * Creates a tag ingredient.
	 * @param tag the tag identifier
	 */
	public TagIngredient(Identifier tag) {
		this.tag = tag;
	}

	/**
	 * Creates a tag ingredient.
	 * @param tag the tag identifier (as a string)
	 */
	public TagIngredient(String tag) {
		this(Identifier.parse(tag));
	}

	@Override
	public boolean testItem(ItemStack item) {
		return item.getType().hasTag(tag);
	}

}
