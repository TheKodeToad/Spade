package me.mcblueparrot.spade.api.recipe;

import java.util.Map;

import me.mcblueparrot.spade.api.item.Ingredient;

/**
 * Represents a shaped recipe, that has a specific shape that can be placed anywhere in
 * a crafting table.
 */
public interface ShapedRecipe extends CraftingRecipe {

	/**
	 * Gets the shape of the recipe as an array of lines.
	 * @return the shape
	 */
	public String[] getShape();

	/**
	 * Gets the map of characters to ingredients.
	 * @return the map
	 */
	public Map<Character, Ingredient> getIngredients();

}
