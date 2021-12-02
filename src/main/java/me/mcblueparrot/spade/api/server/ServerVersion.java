package me.mcblueparrot.spade.api.server;

import java.util.Date;

/**
 * Represents a server version
 */
public interface ServerVersion {

	/**
	 * Gets the version's name (for example 1.14.4).
	 * @return the name
	 */
	public String getName();

	/**
	 * Gets the pack version (the number used to determine
	 * if a pack is incompatible).
	 * @return the pack version
	 */
	public int getPackVersion();

	/**
	 * Gets the protocol version (the number used to determine
	 * if a client or server is outdated).
	 * @return the protocol version
	 */
	public int getProtocolVersion();

	/**
	 * Gets the world version (the number used to determine
	 * if a world is outdated and needs to be upgraded or
	 * was saved in a newer version and may cause data loss).
	 * @return
	 */
	public int getWorldVersion();

	/**
	 * Gets if the version is stable.
	 * @return if the version is stable
	 */
	public boolean isStable();

	/**
	 * Gets the time when the version was built.
	 * @return the time when the version was built
	 */
	public Date getBuildTime();

}
