package me.mcblueparrot.spade.api.recipe.builder;

import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.item.Ingredient;
import me.mcblueparrot.spade.api.item.ItemStack;
import me.mcblueparrot.spade.api.recipe.CampfireRecipe;

/**
 * Represents a campfire recipe builder.
 * @see CampfireRecipe
 */
public class CampfireRecipeBuilder extends CookingRecipeBuilder {

	/**
	 * Creates a campfire recipe builder.
	 * @param id the identifier
	 */
	public CampfireRecipeBuilder(Identifier id) {
		super(id);
	}

	/**
	 * Creates a campfire recipe builder.
	 * @param id the identifier
	 * @param result the result
	 */
	public CampfireRecipeBuilder(Identifier id, ItemStack result) {
		super(id, result);
	}

	@Override
	public CampfireRecipeBuilder setId(Identifier id) {
		super.setId(id);
		return this;
	}

	@Override
	public CampfireRecipeBuilder setResult(ItemStack result) {
		super.setResult(result);
		return this;
	}

	@Override
	public CampfireRecipeBuilder setGroup(String group) {
		super.setGroup(group);
		return this;
	}

	@Override
	public CampfireRecipeBuilder setIngredient(Ingredient ingredient) {
		super.setIngredient(ingredient);
		return this;
	}

	@Override
	public CampfireRecipeBuilder setCookTime(int cookTime) {
		super.setCookTime(cookTime);
		return this;
	}

	@Override
	public CampfireRecipeBuilder setExperience(float experience) {
		super.setExperience(experience);
		return this;
	}

	@Override
	public CampfireRecipe create() {
		return Spade.createCampfireRecipe(this);
	}

}
