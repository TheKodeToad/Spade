package me.mcblueparrot.spade.api.recipe.builder;

import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.item.Ingredient;
import me.mcblueparrot.spade.api.item.ItemStack;
import me.mcblueparrot.spade.api.recipe.SmeltingRecipe;

/**
 * Represents a smelting recipe builder.
 * @see SmeltingRecipe
 */
public class SmeltingRecipeBuilder extends CookingRecipeBuilder {

	/**
	 * Creates a smelting recipe builder.
	 * @param id the identifier
	 */
	public SmeltingRecipeBuilder(Identifier id) {
		super(id);
	}

	/**
	 * Creates a smelting recipe builder.
	 * @param id the identifier
	 * @param result the result
	 */
	public SmeltingRecipeBuilder(Identifier id, ItemStack result) {
		super(id, result);
	}

	@Override
	public SmeltingRecipeBuilder setId(Identifier id) {
		super.setId(id);
		return this;
	}

	@Override
	public SmeltingRecipeBuilder setResult(ItemStack result) {
		super.setResult(result);
		return this;
	}

	@Override
	public SmeltingRecipeBuilder setGroup(String group) {
		super.setGroup(group);
		return this;
	}

	@Override
	public SmeltingRecipeBuilder setIngredient(Ingredient ingredient) {
		super.setIngredient(ingredient);
		return this;
	}

	@Override
	public SmeltingRecipeBuilder setCookTime(int cookTime) {
		super.setCookTime(cookTime);
		return this;
	}

	@Override
	public SmeltingRecipeBuilder setExperience(float experience) {
		super.setExperience(experience);
		return this;
	}

	@Override
	public SmeltingRecipe create() {
		return Spade.createSmeltingRecipe(this);
	}

}
