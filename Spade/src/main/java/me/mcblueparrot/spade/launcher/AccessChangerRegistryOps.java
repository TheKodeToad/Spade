package me.mcblueparrot.spade.launcher;

import java.lang.reflect.Modifier;

import net.minecraft.util.dynamic.RegistryOps;

public class AccessChangerRegistryOps extends AccessChanger {

	public AccessChangerRegistryOps() {
		super(RegistryOps.class);
	}

	@Override
	public int applyMethod(String name, String signature, int original) {
		if(name.equals("method_31152")) {
			return (original & ~Modifier.PROTECTED) | Modifier.PUBLIC;
		}
		return original;
	}

}
