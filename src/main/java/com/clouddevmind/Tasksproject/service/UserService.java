package com.clouddevmind.Tasksproject.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.clouddevmind.Tasksproject.dao.UserDao;
import com.clouddevmind.Tasksproject.domain.User;

@Service
public class UserService {

    @Autowired
    protected UserDao userDao;
    
    //Encoder to save an encoded password
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Returns all resources from the given model
     * @return ArrayList<User>
     */
    public ArrayList<User> list(){
        //You have to cast the returned object to be an ArrayList class's instance
        return (ArrayList<User>) this.userDao.findAll();
    }


    /**
     * Saves a given user in the database. It also encrypts the password
     * @param User user to store
     * @return user
     */
    public User save(User user){
        user.setPassword(this.encoder.encode(user.getPassword()));
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
