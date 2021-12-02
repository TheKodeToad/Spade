import java.io.IOException;
import java.util.Arrays;

import me.mcblueparrot.spade.Plugin;
import me.mcblueparrot.spade.Spade;
import me.mcblueparrot.spade.command.CommandException;

public class Main extends Plugin {

	private static Plugin instance;

	@Override
	public void onEnable() {
		instance = this;
		try {
			saveDefaultConfig();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Events.register();
		getConfig().getSection("cool").set("enabled", true);
		getConfig().getSection("this").getSection("is").getSection("so").getSection("cool").set("don't", "you think");
		getConfig().getSection("hello").set("heaopehpe9uaspihuaeop", Arrays.asList("mo", "go", "loo", "poo"));
		try {
			saveConfig();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Spade.registerCommand("hello", (sender, args) -> {
			if(!(sender.isOperator())) {
				throw new CommandException("You are not an op");
			}
			sender.sendMessage("You are an op!");
		});
		System.out.println(getConfig().getSection("cool").getBoolean("enabled"));
	}

	@Override
	public void onDisable() {
		System.out.println("Goodbye");
	}

	public static Plugin getInstance() {
		return instance;
	}

}
