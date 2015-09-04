package edu.asu.diging.lerna.herckules.domain.impl;

import java.util.List;

import edu.asu.diging.lerna.herckules.authentication.IUser;
import edu.asu.diging.lerna.herckules.domain.IIolausDetails;
import edu.asu.diging.lerna.herckules.domain.IProject;
import edu.asu.diging.lerna.herckules.domain.schema.factory.ISchema;

public class Project implements IProject {
	private String projectid;
	private String projectName;
	private String description;
	private String projectIdentifier;
	private List<String> databaseList;
	
	private IUser creator;
	private List<IUser> projectAdmins;
	
	private String dataset;
	private ISchema schema;
	private IIolausDetails iolausDetails;
	
	@Override
	public String getDataset() {
		return dataset;
	}
	
	@Override
	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	
	private String instanceid;
	@Override
	public String getInstanceid() {
		return instanceid;
	}
	@Override
	public void setInstanceid(String instanceid) {
		this.instanceid = instanceid;
	}

	
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
