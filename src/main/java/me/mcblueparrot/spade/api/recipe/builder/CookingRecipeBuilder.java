package me.mcblueparrot.spade.api.recipe.builder;

import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.item.Ingredient;
import me.mcblueparrot.spade.api.item.ItemStack;
import me.mcblueparrot.spade.api.recipe.CookingRecipe;

/**
 * Represents a cooking recipe builder.
 * @see CookingRecipe
 */
public abstract class CookingRecipeBuilder extends RecipeBuilder {

	private Ingredient ingredient;
	private int cookTime;
	private float experience;

	public CookingRecipeBuilder(Identifier id) {
		super(id);
	}

	public CookingRecipeBuilder(Identifier id, ItemStack result) {
		super(id, result);
	}

	@Override
	public CookingRecipeBuilder setId(Identifier id) {
		super.setId(id);
		return this;
	}

	@Override
	public CookingRecipeBuilder setResult(ItemStack result) {
		super.setResult(result);
		return this;
	}

	@Override
	public CookingRecipeBuilder setGroup(String group) {
		super.setGroup(group);
		return this;
	}

	/**
	 * @see CookingRecipe#getIngredient()
	 */
	public Ingredient getIngredient() {
		return ingredient;
	}

	/**
	 * Sets the recipe's input ingredient.
	 * @param ingredient the ingredient
	 */
	public CookingRecipeBuilder setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
		return this;
	}

	/**
	 * @see CookingRecipe#getCookTime()
	 */
	public int getCookTime() {
		return cookTime;
	}

	/**
	 * Sets the cook time in ticks.
	 * @param cookTime the cook time
	 */
	public CookingRecipeBuilder setCookTime(int cookTime) {
		this.cookTime = cookTime;
		return this;
	}

	/**
	 * @see CookingRecipe#getExperience()
	 */
	public float getExperience() {
		return experience;
	}

	/**
	 * Sets the recipe's experience.
	 * @param experience the experience
	 */
	public CookingRecipeBuilder setExperience(float experience) {
		this.experience = experience;
		return this;
	}

}
