package edu.asu.diging.lerna.herckules.domain.queryObject;

import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import edu.asu.diging.lerna.herckules.domain.queryObject.impl.Database;
import edu.asu.diging.lerna.herckules.domain.queryObject.impl.Dataset;
import edu.asu.diging.lerna.herckules.domain.queryObject.impl.Node;
import edu.asu.diging.lerna.herckules.domain.queryObject.impl.Query;
import edu.asu.diging.lerna.herckules.domain.queryObject.impl.Relationship;

@XmlJavaTypeAdapter(Query.Adapter.class)
public interface IQuery {

	/**
	 * Gets the value of the database property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Database }
	 *     
	 */
	public abstract List<String> getDatabaseList();

	/**
	 * Sets the value of the database property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Database }
	 *     
	 */
	public abstract void setDatabaseList(List<String> value);

	/**
	 * Gets the value of the dataset property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Dataset }
	 *     
	 */
	public abstract IDataset getDataset();

	/**
	 * Sets the value of the dataset property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Dataset }
	 *     
	 */
	public abstract void setDataset(IDataset value);

	/**
	 * Gets the value of the node property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Node }
	 *     
	 */
	public abstract INode getNode();

	/**
	 * Sets the value of the node property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Node }
	 *     
	 */
	public abstract void setNode(INode value);

	/**
	 * Gets the value of the relationship property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Relationship }
	 *     
	 */
	public abstract IRelationship getRelationship();

	/**
	 * Sets the value of the relationship property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link Relationship }
	 *     
	 */
	public abstract void setRelationship(IRelationship value);

	/**
	 * Gets the value of the database ID.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Database }
	 *     
	 */
	public abstract String getDatabaseId(IDatabase db);

	/**
	 * Gets the value of the dataset name.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Dataset }
	 *     
	 */
	public abstract String getDatasetName(IDataset ds);

	/**
	 * Gets the value of the Node details.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Node }
	 *     
	 */
	public abstract void getNodeDetails(INode node);

	/**
	 * Gets the value of the database list.
	 * 
	 * @return
	 *     possible object is
	 *     {@link Dataset }
	 *     
	 */
	List<IDatabase> getDatabaseList(IDatabaseList dbList);

}