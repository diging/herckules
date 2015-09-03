//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.25 at 09:21:19 AM MST 
//


package edu.asu.diging.lerna.herckules.domain.queryObject.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import edu.asu.diging.lerna.herckules.domain.queryObject.IDatabase;
import edu.asu.diging.lerna.herckules.domain.queryObject.IDatabaseList;
import edu.asu.diging.lerna.herckules.domain.queryObject.IDataset;
import edu.asu.diging.lerna.herckules.domain.queryObject.INode;
import edu.asu.diging.lerna.herckules.domain.queryObject.IQuery;
import edu.asu.diging.lerna.herckules.domain.queryObject.IRelationship;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://digitalhps.org/lerna-query-model}database" minOccurs="0"/>
 *         &lt;element ref="{http://digitalhps.org/lerna-query-model}dataset" minOccurs="0"/>
 *         &lt;element ref="{http://digitalhps.org/lerna-query-model}node" minOccurs="0"/>
 *         &lt;element ref="{http://digitalhps.org/lerna-query-model}relationship" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "databaseList",
    "dataset",
    "node",
    "relationship"
})
@XmlRootElement(name = "query")
public class Query implements IQuery {
	
	@XmlElementWrapper(name="databaseList")
    @XmlElement(name="database")
	protected List<String> databaseList;
	@XmlJavaTypeAdapter(Dataset.Adapter.class) protected IDataset dataset;
	@XmlJavaTypeAdapter(Node.Adapter.class) protected INode node;
	@XmlJavaTypeAdapter(RelNode.Adapter.class) protected IRelationship relationship;
	

    /* (non-Javadoc)
	 * @see edu.asu.lerna.iolaus.domain.queryobject.impl.IQuery#getDatabase()
	 */
    @Override
	public List<String> getDatabaseList() {
        return databaseList;
    }

    /* (non-Javadoc)
	 * @see edu.asu.lerna.iolaus.domain.queryobject.impl.IQuery#setDatabase(edu.asu.lerna.iolaus.domain.queryobject.IDatabase)
	 */
    @Override
	public void setDatabaseList(List<String> value) {
        this.databaseList = value;
    }

    /* (non-Javadoc)
	 * @see edu.asu.lerna.iolaus.domain.queryobject.impl.IQuery#getDataset()
	 */
    @Override
    public IDataset getDataset() {
        return dataset;
    }

    /* (non-Javadoc)
	 * @see edu.asu.lerna.iolaus.domain.queryobject.impl.IQuery#setDataset(edu.asu.lerna.iolaus.domain.queryobject.IDataset)
	 */
    @Override
	public void setDataset(IDataset value) {
        this.dataset = value;
    }

    /* (non-Javadoc)
	 * @see edu.asu.lerna.iolaus.domain.queryobject.impl.IQuery#getNode()
	 */
    @Override
	public INode getNode() {
        return node;
    }

    /* (non-Javadoc)
	 * @see edu.asu.lerna.iolaus.domain.queryobject.impl.IQuery#setNode(edu.asu.lerna.iolaus.domain.queryobject.INode)
	 */
    @Override
	public void setNode(INode value) {
        this.node = value;
    }

    /* (non-Javadoc)
	 * @see edu.asu.lerna.iolaus.domain.queryobject.impl.IQuery#getRelationship()
	 */
    @Override
	public IRelationship getRelationship() {
        return relationship;
    }

    /* (non-Javadoc)
	 * @see edu.asu.lerna.iolaus.domain.queryobject.impl.IQuery#setRelationship(edu.asu.lerna.iolaus.domain.queryobject.impl.Relationship)
	 */
    @Override
	public void setRelationship(IRelationship value) {
        this.relationship = value;
    }

    
    /* (non-Javadoc)
	 * @see edu.asu.lerna.iolaus.domain.queryobject.impl.IQuery#getDatabaseId(edu.asu.lerna.iolaus.domain.queryobject.IDatabase)
	 */
    @Override
	public String getDatabaseId(IDatabase db){
    	return db.getId();
    }
    
    @Override
	public List<IDatabase> getDatabaseList(IDatabaseList dbList){
    	return dbList.getDatabase();
    }
    
    
    /* (non-Javadoc)
	 * @see edu.asu.lerna.iolaus.domain.queryobject.impl.IQuery#getDatasetName(edu.asu.lerna.iolaus.domain.queryobject.IDataset)
	 */
    @Override
	public String getDatasetName(IDataset ds){
    	return ds.getId();
    }
    
    /* (non-Javadoc)
	 * @see edu.asu.lerna.iolaus.domain.queryobject.impl.IQuery#getNodeDetails(edu.asu.lerna.iolaus.domain.queryobject.impl.Node)
	 */
    @Override
	public void getNodeDetails(INode node){
    	node.getNodeDetails(node);
    }
    
    public static class Adapter extends XmlAdapter<Query,IQuery> {
    	public IQuery unmarshal(Query v) { return v; }
    	public Query marshal(IQuery v) { return (Query)v; }

     }
}
