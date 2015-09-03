package edu.asu.diging.lerna.herckules.domain.impl;

import org.hibernate.validator.constraints.NotEmpty;

import edu.asu.diging.lerna.herckules.domain.IIolausDetails;

public class IolausDetails implements IIolausDetails {

	private String id;
	
	@NotEmpty(message = "Port cannot be empty")
	private String port;

	@NotEmpty(message = "Host Name cannot be empty")
	private String host;

	@NotEmpty(message = "UserName cannot be empty")
	private String username;

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

	@NotEmpty(message = "Password cannot be empty")
	private String password;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public String getPort() {
		return port;
	}

	@Override
	public void setPort(String port) {
		this.port = port;

	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		IIolausDetails iolaus = (IIolausDetails) obj;

		if (id == null) {
			if (iolaus.getId() != null)
				return false;
		} else if (!id.equals(iolaus.getId()))
			return false;
		
		
		
		if (host == null) {
			if (iolaus.getHost() != null)
				return false;
		} else if (!host.equals(iolaus.getHost()))
			return false;
		
		if (port == null) {
			if (iolaus.getPort() != null)
				return false;
		} else if (!port.equals(iolaus.getPort()))
			return false;
		
		return true;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		
		return result;
	}

}
