package edu.asu.diging.lerna.herckules.authentication.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.asu.diging.lerna.herckules.authentication.HerckulesGrantedAuthority;
import edu.asu.diging.lerna.herckules.authentication.IProjectDBConnector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;

import com.objectdb.Utilities;

import edu.asu.diging.lerna.herckules.domain.IProject;
import edu.asu.diging.lerna.herckules.domain.impl.Project;

@Component
@PropertySource(value = "classpath:/db.properties")
public class ProjectDBConnector implements IProjectDBConnector {
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

	public Project retrieveProject(Project p) {
		EntityManager manager = Utilities.getEntityManager(dbPath);
		manager.getTransaction().begin();
		TypedQuery<Project> query = manager.createQuery(
				"SELECT p FROM Project p WHERE p.creator == :creator",
				Project.class);		
		manager.getTransaction().commit();
		manager.close();
		return query.setParameter("creator", p.getCreator()).getSingleResult();
	}

	public boolean addProject(Project p) {

		// Remove The Check
		EntityManager manager = Utilities.getEntityManager(dbPath);
		manager.getTransaction().begin();
		Project obj;
		boolean flag = false;
		obj = p;
		manager.persist(obj);
		flag = true;
		manager.getTransaction().commit();
		manager.close();
		return flag;
	}

	public boolean updateProject(Project p) {
		
		return deleteProject(p.getProjectid()) && addProject(p);
		
	}

	// Use the manager class delete functionality
	public boolean deleteProject(String projectid) {
		EntityManager manager = Utilities.getEntityManager(dbPath);
		manager.getTransaction().begin();
		Project p1 = manager.find(Project.class, projectid);
		boolean flag = false;
		if (p1 !=null) {
			manager.remove(p1);
			flag = true;
		}
		else{
			flag = false;
		}
		manager.getTransaction().commit();
		manager.close();
		return flag;

	}

}