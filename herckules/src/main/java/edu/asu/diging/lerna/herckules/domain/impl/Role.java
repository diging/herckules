package edu.asu.diging.lerna.herckules.domain.impl;

import edu.asu.diging.lerna.herckules.authentication.impl.User;
import edu.asu.diging.lerna.herckules.domain.IRole;

/**
 * {@link Role} is used to define a role for the {@link User}
 * 
 * @author : Lohith Dwaraka
 *
 */
public class Role implements IRole {

	private String id;
	private String name;
	private String description;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role role = (Role) obj;
		

		if (id == null) {
			if (role.id != null)
				return false;
		} else if (!id.equals(role.id))
			return false;
		
		if (name == null) {
			if (role.name != null)
				return false;
		} else if (!name.equals(role.name))
			return false;
		

		if (description == null) {
			if (role.description != null)
				return false;
		} else if (!description.equals(role.description))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}
}
