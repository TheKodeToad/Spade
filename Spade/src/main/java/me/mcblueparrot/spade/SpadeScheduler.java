package me.mcblueparrot.spade;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SpadeScheduler implements Scheduler {

	private ExecutorService threadPool = Executors.newFixedThreadPool(4);

	@Override
	public void runTaskAsync(Runnable task) {
		threadPool.submit(task);
	}

}
