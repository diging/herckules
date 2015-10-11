package edu.asu.diging.lerna.herckules.authentication.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.asu.diging.lerna.herckules.authentication.HerckulesGrantedAuthority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;

import com.objectdb.Utilities;

import edu.asu.diging.lerna.herckules.domain.IProject;
import edu.asu.diging.lerna.herckules.domain.impl.Project;

@Component
@PropertySource(value = "classpath:/db.properties")
public class ProjectDBConnector {
	@Autowired
	private Environment env;
	private String dbPath;

	@PostConstruct
	public void init() {
		String projFolder = env.getProperty("db.path");
		if (!projFolder.endsWith(File.separator)) {
			projFolder = projFolder + File.separator;
		}
		dbPath = projFolder + env.getProperty("db.proj.name");
	}
	/*
	 * public List<Project> retrieveAllProjects(String projectid){ EntityManager
	 * manager = Utilities.getEntityManager("dbPath");
	 * manager.getTransaction().begin();
	 * 
	 * List<Project> allProjects = new ArrayList<Project>(); TypedQuery<Project>
	 * query = manager.createQuery("SELECT p FROM Project p", Project.class);
	 * List<Project> projects = query.getResultList(); for (Project proj :
	 * projects) { allProjects.add(addProject(proj)); }
	 * manager.getTransaction().commit(); manager.close(); return allProjects;
	 * //go through user admins, put in correct list }
	 */

	public List<Project> retrieveProject(IProject p) {

		EntityManager manager = Utilities.getEntityManager(dbPath);
		manager.getTransaction().begin();
		List<Project> allProjects = new ArrayList<Project>();
		TypedQuery<Project> query = manager.createQuery(
				"SELECT p FROM Project p WHERE p.creator == '" + p.getCreator()
						+ "'", Project.class);
		// List<Project> projects = query.getResultList();
		// for(Project d : projects ){
		// System.out.println(d);
		// }
		manager.getTransaction().commit();
		manager.close();

		return allProjects;
	}

	public boolean addProject(Project p) {

		// detect user;put in list; cascade=all
		EntityManager manager = Utilities.getEntityManager(dbPath);
		manager.getTransaction().begin();
		TypedQuery<Project> query = manager.createQuery(
				"SELECT p FROM Project p WHERE p.getProjectName == '"
						+ p.getProjectName() + "'", Project.class);
		List<Project> projects = query.getResultList();
		Project obj;
		boolean flag = false;
		if (projects == null || projects.isEmpty()) {
			obj = p;
			manager.persist(obj);
			flag = true;
		} else {
			System.out.println("Project with same name exists....");
		}
		// for(Project d : projects ){
		// System.out.println(d);
		// }
		manager.getTransaction().commit();
		manager.close();
		return flag;
	}

	public void updateProject(Project p) {
		

	}

	public boolean deleteProject(Project p) {
		EntityManager manager = Utilities.getEntityManager(dbPath);
		manager.getTransaction().begin();
		int query = manager.createQuery(
				"DELETE FROM Project p WHERE p.getProjectName == '"
						+ p.getProjectName() + "'", Project.class)
				.executeUpdate();
		boolean flag = false;
		if (query >= 0) {
			flag = true;
		}
		manager.getTransaction().commit();
		manager.close();

		return flag;

	}

}