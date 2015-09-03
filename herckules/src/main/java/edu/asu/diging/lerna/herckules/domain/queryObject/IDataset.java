package edu.asu.diging.lerna.herckules.domain.queryObject;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import edu.asu.diging.lerna.herckules.domain.queryObject.impl.Dataset;

@XmlJavaTypeAdapter(Dataset.Adapter.class)
@XmlSeeAlso(Dataset.class)
public interface IDataset {

	/**
	 * Gets the value of the id property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public abstract String getId();

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public abstract void setId(String value);

}