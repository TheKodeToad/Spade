package me.mcblueparrot.spade.vanilla;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Logger;

import me.mcblueparrot.spade.PluginManager;
import me.mcblueparrot.spade.Scheduler;
import me.mcblueparrot.spade.Server;
import me.mcblueparrot.spade.ServerVersion;
import me.mcblueparrot.spade.Spade;
import me.mcblueparrot.spade.SpadePluginManager;
import me.mcblueparrot.spade.SpadeScheduler;
import me.mcblueparrot.spade.block.Block;
import me.mcblueparrot.spade.entity.EntityType;
import me.mcblueparrot.spade.entity.Player;
import me.mcblueparrot.spade.item.Item;
import me.mcblueparrot.spade.vanilla.block.VanillaBlock;
import me.mcblueparrot.spade.vanilla.entity.VanillaEntityType;
import me.mcblueparrot.spade.vanilla.entity.VanillaPlayer;
import me.mcblueparrot.spade.vanilla.item.VanillaItem;
import net.md_5.bungee.api.chat.BaseComponent;
import net.minecraft.MinecraftVersion;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.dedicated.MinecraftDedicatedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VanillaServer implements VanillaBased<MinecraftDedicatedServer>, Server {

	private static Logger logger = Spade.getLogger();
	private static boolean bungeecord = false;
	protected MinecraftDedicatedServer server;
	private ServerVersion version = new VanillaServerVersion(MinecraftVersion.create());
	private PluginManager pluginManager = new SpadePluginManager();
	private Scheduler scheduler = new SpadeScheduler();
	private Map<String, Item> itemMap = new HashMap<String, Item>();
	private Map<String, Block> blockMap = new HashMap<String, Block>();
	private Map<String, EntityType> entityMap = new HashMap<String, EntityType>();

	public static void setProperties(boolean bungeecord) {
		VanillaServer.bungeecord = bungeecord;
	}

	public static boolean isBungeecord() {
		return bungeecord;
	}

	public VanillaServer(MinecraftDedicatedServer server) {
		this.server = server;
//		dump();
	}

	public void init() {
		logger.info("Loading items, blocks and entities...");
		for(net.minecraft.item.Item item : Registry.ITEM) {
			Identifier id = Registry.ITEM.getId(item);
			itemMap.put(id.toString(), new VanillaItem(item, id.toString()));
		}
		for(net.minecraft.block.Block block : Registry.BLOCK) {
			Identifier id = Registry.BLOCK.getId(block);
			blockMap.put(id.toString(), new VanillaBlock(block, id.toString()));
		}
		for(net.minecraft.entity.EntityType<?> entity : Registry.ENTITY_TYPE) {
			Identifier id = Registry.ENTITY_TYPE.getId(entity);
			entityMap.put(id.toString(), new VanillaEntityType(entity, id.toString()));
		}
	}

//	private void dump() {
//		File dumpItems = new File(getFolder(), "dumpItems.java");
//		System.out.println("Dumping items...");
//		StringBuilder items = new StringBuilder();
//		for(net.minecraft.item.Item item : Registry.ITEM) {
//			Identifier id = Registry.ITEM.getId(item);
//			System.out.println("Dumping " + id.getPath() + "...");
//			items.append("\tpublic static final Item " + id.getPath().toUpperCase() + " = register(\"" + id.getPath() + "\");\n");
//		}
//		try {
//			FileUtils.writeStringToFile(dumpItems, items.toString(), Charset.defaultCharset());
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Dumped");
//		File dumpBlocks = new File(getFolder(), "dumpBlocks.java");
//		System.out.println("Dumping blocks...");
//		StringBuilder blocks = new StringBuilder();
//		for(net.minecraft.block.Block block : Registry.BLOCK) {
//			Identifier id = Registry.BLOCK.getId(block);
//			System.out.println("Dumping " + id.getPath() + "...");
//			blocks.append("\tpublic static final Block " + id.getPath().toUpperCase() + " = register(\"" + id.getPath() + "\");\r");
//		}
//		try {
//			FileUtils.writeStringToFile(dumpBlocks, blocks.toString(), Charset.defaultCharset());
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Dumped");
//		File dumpEntities = new File(getFolder(), "dumpEntities.java");
//		System.out.println("Dumping entities...");
//		StringBuilder entities = new StringBuilder();
//		for(net.minecraft.entity.EntityType<?> entity : Registry.ENTITY_TYPE) {
//			Identifier id = Registry.ENTITY_TYPE.getId(entity);
//			System.out.println("Dumping " + id.getPath() + "...");
//			String className = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, id.getPath());
//			if(!className.equals("Player")) {
//				className += "Entity";
//			}
//			entities.append("\tpublic static final EntityType<" + className + "> " + id.getPath().toUpperCase() + " = EntityTypes.<" + className + ">register(\"" + id.getPath() + "\");\r");
//		}
//		try {
//			FileUtils.writeStringToFile(dumpEntities, entities.toString(), Charset.defaultCharset());
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Dumped");
//		System.exit(0);
//	}

	@Override
	public MinecraftDedicatedServer getVanilla() {
		return server;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{version = " + getVersion() + "}";
	}

	public static VanillaServer getInstance() {
		return (VanillaServer) Spade.getServer();
	}

	@Override
	public int getPort() {
		return server.getServerPort();
	}

	@Override
	public String getIp() {
		return server.getServerIp();
	}

	@Override
	public ServerVersion getVersion() {
		return version;
	}

	@Override
	public File getFolder() {
		return server.getRunDirectory();
	}

	@Override
	public File getPluginFolder() {
		return new File(getFolder(), "plugins");
	}

	@Override
	public PluginManager getPluginManager() {
		return pluginManager;
	}

	@Override
	public void sendMessage(String message) {
		logger.info(message);
	}

	@Override
	public void sendMessage(BaseComponent message) {
		logger.info(message.toPlainText());
	}

	@Override
	public void sendJsonMessage(String json) {
		sendMessage(Text.Serializer.fromJson(json).asString());
	}

	@Override
	public Player getPlayer(UUID uuid) {
		ServerPlayerEntity player = server.getPlayerManager().getPlayer(uuid);
		if(player == null) {
			return null;
		}
		return new VanillaPlayer(player);
	}

	@Override
	public Player getPlayer(String username) {
		ServerPlayerEntity player = server.getPlayerManager().getPlayer(username);
		if(player == null) {
			return null;
		}
		return new VanillaPlayer(player);
	}

	@Override
	public Set<VanillaPlayer> getPlayers() {
		return server.getPlayerManager().getPlayerList().stream().map(VanillaPlayer::new).collect(Collectors.toSet());
	}

	@Override
	public int getMaxPlayers() {
		return server.getMaxPlayerCount();
	}

	@Override
	public void setMaxPlayers(int maxPlayers) {
		Field maxPlayersField;
		try {
			maxPlayersField = PlayerManager.class.getDeclaredField("maxPlayerCount");
			maxPlayersField.setAccessible(true);
			maxPlayersField.set(server.getPlayerManager(), maxPlayers);
		}
		catch(NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			return;
		}
	}

	@Override
	public boolean isOperator() {
		return true;
	}

	@Override
	public boolean isConsole() {
		return true;
	}

	@Override
	public Scheduler getScheduler() {
		return scheduler;
	}

	@Override
	public Item getItem(String id) {
		Identifier identifier = new Identifier(id);
		return itemMap.get(identifier.toString());
	}

	@Override
	public Block getBlock(String id) {
		Identifier identifier = new Identifier(id);
		return blockMap.get(identifier.toString());
	}

	@Override
	public EntityType getEntityType(String id) {
		Identifier identifier = new Identifier(id);
		return entityMap.get(identifier.toString());
	}

}
