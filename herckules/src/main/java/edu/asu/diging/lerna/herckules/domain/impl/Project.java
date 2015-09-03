package edu.asu.diging.lerna.herckules.domain.impl;

import java.util.List;

import edu.asu.diging.lerna.herckules.domain.IIolausDetails;
import edu.asu.diging.lerna.herckules.domain.IProject;
import edu.asu.diging.lerna.herckules.domain.schema.factory.ISchema;
import edu.asu.diging.lerna.herckules.user.IUser;

public class Project implements IProject {
	private String projectid;
	private String projectName;
	private String description;
	private String projectIdentifier;
	private List<String> databaseList;
	
	private IUser creator;
	private List<IUser> projectAdmins;
	
	private String dataset;
	
	@Override
	public String getDataset() {
		return dataset;
	}
	
	@Override
	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	//@DBRef
	private IIolausDetails iolausDetails;
	
	private String instanceid;
	@Override
	public String getInstanceid() {
		return instanceid;
	}
	@Override
	public void setInstanceid(String instanceid) {
		this.instanceid = instanceid;
	}

	private ISchema schema;

	@Override
	public String getProjectid() {
		return projectid;
	}

	@Override
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	@Override
	public String getProjectName() {
		return projectName;
	}

	@Override
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public IUser getCreator() {
		return creator;
	}

	@Override
	public void setCreator(IUser creator) {
		this.creator = creator;
	}

	@Override
	public List<IUser> getProjectAdmins() {
		return projectAdmins;
	}

	@Override
	public void setProjectAdmins(List<IUser> projectAdmins) {
		this.projectAdmins = projectAdmins;
	}

	@Override
	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	@Override
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	
	@Override
	public List<String> getDatabaseList() {
		return databaseList;
	}
	
	@Override
	public void setDatabaseList(List<String> databaseList) {
		this.databaseList = databaseList;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		IProject project = (IProject) obj;
		if (projectid == null) {
			if (project.getProjectid() != null)
				return false;
		} else if (!projectid.equals(project.getProjectid()))
			return false;

		if (projectName == null) {
			if (project.getProjectName() != null)
				return false;
		} else if (!projectName.equals(project.getProjectName()))
			return false;
		
		if (description == null) {
			if (project.getDescription() != null)
				return false;
		} else if (!description.equals(project.getDescription()))
			return false;
		
		if (projectIdentifier == null) {
			if (project.getProjectIdentifier() != null)
				return false;
		} else if (!projectIdentifier.equals(project.getProjectIdentifier()))
			return false;
		
		if (creator == null) {
			if (project.getCreator() != null)
				return false;
		} else if (!creator.equals(project.getCreator()))
			return false;
		
		if (projectAdmins == null) {
			if (project.getProjectAdmins() != null)
				return false;
		} else if (!projectAdmins.equals(project.getProjectAdmins()))
			return false;
		
		if (dataset == null) {
			if (project.getDataset() != null)
				return false;
		} else if (!dataset.equals(project.getDataset()))
			return false;
		
		
		if (iolausDetails == null) {
			if (project.getIolausDetails() != null)
				return false;
		} else if (!iolausDetails.equals(project.getIolausDetails()))
			return false;
		
		return true;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((projectid == null) ? 0 : projectid.hashCode());
		result = prime * result	+ ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((projectIdentifier == null) ? 0 : projectIdentifier.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((projectAdmins == null) ? 0 : projectAdmins.hashCode());
		result = prime * result + ((dataset == null) ? 0 : dataset.hashCode());
		result = prime * result + ((iolausDetails == null) ? 0 : iolausDetails.hashCode());
		
		return result;
	}

	@Override
	public void setIolausDetails(IIolausDetails iolausDetails) {
		this.iolausDetails = iolausDetails;

	}

	@Override
	public IIolausDetails getIolausDetails() {
		return iolausDetails;
	}

	@Override
	public ISchema getSchema() {
		return schema;
	}

	@Override
	public void setSchema(ISchema schema) {
		this.schema = schema;
	}

}
