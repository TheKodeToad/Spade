package me.mcblueparrot.spade.launcher;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinTweaker;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import me.mcblueparrot.spade.remapper.YarnRemapper;
import net.minecraft.launchwrapper.Launch;

public class SpadeLauncher {

	protected static String[] args;

	public static void main(String[] args) throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
		Logger logger = LogManager.getLogger("Launcher");
		if(!SpadeLauncher.class.getClassLoader().getResource("spade.json").toString().startsWith("jar:")) {
			logger.warn("If errors occur, try running the jar which can be built using ./gradle build and found in build/libs");
		}

		SpadeLauncher.args = args;
		File launcherFolder = new File("launcher");
		if(!launcherFolder.exists()) {
			launcherFolder.mkdirs();
		}

		JsonObject spadeData = new JsonParser().parse(resourceToString("spade.json")).getAsJsonObject();

		// Download vanilla jar if it doesn't exist or is invalid
//		File vanillaJar = new File(launcherFolder, "vanilla.jar");
//		downloadURL(spadeData.get("minecraft").getAsJsonObject().get("download").getAsString(),
//				vanillaJar,
//				spadeData.get("minecraft").getAsJsonObject().get("hash").getAsString(),
//				() -> logger.info("Downloading vanilla..."));
//
//		File namedJar = new File(launcherFolder, "named.jar");
//		File mappings = new File(launcherFolder, "mappings.tiny");
//
//		if(!namedJar.exists()) {
//			// Download the mappings
//			File mappingsJar = new File(launcherFolder, "mappings.jar");
//			downloadURL(spadeData.get("yarn").getAsJsonObject().get("download").getAsString(),
//					mappingsJar,
//					spadeData.get("yarn").getAsJsonObject().get("hash").getAsString(),
//					() -> logger.info("Downloading mappings..."));
//
//			try(ZipFile mappingsZip = new ZipFile(mappingsJar)) {
//				Enumeration<? extends ZipEntry> entries = mappingsZip.entries();
//				while(entries.hasMoreElements()) {
//					ZipEntry entry = entries.nextElement();
//					if(entry.getName().equals("mappings/mappings.tiny")) {
//						try(InputStream input = mappingsZip.getInputStream(entry); OutputStream output = new FileOutputStream(mappings)) {
//							IOUtils.copy(input, output);
//						}
//						break;
//					}
//				}
//			}
//
//			if(!namedJar.exists()) {
//				// Apply the mappings to the vanilla jar into the named jar
//				logger.info("Applying mappings...");
//
//				deobfuscateJarWithTinyMappings(mappings, "official", "named", vanillaJar, namedJar);
//			}
//		}
		// Add the named jar to the classpath
		addToClasspath(new YarnRemapper(spadeData.get("version").getAsString(), (message) -> {
			logger.info(message);
		}).apply(launcherFolder));

//		for(String modName : getKeys(spadeData.get("mods").getAsJsonObject())) {
//			JsonObject mod = spadeData.get("mods").getAsJsonObject().get(modName).getAsJsonObject();
//			String download = mod.get("download").getAsString();
//			File modFile = new File(launcherFolder, modName + "-" + mod.get("version").getAsString() + ".jar");
//			downloadURL(download, modFile, null, () -> {
//				logger.info("Downloading " + mod.get("name").getAsString() + "...");
//			});
//			File modFileRemapped = new File(launcherFolder, modName + "-" + mod.get("version").getAsString() + "-remapped.jar");
//			if(!modFileRemapped.exists()) {
//				logger.info("Remapping " + mod.get("name").getAsString() + "...");
//				deobfuscateJarWithTinyMappings(mappings, "intermediary", "named", modFile, modFileRemapped);
//			}
//			addToClasspath(modFileRemapped);
//		}

		// Register access changers
		new AccessChangerRegistryOps();
		new AccessChangerProjectileEntity();

		// Run the server through LaunchWrapper using mixins
		Launch.main(new String[] {
			"-version",
			"spade",
			"-gameDir",
			".",
			"-assetsDir",
			".",
			"--mixin",
			"spade.mixins.json",
//			"--mixin",
//			"lithium.mixins.json",
//			"--mixin",
//			"phosphor.mixins.json",
			"--tweakClass",
			SpadeTweaker.class.getName(),
			"--tweakClass",
			MixinTweaker.class.getName(),
		});
	}

//	private static Set<String> getKeys(JsonObject object) {
//		Set<String> keySet = new HashSet<String>();
//		for(Map.Entry<String, JsonElement> entry : object.entrySet()) {
//			keySet.add(entry.getKey());
//		}
//		return keySet;
//	}

//	private static void downloadURL(String url, File destination, String expectedHash, Runnable downloading) throws IOException {
//		if(!(destination.exists() && (expectedHash == null || DigestUtils.sha1Hex(FileUtils.readFileToByteArray(destination)).equalsIgnoreCase(expectedHash)))) {
//			downloading.run();
//			FileUtils.copyURLToFile(new URL(url), destination);
//		}
//	}

	private static String resourceToString(String resource) throws IOException {
		return IOUtils.toString(SpadeLauncher.class.getClassLoader().getResourceAsStream(resource), StandardCharsets.UTF_8);
	}

//	private static void deobfuscateJarWithTinyMappings(File mappings, String from, String to, File in, File out) throws IOException {
//		TinyRemapper remapper = TinyRemapper.newRemapper()
//				.withMappings(TinyUtils.createTinyMappingProvider(mappings.toPath(), from, to))
//				.renameInvalidLocals(true)
//				.rebuildSourceFilenames(true)
//				.build();
//		OutputConsumerPath output = new OutputConsumerPath.Builder(out.toPath()).build();
//		output.addNonClassFiles(in.toPath());
//		remapper.readInputs(in.toPath());
//		remapper.apply(output);
//		output.close();
//		remapper.finish();
//	}

	private static void addToClasspath(File jar) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException {
		ClassLoader classLoader = SpadeLauncher.class.getClassLoader();
		Method addURL = getMethod(classLoader.getClass(), "addURL", URL.class);
		addURL.setAccessible(true);
		addURL.invoke(classLoader, jar.toURI().toURL());
	}

	private static Method getMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
		Method method = null;
		Class<?> newClass = clazz;
		while(method == null) {
			if(newClass == null) {
				return null;
			}
			try {
				method = newClass.getDeclaredMethod(name, parameterTypes);
			}
			catch(NoSuchMethodException e) {
				newClass = clazz.getSuperclass();
			}
		}
		return method;
	}

}
