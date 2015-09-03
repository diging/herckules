package edu.asu.diging.lerna.herckules.domain.impl;

import edu.asu.diging.lerna.herckules.domain.IDataset;


public class Dataset implements IDataset {

	private String id;
	private String description;
	
	@Override
	public String getId(){
		return id;
	}
	
	@Override
	public String getDescription()
	{
		return description;
	}
	
	@Override
	public void setId(String id)
	{
		this.id = id;
	}
	
	@Override
	public void setDescription(String description){
		this.description = description;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		IDataset dataset = (Dataset)obj;
		if (id == null) {
			if (dataset.getId() != null)
				return false;
		} else if (!id.equals(dataset.getId()))
			return false;
		
		
		if (description == null) {
			if (dataset.getDescription() != null)
				return false;
		} else if (!description.equals(dataset.getDescription()))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		
		return result;
	}
}
