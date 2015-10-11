package edu.asu.diging.lerna.herckules.authentication.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.objectdb.Utilities;
import edu.asu.diging.lerna.herckules.authentication.HerckulesGrantedAuthority;
import edu.asu.diging.lerna.herckules.authentication.IUser;
import edu.asu.diging.lerna.herckules.authentication.IUserManager;
@Component
@PropertySource(value = "classpath:/db.properties")
public class UserManager implements IUserManager {
	@Autowired
	private Environment env;
	private String dbpath;
	
	@PostConstruct
	public void init() {
		String dbfolder = env.getProperty("db.path");
		if (!dbfolder.endsWith(File.separator))
			dbfolder = dbfolder + File.separator;
		dbpath = dbfolder + env.getProperty("db.name");
	}
	
	/* (non-Javadoc)
	 * @see edu.asu.diging.lerna.herckules.authentication.impl.IUserManager#saveUser(edu.asu.diging.lerna.herckules.authentication.IUser)
	 */
	@Override
	public void saveUser(IUser user) {
		EntityManager manager = Utilities.getEntityManager(dbpath);
		manager.getTransaction().begin();
		TypedQuery<PersistentUser> q = manager.createQuery("SELECT p FROM PersistentUser p WHERE p.username == '" + user.getUsername() + "'", PersistentUser.class);
		List<PersistentUser> users = q.getResultList();
		PersistentUser obj;
		if (users == null || users.isEmpty()) {
			obj = new PersistentUser();
			obj.setUsername(user.getUsername());
			manager.persist(obj);
		}
		else
			obj = users.iterator().next();
		
		List<String> roles = new ArrayList<String>();
		for (HerckulesGrantedAuthority authority : user.getAuthorities()) {
			roles.add(authority.getAuthority());
		}
		
		((PersistentUser) obj).setAuthorities(roles);
		((PersistentUser) obj).setEmail(user.getEmail());
		((PersistentUser) obj).setName(user.getName());
		((PersistentUser) obj).setPassword(user.getPassword());
		
		manager.getTransaction().commit();
		manager.close();
	}

	/* (non-Javadoc)
	 * @see edu.asu.diging.lerna.herckules.authentication.impl.IUserManager#getUserById(java.lang.String)
	 */
	@Override
	public User getUserById(String userId) {
		EntityManager manager = Utilities.getEntityManager(dbpath);
		manager.getTransaction().begin();
		try {
			PersistentUser perUser = manager.find(PersistentUser.class, userId);
			if (perUser == null)
				return null;
			
			User user = createUser(perUser);
			return user;
		} finally {
			manager.getTransaction().commit();
			manager.close();
		}
		
	}

	private User createUser(PersistentUser persUser) {
		User user = new User();
		List<HerckulesGrantedAuthority> authorities = new ArrayList<HerckulesGrantedAuthority>();
		for (String role : persUser.getAuthorities()) {
			authorities.add(new HerckulesGrantedAuthority(role));
		}
		user.setAuthorities(authorities);
		user.setEmail(persUser.getEmail());
		user.setName(persUser.getName());
		user.setPassword(persUser.getPassword());
		user.setUsername(persUser.getUsername());
		return user;
	}

	/* (non-Javadoc)
	 * @see edu.asu.diging.lerna.herckules.authentication.impl.IUserManager#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {
		EntityManager manager = Utilities.getEntityManager(dbpath);
		manager.getTransaction().begin();
		List<User> allUsers = new ArrayList<User>();
		TypedQuery<PersistentUser> query =
				    manager.createQuery("SELECT p FROM PersistentUser p", PersistentUser.class);
		List<PersistentUser> users = query.getResultList();
		
		for (PersistentUser user : users) {
			allUsers.add(createUser(user));
		}
		manager.getTransaction().commit();
		manager.close();
		return allUsers;
	}

	/* (non-Javadoc)
	 * @see edu.asu.diging.lerna.herckules.authentication.impl.IUserManager#deleteUser(java.lang.String)
	 */
	@Override
	public boolean deleteUser(String username) {
		EntityManager manager = Utilities.getEntityManager(dbpath);
		manager.getTransaction().begin();
		PersistentUser perUser = manager.find(PersistentUser.class, username);
		
		boolean success = true;
		if (perUser != null) {
			manager.remove(perUser);
		}
		else {
			success = false;
		}
		manager.getTransaction().commit();
		manager.close();
		return success;		
	}
}
