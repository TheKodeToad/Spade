package me.mcblueparrot.spade.api.command.permission;

import java.util.Objects;

import me.mcblueparrot.spade.api.id.Identifier;

/**
 * Represents a permission that can be applied to a {@link PermissionHolder}.
 */
public class Permission {

	private Identifier id;

	/**
	 * Creates a permission.
	 * @param id the identifier
	 */
	public Permission(Identifier id) {
		this.id = id;
	}

	/**
	 * Gets the permission's identifier.
	 * @return the identifier
	 */
	public Identifier getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		Permission other = (Permission) obj;
		return Objects.equals(id, other.id);
	}

}
