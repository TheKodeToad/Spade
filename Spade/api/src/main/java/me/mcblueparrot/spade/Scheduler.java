package me.mcblueparrot.spade;

public interface Scheduler {

	/**
	 * @see Server#getScheduler()
	 */
	public static Scheduler getInstance() {
		return Spade.getScheduler();
	}


	/**
	 * Runs a task asynchronously
	 * @param task The task
	 */
	public void runTaskAsync(Runnable task);

}
