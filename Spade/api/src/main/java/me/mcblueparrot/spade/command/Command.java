package me.mcblueparrot.spade.command;

import java.util.List;

import me.mcblueparrot.spade.CommandSender;

/**
 * Represents a command
 */
public interface Command {

	/**
	 * Invoked when the command is executed
	 * @param sender The sender of the command
	 * @param arguments The arguments
	 */
	public void execute(CommandSender sender, List<String> arguments) throws CommandException;

}
