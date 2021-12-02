package me.mcblueparrot.spade.api.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.plugin.loader.PluginLoader;

public class DefaultPluginManager implements PluginManager {

	private List<PluginLoader> loaders = new ArrayList<PluginLoader>();
	private List<Plugin> plugins = new ArrayList<Plugin>();
	private Logger logger = LogManager.getLogger("Plugin Manager");

	@Override
	public List<PluginLoader> getLoaders() {
		return Collections.unmodifiableList(loaders);
	}

	@Override
	public void addLoader(PluginLoader loader) {
		loaders.add(loader);
	}

	@Override
	public void removeLoader(PluginLoader loader) {
		loaders.remove(loader);
	}

	@Override
	public void load() {
		if(!Spade.getPluginsFolder().exists()) {
			Spade.getPluginsFolder().mkdirs();
		}
		for(File file : Spade.getPluginsFolder().listFiles()) {
			load(file);
		}
	}

	@Override
	public void load(File file) {
		for(PluginLoader loader : getLoaders()) {
			try {
				Plugin plugin = loader.loadPlugin(file);
				plugins.add(plugin);
				if(plugin != null) {
					return;
				}
			}
			catch(Throwable error) {
				logger.error("Could not load plugin from file " + file.getName(), error);
			}
		}
	}

	@Override
	public List<Plugin> getPlugins() {
		return Collections.unmodifiableList(plugins);
	}

	@Override
	public void enable() {
		plugins.forEach(this::enable);
	}

	@Override
	public void enable(Plugin plugin) {
		logger.info("Enabling " + plugin + "...");
		try {
			plugin.onEnable();
		}
		catch(Throwable error) {
			logger.info("Error enabling " + plugin, error);
		}
	}

	@Override
	public void disable() {
		plugins.forEach(this::disable);
	}

	@Override
	public void disable(Plugin plugin) {
		logger.info("Disabling " + plugin + "...");
		try {
			plugin.onEnable();
		}
		catch(Throwable error) {
			logger.info("Error disabling " + plugin, error);
		}
	}

}
