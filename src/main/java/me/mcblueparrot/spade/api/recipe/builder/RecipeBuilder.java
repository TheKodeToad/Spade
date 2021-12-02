package me.mcblueparrot.spade.api.recipe.builder;

import me.mcblueparrot.spade.api.id.Identifiable;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.item.ItemStack;
import me.mcblueparrot.spade.api.recipe.Recipe;

/**
 * Represents a recipe builder.
 * @see Recipe
 */
public abstract class RecipeBuilder implements Identifiable {

	private Identifier id;
	private ItemStack result;
	private String group;

	public RecipeBuilder(Identifier id) {
		this(id, null);
	}

	public RecipeBuilder(Identifier id, ItemStack result) {
		this.id = id;
		this.result = result;
	}

	/**
	 * @see Recipe#getId()
	 */
	@Override
	public Identifier getId() {
		return id;
	}

	/**
	 * Sets the recipe's identifier.
	 * @param id the identifier
	 */
	public RecipeBuilder setId(Identifier id) {
		this.id = id;
		return this;
	}

	/**
	 * @see Recipe#getResult()
	 */
	public ItemStack getResult() {
		return result;
	}

	/**
	 * Sets the recipe's result.
	 * @param result the result
	 */
	public RecipeBuilder setResult(ItemStack result) {
		this.result = result;
		return this;
	}

	/**
	 * @see Recipe#getGroup()
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Sets the recipe's group.
	 * @param group the group
	 */
	public RecipeBuilder setGroup(String group) {
		this.group = group;
		return this;
	}

	/**
	 * Creates and adds the recipe to the server.
	 * @return the recipe
	 */
	public abstract Recipe create();

}
