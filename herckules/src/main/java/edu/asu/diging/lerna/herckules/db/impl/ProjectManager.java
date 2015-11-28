package edu.asu.diging.lerna.herckules.db.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.asu.diging.lerna.herckules.authentication.impl.IExceptionMessages;
import edu.asu.diging.lerna.herckules.db.IProjectDBConnector;
import edu.asu.diging.lerna.herckules.db.IProjectManager;
import edu.asu.diging.lerna.herckules.domain.impl.Project;
import edu.asu.diging.lerna.herkules.exception.HerckulesArgumentException;
import edu.asu.diging.lerna.herkules.exception.ProjectIDNotFoundException;

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
	private IProjectDBConnector dbconnector;

	/**
	 * Deletes the project from the database after validation of parameter.
	 * 
	 * @param projectid
	 *            The identifier for the project to be deleted.
	 * @return true if the project is deleted from the database.
	 * @throws ProjectIDNotFoundException
	 *             Exception thrown when project with the specified ID does not
	 *             exist.
	 * @throws HerckulesArgumentException
	 *             Exception thrown if the provided projectID is empty or null
	 */
	public boolean deleteProject(String projectid)
			throws HerckulesArgumentException, ProjectIDNotFoundException {
		if (projectid == null || projectid.trim().equals("")) {
			throw new HerckulesArgumentException(
					IExceptionMessages.EMPTY_INPUT_EXCEPTION);
		}
		return dbconnector.deleteProject(projectid);
	}

	/**
	 * Retrieves the project from the database after validation of parameter.
	 * 
	 * @param projectId
	 *            The ID of the project object that is to be retrieved.
	 * @return true if the project is retrieved from the database.
	 * @throws HerckulesArgumentException
	 *             Exception thrown if the provided projectId is empty or null
	 */
	public Project retrieveProject(String projectId)
			throws HerckulesArgumentException {
		if (projectId == null || projectId.trim().equals("")) {
			throw new HerckulesArgumentException(
					IExceptionMessages.EMPTY_INPUT_EXCEPTION);
		}
		return dbconnector.retrieveProject(projectId);
	}

	/**
	 * Adds the project to the database after validation of parameter.
	 * 
	 * @param project
	 *            The project object that is to be added.
	 * @return true if the project is added to the database.
	 * @throws HerckulesArgumentException
	 *             Exception thrown if the provided projectID is empty or null
	 */

	@Override
	public boolean addProject(Project project)
			throws HerckulesArgumentException {
		if (project == null || project.getProjectid() == null
				|| project.getProjectid().trim().equals("")
				|| project.getProjectName() == null
				|| project.getProjectName().trim().equals("")) {
			throw new HerckulesArgumentException(
					IExceptionMessages.EMPTY_INPUT_EXCEPTION);
		}
		return dbconnector.addProject(project);
	}

	/**
	 * Updates to the database after validation of parameter.
	 * 
	 * @param projectId
	 *            The ID of the project object that is to be updated.
	 * @return true if the project is updated in the database.
	 * @throws ProjectIDNotFoundException
	 *             Exception thrown when project object does not exist.
	 * @throws HerckulesArgumentException
	 *             Exception thrown if the provided projectID is empty or null
	 */
	@Override
	public boolean updateProject(String projectId)
			throws ProjectIDNotFoundException, HerckulesArgumentException {
		if (projectId == null || projectId.trim().equals("")) {
			throw new HerckulesArgumentException(
					IExceptionMessages.EMPTY_INPUT_EXCEPTION);
		}
		return dbconnector.updateProject(projectId);
	}
}
