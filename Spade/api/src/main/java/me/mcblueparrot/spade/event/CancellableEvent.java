package me.mcblueparrot.spade.event;

/**
 * An event that can be cancelled
 */
public interface CancellableEvent {

	/**
	 * Sets whether to cancel the event
	 * @param cancelled Whether to cancel the event
	 */
	public void setCancelled(boolean cancelled);

	/**
	 * Gets whether the event will be cancelled
	 * @return Whether the event will be cancelled
	 */
	public boolean isCancelled();

}
