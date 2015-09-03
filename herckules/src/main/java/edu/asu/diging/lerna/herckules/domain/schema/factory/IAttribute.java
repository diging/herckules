package edu.asu.diging.lerna.herckules.domain.schema.factory;

import java.util.List;

public interface IAttribute {
	
	/**
	 * sets the name of attribute  
	 * @param name is a name of the attribute
	 */
	void setName(String name);
	
	/**
	 * @return the name of the attribute
	 */
	String getName();
	
	/**
	 * sets the datatype of the attribute
	 * @param datatype is a datatype of the attribute.
	 */
	void setDatatype(String datatype);

	/**
	 * @return the datatype of the attribute
	 */
	String getDatatype();

	List<IAttribute> getChildren();

	void addChild(IAttribute child);
}
