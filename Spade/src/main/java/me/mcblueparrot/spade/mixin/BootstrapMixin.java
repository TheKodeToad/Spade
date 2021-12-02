package me.mcblueparrot.spade.mixin;

import org.apache.logging.log4j.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import me.mcblueparrot.spade.SpadePrintStream;
import net.minecraft.Bootstrap;

@Mixin(Bootstrap.class)
public abstract class BootstrapMixin {

	@Overwrite
	private static void setOutputStreams() {
		System.setOut(new SpadePrintStream(System.out, Level.INFO));
		System.setErr(new SpadePrintStream(System.err, Level.ERROR));
	}

}
