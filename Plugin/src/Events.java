import me.mcblueparrot.spade.Plugin;
import me.mcblueparrot.spade.Spade;
import me.mcblueparrot.spade.entity.Player;
import me.mcblueparrot.spade.event.player.PlayerChatEvent;
import me.mcblueparrot.spade.event.player.PlayerJoinEvent;
import me.mcblueparrot.spade.event.player.PlayerQuitEvent;

public class Events {

	public static void register() {
		Plugin plugin = Main.getInstance();
		Spade.registerListener(plugin, PlayerJoinEvent.class, Events::onPlayerJoin);
		Spade.registerListener(plugin, PlayerChatEvent.class, Events::onPlayerChat);
	}

	public static void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.sendMessage(Main.getInstance().getConfig().getSection("messages").getString("welcome"));
//		player.setClientTime(1000);
		System.out.println(player.getWorld().getName());
		System.out.println(player.getWorld().getTime());
		System.out.println(player.getWorld().getTimeOfDay());
//		Main.getInstance().getConfig().set(event.getPlayer().getUUID().toString(), event.getPlayer());
//		try {
//			Main.getInstance().saveConfig();
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public static void onPlayerQuit(PlayerQuitEvent event) {
	}

	public static void onPlayerChat(PlayerChatEvent event) {
		event.setFormat(Main.getInstance().getConfig().getSection("messages").getString("chat"));
	}

}
