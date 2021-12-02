package me.mcblueparrot.spade.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import me.mcblueparrot.spade.Spade;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

public class PluginsCommand implements Command<ServerCommandSource> {

	@Override
	public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
		if(Spade.getPluginManager().getPlugins().isEmpty()) {
			context.getSource().sendFeedback(new TranslatableText("No plugins installed"), false);
		}
		else {
			StringBuilder plugins = new StringBuilder();
			Spade.getPluginManager().getPlugins().forEach((plugin) -> plugins.append(plugin.getName()));
			context.getSource().sendFeedback(new TranslatableText("Plugins"), false);
			context.getSource().sendFeedback(new LiteralText(plugins.toString()), false);
		}
		return 0;
	}

}
