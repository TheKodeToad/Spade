package me.mcblueparrot.spade;

import java.io.File;

public class ScriptPlugin extends Plugin {

	private Runnable onEnable;
	private Runnable onDisable;
	private File scriptFile;

	public ScriptPlugin(File scriptFile) {
		this.scriptFile = scriptFile;
	}

	@Override
	public void onEnable() {
		onEnable.run();
	}

	/**
	 * Sets what to run when the plugin in enabled
	 * @param onDisable What to run
	 */
	public void onEnable(Runnable onEnable) {
		this.onEnable = onEnable;
	}

	@Override
	public void onDisable() {
		onDisable.run();
	}

	/**
	 * Sets what to run when the plugin in disabled
	 * @param onDisable What to run
	 */
	public void onDisable(Runnable onDisable) {
		this.onDisable = onDisable;
	}

	public File getScriptFile() {
		return scriptFile;
	}

}
