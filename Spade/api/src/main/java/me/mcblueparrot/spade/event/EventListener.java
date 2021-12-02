package me.mcblueparrot.spade.event;

import me.mcblueparrot.spade.Plugin;
import me.mcblueparrot.spade.PluginManager;
import me.mcblueparrot.spade.Spade;

/**
 * An event listener that gets called when an event occurs
 * @param <E> The event to listen to
 */
@FunctionalInterface
public interface EventListener<E extends Event> {

	/**
	 * @see PluginManager#registerListener(Plugin, Class, EventListener)
	 */
	public static <E extends Event> void register(Plugin plugin, Class<E> event, EventListener<E> listener) {
		Spade.getPluginManager().registerListener(plugin, event, listener);
	}

	/**
	 * @see PluginManager#registerListener(Plugin, Class, EventListener, EventPriority)
	 */
	public static <E extends Event> void register(Plugin plugin, Class<E> event, EventListener<E> listener, EventPriority priority) {
		Spade.getPluginManager().registerListener(plugin, event, listener, priority);
	}

	public void onEvent(E event);

}
