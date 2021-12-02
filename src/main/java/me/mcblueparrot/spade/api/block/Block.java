package me.mcblueparrot.spade.api.block;

import me.mcblueparrot.spade.api.world.Location;

/**
 * Represents a physical block in a world.
 */
public interface Block {

	/**
	 * Sets the type of block.
	 * @param block the type of block
	 */
	public void setType(BlockType block);

	/**
	 * Gets the type of block.
	 * @return the type of block
	 */
	public BlockType getType();

	/**
	 * Gets the block's data.
	 * @return the block's data
	 */
	public BlockData getData();

	/**
	 * Gets the block's location.
	 * @return the block's location
	 */
	public Location getLocation();

	/**
	 * Gets the block's chunk location.
	 * @return the block's chunk location
	 */
	public Location getChunk();

}
