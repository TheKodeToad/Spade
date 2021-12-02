package me.mcblueparrot.spade.api.plugin.loader;

/**
 * Represents an error that occured during the loading of a plugin.
 */
public class PluginLoadException extends RuntimeException {

	private static final long serialVersionUID = -5233054017778451562L;

	/**
	 * Creates a plugin load exception.
	 * @param message the detail message
	 */
	public PluginLoadException(String message) {
		super(message);
	}

	/**
	 * Creates a plugin load exception.
	 * @param message the detail message
	 * @param cause the exception's cause
	 */
	public PluginLoadException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates a plugin load exception.
	 * @param cause the exception's cause
	 */
	public PluginLoadException(Throwable cause) {
		super(cause);
	}

}
