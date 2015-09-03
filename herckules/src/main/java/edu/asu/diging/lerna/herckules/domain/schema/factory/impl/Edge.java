package edu.asu.diging.lerna.herckules.domain.schema.factory.impl;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.asu.diging.lerna.herckules.domain.schema.factory.IAttribute;
import edu.asu.diging.lerna.herckules.domain.schema.factory.IEdge;

public class Edge implements IEdge {

	// stores the name of attribute and Attribute.
	private List<IAttribute> attributeList;
	private String type;
	private String uniqueId;
	private List<IAttribute> typeAttributes;
	private String sourceType;
	private String targetType;

	/**
	 * protected default constructor.
	 */
	protected Edge() {

		attributeList = new ArrayList<IAttribute>();
		typeAttributes = new ArrayList<IAttribute>();
	}

	/**
	 * {@link Inherited}
	 */
	@Override
	public String getType() {
		return type;
	}

	/**
	 * {@link Inherited}
	 */
	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public List<IAttribute> getTypeAttributes() {
		return Collections.unmodifiableList(typeAttributes);
	}

	@Override
	public void addTypeAttributes(IAttribute typeAttribute) {

		typeAttributes.add(typeAttribute);
	}

	@Override
	public void addAllTypeAttributes(List<IAttribute> typeAttribute) {
		if (typeAttributes == null) {
			typeAttributes = new ArrayList<IAttribute>();
		}
		typeAttributes.addAll(typeAttribute);
	}

	/**
	 * {@link Inherited}
	 */
	@Override
	public boolean addAttribute(IAttribute attribute) {
		String attributeName = attribute.getName();
		boolean added = false;
		if (!(attributeName == null && attributeName == "")) {
			attributeList.add(attribute);
			added = true;
		}
		return added;
	}

	@Override
	public void addAllAttributes(List<IAttribute> attributes) {

		attributeList.addAll(attributes);
	}

	@Override
	public List<IAttribute> getAttributeList() {

		return Collections.unmodifiableList(attributeList);
	}

	@Override
	public String getUniqueId() {
		return uniqueId;
	}

	@Override
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	@Override
	public String getSourceType() {
		return sourceType;
	}

	@Override
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	@Override
	public String getTargetType() {
		return targetType;
	}

	@Override
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	
}
