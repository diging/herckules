package edu.asu.diging.lerna.herckules.authentication;

import edu.asu.diging.lerna.herckules.domain.impl.Project;

public interface IProjectDBConnector {
	public Project retrieveProject(Project p);
	public boolean addProject(Project p);
	public boolean updateProject(Project p);
	public boolean deleteProject(String projectid) throws Exception;
}
