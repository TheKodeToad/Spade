package me.mcblueparrot.spade.vanilla.inventory;

import me.mcblueparrot.spade.inventory.Inventory;
import me.mcblueparrot.spade.item.Item;
import me.mcblueparrot.spade.vanilla.VanillaBased;
import me.mcblueparrot.spade.vanilla.item.VanillaItem;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

public class VanillaInventory implements VanillaBased<net.minecraft.inventory.Inventory>, Inventory {

	protected net.minecraft.inventory.Inventory inventory;

	public VanillaInventory(net.minecraft.inventory.Inventory inventory) {
		this.inventory = inventory;
	}

	@Override
	public net.minecraft.inventory.Inventory getVanilla() {
		return inventory;
	}

	@Override
	public void addItem(Item... items) {
		for(Item item : items) {
			net.minecraft.item.Item vanilla = ((VanillaItem) item).getVanilla();
			if(inventory instanceof PlayerInventory) {
				((PlayerInventory) inventory).insertStack(new ItemStack(vanilla));
			}
		}
	}

}
