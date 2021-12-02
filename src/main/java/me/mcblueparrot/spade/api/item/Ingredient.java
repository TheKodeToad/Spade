package me.mcblueparrot.spade.api.item;

/**
 * Represents an ingredient.
 */
@FunctionalInterface
public interface Ingredient {

	/**
	 * Tests if the item matches the ingredient's criteria.
	 * @param item the item
	 * @return if the item matches the criteria
	 */
	public boolean testItem(ItemStack item);

	/**
	 * Tests if the items all match the ingredient's criteria.
	 * @return if the items all match the criteria
	 */
	public default boolean testItems(ItemStack... items) {
		for(ItemStack item : items) {
			if(!testItem(item)) {
				return false;
			}
		}
		return true;
	}

}
