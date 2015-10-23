package edu.asu.diging.lerna.herckules.db.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.diging.lerna.herckules.db.IProjectDBConnector;
import edu.asu.diging.lerna.herckules.domain.impl.Project;

/**
 * Description of ProjectDBConnector class This class helps retrieve, add,
 * update, delete project from an ObjectDB database.
 * 
 * @author Vineel Vutukuri
 * @author Tamalika Mukherjee
 * 
 */

@Component
@Transactional
public class ProjectDBConnector implements IProjectDBConnector {

	@PersistenceContext
	protected EntityManager manager;

	/**
	 * Retrieves project by searching through the creator attribute from the
	 * database.
	 * 
	 * @param Project
	 */
	@Transactional
	public Project retrieveProject(Project p) {
		TypedQuery<Project> query = manager.createQuery(
				"SELECT p FROM Project p WHERE p.creator == :creator",
				Project.class);
		p = query.setParameter("creator", p.getCreator()).getSingleResult();
		return p;
	}

	@Transactional
	public boolean addProject(Project p) {

		/**
		 * Adds the project to the database.
		 * 
		 * @param Project
		 */

		manager.persist(p);
		return true;
	}

	@Transactional
	public boolean updateProject(Project p) {
		/**
		 * Updates all the attributes of the project.
		 * 
		 * @param Project
		 */
		Project proj = manager.find(Project.class, p.getProjectid());
		proj.setCreator(p.getCreator());
		proj.setProjectAdmins(p.getProjectAdmins());
		proj.setDescription(p.getDescription());
		proj.setProjectName(p.getProjectName());
		proj.setSchema(p.getSchema());
		proj.setIolausDetails(p.getIolausDetails());
		proj.setDataset(p.getDataset());
		proj.setDatabaseList(p.getDatabaseList());
		return true;
	}

	@Transactional
	public boolean deleteProject(String projectid) throws Exception {
		/**
		 * @throws NullPointerException
		 *             If project with specified project id is missing.
		 * 
		 * @param projectid
		 */

		Project proj = manager.find(Project.class, projectid);
		boolean flag = false;
		try {
			manager.remove(proj);
			flag = true;
		} catch (NullPointerException e) {
			flag = false;
		}
		return flag;
	}

}