package me.mcblueparrot.spade.api.recipe;

import me.mcblueparrot.spade.api.item.Ingredient;

/**
 * Represents a smithing table recipe.
 */
public interface SmithingRecipe extends Recipe {

	/**
	 * Gets the recipe's base ingredient.
	 * @return the ingredient
	 */
	public Ingredient getBase();

	/**
	 * Gets the recipe's addition ingredient.
	 * @return the ingredient
	 */
	public Ingredient getAddition();

}
