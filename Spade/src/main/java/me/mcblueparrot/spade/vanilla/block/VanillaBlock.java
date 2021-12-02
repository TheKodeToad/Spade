package me.mcblueparrot.spade.vanilla.block;

import me.mcblueparrot.spade.block.Block;
import me.mcblueparrot.spade.vanilla.VanillaBased;

public class VanillaBlock implements VanillaBased<net.minecraft.block.Block>, Block {

	protected net.minecraft.block.Block block;
	private String id;

	public VanillaBlock(net.minecraft.block.Block block, String id) {
		this.block = block;
		this.id = id;
	}

	@Override
	public net.minecraft.block.Block getVanilla() {
		return block;
	}

	@Override
	public float getBlastResistance() {
		return block.getBlastResistance();
	}

	@Override
	public String getId() {
		return id;
	}

}
