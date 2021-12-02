package me.mcblueparrot.spade.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mojang.brigadier.AmbiguityConsumer;
import com.mojang.brigadier.CommandDispatcher;

import me.mcblueparrot.spade.SpadePluginManager;
import me.mcblueparrot.spade.command.CommandException;
import me.mcblueparrot.spade.commands.AboutCommand;
import me.mcblueparrot.spade.commands.PluginsCommand;
import me.mcblueparrot.spade.commands.ReloadPluginsCommand;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

@Mixin(CommandManager.class)
public abstract class CommandManagerMixin {

	@Shadow
	public CommandDispatcher<ServerCommandSource> dispatcher;

	@Redirect(at = @At(value = "INVOKE", target = "Lcom/mojang/brigadier/CommandDispatcher;findAmbiguities(Lcom/mojang/brigadier/AmbiguityConsumer;)V"), method = "<init>")
	private void init(CommandDispatcher<ServerCommandSource> dispatcher, AmbiguityConsumer<ServerCommandSource> ambiguityConsumer, CommandManager.RegistrationEnvironment registrationEnvironment) {
		dispatcher.register(CommandManager.literal("plugins").executes(new PluginsCommand()));
		dispatcher.register(CommandManager.literal("about").executes(new AboutCommand()));
		dispatcher.register(CommandManager.literal("reloadplugins").executes(new ReloadPluginsCommand()));
	}

	@Inject(at = @At("HEAD"), method = "execute", cancellable = true)
	public void execute(ServerCommandSource commandSource, String command, CallbackInfoReturnable<Integer> callback) {
		if(command.startsWith("/")) {
			command = command.substring(1);
		}
		try {
			if(SpadePluginManager.getInstance().execute(commandSource, command)) {
				callback.cancel();
			}
		}
		catch(CommandException e) {
			commandSource.sendError(new LiteralText(e.getMessage()));
			callback.cancel();
		}
		catch(Throwable e) {
			commandSource.sendError(new LiteralText("An unexpected error occured"));
			callback.cancel();
		}
	}

}
