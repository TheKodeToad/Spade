package me.mcblueparrot.spade.launcher;

import java.lang.reflect.Modifier;

import net.minecraft.entity.projectile.ProjectileEntity;

public class AccessChangerProjectileEntity extends AccessChanger {

	public AccessChangerProjectileEntity() {
		super(ProjectileEntity.class);
	}

	@Override
	public int applyMethod(String name, String signature, int original) {
		if(name.equals("<init>")) {
			return (original & ~Modifier.PROTECTED) | Modifier.PUBLIC;
		}
		return original;
	}

}
