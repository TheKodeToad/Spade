package me.mcblueparrot.spade.vanilla.entity;

import me.mcblueparrot.spade.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;

public class VanillaLivingEntity extends VanillaEntity implements LivingEntity {

	public VanillaLivingEntity(Entity entity) {
		super(entity);
	}

	/**
	 * Gets the vanilla object which this is based on as a living entity
	 */
	public net.minecraft.entity.LivingEntity getVanillaLivingEntity() {
		return (net.minecraft.entity.LivingEntity) getVanilla();
	}

	@Override
	public void kill() {
		getVanillaLivingEntity().kill();
	}

	@Override
	public float getHealth() {
		return getVanillaLivingEntity().getHealth();
	}

	@Override
	public void setHealth(float health) {
		getVanillaLivingEntity().setHealth(health);
	}

	@Override
	public void damage(float amount) {
		getVanillaLivingEntity().damage(DamageSource.GENERIC, amount);
	}

	@Override
	public void heal(float amount) {
		getVanillaLivingEntity().heal(amount);
	}

}
