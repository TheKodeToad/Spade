package me.mcblueparrot.spade.inventory;

import me.mcblueparrot.spade.item.Item;

public interface Inventory {

	/**
	 * Adds items to the inventory
	 * @param items The items
	 */
	public void addItem(Item... items);

}
