package me.mcblueparrot.spade.api.recipe.builder;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.Validate;

import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.item.Ingredient;
import me.mcblueparrot.spade.api.item.ItemStack;
import me.mcblueparrot.spade.api.recipe.ShapedRecipe;

/**
 * Represents a shaped recipe builder.
 * @see ShapedRecipe
 */
public class ShapedRecipeBuilder extends CraftingRecipeBuilder {

	private String[] shape;
	private Map<Character, Ingredient> ingredients = new HashMap<Character, Ingredient>();

	/**
	 * Creates a shapeless recipe builder.
	 * @param id the identifier
	 */
	public ShapedRecipeBuilder(Identifier id) {
		super(id);
	}

	/**
	 * Creates a shapeless recipe builder.
	 * @param id the identifier
	 * @param result the result
	 */
	public ShapedRecipeBuilder(Identifier id, ItemStack result) {
		super(id, result);
	}

	@Override
	public ShapedRecipeBuilder setId(Identifier id) {
		super.setId(id);
		return this;
	}

	@Override
	public ShapedRecipeBuilder setResult(ItemStack result) {
		super.setResult(result);
		return this;
	}

	@Override
	public ShapedRecipeBuilder setGroup(String group) {
		super.setGroup(group);
		return this;
	}

	/**
	 * @see ShapedRecipe#getShape()
	 */
	public String[] getShape() {
		return shape;
	}

	/**
	 * Sets the recipe's shape.
	 * <p>For example:</p>
	 * <pre><code>new ShapedRecipeBuilder("crafting_table")
	 *	.setShape("##", "##")
	 *	.setIngredient('#', new ItemStack(ItemType.OAK_PLANKS))
	 *	.create();</code></pre>
	 * <p>will create a recipe for crafting recipe.</p>
	 * @param shape the shape
	 */
	public ShapedRecipeBuilder setShape(String... shape) {
		int width = -1;
		Validate.isTrue(shape.length > 0 && shape.length < 4, "Shape must have 1-3 rows");
		for(String line : shape) {
			Validate.notNull(line, "List must not be null");
			if(width == -1) {
				width = line.length();
			}
			Validate.isTrue(line.length() > 0 && line.length() < 4, "Shape must have 1-3 columns");
			Validate.isTrue(line.length() == width, "Shape must be rectangular");
		}
		this.shape = shape;
		return this;
	}

	/**
	 * @see ShapedRecipe#getIngredients()
	 */
	public Map<Character, Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * Sets an ingredient in the recipe.
	 * @param key the character that represents the ingredient
	 * @param ingredient the ingredient
	 */
	public ShapedRecipeBuilder setIngredient(Character key, Ingredient ingredient) {
		ingredients.put(key, ingredient);
		return this;
	}

	/**
	 * Sets an ingredient in the recipe.
	 * @param key the character that represents the ingredient (as a string containing a single character)
	 * @param ingredient the ingredient
	 */
	public ShapedRecipeBuilder setIngredient(String key, Ingredient ingredient) {
		Validate.isTrue(key.length() == 1, "Key must contain 1 character");
		return setIngredient(key.charAt(0), ingredient);
	}

	@Override
	public ShapedRecipe create() {
		return Spade.createShapedRecipe(this);
	}
}
