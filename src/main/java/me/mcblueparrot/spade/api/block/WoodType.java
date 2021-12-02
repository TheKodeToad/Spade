package me.mcblueparrot.spade.api.block;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Represents a type of wood.
 */
public class WoodType {

	private static Map<String, WoodType> byName = new HashMap<String, WoodType>();
	private static Set<WoodType> woodTypes;

	private String name;

	private WoodType(String name) {
		this.name = name;
		byName.put(this.name, this);
		woodTypes.add(this);
	}

	/**
	 * Gets a wood type by its name.
	 * @param name the name
	 * @return the boat type
	 */
	public static WoodType getWoodType(String name) {
		return byName.get(name);
	}

	/**
	 * Gets a list of all wood types.
	 * @return the list
	 */
	public static Set<WoodType> getWoodTypes() {
		return woodTypes;
	}

	/**
	 * Gets whether the wood can be used to create a boat.
	 * @return whether the wood can be used to create a boat
	 */
	public boolean hasBoat() {
		return !(equals(CRIMSON) || equals(WARPED));
	}

	/**
	 * Gets the name of the wood type.
	 * @return the name of the wood type
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public static final WoodType OAK = new WoodType("oak");
	public static final WoodType SPRUCE = new WoodType("spruce");
	public static final WoodType BIRCH = new WoodType("birch");
	public static final WoodType JUNGLE = new WoodType("jungle");
	public static final WoodType ACACIA = new WoodType("acacia");
	public static final WoodType DARK_OAK = new WoodType("dark_oak");
	public static final WoodType CRIMSON = new WoodType("crimson");
	public static final WoodType WARPED = new WoodType("warped");

}
