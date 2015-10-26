package edu.asu.diging.lerna.herckules.authentication.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.asu.diging.lerna.herckules.domain.impl.Project;
import edu.asu.diging.lerna.herckules.authentication.impl.ProjectDBConnector;


@Service
public  class projectManager implements IprojectManager{
	@Autowired
	ProjectDBConnector proj=new ProjectDBConnector();

	
	@Override
	public boolean deleteProject(String projectid) throws Exception {
		if(projectid==null||projectid.equals("")){
			throw new NullPointerException("NULL POINTER EXCEPTION");
		}		
		return proj.deleteProject(projectid);
	}


	@Override
	public Project retrieveProject(Project p) throws Exception {
		if(p.getProjectid()==null||p.getProjectid().equals("")){
			throw new NullPointerException("NULL POINTER EXCEPTION");
		}
		return proj.retrieveProject(p);
				  
	}

	@Override
	public boolean addProject(Project p) throws Exception {
		if(p.getProjectid()==null||p.getProjectid().equals("")||p.getProjectName() == null || p.getProjectName().trim().equals("")){
			throw new NullPointerException("NULL POINTER EXCEPTION");
		}
		return proj.addProject(p);
	}

	@Override
	public boolean updateProject(Project p) throws Exception {
		if(p.getProjectid()==null||p.getProjectid().equals("")){
			throw new NullPointerException("NULL POINTER EXCEPTION");
		}
		return proj.updateProject(p);
	}
} 