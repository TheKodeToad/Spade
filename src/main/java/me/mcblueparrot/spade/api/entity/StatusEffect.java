package me.mcblueparrot.spade.api.entity;

import me.mcblueparrot.spade.api.Cloneable;

public class StatusEffect implements Cloneable<StatusEffect> {

	private StatusEffect type;
	private int duration;
	private int amplifier;
	private boolean permanent;
	private boolean particles;
	private boolean icon;

	/**
	 * Creates a status effect.
	 * @param type the type
	 * @param duration the duration
	 * @param amplifier the amplifier
	 */
	public StatusEffect(StatusEffect type, int duration, int amplifier) {
		this.type = type;
		this.duration = duration;
		this.amplifier = amplifier;
	}

	/**
	 * Creates a copy of a status effect.
	 * @param effect the status effect
	 */
	public StatusEffect(StatusEffect effect) {
		this(effect.getType(), effect.getDuration(), effect.getAmplifier());
	}

	/**
	 * Gets the status effect's type.
	 * @return the type
	 */
	public StatusEffect getType() {
		return type;
	}

	/**
	 * Gets the status effect's duration.
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Sets the status effect's duration.
	 * @param duration the duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Gets the status effect's amplifier.
	 * @return the amplifier
	 */
	public int getAmplifier() {
		return amplifier;
	}

	/**
	 * Sets the status effect's amplifier.
	 * @param amplifier the amplifier
	 */
	public void setAmplifier(int amplifier) {
		this.amplifier = amplifier;
	}

	/**
	 * Gets if the status effect is permanent.
	 * @return if the status effect is permanent
	 */
	public boolean isPermanent() {
		return permanent;
	}

	/**
	 * Sets if the status effect is permanent.
	 * @param permanent if the status effect is permanent
	 */
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	/**
	 * Gets if particles are shown.
	 * @return if particles are shown
	 */
	public boolean hasParticles() {
		return particles;
	}

	/**
	 * Sets if particles are shown.
	 * @param particles if particles are shown
	 */
	public void setParticles(boolean particles) {
		this.particles = particles;
	}

	/**
	 * Gets if the icon is shown.
	 * @return if the icon is shown
	 */
	public boolean hasIcon() {
		return icon;
	}

	/**
	 * Sets if the icon is shown.
	 * @param icon if the icon is shown
	 */
	public void setIcon(boolean icon) {
		this.icon = icon;
	}

	@Override
	public StatusEffect clone() {
		return new StatusEffect(this);
	}

}
