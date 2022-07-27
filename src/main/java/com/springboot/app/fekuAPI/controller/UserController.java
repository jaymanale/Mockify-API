package com.springboot.app.fekuAPI.controller;

import com.springboot.app.fekuAPI.model.User;
import com.springboot.app.fekuAPI.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Save User
    // POST : http://localhost:8080/api/v1/users
    @PostMapping()
    public ResponseEntity<User> saveUsers(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    // Get all USers
    // GET : http://localhost:8080/api/v1/users
    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    // Get User by ID
    // GET : http://localhost:8080/api/v1/users/1
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    // Update User by ID
    // PUT : http://localhost:8080/api/v1/users/1
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }

    // Delete User by ID
    // DELETE : http://localhost:8080/api/v1/users/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(String.format("Employee with ID : %s deleted successfully.", id), HttpStatus.OK);
    }
}
