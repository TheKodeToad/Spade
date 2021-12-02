package me.mcblueparrot.spade.api.entity;

import java.util.List;
import java.util.Objects;

import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.id.Identifiable;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.server.Server;

/**
 * Represents a type of status effect.
 */
public abstract class StatusEffectType implements Identifiable {

	private Identifier id;

	protected StatusEffectType(Identifier id) {
		this.id = id;
	}

	/**
	 * Gets the status effect type's identifier.
	 * @return the identifier
	 */
	@Override
	public Identifier getId() {
		return id;
	}

	/**
	 * Gets if the status effect benefits entities.
	 * @return if the status effect benefits entities
	 */
	public abstract boolean isBeneficial();

	/**
	 * Gets if the status effect directly harms entities.
	 * @return if the status effect directly harms entities
	 */
	public abstract boolean isHarmful();

	/**
	 * Gets if the status effect is neutral (neither harms nor benefits entities).
	 * @return if the status effect is neutral
	 */
	public abstract boolean isNeutral();

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
		StatusEffectType other = (StatusEffectType) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * @see Server#getStatusEffectType(Identifier)
	 */
	public static StatusEffectType getStatusEffectType(Identifier id) {
		return Spade.getStatusEffectType(id);
	}

	/**
	 * @see Server#getStatusEffectType(String)
	 */
	public static StatusEffectType getStatusEffectType(String id) {
		return Spade.getStatusEffectType(id);
	}

	/**
	 * @see Server#getStatusEffectTypes()
	 */
	public static List<StatusEffectType> getStatusEffectTypes() {
		return Spade.getStatusEffectTypes();
	}

	public static final StatusEffectType SPEED = getStatusEffectType("speed");
	public static final StatusEffectType SLOWNESS = getStatusEffectType("slowness");
	public static final StatusEffectType HASTE = getStatusEffectType("haste");
	public static final StatusEffectType MINING_FATIGUE = getStatusEffectType("mining_fatigue");
	public static final StatusEffectType STRENGTH = getStatusEffectType("strength");
	public static final StatusEffectType INSTANT_HEALTH = getStatusEffectType("instant_health");
	public static final StatusEffectType INSTANT_DAMAGE = getStatusEffectType("instant_damage");
	public static final StatusEffectType JUMP_BOOST = getStatusEffectType("jump_boost");
	public static final StatusEffectType NAUSEA = getStatusEffectType("nausea");
	public static final StatusEffectType REGENERATION = getStatusEffectType("regeneration");
	public static final StatusEffectType RESISTANCE = getStatusEffectType("resistance");
	public static final StatusEffectType FIRE_RESISTANCE = getStatusEffectType("fire_resistance");
	public static final StatusEffectType WATER_BREATHING = getStatusEffectType("water_breathing");
	public static final StatusEffectType INVISIBILITY = getStatusEffectType("invisibility");
	public static final StatusEffectType BLINDNESS = getStatusEffectType("blindness");
	public static final StatusEffectType NIGHT_VISION = getStatusEffectType("night_vision");
	public static final StatusEffectType HUNGER = getStatusEffectType("hunger");
	public static final StatusEffectType WEAKNESS = getStatusEffectType("weakness");
	public static final StatusEffectType POISON = getStatusEffectType("poison");
	public static final StatusEffectType WITHER = getStatusEffectType("wither");
	public static final StatusEffectType HEALTH_BOOST = getStatusEffectType("health_boost");
	public static final StatusEffectType ABSORPTION = getStatusEffectType("absorption");
	public static final StatusEffectType SATURATION = getStatusEffectType("saturation");
	public static final StatusEffectType GLOWING = getStatusEffectType("glowing");
	public static final StatusEffectType LEVITATION = getStatusEffectType("levitation");
	public static final StatusEffectType LUCK = getStatusEffectType("luck");
	public static final StatusEffectType UNLUCK = getStatusEffectType("unluck");
	public static final StatusEffectType SLOW_FALLING = getStatusEffectType("slow_falling");
	public static final StatusEffectType CONDUIT_POWER = getStatusEffectType("conduit_power");
	public static final StatusEffectType DOLPHINS_GRACE = getStatusEffectType("dolphins_grace");
	public static final StatusEffectType BAD_OMEN = getStatusEffectType("bad_omen");
	public static final StatusEffectType HERO_OF_THE_VILLAGE = getStatusEffectType("hero_of_the_village");

}
