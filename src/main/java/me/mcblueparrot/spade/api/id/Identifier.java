package me.mcblueparrot.spade.api.id;

import java.util.Objects;
import java.util.UUID;

import org.apache.commons.lang3.Validate;

import me.mcblueparrot.spade.api.Cloneable;
import me.mcblueparrot.spade.api.SpadeExceptionMessages;
import me.mcblueparrot.spade.api.plugin.Plugin;

/**
 * Represents an identifier (for example <code>minecraft:air</code>).
 * <p>Namespaces and paths can only contain lowercase letters, digits or the following characters: "_", "." and "-".</p>
 * <p>Paths can also contain forward slashes.</p>
 */
public class Identifier implements Cloneable<Identifier> {

	private static final String MINECRAFT_NAMESPACE = "minecraft";
	private static final String NAMESPACE_REGEX = "[0-9a-z._-]+";
	private static final String PATH_REGEX = "[0-9a-z/._-]+";
	private String namespace;
	private String path;

	/**
	 * Creates an identifier for a plugin.
	 * @param plugin the plugin
	 * @param path the path
	 */
	public Identifier(Plugin plugin, String path) {
		this(plugin.getName().toLowerCase(), path);
	}

	/**
	 * Creates an identifier.
	 * @param namespace the namespace
	 * @param path the path
	 */
	public Identifier(String namespace, String path) {
		validateNamespace(Validate.notNull(namespace, SpadeExceptionMessages.NAMESPACE_NULL));
		validatePath(Validate.notNull(path, SpadeExceptionMessages.PATH_NULL));
		this.namespace = namespace;
		this.path = path;
	}

	/**
	 * Creates a copy of an identifier.
	 * @param id the identifier
	 */
	public Identifier(Identifier id) {
		this(id.namespace, id.path);
	}

	/**
	 * Parse an identifier in the format <code>namespace:path</code>.
	 * <p>If the string does not contain a colon, the identifier will use the <code>minecraft</code> namespace.</p>
	 * @param id the string to parse
	 * @return the identifier
	 */
	public static Identifier parse(String id) {
		if(id.contains(":")) {
			return new Identifier(id.substring(0, id.indexOf(":")), id.substring(id.indexOf(":") + 1));
		}
		else {
			return Identifier.minecraft(id);
		}
	}

	/**
	 * Validates a namespace.
	 * @param namespace the namespace
	 * @throws IllegalArgumentException if the namespace is invalid
	 */
	public static void validateNamespace(String namespace) {
		Validate.matchesPattern(namespace, NAMESPACE_REGEX, "The namespace %s does not match the pattern %s", namespace, NAMESPACE_REGEX);
	}

	/**
	 * Validates a path.
	 * @param path the path
	 * @throws IllegalArgumentException if the path is invalid
	 */
	public static void validatePath(String path) {
		Validate.matchesPattern(path, PATH_REGEX, "The path %s does not match the pattern %s", path, PATH_REGEX);
	}

	/**
	 * Gets the namespace.
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * Gets the path.
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Gets if the namespace is the <code>minecraft</code> namespace.
	 * @return if the namespace is the <code>minecraft</code> namespace
	 */
	public boolean isMinecraft() {
		return getNamespace().equals(MINECRAFT_NAMESPACE);
	}

	/**
	 * Generate a random identifier with the <code>minecraft</code> namespace.
	 * @return the identifier
	 */
	public static Identifier random() {
		return random("minecraft");
	}

	/**
	 * Generate a random identifier.
	 * @param namespace the namespace
	 * @return the identifier
	 */
	public static Identifier random(String namespace) {
		return new Identifier(namespace, UUID.randomUUID().toString());
	}

	/**
	 * Generate a random identifier.
	 * @param plugin the plugin to use for the namespace
	 * @return the identifier
	 */
	public static Identifier random(Plugin plugin) {
		return new Identifier(plugin, UUID.randomUUID().toString());
	}

	/**
	 * Gets a identifier with the <code>minecraft</code> namespace.
	 * @param path the path
	 * @return the identifier
	 */
	public static Identifier minecraft(String path) {
		return new Identifier(MINECRAFT_NAMESPACE, path);
	}

	@Override
	public String toString() {
		return namespace + ":" + path;
	}

	@Override
	public int hashCode() {
		return Objects.hash(namespace, path);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Identifier other = (Identifier) obj;
		return Objects.equals(namespace, other.namespace) && Objects.equals(path, other.path);
	}

	@Override
	public Identifier clone() {
		return new Identifier(this);
	}

}
