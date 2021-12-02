package me.mcblueparrot.spade;

import me.mcblueparrot.spade.event.Event;
import me.mcblueparrot.spade.event.EventListener;
import me.mcblueparrot.spade.event.EventPriority;

public class RegisteredListener {

	private Class<? extends Event> event;
	private EventListener<?> listener;
	private EventPriority priority = EventPriority.NORMAL;

	public RegisteredListener(Class<? extends Event> event, EventListener<?> listener, EventPriority priority) {
		this.event = event;
		this.listener = listener;
		this.priority = priority;
	}

	public Class<? extends Event> getEventClass() {
		return event;
	}

	public EventListener<?> getListener() {
		return listener;
	}

	public EventPriority getPriority() {
		return priority;
	}

}
