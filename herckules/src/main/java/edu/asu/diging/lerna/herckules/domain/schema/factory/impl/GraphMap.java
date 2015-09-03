package edu.asu.diging.lerna.herckules.domain.schema.factory.impl;

import java.util.HashMap;
import java.util.Map;

import edu.asu.diging.lerna.herckules.domain.schema.factory.IGraph;

 public class GraphMap {

	 public static Map<String, IGraph> graphMap = new HashMap<String, IGraph>();
	
	public GraphMap() {
		graphMap = new HashMap<String, IGraph>();
	}
	
	public static IGraph getGraph(String id)
	{
		IGraph graph = graphMap.get(id);
		return graph;
	}
	
	public static void setGraph(String id, IGraph graph)
	{
		graphMap.put(id, graph);
	}
}
