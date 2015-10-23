package edu.asu.diging.lerna.herckules.authentication;

import org.springframework.security.core.GrantedAuthority;

public class HerckulesGrantedAuthority implements GrantedAuthority{

	private String roleName;
	private static final long serialVersionUID = 711167440813692597L;
	
	public HerckulesGrantedAuthority(){
		super();
	}
	/**
	 * Sets the rolename for this object
	 * @param name
	 */
	public HerckulesGrantedAuthority(String name){
		this.roleName=name;
	}
	
	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String getAuthority() {
		return this.roleName;
	}

	/**
	 * Setter for the {@link Role}
	 * @param roleName
	 */
	public void setAuthority(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		HerckulesGrantedAuthority authority = (HerckulesGrantedAuthority) obj;
		if (roleName == null) {
			if (authority.roleName != null)
				return false;
		} else if (!roleName.equals(authority.roleName))
			return false;
		
		return true;
	}
}
