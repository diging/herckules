package edu.asu.diging.lerna.herckules.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.asu.diging.lerna.herckules.authentication.HerckulesGrantedAuthority;
import edu.asu.diging.lerna.herckules.authentication.IUser;
import edu.asu.diging.lerna.herckules.authentication.IUserManager;
import edu.asu.diging.lerna.herckules.authentication.impl.User;

@Controller
public class TestController {

	@Autowired
	private IUserManager userManager;
	
	@RequestMapping(value = "test")
	public @ResponseBody String testUser() throws JsonGenerationException, JsonMappingException, IOException {
		IUser user = new User();
		user.setUsername("test2");
		user.setPassword("xxx");
		user.setName("Test");
		user.setAuthorities(new ArrayList<HerckulesGrantedAuthority>());
		user.getAuthorities().add(new HerckulesGrantedAuthority("ADMIN"));
		
		userManager.saveUser(user);
		List<User> users = userManager.getAllUsers();
		
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(users);
	}
}
