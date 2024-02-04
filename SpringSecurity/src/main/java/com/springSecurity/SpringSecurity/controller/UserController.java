package com.springSecurity.SpringSecurity.controller;

import com.springSecurity.SpringSecurity.entity.User;
import com.springSecurity.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        final User userDetails = this.userService.createUser(user);
        return ResponseEntity.ok(userDetails);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<User> getSingleUser(@PathVariable("email") final String email){
        final User user = this.userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        final List<User> userList = this.userService.getAllUser();
        return ResponseEntity.ok(userList);
    }
}
