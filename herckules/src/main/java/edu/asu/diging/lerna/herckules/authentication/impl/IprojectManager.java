package edu.asu.diging.lerna.herckules.authentication.impl;

import edu.asu.diging.lerna.herckules.domain.impl.Project;

public interface IprojectManager {
	public boolean deleteProject(String projectid) throws Exception;
	public Project retrieveProject(Project p) throws Exception;
	public boolean addProject(Project p)throws Exception;
	public boolean updateProject(Project p)throws Exception;
}