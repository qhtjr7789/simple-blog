package com.example.blog.controller;

import com.example.blog.service.UserService;
import com.example.blog.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    //UserService service = new UserService();
    @Autowired
    UserService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable("id") int id) {
        return service.findOne(id);

    }

    // save
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();


        return ResponseEntity.created(location).build();


    }

    // Delete
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        User deletedUser = service.deleteUseById(id);
        if (deletedUser ==null){
            throw new RuntimeException("id -"+ id );
        }

    }
}
