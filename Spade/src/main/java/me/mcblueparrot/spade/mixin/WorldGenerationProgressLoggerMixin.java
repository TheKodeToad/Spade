package me.mcblueparrot.spade.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import me.mcblueparrot.spade.Spade;
import net.minecraft.server.WorldGenerationProgressLogger;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.chunk.ChunkStatus;

@Mixin(WorldGenerationProgressLogger.class)
public abstract class WorldGenerationProgressLoggerMixin {

	@Shadow
	public int generatedCount;
	@Shadow
	public long nextMessageTime;
	@Shadow
	public abstract int getProgressPercentage();

	public int lastAmount = -1;

	@Overwrite
	public void setChunkStatus(ChunkPos pos, ChunkStatus status) {
		if(status.equals(ChunkStatus.FULL)) {
			generatedCount++;
		}

		int amount = getProgressPercentage();
		if(amount != lastAmount && Util.getMeasuringTimeMs() > nextMessageTime) {
			lastAmount = amount;
			nextMessageTime += 500;
			Spade.getLogger().info(new TranslatableText("menu.preparingSpawn", MathHelper.clamp(amount, 0, 100)).getString());
		}
	}

}
