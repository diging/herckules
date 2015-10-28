package edu.asu.diging.lerna.herckules.db.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.diging.lerna.herckules.db.IProjectDBConnector;
import edu.asu.diging.lerna.herckules.domain.impl.Project;
import edu.asu.diging.lerna.herkules.exception.*;

/**
 * Description of ProjectDBConnector class This class helps retrieve, add,
 * update, delete project from an ObjectDB database.
 * 
 * @author Tamalika Mukherjee
 * @author Vineel Vutukuri
 * 
 */

@Component
@Transactional
public class ProjectDBConnector implements IProjectDBConnector {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public Project retrieveProject(Project project) {
		/**
		 * Retrieves project by searching through the creator attribute from the
		 * database.
		 * 
		 * @param Project
		 */
		TypedQuery<Project> query = manager
				.createQuery(
						"SELECT project FROM Project project WHERE project.creator == :creator",
						Project.class);
		project = query.setParameter("creator", project.getCreator())
				.getSingleResult();
		return project;
	}

	@Transactional
	public boolean addProject(Project project) {
		/**
		 * Adds the project to the database.
		 * 
		 * @param Project
		 */
		manager.persist(project);
		return true;
	}

	@Transactional
	public boolean updateProject(Project project) {
		/**
		 * Updates all the attributes of the project.
		 * 
		 * @param Project
		 */
		Project proj = manager.find(Project.class, project.getProjectid());
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

	@Transactional
	public boolean deleteProject(String projectID)
			throws ProjectNotFoundException {
		/**
		 * Removes the project with the specified projectID.
		 * 
		 * @param projectID
		 */

		Project project = manager.find(Project.class, projectID);

		if (project != null) {
			manager.remove(project);
			return true;
		}

		throw new ProjectNotFoundException(
				"Project with the specified Id does not exist.");

	}
}