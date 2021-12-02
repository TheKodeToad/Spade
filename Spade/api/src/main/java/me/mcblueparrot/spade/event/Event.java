package me.mcblueparrot.spade.event;

import me.mcblueparrot.spade.PluginManager;
import me.mcblueparrot.spade.Spade;

/**
 * An event that can be called through {@link PluginManager}
 */
public interface Event {

	/**
	 * @see PluginManager#callEvent(Event)
	 */
	public static void call(Event event) {
		Spade.callEvent(event);
	}

}
