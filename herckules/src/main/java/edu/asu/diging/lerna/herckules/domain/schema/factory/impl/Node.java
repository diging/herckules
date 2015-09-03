package edu.asu.diging.lerna.herckules.domain.schema.factory.impl;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.asu.diging.lerna.herckules.domain.schema.factory.IAttribute;
import edu.asu.diging.lerna.herckules.domain.schema.factory.INode;


/**
 * This class has list of all {@link Attribute} present in the table. Its
 * default constructor is protected. So, object be created only by
 * {@link SchemaFactory}
 * 
 * @author Karan Kothari
 */
public class Node implements INode {
		
		// stores the name of attribute and Attribute.
		private List<IAttribute> attributeList;
		private String type;
		private String uniqueId;
		private List<IAttribute> typeAttributes;

		/**
		 * protected default constructor.
		 */
		protected Node() {

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

}
