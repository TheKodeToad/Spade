package me.mcblueparrot.spade.api.entity;

import java.util.List;

import me.mcblueparrot.spade.api.ProjectileSource;

/**
 * Represents a living entity.
 */
public interface LivingEntity extends DamageableEntity, ProjectileSource {

	/**
	 * Gets a list of status effects of the entity.
	 * @return the list
	 */
	public List<StatusEffect> getStatusEffects();

	/**
	 * Adds a status effect to the entity.
	 * @param effect the effect
	 */
	public void addStatusEffect(StatusEffect effect);

	/**
	 * Removes a status effect from the entity.
	 * @param effect the effect
	 */
	public void removeStatusEffect(StatusEffect effect);

}
