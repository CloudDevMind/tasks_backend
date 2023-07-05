package com.clouddevmind.Tasksproject.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clouddevmind.Tasksproject.domain.User;
import com.clouddevmind.Tasksproject.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Returns all users using the UserService method getAll()
     * @return ArrayList<User>
     */
    @GetMapping("/all")
    public ArrayList<User> getAll(){
        return this.userService.list();
    }

    /**
     * Stores a given user in the database
     * @param User user to store
     * @return
     */
    @PostMapping("/new")
    public User saveUser(@RequestBody User user){
        return this.userService.save(user);
    }
}
