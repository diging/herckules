package edu.asu.diging.lerna.herckules.service.d3.impl;

import java.util.HashMap;

import edu.asu.diging.lerna.herckules.service.d3.IJsonRelation;

public class JsonRelation implements IJsonRelation {
	
	String type;
	String endNode;
	String startNode;
	String id;
	HashMap<String, String> data ;
	
	public JsonRelation()
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
	public String getEndNode() {
		return endNode;
	}
	
	@Override
	public void setEndNode(String endNode) {
		this.endNode = endNode;
	}
	
	@Override
	public String getStartNode() {
		return startNode;
	}
	
	@Override
	public void setStartNode(String startNode) {
		this.startNode = startNode;
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
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	

}
