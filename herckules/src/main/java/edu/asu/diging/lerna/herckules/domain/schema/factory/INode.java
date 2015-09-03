package edu.asu.diging.lerna.herckules.domain.schema.factory;

import java.util.List;

/**
 * 
 * @author Karan Kothari
 *
 */
public interface INode {

	/**
	 * This method adds an attribute in the {@link Node}.
	 * 
	 * @param attr
	 *            is a {@link IAttribute}. It has name and type of attribute.
	 * @return true if attribute name is unique and false if attribute name is
	 *         empty or null
	 * 
	 */
	boolean addAttribute(IAttribute attr);

	/**
	 * This method returns the list of Attributes present in the Table. The list
	 * is unmodifiable.
	 * 
	 * @return the list of Attribute.
	 */
	List<IAttribute> getAttributeList();

	/**
	 * @return the type (type attribute) of table.
	 */
	String getType();

	/**
	 * @param type
	 *            is a type attribute of the table
	 */
	void setType(String type);

	/**
	 * @return the unique Id associated with the table
	 */
	String getUniqueId();

	/**
	 * sets the unique id for a table
	 * 
	 * @param uniqueId
	 *            is a unique id of a table
	 */
	void setUniqueId(String uniqueId);
	
	/**
	 * 
	 * @return the list of 'type' attributes.
	 */
	List<IAttribute> getTypeAttributes();

	/**
	 * adds the type attribute to the list.
	 * @param typeAttribute is a {@link IAttribute} and it is a type attribute for a particular node.
	 */
	void addTypeAttributes(IAttribute typeAttribute);

	/**
	 * adds list of the type attribute to the list.
	 * @param typeAttribute
	 */
	void addAllTypeAttributes(List<IAttribute> typeAttribute);

	void addAllAttributes(List<IAttribute> attributes);
	
}
