package me.mcblueparrot.spade.api.world.area;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import me.mcblueparrot.spade.api.Cloneable;
import me.mcblueparrot.spade.api.block.Block;
import me.mcblueparrot.spade.api.entity.Entity;
import me.mcblueparrot.spade.api.world.Location;
import me.mcblueparrot.spade.api.world.World;

/**
 * Represents an area in a world.
 */
public interface Area extends Iterable<Block>, Cloneable<Area> {

	/**
	 * Gets the world the area is located in.
	 * @return the world
	 */
	public World getWorld();

	/**
	 * Gets a list of blocks in the area.
	 * @return the list of blocks
	 */
	public default List<Block> getBlocks() {
		return getBlocks(getWorld());
	}

	/**
	 * Gets a list of blocks in the area.
	 * @param world the world
	 * @return the list of blocks
	 */
	public default List<Block> getBlocks(World world) {
		List<Block> blocks = new ArrayList<Block>();
		for(Location location : getLocations(world)) {
			blocks.add(location.getBlock());
		}
		return blocks;
	}

	/**
	 * Gets a list of block locations in the area.
	 * @return the list of block locations
	 */
	public default List<Location> getLocations() {
		return getLocations(getWorld());
	}

	/**
	 * Gets a list of block locations in the area.
	 * @param world the world
	 * @return the list of block locations
	 */
	public List<Location> getLocations(World world);

	/**
	 * Gets if the area contains a location.
	 * @param location the location
	 * @return if the area contains a location
	 */
	public boolean contains(Location location);

	/**
	 * Gets if the area contains an entity.
	 * @param entity the entity
	 * @return if the area contains an entity
	 */
	public default boolean contains(Entity entity) {
		return contains(entity.getLocation());
	}

	/**
	 * Gets if the area contains a block.
	 * @param block the block
	 * @return if the area contains a block
	 */
	public default boolean contains(Block block) {
		return contains(block.getLocation());
	}

	@Override
	public default Iterator<Block> iterator() {
		return getBlocks().iterator();
	}

}
