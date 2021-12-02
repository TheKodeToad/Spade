package me.mcblueparrot.spade.remapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import net.fabricmc.tinyremapper.OutputConsumerPath;
import net.fabricmc.tinyremapper.TinyRemapper;
import net.fabricmc.tinyremapper.TinyUtils;

public class YarnRemapper {

	private String version;
	private Consumer<String> output;

	public YarnRemapper(String version, Consumer<String> output) {
		this.version = version;
		this.output = output;
	}

	public String getVersion() {
		return version;
	}

	public File apply(File workFolder) throws JsonSyntaxException, MalformedURLException, IOException {
		File vanillaJar = new File(workFolder, "vanilla.jar");
		File mappingsJar = new File(workFolder, "mappings.jar");
		File mappingsFile = new File(workFolder, "mappings.tiny");
		File namedJar = new File(workFolder, "named.jar");
		JsonParser parser = new JsonParser();

		if(!vanillaJar.exists()) {
			output.accept("Downloading vanilla...");
			JsonObject versionManifest = parser.parse(IOUtils.toString(new URL("https://launchermeta.mojang.com/mc/game/version_manifest.json"), StandardCharsets.UTF_8)).getAsJsonObject();
			JsonArray versions = versionManifest.get("versions").getAsJsonArray();
			JsonObject versionData = null;
			for(JsonElement versionElem : versions) {
				JsonObject testVersion = versionElem.getAsJsonObject();
				if(testVersion.get("id").getAsString().equals(version)) {
					versionData = parser.parse(IOUtils.toString(new URL(testVersion.get("url").getAsString()), StandardCharsets.UTF_8)).getAsJsonObject();
				}
			}
			if(versionData != null) {
				FileUtils.copyURLToFile(new URL(versionData.get("downloads").getAsJsonObject().get("server").getAsJsonObject().get("url").getAsString()), vanillaJar);
			}
			else {
				throw new RuntimeException("Could not download vanilla jar");
			}
		}

		if(!mappingsJar.exists()) {
			output.accept("Downloading mappings...");
			JsonObject yarnVersions = parser.parse(IOUtils.toString(new URL("https://maven.fabricmc.net/net/fabricmc/yarn/versions.json"), StandardCharsets.UTF_8)).getAsJsonObject();
			JsonArray yarnBuilds = yarnVersions.get(version).getAsJsonArray();
			int yarnBuild = yarnBuilds.get(yarnBuilds.size() - 1).getAsInt();
			String yarnVersion = version + "+build." + yarnBuild;
			FileUtils.copyURLToFile(new URL("https://maven.fabricmc.net/net/fabricmc/yarn/" + yarnVersion + "/yarn-" + yarnVersion + "-mergedv2.jar"), mappingsJar);
		}

		if(!mappingsFile.exists()) {
			try(ZipFile mappingsZip = new ZipFile(mappingsJar)) {
				Enumeration<? extends ZipEntry> entries = mappingsZip.entries();
				while(entries.hasMoreElements()) {
					ZipEntry entry = entries.nextElement();
					if(entry.getName().equals("mappings/mappings.tiny")) {
						try(InputStream input = mappingsZip.getInputStream(entry); OutputStream output = new FileOutputStream(mappingsFile)) {
							IOUtils.copy(input, output);
						}
						break;
					}
				}
			}
		}

		if(!namedJar.exists()) {
			output.accept("Remapping...");
			TinyRemapper remapper = TinyRemapper.newRemapper()
				.withMappings(TinyUtils.createTinyMappingProvider(mappingsFile.toPath(), "official", "named"))
				.renameInvalidLocals(true)
				.rebuildSourceFilenames(true)
				.build();
			OutputConsumerPath output = new OutputConsumerPath.Builder(namedJar.toPath()).build();
			output.addNonClassFiles(vanillaJar.toPath());
			remapper.readInputs(vanillaJar.toPath());
			remapper.apply(output);
			output.close();
			remapper.finish();
		}
		return namedJar;
	}

	public static void main(String[] args) throws JsonSyntaxException, MalformedURLException, IOException {
		new YarnRemapper("1.16.3", System.out::println).apply(new File("./work"));
	}

}
