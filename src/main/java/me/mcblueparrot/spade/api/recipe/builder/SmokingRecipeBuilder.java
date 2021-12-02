package me.mcblueparrot.spade.api.recipe.builder;

import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.item.Ingredient;
import me.mcblueparrot.spade.api.item.ItemStack;
import me.mcblueparrot.spade.api.recipe.SmokingRecipe;

/**
 * Represents a smoking recipe builder.
 * @see SmokingRecipe
 */
public class SmokingRecipeBuilder extends CookingRecipeBuilder {

	/**
	 * Creates a smoking recipe builder.
	 * @param id the identifier
	 */
	public SmokingRecipeBuilder(Identifier id) {
		super(id);
	}

	/**
	 * Creates a smoking recipe builder.
	 * @param id the identifier
	 * @param result the result
	 */
	public SmokingRecipeBuilder(Identifier id, ItemStack result) {
		super(id, result);
	}

	@Override
	public SmokingRecipeBuilder setId(Identifier id) {
		super.setId(id);
		return this;
	}

	@Override
	public SmokingRecipeBuilder setResult(ItemStack result) {
		super.setResult(result);
		return this;
	}

	@Override
	public SmokingRecipeBuilder setGroup(String group) {
		super.setGroup(group);
		return this;
	}

	@Override
	public SmokingRecipeBuilder setIngredient(Ingredient ingredient) {
		super.setIngredient(ingredient);
		return this;
	}

	@Override
	public SmokingRecipeBuilder setCookTime(int cookTime) {
		super.setCookTime(cookTime);
		return this;
	}

	@Override
	public SmokingRecipeBuilder setExperience(float experience) {
		super.setExperience(experience);
		return this;
	}

	@Override
	public SmokingRecipe create() {
		return Spade.createSmokingRecipe(this);
	}

}
