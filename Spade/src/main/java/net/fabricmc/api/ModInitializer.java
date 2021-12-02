package net.fabricmc.api;

/**
 * Prevent NoClassDefFoundError
 */
public interface ModInitializer {

	public void onInitialize();

}
