package edu.asu.diging.lerna.herckules.domain.schema.factory.impl;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.asu.diging.lerna.herckules.domain.schema.factory.IEdge;
import edu.asu.diging.lerna.herckules.domain.schema.factory.INode;
import edu.asu.diging.lerna.herckules.domain.schema.factory.ISchema;

/**
 * This class stores the schema of the dataset. Constructor of this class is
 * protected. So, object can be created only by the {@link SchemaFactory}.
 * 
 * @author Karan Kothari
 * 
 */
public class Schema implements ISchema {

	
	private List<INode> nodeList;
	
	private List<IEdge> edgeList;
	
	
	/**
	 * protected constructor
	 */
	protected Schema() {
		nodeList = new ArrayList<INode>();
		edgeList = new ArrayList<IEdge>();
	}

	/**
	 * {@link Inherited}
	 */
	@Override
	public void addNode(INode node) {
		if (node != null)
			nodeList.add(node);
	}
	
	/**
	 * {@link Inherited}
	 */
	@Override
	public void addEdge(IEdge edge) {
		if (edge != null)
			edgeList.add(edge);
	}
	
	/**
	 * {@link Inherited}
	 */
	@Override
	public List<INode> getNodeList() {
		return Collections.unmodifiableList(nodeList);
	}
	
	/**
	 * {@link Inherited}
	 */
	@Override
	public List<IEdge> getEdgeList() {
		return Collections.unmodifiableList(edgeList);
	}
	
}
