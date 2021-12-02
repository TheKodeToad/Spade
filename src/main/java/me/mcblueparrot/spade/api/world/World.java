package me.mcblueparrot.spade.api.world;

import java.util.List;

import org.apache.commons.lang3.Validate;

import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.SpadeExceptionMessages;
import me.mcblueparrot.spade.api.Vector;
import me.mcblueparrot.spade.api.block.Block;
import me.mcblueparrot.spade.api.entity.Entity;
import me.mcblueparrot.spade.api.entity.EntityType;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.server.Server;
import me.mcblueparrot.spade.api.world.area.Area;

/**
 * Represents a world.
 */
public interface World {

	/**
	 * @see Server#getWorld(Identifier)
	 */
	public static World getWorld(Identifier id) {
		return Spade.getWorld(id);
	}

	/**
	 * @see Server#getWorld(String)
	 */
	public static World getWorld(String id) {
		return Spade.getWorld(id);
	}

	/**
	 * @see Server#getWorlds()
	 */
	public static List<World> getWorlds() {
		return Spade.getWorlds();
	}

	/**
	 * @see Server#getOverworld()
	 */
	public static World getOverworld() {
		return Spade.getOverworld();
	}

	/**
	 * @see Server#getTheNether()
	 */
	public static World getTheNether() {
		return Spade.getTheNether();
	}

	/**
	 * @see Server#getTheEnd()
	 */
	public static World getTheEnd() {
		return Spade.getTheEnd();
	}

	/**
	 * Gets the world's identifier (for example <code>minecraft:overworld</code>).
	 * @return the identifier
	 */
	public Identifier getId();

	/**
	 * Gets if the world is the overworld.
	 * @return if the world is the overworld
	 */
	public default boolean isOverworld() {
		return getId().isMinecraft() && getId().getPath().equals("overworld");
	}

	/**
	 * Gets if the world is the nether.
	 * @return if the world is the nether
	 */
	public default boolean isTheNether() {
		return getId().isMinecraft() && getId().getPath().equals("the_nether");
	}

	/**
	 * Gets if the world is the end.
	 * @return if the world is the end
	 */
	public default boolean isTheEnd() {
		return getId().isMinecraft() && getId().getPath().equals("the_end");
	}

	/**
	 * Creates an entity without spawning it.
	 * @param type the type of entity
	 * @param location the location
	 * @return the entity
	 */
	public Entity createEntity(EntityType type, Location location);

	/**
	 * Adds an entity to the world.
	 * @param entity the entity
	 */
	public void addEntity(Entity entity);

	/**
	 * Gets a block at the specified position.
	 * @param position the position
	 * @return the block
	 */
	public Block getBlock(Vector position);

	/**
	 * Gets a block at the specified position.
	 * @param x the X
	 * @param y the Y
	 * @param z the Z
	 */
	public default Block getBlock(int x, int y, int z) {
		return getBlock(new Vector(x, y, z));
	}

	/**
	 * Gets a block at the specified location.
	 * @param location the location
	 * @return the block
	 */
	public default Block getBlock(Location location) {
		WorldUtils.validateLocation(location, this);
		return getBlock(new Vector(location.getX(), location.getY(), location.getZ()));
	}

	/**
	 * Gets a list of entities in the world.
	 * @return the list of entities
	 */
	public List<Entity> getEntities();

	/**
	 * Gets a list of entities in an area.
	 * @param area the area
	 * @return the list of entities
	 */
	public List<Entity> getEntities(Area area);

	/**
	 * Gets the biome at the specified position.
	 * @param location the position
	 * @return the biome
	 */
	public BiomeType getBiome(Vector position);

	/**
	 * Gets the biome at the specified position.
	 * @param x the X
	 * @param y the Y
	 * @param z the Z
	 * @return the biome
	 */
	public default BiomeType getBiome(int x, int y, int z) {
		return getBiome(new Vector(x, y, z));
	}

	/**
	 * Gets the biome at the specified location.
	 * @param location the location
	 * @return the biome
	 */
	public default BiomeType getBiome(Location location) {
		WorldUtils.validateLocation(location, this);
		return getBiome(new Vector(location.getX(), location.getY(), location.getZ()));
	}

	/**
	 * Sets the biome at the specified position.
	 * @param position the position
	 * @param biome the biome
	 */
	public void setBiome(Vector position, BiomeType biome);

	/**
	 * Sets the biome at the specified position.
	 * @param x the X
	 * @param y the Y
	 * @param z the Z
	 * @param biome the biome
	 */
	public default void setBiome(int x, int y, int z, BiomeType biome) {
		setBiome(new Vector(x, y, z), biome);
	}

	/**
	 * Sets the biome at the specified location.
	 * @param location the location
	 * @param biome the biome
	 */
	public default void setBiome(Location location, BiomeType biome) {
		WorldUtils.validateLocation(location, this);
		setBiome(new Vector(location.getX(), location.getY(), location.getZ()), biome);
	}

	/**
	 * Gets the world's seed.
	 * @return the seed
	 */
	public long getSeed();

	/**
	 * Unloads the world.
	 */
	public void unload();

}

class WorldUtils {

	public static void validateLocation(Location location, World world) {
		Validate.isTrue(location.getWorld() == null || location.getWorld().equals(world), SpadeExceptionMessages.LOCATION_IN_OTHER_WORLD);
	}

}
