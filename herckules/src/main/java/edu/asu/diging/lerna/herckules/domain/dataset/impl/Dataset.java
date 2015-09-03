//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.06 at 01:16:07 PM MST 
//


package edu.asu.diging.lerna.herckules.domain.dataset.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import edu.asu.diging.lerna.herckules.domain.dataset.IDataset;
import edu.asu.diging.lerna.herckules.domain.dataset.INode;
import edu.asu.diging.lerna.herckules.domain.dataset.IRelation;




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
 *         &lt;element name="DatabaseList" type="{http://digitalhps.org/lerna-Dataset-model}DatabaseList" minOccurs="0"/>
 *         &lt;element name="NodeList" type="{http://digitalhps.org/lerna-Dataset-model}NodeList" minOccurs="0"/>
 *         &lt;element name="RelationList" type="{http://digitalhps.org/lerna-Dataset-model}RelationList" minOccurs="0"/>
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
	"datasetType",
	"indexRelation",
    "databaseList",
    "nodeList",
    "relationList"
})
@XmlRootElement(name = "dataset")
public class Dataset implements IDataset {

	@XmlElement(required = true)
	 protected String datasetType;
	
	@XmlElement(required = true)
	 protected boolean indexRelation;
	
	@XmlElementWrapper(name="databaseList", required = true)
    @XmlElement(name="database")
	protected List<String> databaseList;
    
	@XmlElementWrapper(name="nodeList", required = true)
    @XmlElement(name="node")
	@XmlJavaTypeAdapter(Node.Adapter.class) protected List<INode> nodeList;
	
	@XmlElementWrapper(name="relationList")
    @XmlElement(name="relation")
	@XmlJavaTypeAdapter(Relation.Adapter.class) protected List<IRelation> relationList;

    /**
     * Gets the value of the databaseList property.
     * 
     * @return
     *     possible object is
     *     {@link DatabaseList }
     *     
     */
	@Override
    public List<String> getDatabaseList() {
        return databaseList;
    }

    /**
     * Sets the value of the databaseList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatabaseList }
     *     
     */
	@Override
    public void setDatabaseList(List<String> value) {
        this.databaseList = value;
    }

    /**
     * Gets the value of the nodeList property.
     * 
     * @return
     *     possible object is
     *     {@link NodeList }
     *     
     */
	@Override
    public List<INode> getNodeList() {
        return nodeList;
    }

    /**
     * Sets the value of the nodeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link NodeList }
     *     
     */
	@Override
    public void setNodeList(List<INode> value) {
        this.nodeList = value;
    }

    /**
     * Gets the value of the relationList property.
     * 
     * @return
     *     possible object is
     *     {@link RelationList }
     *     
     */
	@Override
    public List<IRelation> getRelationList() {
        return relationList;
    }

    /**
     * Sets the value of the relationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationList }
     *     
     */
	@Override
    public void setRelationList(List<IRelation> value) {
        this.relationList = value;
    }

	@Override  
	public String getDatasetType(){
		return datasetType;
	}
	
	@Override  
	public void setDatasetType(String value){
		this.datasetType=value;;
	}

	@Override
	public boolean isIndexRelation() {
		return indexRelation;
	}

}
