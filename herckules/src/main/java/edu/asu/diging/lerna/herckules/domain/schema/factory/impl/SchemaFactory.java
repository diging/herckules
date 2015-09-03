package edu.asu.diging.lerna.herckules.domain.schema.factory.impl;

import edu.asu.diging.lerna.herckules.domain.schema.factory.IAttribute;
import edu.asu.diging.lerna.herckules.domain.schema.factory.IEdge;
import edu.asu.diging.lerna.herckules.domain.schema.factory.INode;
import edu.asu.diging.lerna.herckules.domain.schema.factory.ISchema;

/**
 * This is a factory class. It creates objects of {@link Attribute},
 * {@link Table} and {@link Schema}.
 * 
 * @author Karan Kothari
 */
public class SchemaFactory {

	/**
	 * Default constructor
	 */
	public SchemaFactory() {

	}

	/**
	 * This method creates object of {@link Attribute}
	 * 
	 * @return the object of {@link Attribute}
	 */
	public IAttribute createAttribute() {
		return new Attribute();
	}

	/**
	 * This method creates object of {@link Node}
	 * 
	 * @return the object of {@link INode}
	 */
	public INode createNode() {
		return new Node();
	}

	/**
	 * This method creates object of {@link Node}
	 * 
	 * @return the object of {@link INode}
	 */
	public IEdge createEdge() {
		return new Edge();
	}
	
	/**
	 * This method creates object of {@link Schema}
	 * 
	 * @return the object of {@link Schema}
	 */
	public ISchema createSchema() {
		return new Schema();
	}

}
