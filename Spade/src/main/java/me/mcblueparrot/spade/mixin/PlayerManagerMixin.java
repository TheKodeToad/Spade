package me.mcblueparrot.spade.mixin;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.mcblueparrot.spade.Spade;
import me.mcblueparrot.spade.entity.Player;
import me.mcblueparrot.spade.event.player.PlayerChatEvent;
import me.mcblueparrot.spade.event.player.PlayerJoinEvent;
import me.mcblueparrot.spade.event.player.PlayerQuitEvent;
import me.mcblueparrot.spade.vanilla.entity.VanillaPlayer;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.MessageType;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;

@Mixin(PlayerManager.class)
public abstract class PlayerManagerMixin {

	@Shadow
	public MinecraftServer server;
	@Shadow
	public abstract void sendToAll(Packet<?> packet);

	@Inject(at = @At("RETURN"), method = "onPlayerConnect")
	public void onPlayerConnect(ClientConnection connection, ServerPlayerEntity player, CallbackInfo callback) {
		Spade.callEvent(new PlayerJoinEvent(new VanillaPlayer(player)));
	}

	@Inject(at = @At("RETURN"), method = "remove")
	public void remove(ServerPlayerEntity player, CallbackInfo callback) {
		Spade.callEvent(new PlayerQuitEvent(new VanillaPlayer(player)));
	}

	@Overwrite
	public void broadcastChatMessage(Text message, MessageType type, UUID senderUuid) {
		if(senderUuid != Util.NIL_UUID && type.equals(MessageType.CHAT) && message instanceof TranslatableText && ((TranslatableText) message).getKey().equals("chat.type.text")) {
			// Must be a chat message
			PlayerChatEvent event = new PlayerChatEvent(Spade.getPlayer(senderUuid), (String) ((TranslatableText) message).getArgs()[1], Spade.getPlayers());
			Spade.callEvent(event);
			if(event.isCancelled() || !event.isVisible()) {
				return;
			}
			Text newMessage = new TranslatableText(String.format(event.getFormat(), event.getDisplayName(), event.getMessage()));
			server.sendSystemMessage(newMessage, senderUuid);
			for(Player player : event.getRecipients()) {
				((VanillaPlayer) player).getVanillaPlayer().networkHandler.sendPacket(new GameMessageS2CPacket(newMessage, type, senderUuid));
			}
		}
		else {
			server.sendSystemMessage(message, senderUuid);
			sendToAll(new GameMessageS2CPacket(message, type, senderUuid));
		}
	}

}
