/**
 * 
 */
package com.rs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.app.model.Users;

/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-20
 */
public interface UsersRepo extends JpaRepository<Users, Long> {
	
}
