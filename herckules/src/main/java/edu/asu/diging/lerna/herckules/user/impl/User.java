package edu.asu.diging.lerna.herckules.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import edu.asu.diging.lerna.herckules.user.HerckulesGrantedAuthority;
import edu.asu.diging.lerna.herckules.user.IUser;

public class User implements IUser, UserDetails {

	private String username;
	private String password;
	private String name;
	private String email;
	private List<HerckulesGrantedAuthority> authorities;

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public List<HerckulesGrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public void setAuthorities(List<HerckulesGrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public void addAuthority(HerckulesGrantedAuthority auth) {
		if(this.authorities == null)
		{
			this.authorities = new ArrayList<HerckulesGrantedAuthority>();
		}
		this.authorities.add(auth);
	}
	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		IUser user = (User)obj;
		if (username == null) {
			if (user.getUsername() != null)
				return false;
		} else if (!username.equals(user.getUsername()))
			return false;
		
		
		if (password == null) {
			if (user.getPassword() != null)
				return false;
		} else if (!password.equals(user.getPassword()))
			return false;
		
		
		if (name == null) {
			if (user.getName() != null)
				return false;
		} else if (!name.equals(user.getName()))
			return false;
		
		
		if (email == null) {
			if (user.getEmail() != null)
				return false;
		} else if (!email.equals(user.getEmail()))
			return false;
		
		if (authorities == null) {
			if (user.getAuthorities() != null)
				return false;
		} else if (!authorities.equals(user.getAuthorities()))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((username == null) ? 0 : username.hashCode());
		result = prime * result	+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((authorities == null) ? 0 : authorities.hashCode());
		
		return result;
	}
	
}