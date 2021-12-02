package me.mcblueparrot.spade.api;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import org.apache.logging.log4j.Logger;

import me.mcblueparrot.spade.api.block.BlockType;
import me.mcblueparrot.spade.api.command.CommandSender;
import me.mcblueparrot.spade.api.entity.EntityType;
import me.mcblueparrot.spade.api.entity.Player;
import me.mcblueparrot.spade.api.entity.StatusEffectType;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.item.ItemType;
import me.mcblueparrot.spade.api.plugin.PluginManager;
import me.mcblueparrot.spade.api.recipe.BlastingRecipe;
import me.mcblueparrot.spade.api.recipe.CampfireRecipe;
import me.mcblueparrot.spade.api.recipe.Recipe;
import me.mcblueparrot.spade.api.recipe.ShapedRecipe;
import me.mcblueparrot.spade.api.recipe.ShapelessRecipe;
import me.mcblueparrot.spade.api.recipe.SmeltingRecipe;
import me.mcblueparrot.spade.api.recipe.SmokingRecipe;
import me.mcblueparrot.spade.api.recipe.builder.BlastingRecipeBuilder;
import me.mcblueparrot.spade.api.recipe.builder.CampfireRecipeBuilder;
import me.mcblueparrot.spade.api.recipe.builder.ShapedRecipeBuilder;
import me.mcblueparrot.spade.api.recipe.builder.ShapelessRecipeBuilder;
import me.mcblueparrot.spade.api.recipe.builder.SmeltingRecipeBuilder;
import me.mcblueparrot.spade.api.recipe.builder.SmokingRecipeBuilder;
import me.mcblueparrot.spade.api.server.Server;
import me.mcblueparrot.spade.api.server.ServerVersion;
import me.mcblueparrot.spade.api.world.BiomeType;
import me.mcblueparrot.spade.api.world.World;

/**
 * Represents the Spade core.
 */
public class Spade {

	private static Server server;

	private Spade() {}

	/**
	 * Gets the current server.
	 * @return the server
	 * @throws UnsupportedOperationException if the server is not set
	 * @see Spade#tryGetServer()
	 */
	public static Server getServer() {
		if(!hasServer()) {
			throw new UnsupportedOperationException("The server has not been set - use tryGetServer instead");
		}
		return server;
	}

	/**
	 * Tries to get the current server.
	 * @return the server, or <code>null</code> if it has not been set
	 */
	public static Server tryGetServer() {
		return server;
	}

	/**
	 * Gets if the server has been set.
	 * @return if the server has been set
	 */
	public static boolean hasServer() {
		return server != null;
	}

	/**
	 * Sets the current server.
	 * @param server the server
	 * @return <code>true</code> if the server was set, <code>false</code> otherwise
	 */
	public static boolean setServer(Server server) {
		if(Spade.server != null) {
			return false;
		}
		Spade.server = server;
		return true;
	}

	/**
	 * @see Server#getLogger()
	 */
	public static Logger getLogger() {
		return getServer().getLogger();
	}

	/**
	 * @see Server#getVersion()
	 */
	public static ServerVersion getVersion() {
		return getServer().getVersion();
	}

	/**
	 * @see Server#getPort()
	 */
	public static int getPort() {
		return getServer().getPort();
	}

	/**
	 * @see Server#getIp()
	 */
	public static String getIp() {
		return getServer().getIp();
	}

	/**
	 * @see Server#getMaxPlayers()
	 */
	public static int getMaxPlayers() {
		return getServer().getMaxPlayers();
	}

	/**
	 * @see Server#getWorld(Identifier)
	 */
	public static World getWorld(Identifier id) {
		return getServer().getWorld(id);
	}

	/**
	 * @see Server#getWorld(String)
	 */
	public static World getWorld(String id) {
		return getServer().getWorld(id);
	}

	/**
	 * @see Server#getWorlds()
	 */
	public static List<World> getWorlds() {
		return getServer().getWorlds();
	}

	/**
	 * @see Server#getOverworld()
	 */
	public static World getOverworld() {
		return getServer().getOverworld();
	}

	/**
	 * @see Server#getTheNether()
	 */
	public static World getTheNether() {
		return getServer().getTheNether();
	}

	/**
	 * @see Server#getTheEnd()
	 */
	public static World getTheEnd() {
		return getServer().getTheEnd();
	}

	/**
	 * @see Server#getBlockType(Identifier)
	 */
	public static BlockType getBlockType(Identifier id) {
		return getServer().getBlockType(id);
	}

	/**
	 * @see Server#getBlockType(String)
	 */
	public static BlockType getBlockType(String id) {
		return getServer().getBlockType(id);
	}

	/**
	 * @see Server#getItemType(Identifier)
	 */
	public static ItemType getItemType(Identifier id) {
		return getServer().getItemType(id);
	}

	/**
	 * @see Server#getItemType(String)
	 */
	public static ItemType getItemType(String id) {
		return getServer().getItemType(id);
	}

	/**
	 * @see Server#getEntityType(Identifier)
	 */
	public static EntityType getEntityType(Identifier id) {
		return getServer().getEntityType(id);
	}

	/**
	 * @see Server#getEntityType(String)
	 */
	public static EntityType getEntityType(String id) {
		return getServer().getEntityType(id);
	}

	/**
	 * @see Server#getStatusEffectType(Identifier)
	 */
	public static StatusEffectType getStatusEffectType(Identifier id) {
		return getServer().getStatusEffectType(id);
	}

	/**
	 * @see Server#getStatusEffectType(String)
	 */
	public static StatusEffectType getStatusEffectType(String id) {
		return getServer().getStatusEffectType(id);
	}

	/**
	 * @see Server#getBiomeType(Identifier)
	 */
	public static BiomeType getBiomeType(Identifier id) {
		return getServer().getBiomeType(id);
	}

	/**
	 * @see Server#getBiomeType(String)
	 */
	public static BiomeType getBiomeType(String id) {
		return getServer().getBiomeType(id);
	}

	/**
	 * @see Server#getBlockTypes()
	 */
	public static List<BlockType> getBlockTypes() {
		return getServer().getBlockTypes();
	}

	/**
	 * @see Server#getItemTypes()
	 */
	public static List<ItemType> getItemTypes() {
		return getServer().getItemTypes();
	}

	/**
	 * @see Server#getEntityTypes()
	 */
	public static List<EntityType> getEntityTypes() {
		return getServer().getEntityTypes();
	}

	/**
	 * @see Server#getStatusEffectTypes()
	 */
	public static List<StatusEffectType> getStatusEffectTypes() {
		return getServer().getStatusEffectTypes();
	}

	/**
	 * @see Server#getBiomeTypes()
	 */
	public static List<BiomeType> getBiomeTypes() {
		return getServer().getBiomeTypes();
	}

	/**
	 * @see Server#getRecipes()
	 */
	public static List<Recipe> getRecipes() {
		return getServer().getRecipes();
	}

	/**
	 * @see Server#getRecipe(Identifier)
	 */
	public static Recipe getRecipe(Identifier id) {
		return getServer().getRecipe(id);
	}

	/**
	 * @see Server#getRecipe(String)
	 */
	public static Recipe getRecipe(String id) {
		return getServer().getRecipe(id);
	}

	/**
	 * @see Server#sendMessage(String)
	 */
	public static void sendMessage(String message) {
		getServer().sendMessage(message);
	}

	/**
	 * @see Server#sendMessage(String[])
	 */
	public static void sendMessage(String... messages) {
		getServer().sendMessage(messages);
	}

	/**
	 * @see Server#executeCommand(String)
	 */
	public static void executeCommand(String command) {
		getServer().executeCommand(command);
	}

	/**
	 * @see Server#dispatchCommand(CommandSender, String)
	 */
	public static void dispatchCommand(CommandSender sender, String command) {
		getServer().dispatchCommand(sender, command);
	}

	/**
	 * @see Server#getOnlinePlayers()
	 */
	public static List<Player> getOnlinePlayers() {
		return getServer().getOnlinePlayers();
	}

	/**
	 * @see Server#getPluginsFolder()
	 */
	public static File getPluginsFolder() {
		return getServer().getPluginsFolder();
	}

	/**
	 * @see Server#broadcastMessage(String)
	 */
	public static void broadcastMessage(String message) {
		getServer().broadcastMessage(message);
	}

	/**
	 * @see Server#broadcastMessage(String, Predicate)
	 */
	public static void broadcastMessage(String message, Predicate<CommandSender> predicate) {
		getServer().broadcastMessage(message, predicate);
	}

	/**
	 * @see Server#getPluginManager()
	 */
	public static PluginManager getPluginManager() {
		return getServer().getPluginManager();
	}

	/**
	 * @see Server#createShapelessRecipe(ShaplessRecipeBuilder)
	 */
	public static ShapelessRecipe createShapelessRecipe(ShapelessRecipeBuilder builder) {
		return getServer().createShapelessRecipe(builder);
	}

	/**
	 * @see Server#createShapedRecipe(ShapedRecipeBuilder)
	 */
	public static ShapedRecipe createShapedRecipe(ShapedRecipeBuilder builder) {
		return getServer().createShapedRecipe(builder);
	}

	/**
	 * @see Server#createSmeltingRecipe(SmeltingRecipeBuilder)
	 */
	public static SmeltingRecipe createSmeltingRecipe(SmeltingRecipeBuilder builder) {
		return getServer().createSmeltingRecipe(builder);
	}

	/**
	 * @see Server#createBlastingRecipe(BlastingRecipeBuilder)
	 */
	public static BlastingRecipe createBlastingRecipe(BlastingRecipeBuilder builder) {
		return getServer().createBlastingRecipe(builder);
	}

	/**
	 * @see Server#createSmokingRecipe(SmokingRecipeBuilder)
	 */
	public static SmokingRecipe createSmokingRecipe(SmokingRecipeBuilder builder) {
		return getServer().createSmokingRecipe(builder);
	}

	/**
	 * @see Server#createCampfireRecipe(CampfireRecipeBuilder)
	 */
	public static CampfireRecipe createCampfireRecipe(CampfireRecipeBuilder builder) {
		return getServer().createCampfireRecipe(builder);
	}

	/**
	 * @see Server#getPlayer(String)
	 */
	public static Player getPlayer(String username) {
		return getServer().getPlayer(username);
	}

	/**
	 * @see Server#getPlayer(UUID)
	 */
	public static Player getPlayer(UUID id) {
		return getServer().getPlayer(id);
	}

}
