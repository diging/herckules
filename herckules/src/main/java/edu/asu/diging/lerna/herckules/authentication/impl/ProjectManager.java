package edu.asu.diging.lerna.herckules.authentication.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.asu.diging.lerna.herckules.db.impl.ProjectDBConnector;
import edu.asu.diging.lerna.herckules.domain.IProject;
import edu.asu.diging.lerna.herkules.exception.HerckulesException;
import edu.asu.diging.lerna.herkules.exception.HerckulesStorageException;


public class ProjectManager implements IProjectManager{
	
	@Autowired
	IDBManagerProject dbManager;
	
	@Autowired
	IDBManagerDatabase dbManagerDatabase;
	
	public void addProject(IProject project)throws HerckulesStorageException, HerckulesException{
		if(project==null || project.getProjectIdentifier() == null || 
				project.getProjectIdentifier().trim().equals("") ||
				project.getProjectName().trim().equals(""))
			throw new HerckulesException(IExceptionMessages.OPERATION_EXCEPTION);
		//ProjectDBConnector.addProject(project);
		
	}
	
}
