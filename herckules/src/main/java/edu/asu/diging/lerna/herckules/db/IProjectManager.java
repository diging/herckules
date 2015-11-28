package edu.asu.diging.lerna.herckules.db;

import edu.asu.diging.lerna.herckules.domain.impl.Project;
import edu.asu.diging.lerna.herkules.exception.HerckulesArgumentException;
import edu.asu.diging.lerna.herkules.exception.ProjectIDNotFoundException;

public interface IProjectManager {
	public boolean deleteProject(String projectid)
			throws HerckulesArgumentException, ProjectIDNotFoundException;

	public Project retrieveProject(String projectId)
			throws HerckulesArgumentException;

	public boolean addProject(Project project)
			throws HerckulesArgumentException;

	public boolean updateProject(String projectId)
			throws HerckulesArgumentException, ProjectIDNotFoundException;
}
