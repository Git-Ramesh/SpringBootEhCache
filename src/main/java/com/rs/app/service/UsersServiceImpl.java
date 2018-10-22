package com.rs.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rs.app.model.Users;
import com.rs.app.repository.UsersRepo;

/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-20
 */
@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersRepo usersRepo;

	@Override
	@CachePut(value = "usersCache", key = "#result.id")
	public Users addUser(Users users) {
		System.out.println(users);
		return this.usersRepo.save(users);
	}

	@Override
	@Cacheable(value = "usersCache", key = "#id", unless = "#result == null")
	public Users getUser(long id) {
		return this.usersRepo.getOne(id);
	}

	@Override
	@CachePut(value = "usersCache", key = "#result.id")
	public Users updateUsers(Users users) {
		Optional<Users> optional = this.usersRepo.findById(users.getId());
		optional.ifPresent(usrs -> {
			BeanUtils.copyProperties(users, usrs);
			this.usersRepo.save(usrs);
		});
		return users;
	}

	@Override
	@CacheEvict(value = "usersCache", key = "#id")
	public void deleteUsers(long id) {
		this.usersRepo.deleteById(id);
	}

	@Override
	@Cacheable(value = "usersCache", key = "#root.method.name")
	public List<Users> getAllUsers() {
		return this.usersRepo.findAll();
	}

}
