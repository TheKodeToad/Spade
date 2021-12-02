package me.mcblueparrot.spade.command;

/**
 * Thrown when an error occurs executing a command
 */
public class CommandException extends Exception {

	private static final long serialVersionUID = 4853105649796282326L;

	/**
	 * Creates a {@link CommandException}
	 * @param message The error message
	 */
	public CommandException(String message) {
		super(message);
	}

}
