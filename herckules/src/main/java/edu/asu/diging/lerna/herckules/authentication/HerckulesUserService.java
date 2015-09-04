package edu.asu.diging.lerna.herckules.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *  Customized {@link UserDetailsService} class to get user details and 
 * authenticate it based on the {@link User} and encoded Password
 * @author : Lohith Dwaraka 
 *
 */
@Service(value = "herckulesUserService")
public class HerckulesUserService implements UserDetailsService{

	@Autowired
	private IUserManager dbManagerUser;
	
	/**
	 *  Customized loadUser method for our project
	 * {@inheritDoc}
	 */
	@Override
	public synchronized UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// get user object from DB
		
		UserDetails matchingUser = (UserDetails) dbManagerUser.getUserById(username);
		
		
		// Check if the object matches
		if (matchingUser == null) {
			throw new UsernameNotFoundException("Wrong username or password");
		}

		return matchingUser;
	}
}
