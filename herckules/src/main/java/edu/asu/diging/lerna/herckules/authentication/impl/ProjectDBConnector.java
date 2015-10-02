package edu.asu.diging.lerna.herckules.authentication.impl;

import java.io.File;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;

@Component
@PropertySource(value = "classpath:/db.properties" )
public class ProjectDBConnector {
	@Autowired
	private Environment env;
	private String dbPath;
	
	@PostConstruct
	public void init(){
		
		String projFolder = env.getProperty("db.path");
		if(!projFolder.endsWith(File.separator)){
			projFolder = projFolder + File.separator;		
		}
		dbPath = projFolder + env.getProperty("db.proj.name");		
	}
	
	public void retrieveProject(){
		
	}
	
	public void addProject(){
		
	}
	
	public void updateProject(){
		
	}
	
	public void deleteProject(){
		
	}
	
	




}
