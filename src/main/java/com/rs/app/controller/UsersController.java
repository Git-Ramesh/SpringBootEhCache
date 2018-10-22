package com.rs.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.app.model.Users;
import com.rs.app.service.UsersService;

/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-20
 */
@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;

	@PostMapping("/register")
	private ResponseEntity<Users> registerUsers(@RequestBody Users users) {
		return ResponseEntity.ok(this.usersService.addUser(users));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Users> getUser(@PathVariable("id") long id) {
		return ResponseEntity.ok(this.usersService.getUser(id));
	}

	@PutMapping("/update")
	public ResponseEntity<Users> updateUser(@RequestBody Users users) {
		return ResponseEntity.ok(this.usersService.updateUsers(users));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsers(@PathVariable("id") long id) {
		this.usersService.deleteUsers(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/all")
	public List<Users> allUsers() {
		return this.usersService.getAllUsers();
	}
}
