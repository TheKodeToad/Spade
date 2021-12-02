package me.mcblueparrot.spade.main;

import org.apache.logging.log4j.Logger;

import me.mcblueparrot.spade.Spade;
import me.mcblueparrot.spade.launcher.SpadeLauncher;
import net.minecraft.launchwrapper.Launch;

public class Main {

	public static void main(String[] args) throws Throwable {
		Logger logger = Spade.getLogger();
		if(Launch.classLoader == null || !(Main.class.getClassLoader().equals(Launch.classLoader))) {
			logger.warn("Didn't launch properly. Relaunching through " + SpadeLauncher.class.getName() + "...");
			SpadeLauncher.main(args);
			System.exit(0);
		}
		logger.info("Starting server...");
		try {
			net.minecraft.server.Main.main(args);
		}
		catch(Throwable e) {
			e.fillInStackTrace();
			logger.error("Could not start server:", e);
		}
	}

}
