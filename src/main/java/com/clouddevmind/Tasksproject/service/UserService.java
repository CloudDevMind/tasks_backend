package com.clouddevmind.Tasksproject.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clouddevmind.Tasksproject.dao.UserDao;
import com.clouddevmind.Tasksproject.domain.User;

@Service
public class UserService {

    @Autowired
    protected UserDao userDao;

    /**
     * Returns all resources from the given model
     * @return ArrayList<User>
     */
    public ArrayList<User> list(){
        //You have to cast the returned object to be an ArrayList class's instance
        return (ArrayList<User>) this.userDao.findAll();
    }


    /**
     * Saves a given user in the database
     * @param User user to store
     * @return user
     */
    public User save(User user){
        return this.userDao.save(user);
    }

    /**
     * Finds a User using given property userName
     * @param userName
     * @return User
     */
    public Optional<User> findOneByUsername(String username){
        return this.userDao.findOneByUserName(username);
    }

    /**
     * Finds a User using given property email
     * @param email
     * @return User
     */
    public Optional<User> findOneByEmail(String email){
        return this.userDao.findOneByEmail(email);
    }
}
