package edu.asu.diging.lerna.herckules.domain.schema.factory;

import java.util.List;

import edu.asu.diging.lerna.herckules.domain.schema.factory.impl.Edge;

/**
 * Interface for adding {@link Node}, {@link Edge} and retrieving the List of {@link Node} and {@link Edge}.   
 * @author Karan Kothari
 *
 */
public interface ISchema {
	
	/**
	 * This method inserts the {@link INode} in the existing list of Nodes. 
	 * 
	 * @param node is not expected to be null and its members are also not expected to be null.
	 */
	void addNode(INode node);

	/**
	 * This method inserts the {@link IEdge} in the existing list of Edges. 
	 * 
	 * @param edge is not expected to be null and its members are also not expected to be null.
	 */
	void addEdge(IEdge edge);

	/**
	 * 
	 * @return the unmodifiable list of {@link INode} existing in that schema.
	 */
	List<INode> getNodeList();

	/**
	 * 
	 * @return the unmodifiable list of {@link IEdge} existing in that schema.
	 */
	List<IEdge> getEdgeList();
}
