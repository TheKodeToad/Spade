package me.mcblueparrot.spade;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.Logger;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import me.mcblueparrot.spade.command.Command;
import me.mcblueparrot.spade.command.CommandException;
import me.mcblueparrot.spade.config.Configuration;
import me.mcblueparrot.spade.config.ConfigurationSystem;
import me.mcblueparrot.spade.event.Event;
import me.mcblueparrot.spade.event.EventListener;
import me.mcblueparrot.spade.event.EventPriority;
import me.mcblueparrot.spade.vanilla.entity.VanillaPlayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.server.command.ServerCommandSource;

public class SpadePluginManager implements PluginManager {

	public static SpadePluginManager getInstance() {
		return (SpadePluginManager) Spade.getPluginManager();
	}

	private List<Plugin> plugins = new ArrayList<Plugin>();
	private Map<Plugin, URLClassLoader> classLoaders = new HashMap<Plugin, URLClassLoader>();
	private Logger logger = Spade.getLogger();
	private Map<Plugin, List<EventListener<?>>> listenersMap = new HashMap<Plugin, List<EventListener<?>>>();
	private List<RegisteredListener> listenersQueue = new ArrayList<RegisteredListener>();
	private Map<String, Command> commands = new HashMap<String, Command>();

	@Override
	public void enable() {
		load();
		for(Plugin plugin : plugins) {
			enable(plugin);
		}
	}

	@Override
	public void enable(Plugin plugin) {
		try {
			logger.info("Enabling " + plugin);
			if(plugin.getConfigFile().exists()) {
				plugin.loadConfig();
			}
			plugin.onEnable();
		}
		catch(Throwable e) {
			logger.error("Error enabling " + plugin + ":", e);
		}
	}

	@Override
	public void load() {
		if(!Spade.getPluginFolder().exists()) {
			Spade.getPluginFolder().mkdirs();
		}
		for(File pluginFile : Spade.getPluginFolder().listFiles()) {
			load(pluginFile);
		}
	}

	@Override
	public void load(File pluginFile) {
		if(pluginFile.getName().endsWith(".jar")) {
			URLClassLoader classLoader = null;
			try {
				URL url = pluginFile.toURI().toURL();
				classLoader = URLClassLoader.newInstance(new URL[] {url}, Launch.classLoader);
				Configuration description;
				String main;
				try {
					description = ConfigurationSystem.getDefault().load(IOUtils.toString(classLoader.getResourceAsStream("plugin." + ConfigurationSystem.getDefault().getExtension()), StandardCharsets.UTF_8));
					main = description.getString("main");
					Objects.requireNonNull(main);
					Objects.requireNonNull(description.getString("name"));
					Objects.requireNonNull(description.getString("version"));
				}
				catch(Throwable e) {
					logger.error("Invalid description");
					throw e;
				}
				Class<?> mainClass;
				try {
					mainClass = Class.forName(main, true, classLoader);
				}
				catch(ClassNotFoundException e) {
					logger.error("Could not find main class");
					throw e;
				}
				try {
					Constructor<?> constructor = mainClass.getConstructor();
					Plugin plugin = (Plugin) constructor.newInstance();
					plugin.setDescription(description);
					plugins.add(plugin);
					classLoaders.put(plugin, classLoader);
				}
				catch(NoSuchMethodException e) {
					logger.error("Could not find constructor");
					throw e;
				}
				catch(ExceptionInInitializerError e) {
					logger.error("Could not initialize plugin");
					throw e;
				}
				catch(ClassCastException e) {
					logger.error("Main class does not extend Plugin");
					throw e;
				}
			}
			catch(Throwable e) {
				logger.error("Could not load plugin from file " + pluginFile.getName() + ":",  e);
				if(classLoader != null) {
					try {
						classLoader.close();
					}
					catch(IOException e1) {
						logger.error("Error closing class loader:", e1);
					}
				}
			}
		}
		else if(pluginFile.isDirectory() && pluginFile.getName().endsWith(".plugin")) {
			try {
				File descriptionFile = new File(pluginFile, "plugin." + ConfigurationSystem.getDefault().getExtension());
				Configuration description;
				String scriptName;
				try {
					description = ConfigurationSystem.getDefault().load(descriptionFile);
					scriptName = description.getString("script");
					Objects.requireNonNull(scriptName);
					Objects.requireNonNull(description.getString("name"));
					Objects.requireNonNull(description.getString("version"));
				}
				catch(Throwable e) {
					logger.error("Invalid plugin description");
					throw e;
				}
				if(scriptName.equals("plugin") || scriptName.equals("server") || scriptName.equals("scheduler") || scriptName.equals("pluginManager")) {
					throw new IllegalArgumentException("Script cannot be called plugin, server, scheduler or pluginManager");
				}
				File scriptFile = new File(pluginFile, scriptName + ".groovy");
				if(!scriptFile.exists()) {
					throw new FileNotFoundException("Cannot find script " + scriptFile.getName());
				}
				ScriptPlugin plugin = new ScriptPlugin(scriptFile);
				plugin.setDescription(description);
				Binding binding = new Binding();
				binding.setProperty("plugin", plugin);
				binding.setProperty("server", Spade.getServer());
				binding.setProperty("scheduler", Spade.getScheduler());
				binding.setProperty("pluginManager", this);
				GroovyShell shell = new GroovyShell(Launch.classLoader);
				Script script = shell.parse(scriptFile);
				script.setBinding(binding);
				script.run();
				plugins.add(plugin);
			}
			catch(Throwable e) {
				logger.error("Could not load plugin from folder " + pluginFile.getName() + ":", e);
			}
		}
	}

	@Override
	public void disable() {
		for(Plugin plugin : plugins) {
			disable(plugin);
		}
		unload();
	}

	@Override
	public void disable(Plugin plugin) {
		try {
			logger.info("Disabling " + plugin);
			List<EventListener<?>> listeners = new ArrayList<EventListener<?>>();
			for(EventListener<?> listener : getListeners(plugin)) {
				listeners.add(listener);
			}
			for(EventListener<?> listener : listeners) {
				unregisterListener(plugin, listener);
			}
			plugin.onDisable();
		}
		catch (Throwable e) {
			logger.error("Error disabling plugin " + plugin + ":", e);
		}
	}

	@Override
	public void unload() {
		List<Plugin> pluginsToUnload = new ArrayList<Plugin>();
		for(Plugin plugin : plugins) {
			pluginsToUnload.add(plugin);
		}
		for(Plugin plugin : pluginsToUnload) {
			unload(plugin);
		}
	}

	@Override
	public void unload(Plugin plugin) {
		plugins.remove(plugin);
		URLClassLoader classLoader = classLoaders.get(plugin);
		if(classLoader != null) {
			try {
				classLoader.close();
			}
			catch (IOException e) {
				logger.error("Could not unload plugin:", e);
			}
		}
	}

	@Override
	public List<Plugin> getPlugins() {
		return plugins;
	}

	@Override
	public <E extends Event> void registerListener(Plugin plugin, Class<E> event, EventListener<E> listener, EventPriority priority) {
		for(RegisteredListener registeredListener : listenersQueue) {
			if(registeredListener.getListener().equals(listener)) {
				throw new IllegalArgumentException("Listener already registered");
			}
		}
		getListeners(plugin).add(listener);
		listenersQueue.add(new RegisteredListener(event, listener, priority));
		sortQueue();
	}

	private void sortQueue() {
		listenersQueue.sort((l1, l2) -> l1.getPriority().compareTo(l2.getPriority()));
	}

	@Override
	public void unregisterListener(Plugin plugin, EventListener<?> listener) {
		RegisteredListener registeredListener = null;
		for(RegisteredListener testRegisteredListener : listenersQueue) {
			if(testRegisteredListener.getListener().equals(listener)) {
				registeredListener = testRegisteredListener;
				break;
			}
		}
		if(registeredListener == null) {
			throw new IllegalArgumentException("Listener not registered");
		}
		getListeners(plugin).remove(listener);
		listenersQueue.remove(registeredListener);
	}

	@Override
	public List<EventListener<?>> getListeners(Plugin plugin) {
		List<EventListener<?>> listeners = listenersMap.get(plugin);
		if(listeners == null) {
			listeners = new ArrayList<EventListener<?>>();
			listenersMap.put(plugin, listeners);
		}
		return listeners;
	}

	@Override
	public <E extends Event> void callEvent(E event) {
		_callEvent(event);
	}

	@SuppressWarnings("unchecked")
	private <E extends Event> void _callEvent(E event) {
		for(RegisteredListener registeredListener : listenersQueue) {
			if(registeredListener.getEventClass().isAssignableFrom(event.getClass())) {
				try {
					((EventListener<E>) registeredListener.getListener()).onEvent(event);
				}
				catch(Throwable e) {
					logger.error("Error calling event:", e);
				}
			}
		}
	}

	@Override
	public void registerCommand(String name, Command command) {
		commands.put(name, command);
	}

	public boolean execute(ServerCommandSource commandSource, String commandStr) throws CommandException {
		String[] args = commandStr.split(" ");
		if(args.length == 0) {
			return false;
		}
		Command command = commands.get(args[0]);
		if(command == null) {
			return false;
		}
		CommandSender sender = null;
		if(commandSource.getEntity() != null) {
			if(commandSource.getEntity() instanceof PlayerEntity) {
				sender = new VanillaPlayer(commandSource.getEntity());
			}
		}
		else if(commandSource.getEntity() == null && commandSource.getName().equals("Server")) {
			sender = Spade.getServer();
		}
		if(sender != null) {
			List<String> arguments = new ArrayList<String>(Arrays.asList(args));
			arguments.remove(0);
			command.execute(sender, arguments);
			return true;
		}
		return false;
	}

}
