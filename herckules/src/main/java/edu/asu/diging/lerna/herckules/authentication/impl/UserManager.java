package edu.asu.diging.lerna.herckules.authentication.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.diging.lerna.herckules.authentication.HerckulesGrantedAuthority;
import edu.asu.diging.lerna.herckules.authentication.IUser;
import edu.asu.diging.lerna.herckules.authentication.IUserManager;

@Component
@Transactional
public class UserManager implements IUserManager {

	@PersistenceContext
	protected EntityManager manager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.asu.diging.lerna.herckules.authentication.impl.IUserManager#saveUser
	 * (edu.asu.diging.lerna.herckules.authentication.IUser)
	 */
	@Transactional
	@Override
	public void saveUser(IUser user) {
		TypedQuery<PersistentUser> q = manager.createQuery(
				"SELECT p FROM PersistentUser p WHERE p.username == '"
						+ user.getUsername() + "'", PersistentUser.class);
		List<PersistentUser> users = q.getResultList();
		PersistentUser obj;
		if (users == null || users.isEmpty()) {
			obj = new PersistentUser();
			obj.setUsername(user.getUsername());
			manager.persist(obj);
		} else
			obj = users.iterator().next();

		List<String> roles = new ArrayList<String>();
		for (HerckulesGrantedAuthority authority : user.getAuthorities()) {
			roles.add(authority.getAuthority());
		}

		((PersistentUser) obj).setAuthorities(roles);
		((PersistentUser) obj).setEmail(user.getEmail());
		((PersistentUser) obj).setName(user.getName());
		((PersistentUser) obj).setPassword(user.getPassword());
		manager.merge(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.asu.diging.lerna.herckules.authentication.impl.IUserManager#getUserById
	 * (java.lang.String)
	 */
	@Override
	@Transactional
	public User getUserById(String userId) {
		PersistentUser perUser = manager.find(PersistentUser.class, userId);
		if (perUser == null)
			return null;

		User user = createUser(perUser);
		return user;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.asu.diging.lerna.herckules.authentication.impl.IUserManager#getAllUsers
	 * ()
	 */
	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<User>();
		TypedQuery<PersistentUser> query = manager.createQuery(
				"SELECT p FROM PersistentUser p", PersistentUser.class);
		List<PersistentUser> users = query.getResultList();

		for (PersistentUser user : users) {
			allUsers.add(createUser(user));
		}
		return allUsers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.asu.diging.lerna.herckules.authentication.impl.IUserManager#deleteUser
	 * (java.lang.String)
	 */
	@Override
	public boolean deleteUser(String username) {
		PersistentUser perUser = manager.find(PersistentUser.class, username);

		if (perUser != null) {
			manager.remove(perUser);
			return true;
		} 
		return false;
	}
}
