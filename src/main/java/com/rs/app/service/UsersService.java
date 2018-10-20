/**
 * 
 */
package com.rs.app.service;

import java.util.List;

import com.rs.app.model.Users;

/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-20
 */
public interface UsersService {
	Users addUser(Users users);

	Users getUser(long id);

	Users updateUsers(Users users);

	void deleteUsers(long id);

	List<Users> getAllUsers();
}
