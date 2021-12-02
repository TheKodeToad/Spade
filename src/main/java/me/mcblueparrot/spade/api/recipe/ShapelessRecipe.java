package me.mcblueparrot.spade.api.recipe;

import java.util.List;

import me.mcblueparrot.spade.api.item.ItemStack;

/**
 * Represents a shapeless recipe, that allows items to be placed anywhere.
 */
public interface ShapelessRecipe extends CraftingRecipe {

	/**
	 * Gets a list of ingredients of the recipe.
	 * @return the list
	 */
	public List<ItemStack> getIngredients();

}
