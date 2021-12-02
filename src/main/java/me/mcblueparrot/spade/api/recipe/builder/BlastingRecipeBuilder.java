package me.mcblueparrot.spade.api.recipe.builder;

import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.item.Ingredient;
import me.mcblueparrot.spade.api.item.ItemStack;
import me.mcblueparrot.spade.api.recipe.BlastingRecipe;

/**
 * Represents a blasting recipe builder.
 * @see BlastingRecipe
 */
public class BlastingRecipeBuilder extends CookingRecipeBuilder {

	/**
	 * Creates a blasting recipe builder.
	 * @param id the identifier
	 */
	public BlastingRecipeBuilder(Identifier id) {
		super(id);
	}

	/**
	 * Creates a blasting recipe builder.
	 * @param id the identifier
	 * @param result the result
	 */
	public BlastingRecipeBuilder(Identifier id, ItemStack result) {
		super(id, result);
	}

	@Override
	public BlastingRecipeBuilder setId(Identifier id) {
		super.setId(id);
		return this;
	}

	@Override
	public BlastingRecipeBuilder setResult(ItemStack result) {
		super.setResult(result);
		return this;
	}

	@Override
	public BlastingRecipeBuilder setGroup(String group) {
		super.setGroup(group);
		return this;
	}

	@Override
	public BlastingRecipeBuilder setIngredient(Ingredient ingredient) {
		super.setIngredient(ingredient);
		return this;
	}

	@Override
	public BlastingRecipeBuilder setCookTime(int cookTime) {
		super.setCookTime(cookTime);
		return this;
	}

	@Override
	public BlastingRecipeBuilder setExperience(float experience) {
		super.setExperience(experience);
		return this;
	}

	@Override
	public BlastingRecipe create() {
		return Spade.createBlastingRecipe(this);
	}

}
