package me.mcblueparrot.spade.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {

	@SuppressWarnings("resource")
	@Inject(at = @At("RETURN"), method = "setTimeOfDay")
	public void setTimeOfDay(long timeOfDay, CallbackInfo callback) {
		ServerWorld world = (ServerWorld) (Object) this;
		for(ServerPlayerEntity player : world.getServer().getPlayerManager().getPlayerList()) {
			ServerWorld playerWorld = player.getServerWorld();
			player.networkHandler.sendPacket(new WorldTimeUpdateS2CPacket(playerWorld.getTime(), playerWorld.getTimeOfDay(), playerWorld.getGameRules().getBoolean(GameRules.DO_DAYLIGHT_CYCLE)));
		}
	}

}
