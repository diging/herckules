package edu.asu.diging.lerna.herckules.user;

import java.util.List;

public interface IUser {

	public abstract void setUsername(String username);

	public abstract String getPassword();

	public abstract void setPassword(String password);

	public abstract String getUsername();

	public abstract String getName();
	
	public abstract	void setName(String name);

	public abstract String getEmail();

	public abstract void setEmail(String email);

	public abstract boolean isAccountNonExpired();

	public abstract boolean isAccountNonLocked();

	public abstract boolean isCredentialsNonExpired();

	public abstract boolean isEnabled();

	public abstract List<HerckulesGrantedAuthority> getAuthorities();

	public abstract void setAuthorities(List<HerckulesGrantedAuthority> authorities);

	public abstract void addAuthority(HerckulesGrantedAuthority auth);

}