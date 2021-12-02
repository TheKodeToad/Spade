package me.mcblueparrot.spade.api;

/**
 * Used internally by the API.
 */
public interface SpadeExceptionMessages {

	String PLUGIN_NULL = "Plugin must not be null";
	String ITEM_TYPE_NULL = "Item type must not be null";
	String BLOCK_TYPE_NULL = "Block type must not be null";
	String ENTITY_TYPE_NULL = "Entity type must not be null";
	String WORLD_NULL = "World must not be null";
	String NAMESPACE_NULL = "Namespace must not be null";
	String PATH_NULL = "Path must not be null";
	String VECTOR_COMPONENT_RANGE = "Component must be within the range 0-2";
	String LOCATION_IN_OTHER_WORLD = "Location is in another world";

}
