package edu.asu.diging.lerna.herckules.domain.schema.factory.impl;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

import edu.asu.diging.lerna.herckules.domain.schema.factory.Datatype;
import edu.asu.diging.lerna.herckules.domain.schema.factory.IAttribute;

/**
 * This class holds Name and {@link Datatype} of the attribute. Constructor of
 * this class is protected. So, object can be created only by the
 * {@link SchemaFactory}.
 * 
 * @author Karan Kothari
 * 
 */
public class Attribute implements IAttribute {

	private String name;
	private String datatype;
	private List<IAttribute> children;
	
	/**
	 * protected constructor
	 */
	protected Attribute() {
		
	}

	/**
	 * {@link Inherited}
	 */
	@Override
	public void setName(String att) {
		this.name = att;
	}

	/**
	 * {@link Inherited}
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * {@link Inherited}
	 */
	@Override
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	/**
	 * {@link Inherited}
	 */
	@Override
	public String getDatatype() {
		return datatype;
	}

	@Override
	public List<IAttribute> getChildren() {
		return children;
	}

	@Override
	public void addChild(IAttribute child) {
		
		if(children == null){
			children = new ArrayList<IAttribute>();
		}
		this.children.add(child);
	}
	
	
	@Override
	public boolean equals(Object obj) {

		Attribute att = (Attribute) obj;
		
		if (this.name.equals(att.name)){
			return true;
		}
		else{
			return false;
		}

	}
	
	@Override
	public int hashCode() {
		
		return this.name.hashCode();
	
	}

}
