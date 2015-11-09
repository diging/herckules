package edu.asu.diging.lerna.herckules.db.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.diging.lerna.herckules.authentication.impl.IExceptionMessages;
import edu.asu.diging.lerna.herckules.db.IProjectDBConnector;
import edu.asu.diging.lerna.herckules.domain.impl.Project;
import edu.asu.diging.lerna.herkules.exception.*;

/**
 * This class implements {@link IProjectDBConnector} functions. This component
 * layer class is used to retrieve, or delete a project from a objectDB
 * database. It also has functions for adding or modifying a project.
 * 
 * @author Tamalika Mukherjee
 * @author Vineel Vutukuri
 */

@Component
@Transactional
public class ProjectDBConnector implements IProjectDBConnector {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Retrieves the project from the database.
	 * 
	 * @param Project
	 *            The project object that is to be retrieved to the database.
	 * @return true Returns true if the project is successfully retrieved from the
	 *         database.
	 */
	@Transactional
	public Project retrieveProject(Project project) {

		TypedQuery<Project> query = manager
				.createQuery(
						"SELECT project FROM Project project WHERE project.creator == :creator",
						Project.class);
		project = query.setParameter("creator", project.getCreator())
				.getSingleResult();
		return project;
	}

	/**
	 * Adds the project to the database.
	 * 
	 * @param Project
	 *            The project object that is to be added to the database.
	 * @return true Returns true if the project is successfully added to the
	 *         database.
	 */
	@Transactional
	public boolean addProject(Project project) {

		manager.persist(project);
		return true;
	}

	/**
	 * Updates all the attributes of the project.
	 * 
	 * @param Project
	 *            The project object that is to be retrieved from the database.
	 * @return true Returns true if the project object is updated.
	 * @throws ProjectIDNotFoundException
	 *             Exception thrown when the projectID is not found in the
	 *             database.
	 */
	@Transactional
	public boolean updateProject(Project project)
			throws ProjectIDNotFoundException {

		Project proj = manager.find(Project.class, project.getProjectid());
		if (proj != null) {
			proj.setCreator(project.getCreator());
			proj.setProjectAdmins(project.getProjectAdmins());
			proj.setDescription(project.getDescription());
			proj.setProjectName(project.getProjectName());
			proj.setSchema(project.getSchema());
			proj.setIolausDetails(project.getIolausDetails());
			proj.setDataset(project.getDataset());
			proj.setDatabaseList(project.getDatabaseList());
			return true;
		}
		throw new ProjectIDNotFoundException(
				IExceptionMessages.PROJECTID_EXCEPTION);
	}

	/**
	 * Removes the project with the specified projectID.
	 * 
	 * @param projectID
	 *            The projectID that is to be deleted from the database.
	 * @return true Returns true if the project is deleted.
	 * @throws ProjectIDNotFoundException
	 *             Exception thrown when the projectID is not found in the
	 *             database.
	 */

	@Transactional
	public boolean deleteProject(String projectID)
			throws ProjectIDNotFoundException {

		Project project = manager.find(Project.class, projectID);

		if (project != null) {
			manager.remove(project);
			return true;
		}

		throw new ProjectIDNotFoundException(
				IExceptionMessages.PROJECTID_EXCEPTION);

	}
}