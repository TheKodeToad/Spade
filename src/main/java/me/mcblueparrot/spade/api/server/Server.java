package me.mcblueparrot.spade.api.server;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import org.apache.logging.log4j.Logger;

import me.mcblueparrot.spade.api.Spade;
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
import me.mcblueparrot.spade.api.world.BiomeType;
import me.mcblueparrot.spade.api.world.World;

/**
 * Represents a server.
 */
public interface Server extends CommandSender {

	/**
	 * @see Spade#getServer()
	 */
	public static Server getInstance() {
		return Spade.getServer();
	}

	/**
	 * Gets the server version.
	 * @return the version
	 */
	public ServerVersion getVersion();

	/**
	 * Gets the server port.
	 * @return the port
	 */
	public int getPort();

	/**
	 * Gets the server IP (most likely <code>null</code>).
	 * @return the IP
	 */
	public String getIp();

	/**
	 * Gets the maximum players allowed on the server.
	 * @return the maximum players
	 */
	public int getMaxPlayers();

	/**
	 * Gets a world by its identifier.
	 * @param id the identifier
	 * @return the world
	 */
	public World getWorld(Identifier id);

	/**
	 * Gets a world by its identifier.
	 * @param id the identifier (as a string)
	 * @return the world
	 */
	public default World getWorld(String id) {
		return getWorld(Identifier.parse(id));
	}

	/**
	 * Gets a list of all worlds.
	 * @return the list
	 */
	public List<World> getWorlds();

	/**
	 * Gets the server's overworld dimension.
	 * @return the overworld dimension
	 */
	public default World getOverworld() {
		return getWorld(Identifier.minecraft("overworld"));
	}

	/**
	 * Gets the server's nether dimension.
	 * @return the nether dimension
	 */
	public default World getTheNether() {
		return getWorld(Identifier.minecraft("the_nether"));
	}

	/**
	 * Gets the server's end dimension.
	 * @return the end dimension
	 */
	public default World getTheEnd() {
		return getWorld(Identifier.minecraft("the_nether"));
	}

	/**
	 * Gets a block type by its identifier.
	 * @param id the identifier
	 * @return the block type
	 */
	public BlockType getBlockType(Identifier id);

	/**
	 * Gets a block type by its identifier.
	 * @param id the identifier (as a string)
	 * @return the block type
	 */
	public default BlockType getBlockType(String id) {
		return getBlockType(Identifier.parse(id));
	}

	/**
	 * Gets an item type by its identifier.
	 * @param id the identifier
	 * @return the item type
	 */
	public ItemType getItemType(Identifier id);

	/**
	 * Gets an item type by its identifier.
	 * @param id the identifier (as a string)
	 * @return the item type
	 */
	public default ItemType getItemType(String id) {
		return getItemType(Identifier.parse(id));
	}

	/**
	 * Gets an entity type by its identifier.
	 * @param id the identifier
	 * @return the entity type
	 */
	public EntityType getEntityType(Identifier id);

	/**
	 * Gets an entity type by its identifier.
	 * @param id the identifier (as a string)
	 * @return the entity type
	 */
	public default EntityType getEntityType(String id) {
		return getEntityType(Identifier.parse(id));
	}

	/**
	 * Gets a status effect type by its identifier.
	 * @param id the identifier
	 * @return the status effect type
	 */
	public StatusEffectType getStatusEffectType(Identifier id);

	/**
	 * Gets a status effect type by its identifier.
	 * @param id the identifier (as a string)
	 * @return the status effect type
	 */
	public default StatusEffectType getStatusEffectType(String id) {
		return getStatusEffectType(id);
	}

	/**
	 * Gets a biome type by its identifier.
	 * @param id the identifier
	 * @return the biome type
	 */
	public BiomeType getBiomeType(Identifier id);

	/**
	 * Gets a biome type by its identifier.
	 * @param id the identifier (as a string)
	 * @return the biome type
	 */
	public default BiomeType getBiomeType(String id) {
		return getBiomeType(Identifier.parse(id));
	}

	/**
	 * Gets a list of all block types.
	 * @return the list
	 */
	public List<BlockType> getBlockTypes();

	/**
	 * Gets a list of all item types.
	 * @return the list
	 */
	public List<ItemType> getItemTypes();

	/**
	 * Gets a list of all entity types.
	 * @return the list
	 */
	public List<EntityType> getEntityTypes();

	/**
	 * Gets a list of all status effect types.
	 * @return the list
	 */
	public List<StatusEffectType> getStatusEffectTypes();

	/**
	 * Gets a list of all biome types.
	 * @return the list
	 */
	public List<BiomeType> getBiomeTypes();

	/**
	 * Gets a list of all recipes.
	 * @return the list
	 */
	public List<Recipe> getRecipes();

	/**
	 * Gets a recipe by its identifier.
	 * @param id the identifier
	 * @return the recipe
	 */
	public Recipe getRecipe(Identifier id);

	/**
	 * Gets a recipe by its identifier.
	 * @param id the identifier (as a string)
	 * @return the recipe
	 */
	public default Recipe getRecipe(String id) {
		return getRecipe(Identifier.parse(id));
	}

	/**
	 * Gets the server's logger.
	 * @return the logger
	 */
	public Logger getLogger();

	@Override
	public default void sendMessage(String message) {
		getLogger().info(message);
	}

	/**
	 * Executes a command as the console.
	 */
	@Override
	public default void executeCommand(String command) {
		CommandSender.super.executeCommand(command);
	}

	/**
	 * Dispatches a command as a command sender.
	 * @param sender the command sender
	 * @param command the command
	 */
	public void dispatchCommand(CommandSender sender, String command);

	/**
	 * Gets a list of online players.
	 * @return the list
	 */
	public List<Player> getOnlinePlayers();

	/**
	 * Gets the folder where plugins are stored.
	 * @return the folder
	 */
	public default File getPluginsFolder() {
		return new File(".", "plugins");
	}

	/**
	 * Broadcasts a message.
	 * @param message the message
	 */
	public default void broadcastMessage(String message) {
		broadcastMessage(message, (sender) -> true);
	}

	/**
	 * Broadcasts a message.
	 * @param message the message
	 * @param filter the recipient filter
	 */
	public default void broadcastMessage(String message, Predicate<CommandSender> filter) {
		List<CommandSender> recipients = new ArrayList<CommandSender>();
		recipients.addAll(getOnlinePlayers());
		recipients.add(this);
		for(CommandSender recipient : recipients) {
			if(filter.test(recipient)) {
				recipient.sendMessage(message);
			}
		}
	}

	/**
	 * Gets the server's plugin manager.
	 * @return the plugin manager
	 */
	public PluginManager getPluginManager();

	/**
	 * Creates a shapeless recipe from a recipe builder.
	 * @param builder the builder
	 * @return the recipe
	 */
	public ShapelessRecipe createShapelessRecipe(ShapelessRecipeBuilder builder);

	/**
	 * Creates a shaped recipe from a recipe builder.
	 * @param builder the builder
	 * @return the recipe
	 */
	public ShapedRecipe createShapedRecipe(ShapedRecipeBuilder builder);

	/**
	 * Creates a smelting recipe from a recipe builder.
	 * @param builder the builder
	 * @return the recipe
	 */
	public SmeltingRecipe createSmeltingRecipe(SmeltingRecipeBuilder builder);

	/**
	 * Creates a blasting recipe from a recipe builder.
	 * @param builder the builder
	 * @return the recipe
	 */
	public BlastingRecipe createBlastingRecipe(BlastingRecipeBuilder builder);

	/**
	 * Creates a smoking recipe from a recipe builder.
	 * @param builder the builder
	 * @return the recipe
	 */
	public SmokingRecipe createSmokingRecipe(SmokingRecipeBuilder builder);

	/**
	 * Creates a campfire recipe from a recipe builder.
	 * @param builder the builder
	 * @return the recipe
	 */
	public CampfireRecipe createCampfireRecipe(CampfireRecipeBuilder builder);

	/**
	 * Gets a player by their username.
	 * @param username the username
	 * @return the player
	 */
	public Player getPlayer(String username);

	/**
	 * Gets a player by their uuid.
	 * @param id the uuid
	 * @return the player
	 */
	public Player getPlayer(UUID id);

}
