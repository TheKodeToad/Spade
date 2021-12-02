package me.mcblueparrot.spade;

/**
 * Represents the version of a server
 */
public interface ServerVersion {

	/**
	 * @see Server#getVersion()
	 */
	public static ServerVersion get() {
		return Spade.getVersion();
	}

	/**
	 * Gets the version's id. For example 1.14.4
	 * @return The id
	 */
	public String getId();

	/**
	 * Gets whether the version is a release
	 * @return <code>true</code> if the version is a release, false if a snapshot
	 */
	public boolean isRelease();

	/**
	 * Gets whether the version is a snapshot
	 * @return <code>true</code> if the version is a snapshot, false if a release
	 */
	public default boolean isSnapshot() {
		return !isRelease();
	}

	/**
	 * Gets the version's protocol version number
	 * @see <a href="https://minecraft.gamepedia.com/Protocol_version">Wiki page</a>
	 * @return The protocol version number
	 */
	public int getProtocolVersion();

	/**
	 * Gets the pack version
	 * @return The pack version
	 */
	public int getPackVersion();

}
