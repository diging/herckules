package edu.asu.diging.lerna.herckules.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.asu.diging.lerna.herckules.authentication.IUser;
import edu.asu.diging.lerna.herckules.authentication.IUserManager;
import edu.asu.diging.lerna.herckules.db.IProjectManager;
import edu.asu.diging.lerna.herckules.domain.IProject;
import edu.asu.diging.lerna.herckules.domain.impl.Project;

@Controller
public class ProjectController {
	
	@Autowired
	private IUserManager userManager;

	@RequestMapping(value = "auth/projects")
	public @ResponseBody List<IProject> getProjects(Principal principal) {
		List<IProject> projects = new ArrayList<IProject>();
		IProject proj = new Project();
		IUser user = userManager.getUserById(principal.getName());
		proj.setDescription("This is a description");
		proj.setCreator(user);
		proj.setProjectid("PROJ1");
		proj.setProjectName("Project Nr. One");
		projects.add(proj);
		
		proj = new Project();
		proj.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
		proj.setCreator(user);
		proj.setProjectid("PROJ2");
		proj.setProjectName("Project Nr. Lorem");
		projects.add(proj);		
		return projects;
	}

	@RequestMapping(value = "/retriveProject", method = RequestMethod.GET)
		public String retrieveProject() {
			return "retrieveProject";
		}
	
}
