package me.mcblueparrot.spade.entity;

import me.mcblueparrot.spade.Location;
import me.mcblueparrot.spade.Spade;

public interface EntityType {

	public static final EntityType AREA_EFFECT_CLOUD = get("area_effect_cloud");
	public static final EntityType ARMOR_STAND = get("armor_stand");
	public static final EntityType ARROW = get("arrow");
	public static final EntityType BAT = get("bat");
	public static final EntityType BEE = get("bee");
	public static final EntityType BLAZE = get("blaze");
	public static final EntityType BOAT = get("boat");
	public static final EntityType CAT = get("cat");
	public static final EntityType CAVE_SPIDER = get("cave_spider");
	public static final EntityType CHICKEN = get("chicken");
	public static final EntityType COD = get("cod");
	public static final EntityType COW = get("cow");
	public static final EntityType CREEPER = get("creeper");
	public static final EntityType DOLPHIN = get("dolphin");
	public static final EntityType DONKEY = get("donkey");
	public static final EntityType DRAGON_FIREBALL = get("dragon_fireball");
	public static final EntityType DROWNED = get("drowned");
	public static final EntityType ELDER_GUARDIAN = get("elder_guardian");
	public static final EntityType END_CRYSTAL = get("end_crystal");
	public static final EntityType ENDER_DRAGON = get("ender_dragon");
	public static final EntityType ENDERMAN = get("enderman");
	public static final EntityType ENDERMITE = get("endermite");
	public static final EntityType EVOKER = get("evoker");
	public static final EntityType EVOKER_FANGS = get("evoker_fangs");
	public static final EntityType EXPERIENCE_ORB = get("experience_orb");
	public static final EntityType EYE_OF_ENDER = get("eye_of_ender");
	public static final EntityType FALLING_BLOCK = get("falling_block");
	public static final EntityType FIREWORK_ROCKET = get("firework_rocket");
	public static final EntityType FOX = get("fox");
	public static final EntityType GHAST = get("ghast");
	public static final EntityType GIANT = get("giant");
	public static final EntityType GUARDIAN = get("guardian");
	public static final EntityType HOGLIN = get("hoglin");
	public static final EntityType HORSE = get("horse");
	public static final EntityType HUSK = get("husk");
	public static final EntityType ILLUSIONER = get("illusioner");
	public static final EntityType IRON_GOLEM = get("iron_golem");
	public static final EntityType ITEM = get("item");
	public static final EntityType ITEM_FRAME = get("item_frame");
	public static final EntityType FIREBALL = get("fireball");
	public static final EntityType LEASH_KNOT = get("leash_knot");
	public static final EntityType LIGHTNING_BOLT = get("lightning_bolt");
	public static final EntityType LLAMA = get("llama");
	public static final EntityType LLAMA_SPIT = get("llama_spit");
	public static final EntityType MAGMA_CUBE = get("magma_cube");
	public static final EntityType MINECART = get("minecart");
	public static final EntityType CHEST_MINECART = get("chest_minecart");
	public static final EntityType COMMAND_BLOCK_MINECART = get("command_block_minecart");
	public static final EntityType FURNACE_MINECART = get("furnace_minecart");
	public static final EntityType HOPPER_MINECART = get("hopper_minecart");
	public static final EntityType SPAWNER_MINECART = get("spawner_minecart");
	public static final EntityType TNT_MINECART = get("tnt_minecart");
	public static final EntityType MULE = get("mule");
	public static final EntityType MOOSHROOM = get("mooshroom");
	public static final EntityType OCELOT = get("ocelot");
	public static final EntityType PAINTING = get("painting");
	public static final EntityType PANDA = get("panda");
	public static final EntityType PARROT = get("parrot");
	public static final EntityType PHANTOM = get("phantom");
	public static final EntityType PIG = get("pig");
	public static final EntityType PIGLIN = get("piglin");
	public static final EntityType PIGLIN_BRUTE = get("piglin_brute");
	public static final EntityType PILLAGER = get("pillager");
	public static final EntityType POLAR_BEAR = get("polar_bear");
	public static final EntityType TNT = get("tnt");
	public static final EntityType PUFFERFISH = get("pufferfish");
	public static final EntityType RABBIT = get("rabbit");
	public static final EntityType RAVAGER = get("ravager");
	public static final EntityType SALMON = get("salmon");
	public static final EntityType SHEEP = get("sheep");
	public static final EntityType SHULKER = get("shulker");
	public static final EntityType SHULKER_BULLET = get("shulker_bullet");
	public static final EntityType SILVERFISH = get("silverfish");
	public static final EntityType SKELETON = get("skeleton");
	public static final EntityType SKELETON_HORSE = get("skeleton_horse");
	public static final EntityType SLIME = get("slime");
	public static final EntityType SMALL_FIREBALL = get("small_fireball");
	public static final EntityType SNOW_GOLEM = get("snow_golem");
	public static final EntityType SNOWBALL = get("snowball");
	public static final EntityType SPECTRAL_ARROW = get("spectral_arrow");
	public static final EntityType SPIDER = get("spider");
	public static final EntityType SQUID = get("squid");
	public static final EntityType STRAY = get("stray");
	public static final EntityType STRIDER = get("strider");
	public static final EntityType EGG = get("egg");
	public static final EntityType ENDER_PEARL = get("ender_pearl");
	public static final EntityType EXPERIENCE_BOTTLE = get("experience_bottle");
	public static final EntityType POTION = get("potion");
	public static final EntityType TRIDENT = get("trident");
	public static final EntityType TRADER_LLAMA = get("trader_llama");
	public static final EntityType TROPICAL_FISH = get("tropical_fish");
	public static final EntityType TURTLE = get("turtle");
	public static final EntityType VEX = get("vex");
	public static final EntityType VILLAGER = get("villager");
	public static final EntityType VINDICATOR = get("vindicator");
	public static final EntityType WANDERING_TRADER = get("wandering_trader");
	public static final EntityType WITCH = get("witch");
	public static final EntityType WITHER = get("wither");
	public static final EntityType WITHER_SKELETON = get("wither_skeleton");
	public static final EntityType WITHER_SKULL = get("wither_skull");
	public static final EntityType WOLF = get("wolf");
	public static final EntityType ZOGLIN = get("zoglin");
	public static final EntityType ZOMBIE = get("zombie");
	public static final EntityType ZOMBIE_HORSE = get("zombie_horse");
	public static final EntityType ZOMBIE_VILLAGER = get("zombie_villager");
	public static final EntityType ZOMBIFIED_PIGLIN = get("zombified_piglin");
	public static final EntityType PLAYER = get("player");
	public static final EntityType FISHING_BOBBER = get("fishing_bobber");

	/**
	 * @see Spade#getEntityType(String)
	 */
	public static EntityType get(String id) {
		return Spade.getEntityType(id);
	}

	/**
	 * Spawns the entity in a world
	 * @param location The location
	 * @return The entity
	 */
	public Entity spawn(Location location);

	/**
	 * Gets the id of the entity
	 * @return The id
	 */
	public String getId();

}
