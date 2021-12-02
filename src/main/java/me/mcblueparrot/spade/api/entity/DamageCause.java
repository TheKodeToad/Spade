package me.mcblueparrot.spade.api.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a cause of damage.
 */
public class DamageCause {

	private static Map<String, DamageCause> byName = new HashMap<String, DamageCause>();
	private static Set<DamageCause> damageCauses = new HashSet<DamageCause>();
	private String name;

	private DamageCause(String name) {
		this.name = name;
		byName.put(name, this);
	}

	/**
	 * Gets a damage cause by its name.
	 * @param name the name
	 * @return the damage cause
	 */
	public static DamageCause getDamageCause(String name) {
		return byName.get(name);
	}

	/**
	 * Gets a list of all damage causes.
	 * @return the list
	 */
	public static Set<DamageCause> getDamageCauses() {
		return damageCauses;
	}

	/**
	 * Gets the name of the damage cause.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}



	@Override
	public int hashCode() {
		return Objects.hash(name);
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
		DamageCause other = (DamageCause) obj;
		return Objects.equals(name, other.name);
	}

	/**
	 * Damage caused by touching fire or a campfire.
	 */
	public static final DamageCause IN_FIRE = new DamageCause("inFire");

	/**
	 * Damage caused by being on fire.
	 */
	public static final DamageCause ON_FIRE = new DamageCause("onFire");

	/**
	 * Damage caused by being in lava.
	 */
	public static final DamageCause LAVA = new DamageCause("lava");

	/**
	 * Damage caused by magma blocks.
	 */
	public static final DamageCause HOT_FLOOR = new DamageCause("hotFloor");

	/**
	 * Damage caused by being struck by lightning.
	 */
	public static final DamageCause LIGHTNING_BOLT = new DamageCause("lightningBolt");

	/**
	 * Damage caused by being inside a block.
	 */
	public static final DamageCause IN_WALL = new DamageCause("inWall");

	/**
	 * Damage caused by colliding with too many entities.
	 */
	public static final DamageCause CRAMMING = new DamageCause("cramming");

	/**
	 * Damage caused by drowning.
	 */
	public static final DamageCause DROWN = new DamageCause("drown");

	/**
	 * Damage caused by starving.
	 */
	public static final DamageCause STARVE = new DamageCause("starve");

	/**
	 * Damage caused by a cactus.
	 */
	public static final DamageCause CACTUS = new DamageCause("cactus");

	/**
	 * Damage caused by falling from too high.
	 */
	public static final DamageCause FALL = new DamageCause("fall");

	/**
	 * Damage caused by flying into a wall.
	 */
	public static final DamageCause FLY_INTO_WALL = new DamageCause("flyIntoWall");

	/**
	 * Damage caused by falling into the void.
	 */
	public static final DamageCause OUT_OF_WORLD = new DamageCause("outOfWorld");

	/**
	 * Damage caused for no particular reason.
	 */
	public static final DamageCause GENERIC = new DamageCause("generic");

	/**
	 * Damage caused by a potion.
	 */
	public static final DamageCause MAGIC = new DamageCause("magic");

	/**
	 * Damage caused by the wither potion effect.
	 */
	public static final DamageCause WITHER = new DamageCause("wither");

	/**
	 * Damage caused by being crushed by a falling anvil.
	 */
	public static final DamageCause ANVIL = new DamageCause("anvil");

	/**
	 * Damage caused by being crushed by a falling block.
	 */
	public static final DamageCause FALLING_BLOCK = new DamageCause("fallingBlock");

	/**
	 * Damage caused by dragon breath.
	 */
	public static final DamageCause DRAGON_BREATH = new DamageCause("dragonBreath");

	/**
	 * Damage caused by not being in water.
	 */
	public static final DamageCause DRYOUT = new DamageCause("dryout");

	/**
	 * Damage caused by a sweet berry bush.
	 */
	public static final DamageCause SWEET_BERRY_BUSH = new DamageCause("sweetBerryBush");

}
