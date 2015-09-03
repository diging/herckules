package edu.asu.diging.lerna.herckules.service.d3;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface ID3Object {

	public Set<IJsonNode> getNode();
	public void setNode(Set<IJsonNode> node);
	public List<IJsonRelation> getEdges();
	public void setEdges(List<IJsonRelation> edges);
	public HashMap<String, Integer> getNodeIndex() ;
	public void setNodeIndex(HashMap<String, Integer> nodeMap); 
	
}
