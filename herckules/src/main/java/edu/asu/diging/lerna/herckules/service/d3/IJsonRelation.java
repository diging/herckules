package edu.asu.diging.lerna.herckules.service.d3;

import java.util.HashMap;

public interface IJsonRelation {
	
	String getType();
	void setType(String type);
	String getEndNode();
	void setEndNode(String endNode);
	String getStartNode();
	void setStartNode(String startNode);
	HashMap<String, String> getData();
	void setData(HashMap<String, String> data);
	String getId();
	void setId(String id);

}
