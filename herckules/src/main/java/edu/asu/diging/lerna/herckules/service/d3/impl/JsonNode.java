package edu.asu.diging.lerna.herckules.service.d3.impl;

import java.util.HashMap;

import edu.asu.diging.lerna.herckules.service.d3.IJsonNode;

public class JsonNode implements IJsonNode {
	
	String type;
	String id;
	HashMap<String, String> data;
	
	
	public JsonNode()
	{
		this.data = new HashMap<String, String>();
	}
	
	@Override
	public String getType() {
		return type;
	}
	@Override
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public HashMap<String, String> getData() {
		return data;
	}
	
	@Override
	public void setData(HashMap<String, String> data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JsonNode other = (JsonNode) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
