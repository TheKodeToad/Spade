package me.mcblueparrot.spade.api.recipe;

import java.util.List;

import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.id.Identifiable;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.item.ItemStack;
import me.mcblueparrot.spade.api.server.Server;

/**
 * Represents a recipe.
 */
public interface Recipe extends Identifiable {

	/**
	 * @see Server#getRecipe(Identifier)
	 */
	public static Recipe getRecipe(Identifier id) {
		return Spade.getRecipe(id);
	}

	/**
	 * @see Server#getRecipe(String)
	 */
	public static Recipe getRecipe(String id) {
		return Spade.getRecipe(id);
	}

	/**
	 * @see Server#getRecipes()
	 */
	public static List<Recipe> getRecipes() {
		return Spade.getRecipes();
	}

	/**
	 * Gets the recipe's identifier.
	 * @return the identifier
	 */
	@Override
	public Identifier getId();

	/**
	 * Gets the recipe's result.
	 * @return the result
	 */
	public ItemStack getResult();

	/**
	 * Gets the recipe's group, used to group recipes together in the recipe book.
	 * @return the group
	 */
	public String getGroup();

	/**
	 * Removes the recipe.
	 */
	public void remove();

}
