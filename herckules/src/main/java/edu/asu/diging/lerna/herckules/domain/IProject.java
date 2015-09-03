package edu.asu.diging.lerna.herckules.domain;

import java.util.List;

import edu.asu.diging.lerna.herckules.domain.schema.factory.ISchema;
import edu.asu.diging.lerna.herckules.user.IUser;

public interface IProject {

	public abstract String getProjectid();

	public abstract void setProjectid(String projectid);

	public abstract String getProjectName();

	public abstract void setProjectName(String projectName);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract IUser getCreator();

	public abstract void setCreator(IUser creator);

	public abstract List<IUser> getProjectAdmins();

	public abstract void setProjectAdmins(List<IUser> projectAdmins);
	
	public String getDataset() ;
	public void setDataset(String dataset) ;
	
	public abstract void setIolausDetails(IIolausDetails iolausDetails);
	
	public abstract IIolausDetails getIolausDetails();

	String getProjectIdentifier();

	void setProjectIdentifier(String projectIdentifier);

	ISchema getSchema();

	void setSchema(ISchema schema);

	String getInstanceid();

	

	void setInstanceid(String instanceid);

	List<String> getDatabaseList();

	void setDatabaseList(List<String> databaseList);

}