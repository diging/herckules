package edu.asu.diging.lerna.herckules.authentication.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.asu.diging.lerna.herckules.db.impl.ProjectDBConnector;
import edu.asu.diging.lerna.herckules.domain.impl.Project;
import edu.asu.diging.lerna.herkules.exception.HerckulesStorageException;
import edu.asu.diging.lerna.herkules.exception.ProjectNotFoundException;

/**
 * This class implements {@link IProjectManager} functions. This manager class
 * connects the project controller and the ProjectDBConnector. This is used to
 * validate business logic before retrieving, adding, updating, or deleting a
 * project.
 * 
 * @author Tamalika Mukherjee
 * @author Vineel Vutukuri
 */

@Service
public class ProjectManager implements IProjectManager {
	@Autowired
	ProjectDBConnector proj = new ProjectDBConnector();

	public boolean deleteProject(String projectid)
			throws ProjectNotFoundException {
		/*
		 * Deletes the project from the database after validation of parameter.
		 * 
		 * @param projectid 					The identifier for the project to be deleted.
		 * 
		 * @throws ProjectNotFoundException 	Exception thrown when project with
		 * 											the specified ID does not exist.
		 */
		if (projectid == null || projectid.trim().equals("")) {
			throw new ProjectNotFoundException(
					"Project with the specified ID does not exist.");
		}
		return proj.deleteProject(projectid);
	}

	public Project retrieveProject(Project project)
			throws HerckulesStorageException, ProjectNotFoundException {
		/*
		 * Retrieves the project from the database after validation of
		 * parameter.
		 * 
		 * @param project 						The project object that is to be retrieved.
		 * 
		 * @throws ProjectNotFoundException 	Exception thrown when project object
		 * 														does not exist.
		 */
		if (project.getProjectid() == null
				|| project.getProjectid().trim().equals("")) {
			throw new ProjectNotFoundException(
					"Specified project does not exist.");
		}
		return proj.retrieveProject(project);

	}

	@Override
	public boolean addProject(Project project) throws HerckulesStorageException {
		/*
		 * Adds the project to the database after validation of parameter.
		 * 
		 * @param project 						The project object that is to be added.
		 * 
		 * @throws ProjectNotFoundException 	Exception thrown when project object
		 * 										does not exist.
		 */
		if (project == null || project.getProjectid() == null
				|| project.getProjectid().trim().equals("")
				|| project.getProjectName() == null
				|| project.getProjectName().trim().equals("")) {
			throw new HerckulesStorageException(
					IExceptionMessages.OPERATION_EXCEPTION);
		}
		return proj.addProject(project);
	}

	@Override
	public boolean updateProject(Project project)
			throws ProjectNotFoundException {
		/*
		 * Updates to the database after validation of parameter.
		 * 
		 * @param project 						The project object that is to be updated.
		 * 
		 * @throws ProjectNotFoundException 	Exception thrown when project object
		 * 										does not exist.
		 */
		
		if (project.getProjectid() == null
				|| project.getProjectid().trim().equals("")) {
			throw new ProjectNotFoundException(
					"Specified project does not exist.");
		}
		return proj.updateProject(project);
	}
}
