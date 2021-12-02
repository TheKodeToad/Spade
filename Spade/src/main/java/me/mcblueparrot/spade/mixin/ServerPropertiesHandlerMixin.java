package me.mcblueparrot.spade.mixin;

import java.util.Properties;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.mcblueparrot.spade.vanilla.VanillaServer;
import net.minecraft.server.dedicated.AbstractPropertiesHandler;
import net.minecraft.server.dedicated.ServerPropertiesHandler;
import net.minecraft.util.registry.DynamicRegistryManager;

@Mixin(ServerPropertiesHandler.class)
public abstract class ServerPropertiesHandlerMixin extends AbstractPropertiesHandler<ServerPropertiesHandler> {

	public ServerPropertiesHandlerMixin(Properties properties) {
		super(properties);
	}

	@Shadow
//	public boolean onlineMode;
//	@Shadow
//	public boolean preventProxyConnections;
//	@Shadow
//	public String serverIp;
//	@Shadow
//	public boolean spawnAnimals;
//	@Shadow
//	public boolean spawnNpcs;
//	@Shadow
//	public boolean pvp;
//	@Shadow
//	public boolean allowFlight;
//	@Shadow
//	public String resourcePack;
//	@Shadow
//	public String resourcePackHash;
//	@Shadow
//	public String resourcePackSha1;
//	@Shadow
//	public String motd;
//	@Shadow
//	public boolean forceGameMode;
//	@Shadow
//	public boolean enforceWhitelist;
//	@Shadow
//	public Difficulty difficulty;
//	@Shadow
//	public GameMode gameMode;
//	@Shadow
//	public String levelName;
//	@Shadow
//	public int serverPort;
//	@Shadow
//	public int maxBuildHeight;
//	@Shadow
//	public Boolean announcePlayerAchievements;
//	@Shadow
//	public boolean enableQuery;
//	@Shadow
//	public int queryPort;
//	@Shadow
//	public boolean enableRcon;
//	@Shadow
//	public int rconPort;
//	@Shadow
//	public String rconPassword;
//	@Shadow
//	public boolean hardcore;
//	@Shadow
//	public boolean allowNether;
//	@Shadow
//	public boolean spawnMonsters;
//	@Shadow
//	public boolean snooperEnabled;
//	@Shadow
//	public boolean useNativeTransport;
//	@Shadow
//	public boolean enableCommandBlock;
//	@Shadow
//	public int spawnProtection;
//	@Shadow
//	public int opPermissionLevel;
//	@Shadow
//	public int functionPermissionLevel;
//	@Shadow
//	public long maxTickTime;
//	@Shadow
//	public int viewDistance;
//	@Shadow
//	public int maxPlayers;
//	@Shadow
//	public int networkCompressionThreshold;
//	@Shadow
//	public boolean broadcastRconToOps;
//	@Shadow
//	public boolean broadcastConsoleToOps;
//	@Shadow
//	public int maxWorldSize;
//	@Shadow
//	public boolean syncChunkWrites;
//	@Shadow
//	public boolean enableJmxMonitoring;
//	@Shadow
//	public boolean enableStatus;
//	@Shadow
//	public int entityBroadcastRangePercentage;
//	@Shadow
//	public AbstractPropertiesHandler<ServerPropertiesHandler>.PropertyAccessor<Integer> playerIdleTimeout;
//	@Shadow
//	public AbstractPropertiesHandler<ServerPropertiesHandler>.PropertyAccessor<Boolean> whiteList;
//	@Shadow
//	public GeneratorOptions field_24623;

	@Inject(at = @At("RETURN"), method = "<init>")
	public void init(Properties properties, DynamicRegistryManager manager, CallbackInfo callback) {
		VanillaServer.setProperties(parseBoolean("bungeecord", false));
//		Configuration config = VanillaServer.getConfig();
//		onlineMode = config.getBoolean("onlineMode");
//		preventProxyConnections = config.getBoolean("preventProxyConnections");
//		serverIp = config.getString("serverIp");
//		spawnAnimals = config.getBoolean("spawnAnimals");
//		spawnNpcs = config.getBoolean("spawnNpcs");
//		pvp = config.getBoolean("pvp");
//		allowFlight = config.getBoolean("allowFlight");
//		resourcePack = config.getSection("resourcePack").getString("url");
//		resourcePackHash = config.getSection("resourcePack").getString("hash");
//		resourcePackSha1 = config.getSection("resourcePack").getString("sha1");
//		motd = config.getString("motd");
//		forceGameMode = config.getBoolean("forceGameMode");
//		enforceWhitelist = config.getBoolean("enforceWhitelist");
//		difficulty = Difficulty.valueOf(config.getString("difficulty").toUpperCase());
//		gameMode = GameMode.valueOf(config.getString("gameMode").toUpperCase());
//		levelName = config.getString("levelName");
//		serverPort = config.getInt("serverPort");
//		maxBuildHeight = config.getInt("maxBuildHeight");
//		announcePlayerAchievements = config.getBoolean("announcePlayerAchievements");
//		enableQuery = config.getSection("query").getBoolean("enabled");
//		queryPort = config.getSection("query").getInt("port");
//		enableRcon = config.getSection("rcon").getBoolean("enabled");
//		rconPort = config.getSection("rcon").getInt("port");
//		rconPassword = config.getSection("rcon").getString("password");
//		hardcore = config.getBoolean("hardcore");
//		allowNether = config.getBoolean("allowNether");
//		spawnMonsters = config.getBoolean("spawnMonsters");
//		snooperEnabled = config.getBoolean("snooper");
//		useNativeTransport = config.getBoolean("useNativeTransport");
//		enableCommandBlock = config.getBoolean("enableCommandBlocks");
//		spawnProtection = config.getInt("spawnProtection");
//		opPermissionLevel = config.getInt("opPermissionLevel");
//		functionPermissionLevel = config.getInt("functionPermissionLevel");
//		maxTickTime = config.getLong("maxTickTime");
//		viewDistance = config.getInt("viewDistance");
//		spawnProtection = config.getInt("spawnProtection");
//		maxPlayers = config.getInt("maxPlayers");
//		networkCompressionThreshold = config.getInt("networkCompressionThreshold");
//		spawnProtection = config.getInt("forceGameMode");
//		broadcastRconToOps = config.getBoolean("broadcastRconToOps");
//		broadcastConsoleToOps = config.getBoolean("broadcastConsoleToOps");
//		maxWorldSize = MathHelper.clamp(config.getInt("maxWorldSize"), 1, 29999984);
//		syncChunkWrites = config.getBoolean("syncChunkWrites");
//		enableJmxMonitoring = config.getBoolean("jmxMonitoring");
//		enableJmxMonitoring = config.getBoolean("jmxMonitoring");
//		enableStatus = config.getBoolean("enableStatus");
//		entityBroadcastRangePercentage = MathHelper.clamp(config.getInt("entityBroadcastRangePercentage"), 10, 1000);
	}

}
