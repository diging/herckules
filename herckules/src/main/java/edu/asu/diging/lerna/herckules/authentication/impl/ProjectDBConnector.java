package edu.asu.diging.lerna.herckules.authentication.impl;
import java.io.File;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.asu.diging.lerna.herckules.authentication.IProjectDBConnector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;

import com.objectdb.Utilities;

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
		p = query.setParameter("creator", p.getCreator()).getSingleResult();
		manager.getTransaction().commit();
		manager.close();
		return p;		
	}

	public boolean addProject(Project p) {
		EntityManager manager = Utilities.getEntityManager(dbPath);
		manager.getTransaction().begin();
		manager.persist(p);
		manager.getTransaction().commit();
		manager.close();
		return true;
	}

	public boolean updateProject(Project p) {
		EntityManager manager = Utilities.getEntityManager(dbPath);
		manager.getTransaction().begin();
		Project proj = manager.find(Project.class, p.getProjectid());
		proj.setCreator(p.getCreator());
		proj.setProjectAdmins(p.getProjectAdmins());
		proj.setDescription(p.getDescription());
		proj.setProjectName(p.getProjectName());
		proj.setSchema(p.getSchema());
		proj.setIolausDetails(p.getIolausDetails());
		proj.setDataset(p.getDataset());
		proj.setDatabaseList(p.getDatabaseList());
		manager.getTransaction().commit();
		manager.close();
		return true;				
	}

	public boolean deleteProject(String projectid) throws Exception {
		EntityManager manager = Utilities.getEntityManager(dbPath);
		manager.getTransaction().begin();
		Project proj = manager.find(Project.class, projectid);
		boolean flag = false;
		try{
			manager.remove(proj);
			flag = true;
		}
		catch (Exception e){
			flag = false;
		}
		manager.getTransaction().commit();
		manager.close();
		return flag;

	}

}