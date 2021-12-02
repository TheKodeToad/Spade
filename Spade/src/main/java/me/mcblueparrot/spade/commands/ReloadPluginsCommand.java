package me.mcblueparrot.spade.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import me.mcblueparrot.spade.Spade;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

public class ReloadPluginsCommand implements Command<ServerCommandSource> {

	@Override
	public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
		context.getSource().sendFeedback(new LiteralText("Reloading..."), true);
		try {
			Spade.getPluginManager().reload();
		}
		catch(Throwable e) {
			context.getSource().sendError(new LiteralText("Could not reload"));
			return 0;
		}
		context.getSource().sendFeedback(new LiteralText("Reloaded"), true);
		return 0;
	}

}
