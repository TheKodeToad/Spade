package me.mcblueparrot.spade.vanilla.entity;

import java.util.Objects;
import java.util.UUID;

import me.mcblueparrot.spade.Location;
import me.mcblueparrot.spade.entity.Player;
import me.mcblueparrot.spade.inventory.Inventory;
import me.mcblueparrot.spade.vanilla.VanillaServer;
import me.mcblueparrot.spade.vanilla.inventory.VanillaInventory;
import net.md_5.bungee.api.chat.BaseComponent;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class VanillaPlayer extends VanillaLivingEntity implements Player {

	public VanillaPlayer(net.minecraft.entity.Entity entity) {
		super(entity);
	}

	/**
	 * Gets the vanilla object which this is based on as a server player
	 */
	public ServerPlayerEntity getVanillaPlayer() {
		return (ServerPlayerEntity) getVanilla();
	}

	@Override
	public void sendMessage(String message) {
		Objects.requireNonNull(message);
		getVanillaPlayer().sendMessage(new LiteralText(message), false);
	}

	@Override
	public void sendMessage(BaseComponent message) {
		sendJsonMessage(message.toString());
	}

	@Override
	public void sendJsonMessage(String json) {
		getVanillaPlayer().sendMessage(Text.Serializer.fromJson(json), false);
	}

	@Override
	public void kick(String message) {
		Objects.requireNonNull(message);
		getVanillaPlayer().networkHandler.disconnect(new LiteralText(message));
	}

	@Override
	public void setAllowFlight(boolean canFly) {
		getVanillaPlayer().abilities.allowFlying = canFly;
		getVanillaPlayer().sendAbilitiesUpdate();
	}

	@Override
	public boolean getAllowFlight() {
		return getVanillaPlayer().abilities.allowFlying;
	}

	@Override
	public UUID getUUID() {
		return getVanillaPlayer().getGameProfile().getId();
	}

	@Override
	public String getName() {
		return getVanillaPlayer().getGameProfile().getName();
	}

	@Override
	public void teleport(Location to) {
		getVanillaPlayer().teleport(getVanillaPlayer().getServerWorld(), to.getX(), to.getY(), to.getZ(), to.getYaw(), to.getPitch());
	}

	@Override
	public boolean isOperator() {
		return VanillaServer.getInstance().getVanilla().getPlayerManager().isOperator(getVanillaPlayer().getGameProfile());
	}

	@Override
	public void despawn() {
		throw new UnsupportedOperationException("Cannot despawn player");
	}

	@Override
	public Inventory getInventory() {
		return new VanillaInventory(getVanillaPlayer().inventory);
	}

}
