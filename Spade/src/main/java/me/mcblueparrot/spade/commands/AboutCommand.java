package me.mcblueparrot.spade.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import me.mcblueparrot.spade.Spade;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

public class AboutCommand implements Command<ServerCommandSource> {

	@Override
	public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
		context.getSource().sendFeedback(new TranslatableText("This server is running Spade " + Spade.getVersion().getId()), false);
		return 0;
	}

}
