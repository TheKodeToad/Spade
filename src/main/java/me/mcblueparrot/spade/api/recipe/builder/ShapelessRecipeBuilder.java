package me.mcblueparrot.spade.api.recipe.builder;

import java.util.ArrayList;
import java.util.List;

import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.item.Ingredient;
import me.mcblueparrot.spade.api.item.ItemStack;
import me.mcblueparrot.spade.api.recipe.ShapelessRecipe;

/**
 * Represents a shapeless recipe builder.
 * @see ShapelessRecipe
 */
public class ShapelessRecipeBuilder extends CraftingRecipeBuilder {

	private List<Ingredient> ingredients = new ArrayList<Ingredient>();

	/**
	 * Creates a shapeless recipe builder.
	 * @param id the identifier
	 */
	public ShapelessRecipeBuilder(Identifier id) {
		super(id);
	}

	/**
	 * Creates a shapeless recipe builder.
	 * @param id the identifier
	 * @param result the result
	 */
	public ShapelessRecipeBuilder(Identifier id, ItemStack result) {
		super(id, result);
	}

	@Override
	public ShapelessRecipeBuilder setId(Identifier id) {
		super.setId(id);
		return this;
	}

	@Override
	public ShapelessRecipeBuilder setResult(ItemStack result) {
		super.setResult(result);
		return this;
	}

	@Override
	public ShapelessRecipeBuilder setGroup(String group) {
		super.setGroup(group);
		return this;
	}

	/**
	 * @see ShapelessRecipe#getIngredients()
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * Adds an ingredient to the recipe.
	 * @param ingredient the ingredient
	 */
	public ShapelessRecipeBuilder addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
		return this;
	}

	/**
	 * Removes an ingredient from the recipe.
	 * @param ingredient the ingredient
	 */
	public ShapelessRecipeBuilder removeIngredient(Ingredient ingredient) {
		ingredients.remove(ingredient);
		return this;
	}

	@Override
	public ShapelessRecipe create() {
		return Spade.createShapelessRecipe(this);
	}

}
