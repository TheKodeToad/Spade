package me.mcblueparrot.spade.api.entity;

import java.util.List;
import java.util.Objects;

import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.Taggable;
import me.mcblueparrot.spade.api.id.Identifiable;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.server.Server;

/**
 * Represents a type of entity.
 */
public abstract class EntityType implements Identifiable, Taggable {

	private Identifier id;

	protected EntityType(Identifier id) {
		this.id = id;
	}

	/**
	 * Gets the entity type's identifier.
	 * @return the identifier
	 */
	@Override
	public Identifier getId() {
		return id;
	}

	/**
	 * Gets if the entity type is damageable.
	 * @return if the entity type is damageable
	 */
	public boolean isDamageable() {
		return DamageableEntity.class.isAssignableFrom(getEntityClass());
	}

	/**
	 * Gets if the entity type is living entity.
	 * @return if the entity type is a living entity
	 */
	public boolean isLiving() {
		return LivingEntity.class.isAssignableFrom(getEntityClass());
	}

	/**
	 * Gets if the entity type can be summoned.
	 * @return if the entity type can be summoned
	 */
	public abstract boolean isSummonable();

	/**
	 * Gets the entity class (for example {@link Player}).
	 * @return the entity class
	 */
	public abstract Class<? extends Entity> getEntityClass();

	@Override
	public String toString() {
		return id.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		EntityType other = (EntityType) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * @see Server#getEntityType(Identifier)
	 */
	public static EntityType getEntityType(Identifier id) {
		return Spade.getEntityType(id);
	}

	/**
	 * @see Server#getEntityType(String)
	 */
	public static EntityType getEntityType(String id) {
		return Spade.getEntityType(id);
	}

	/**
	 * @see Server#getEntityTypes()
	 */
	public static List<EntityType> getEntityTypes() {
		return Spade.getEntityTypes();
	}

	public static final EntityType AREA_EFFECT_CLOUD = getEntityType("area_effect_cloud");
	public static final EntityType ARMOR_STAND = getEntityType("armor_stand");
	public static final EntityType ARROW = getEntityType("arrow");
	public static final EntityType BAT = getEntityType("bat");
	public static final EntityType BEE = getEntityType("bee");
	public static final EntityType BLAZE = getEntityType("blaze");
	public static final EntityType BOAT = getEntityType("boat");
	public static final EntityType CAT = getEntityType("cat");
	public static final EntityType CAVE_SPIDER = getEntityType("cave_spider");
	public static final EntityType CHICKEN = getEntityType("chicken");
	public static final EntityType COD = getEntityType("cod");
	public static final EntityType COW = getEntityType("cow");
	public static final EntityType CREEPER = getEntityType("creeper");
	public static final EntityType DOLPHIN = getEntityType("dolphin");
	public static final EntityType DONKEY = getEntityType("donkey");
	public static final EntityType DRAGON_FIREBALL = getEntityType("dragon_fireball");
	public static final EntityType DROWNED = getEntityType("drowned");
	public static final EntityType ELDER_GUARDIAN = getEntityType("elder_guardian");
	public static final EntityType END_CRYSTAL = getEntityType("end_crystal");
	public static final EntityType ENDER_DRAGON = getEntityType("ender_dragon");
	public static final EntityType ENDERMAN = getEntityType("enderman");
	public static final EntityType ENDERMITE = getEntityType("endermite");
	public static final EntityType EVOKER = getEntityType("evoker");
	public static final EntityType EVOKER_FANGS = getEntityType("evoker_fangs");
	public static final EntityType EXPERIENCE_ORB = getEntityType("experience_orb");
	public static final EntityType EYE_OF_ENDER = getEntityType("eye_of_ender");
	public static final EntityType FALLING_BLOCK = getEntityType("falling_block");
	public static final EntityType FIREWORK_ROCKET = getEntityType("firework_rocket");
	public static final EntityType FOX = getEntityType("fox");
	public static final EntityType GHAST = getEntityType("ghast");
	public static final EntityType GIANT = getEntityType("giant");
	public static final EntityType GUARDIAN = getEntityType("guardian");
	public static final EntityType HOGLIN = getEntityType("hoglin");
	public static final EntityType HORSE = getEntityType("horse");
	public static final EntityType HUSK = getEntityType("husk");
	public static final EntityType ILLUSIONER = getEntityType("illusioner");
	public static final EntityType IRON_GOLEM = getEntityType("iron_golem");
	public static final EntityType ITEM = getEntityType("item");
	public static final EntityType ITEM_FRAME = getEntityType("item_frame");
	public static final EntityType FIREBALL = getEntityType("fireball");
	public static final EntityType LEASH_KNOT = getEntityType("leash_knot");
	public static final EntityType LIGHTNING_BOLT = getEntityType("lightning_bolt");
	public static final EntityType LLAMA = getEntityType("llama");
	public static final EntityType LLAMA_SPIT = getEntityType("llama_spit");
	public static final EntityType MAGMA_CUBE = getEntityType("magma_cube");
	public static final EntityType MINECART = getEntityType("minecart");
	public static final EntityType CHEST_MINECART = getEntityType("chest_minecart");
	public static final EntityType COMMAND_BLOCK_MINECART = getEntityType("command_block_minecart");
	public static final EntityType FURNACE_MINECART = getEntityType("furnace_minecart");
	public static final EntityType HOPPER_MINECART = getEntityType("hopper_minecart");
	public static final EntityType SPAWNER_MINECART = getEntityType("spawner_minecart");
	public static final EntityType TNT_MINECART = getEntityType("tnt_minecart");
	public static final EntityType MULE = getEntityType("mule");
	public static final EntityType MOOSHROOM = getEntityType("mooshroom");
	public static final EntityType OCELOT = getEntityType("ocelot");
	public static final EntityType PAINTING = getEntityType("painting");
	public static final EntityType PANDA = getEntityType("panda");
	public static final EntityType PARROT = getEntityType("parrot");
	public static final EntityType PHANTOM = getEntityType("phantom");
	public static final EntityType PIG = getEntityType("pig");
	public static final EntityType PIGLIN = getEntityType("piglin");
	public static final EntityType PIGLIN_BRUTE = getEntityType("piglin_brute");
	public static final EntityType PILLAGER = getEntityType("pillager");
	public static final EntityType POLAR_BEAR = getEntityType("polar_bear");
	public static final EntityType TNT = getEntityType("tnt");
	public static final EntityType PUFFERFISH = getEntityType("pufferfish");
	public static final EntityType RABBIT = getEntityType("rabbit");
	public static final EntityType RAVAGER = getEntityType("ravager");
	public static final EntityType SALMON = getEntityType("salmon");
	public static final EntityType SHEEP = getEntityType("sheep");
	public static final EntityType SHULKER = getEntityType("shulker");
	public static final EntityType SHULKER_BULLET = getEntityType("shulker_bullet");
	public static final EntityType SILVERFISH = getEntityType("silverfish");
	public static final EntityType SKELETON = getEntityType("skeleton");
	public static final EntityType SKELETON_HORSE = getEntityType("skeleton_horse");
	public static final EntityType SLIME = getEntityType("slime");
	public static final EntityType SMALL_FIREBALL = getEntityType("small_fireball");
	public static final EntityType SNOW_GOLEM = getEntityType("snow_golem");
	public static final EntityType SNOWBALL = getEntityType("snowball");
	public static final EntityType SPECTRAL_ARROW = getEntityType("spectral_arrow");
	public static final EntityType SPIDER = getEntityType("spider");
	public static final EntityType SQUID = getEntityType("squid");
	public static final EntityType STRAY = getEntityType("stray");
	public static final EntityType STRIDER = getEntityType("strider");
	public static final EntityType EGG = getEntityType("egg");
	public static final EntityType ENDER_PEARL = getEntityType("ender_pearl");
	public static final EntityType EXPERIENCE_BOTTLE = getEntityType("experience_bottle");
	public static final EntityType POTION = getEntityType("potion");
	public static final EntityType TRIDENT = getEntityType("trident");
	public static final EntityType TRADER_LLAMA = getEntityType("trader_llama");
	public static final EntityType TROPICAL_FISH = getEntityType("tropical_fish");
	public static final EntityType TURTLE = getEntityType("turtle");
	public static final EntityType VEX = getEntityType("vex");
	public static final EntityType VILLAGER = getEntityType("villager");
	public static final EntityType VINDICATOR = getEntityType("vindicator");
	public static final EntityType WANDERING_TRADER = getEntityType("wandering_trader");
	public static final EntityType WITCH = getEntityType("witch");
	public static final EntityType WITHER = getEntityType("wither");
	public static final EntityType WITHER_SKELETON = getEntityType("wither_skeleton");
	public static final EntityType WITHER_SKULL = getEntityType("wither_skull");
	public static final EntityType WOLF = getEntityType("wolf");
	public static final EntityType ZOGLIN = getEntityType("zoglin");
	public static final EntityType ZOMBIE = getEntityType("zombie");
	public static final EntityType ZOMBIE_HORSE = getEntityType("zombie_horse");
	public static final EntityType ZOMBIE_VILLAGER = getEntityType("zombie_villager");
	public static final EntityType ZOMBIFIED_PIGLIN = getEntityType("zombified_piglin");
	public static final EntityType PLAYER = getEntityType("player");
	public static final EntityType FISHING_BOBBER = getEntityType("fishing_bobber");

}
