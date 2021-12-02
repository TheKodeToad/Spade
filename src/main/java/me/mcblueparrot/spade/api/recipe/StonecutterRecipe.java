package me.mcblueparrot.spade.api.recipe;

import me.mcblueparrot.spade.api.item.Ingredient;

/**
 * Represents a stonecutter recipe.
 */
public interface StonecutterRecipe extends Recipe {

	/**
	 * Gets the recipe's ingredient.
	 * @return the ingredient
	 */
	public Ingredient getIngredient();

}
