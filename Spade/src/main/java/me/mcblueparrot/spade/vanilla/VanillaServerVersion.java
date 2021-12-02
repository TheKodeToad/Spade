package me.mcblueparrot.spade.vanilla;

import com.mojang.bridge.game.GameVersion;

import me.mcblueparrot.spade.ServerVersion;

public class VanillaServerVersion implements VanillaBased<GameVersion>, ServerVersion {

	protected GameVersion version;

	public VanillaServerVersion(GameVersion version) {
		this.version = version;
	}

	@Override
	public GameVersion getVanilla() {
		return version;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{id = " + getId() + "}";
	}

	@Override
	public String getId() {
		return version.getId();
	}

	@Override
	public boolean isRelease() {
		return version.isStable();
	}

	@Override
	public int getProtocolVersion() {
		return version.getProtocolVersion();
	}

	@Override
	public int getPackVersion() {
		return version.getPackVersion();
	}

}
