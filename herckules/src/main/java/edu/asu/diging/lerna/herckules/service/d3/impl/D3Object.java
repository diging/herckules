package edu.asu.diging.lerna.herckules.service.d3.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import edu.asu.diging.lerna.herckules.service.d3.ID3Object;
import edu.asu.diging.lerna.herckules.service.d3.IJsonNode;
import edu.asu.diging.lerna.herckules.service.d3.IJsonRelation;

public class D3Object implements ID3Object{

	Set<IJsonNode> node;
	List<IJsonRelation> edges;
	HashMap<String, Integer> nodeIndex;

	
	@Override
	public Set<IJsonNode> getNode() {
		return node;
	}
	
	@Override
	public void setNode(Set<IJsonNode> node) {
		this.node = node;
	}
	
	@Override
	public List<IJsonRelation> getEdges() {
		return edges;
	}
	
	@Override
	public void setEdges(List<IJsonRelation> edges) {
		this.edges = edges;
	}
	
	@Override
	public HashMap<String, Integer> getNodeIndex() {
		return nodeIndex;
	}

	@Override
	public void setNodeIndex(HashMap<String, Integer> nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

}
