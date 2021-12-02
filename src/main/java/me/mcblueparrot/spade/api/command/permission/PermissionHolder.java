package me.mcblueparrot.spade.api.command.permission;

import me.mcblueparrot.spade.api.id.Identifier;

/**
 * Represents something that can have permissions.
 */
public interface PermissionHolder {

	/**
	 * Gets if the permission holder has a permission.
	 * @param permission the permission
	 * @return if the permission holder has the permission
	 */
	public boolean hasPermission(Permission permission);

	/**
	 * Gets if the permission holder has a permission.
	 * @param id the permission's identifier
	 * @return if the permission holder has the permission
	 */
	public default boolean hasPermission(Identifier id) {
		return hasPermission(new Permission(id));
	}

	/**
	 * Gets if the permission holder has a permission.
	 * @param id the permission's identifier (as a string)
	 * @return if the permission holder has the permission
	 */
	public default boolean hasPermission(String id) {
		return hasPermission(Identifier.parse(id));
	}

}
