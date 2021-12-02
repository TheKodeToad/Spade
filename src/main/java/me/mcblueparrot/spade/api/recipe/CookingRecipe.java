package me.mcblueparrot.spade.api.recipe;

import me.mcblueparrot.spade.api.item.Ingredient;

/**
 * Represents a cooking recipe (smelting, blasting, smoking and campfire).
 */
public interface CookingRecipe extends Recipe {

	/**
	 * Gets the input ingredient.
	 * @return the ingredient
	 */
	public Ingredient getIngredient();

	/**
	 * Gets the cook time in ticks.
	 * @return the cook time
	 */
	public int getCookTime();

	/**
	 * Gets the experience of the recipe.
	 * @return the experience
	 */
	public float getExperience();

}
