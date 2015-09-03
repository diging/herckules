package edu.asu.diging.lerna.herckules.service.d3;

import java.util.HashMap;


public interface IJsonNode {
	
	String getType();
	void setType(String type);
	String getId();
	void setId(String id);
	HashMap<String, String> getData();
	void setData(HashMap<String, String> data);
	
}
