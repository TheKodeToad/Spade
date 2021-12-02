package me.mcblueparrot.spade.launcher;

import java.util.ArrayList;
import java.util.List;

public abstract class AccessChanger {

	private Class<?> clazz;
	public static List<AccessChanger> accessChangers = new ArrayList<AccessChanger>();

	public AccessChanger(Class<?> clazz) {
		this.clazz = clazz;
		accessChangers.add(this);
	}

	public int applyMethod(String name, String signature, int original) {
		return original;
	}

	public int applyField(String name, int original) {
		return original;
	}

	public Class<?> getTargetClass() {
		return clazz;
	}

}
