package me.mcblueparrot.spade.api.recipe.builder;

import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.item.ItemStack;
import me.mcblueparrot.spade.api.recipe.CraftingRecipe;

/**
 * Represents a crafting recipe builder.
 * @see CraftingRecipe
 */
public abstract class CraftingRecipeBuilder extends RecipeBuilder {

	public CraftingRecipeBuilder(Identifier id) {
		super(id);
	}

	public CraftingRecipeBuilder(Identifier id, ItemStack result) {
		super(id, result);
	}

	@Override
	public CraftingRecipeBuilder setId(Identifier id) {
		super.setId(id);
		return this;
	}

	@Override
	public CraftingRecipeBuilder setResult(ItemStack result) {
		super.setResult(result);
		return this;
	}

	@Override
	public CraftingRecipeBuilder setGroup(String group) {
		super.setGroup(group);
		return this;
	}

	@Override
	public abstract CraftingRecipe create();

}
