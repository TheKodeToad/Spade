package me.mcblueparrot.spade.vanilla;

/**
 * An object based on a vanilla type
 * @param <V> the vanilla type
 */
public interface VanillaBased<V> {

	/**
	 * Gets the vanilla object which this is based on
	 * @return the object
	 */
	public V getVanilla();

}
