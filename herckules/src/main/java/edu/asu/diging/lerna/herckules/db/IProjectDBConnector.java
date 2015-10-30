package edu.asu.diging.lerna.herckules.db;

import edu.asu.diging.lerna.herckules.domain.impl.Project;

public interface IProjectDBConnector {
	public Project retrieveProject(Project project);
	public boolean addProject(Project project);
	public boolean updateProject(Project project);
	public boolean deleteProject(String projectid) throws Exception;
}
