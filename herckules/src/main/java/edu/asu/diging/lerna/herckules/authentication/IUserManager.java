package edu.asu.diging.lerna.herckules.authentication;

import java.util.List;

import edu.asu.diging.lerna.herckules.authentication.impl.User;

public interface IUserManager {

	public abstract void saveUser(IUser user);

	public abstract User getUserById(String userId);

	public abstract List<User> getAllUsers();

	public abstract boolean deleteUser(String username);

}