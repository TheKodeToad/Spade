package me.mcblueparrot.spade.vanilla.item;

import me.mcblueparrot.spade.item.Item;
import me.mcblueparrot.spade.vanilla.VanillaBased;

public class VanillaItem implements VanillaBased<net.minecraft.item.Item>, Item {

	protected net.minecraft.item.Item item;
	private String id;

	public VanillaItem(net.minecraft.item.Item item, String id) {
		this.item = item;
		this.id = id;
	}

	@Override
	public net.minecraft.item.Item getVanilla() {
		return item;
	}

	@Override
	public String getId() {
		return id;
	}
}
