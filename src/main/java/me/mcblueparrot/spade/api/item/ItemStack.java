package me.mcblueparrot.spade.api.item;

import java.util.Objects;

import org.apache.commons.lang3.Validate;

import me.mcblueparrot.spade.api.Cloneable;
import me.mcblueparrot.spade.api.SpadeExceptionMessages;

/**
 * Represents an item stack.
 */
public class ItemStack implements Cloneable<ItemStack>, Ingredient {

	private ItemType type;
	private int amount;

	/**
	 * Creates an empty item stack.
	 */
	public ItemStack() {
		this(ItemType.AIR, 0);
	}

	/**
	 * Creates an item stack.
	 * @param type the type of item
	 */
	public ItemStack(ItemType type) {
		this(type, 1);
	}

	/**
	 * Creates an item stack.
	 * @param type the type of item
	 * @param amount the amount of items
	 */
	public ItemStack(ItemType type, int amount) {
		this.type = Validate.notNull(type, SpadeExceptionMessages.ITEM_TYPE_NULL);
		this.amount = amount;
	}

	/**
	 * Creates a copy of an item stack.
	 * @param item the item stack
	 */
	public ItemStack(ItemStack item) {
		this(item.type, item.amount);
	}

	/**
	 * Gets the item stack's type.
	 * @return the item type
	 */
	public ItemType getType() {
		return type;
	}

	/**
	 * Gets the amount of items in the stack.
	 * @return the amount of items
	 */
	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return type + " * " + amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, type);
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
		ItemStack other = (ItemStack) obj;
		return amount == other.amount && Objects.equals(type, other.type);
	}

	@Override
	public ItemStack clone() {
		return new ItemStack(this);
	}

	@Override
	public boolean testItem(ItemStack item) {
		return item.getAmount() >= getAmount();
	}

}
