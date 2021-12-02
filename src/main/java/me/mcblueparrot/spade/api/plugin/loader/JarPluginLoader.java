package me.mcblueparrot.spade.api.plugin.loader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

import me.mcblueparrot.spade.api.config.Configuration;
import me.mcblueparrot.spade.api.config.system.ConfigurationSystem;
import me.mcblueparrot.spade.api.plugin.Plugin;

/**
 * Represents a java jar plugin loader.
 */
public class JarPluginLoader implements PluginLoader {

	private List<URLClassLoader> loaders = new ArrayList<URLClassLoader>();

	@Override
	public Plugin loadPlugin(File file) throws IOException {
		try {
			if(!file.getName().endsWith(".jar")) {
				return null;
			}
			URLClassLoader loader = new URLClassLoader(new URL[] {file.toURI().toURL()});
			loaders.add(loader);

			ConfigurationSystem system = ConfigurationSystem.getDefault();
			InputStream descriptionInput = loader.getResourceAsStream("plugin." + system.getExtension());
			InputStreamReader descriptionReader = new InputStreamReader(descriptionInput);
			Configuration description = system.load(descriptionReader);
			descriptionReader.close();
			descriptionInput.close();

			Validate.isTrue(description.containsKey("main"), "No main class specified");

			String main = description.getString("main");
			Class<?> mainClass;
			try {
				mainClass = Class.forName(main, false, loader);
			}
			catch(ClassNotFoundException error) {
				throw new PluginLoadException("Could not find plugin main class (" + main + ")", error);
			}
			if(!Plugin.class.isAssignableFrom(mainClass)) {
				throw new PluginLoadException("Main class must extend Plugin");
			}
			Constructor<?> constructor;
			try {
				constructor = mainClass.getConstructor();
			}
			catch(NoSuchMethodException | SecurityException error) {
				throw new PluginLoadException("Could not find constructor with no arguments in plugin main class (" + main + ")", error);
			}
			try {
				return (Plugin) constructor.newInstance();
			}
			catch(InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new PluginLoadException("Could not initialise plugin");
			}
		}
		catch(MalformedURLException error) {
			throw new Error(error);
		}
	}

	@Override
	public void close() throws IOException {
		for(URLClassLoader loader : loaders) {
			loader.close();
		}
	}

	@Override
	public String getName() {
		return "jar";
	}

}
