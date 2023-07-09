package com.clouddevmind.Tasksproject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clouddevmind.Tasksproject.domain.User;

@Repository
public interface UserDao extends CrudRepository<User, Long>{
    
    /**
     * Finds a User using given property userName
     * @param userName
     * @return User
     */
    public abstract User findByUserName(String userName);
}
