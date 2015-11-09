package edu.asu.diging.lerna.herckules.db;

import edu.asu.diging.lerna.herckules.domain.impl.Project;

public interface IProjectManager {
	public boolean deleteProject(String projectid) throws Exception;
	public Project retrieveProject(Project project) throws Exception;
	public boolean addProject(Project project)throws Exception;
	public boolean updateProject(Project project)throws Exception;
}
