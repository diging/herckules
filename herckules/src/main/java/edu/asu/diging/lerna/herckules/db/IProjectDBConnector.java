package edu.asu.diging.lerna.herckules.db;

import edu.asu.diging.lerna.herckules.domain.impl.Project;
import edu.asu.diging.lerna.herkules.exception.ProjectIDNotFoundException;

public interface IProjectDBConnector {
	public Project retrieveProject(Project project);
	public boolean addProject(Project project);
	public boolean updateProject(Project project) throws ProjectIDNotFoundException;
	public boolean deleteProject(String projectid) throws ProjectIDNotFoundException;
}
