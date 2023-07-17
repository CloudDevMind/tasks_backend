package com.clouddevmind.Tasksproject.dao;

import java.util.Optional;

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
    Optional<User> findOneByUserName(String userName);

    /**
     * Finds a User using given property userName
     * @param userName
     * @return User
     */
    Optional<User> findOneByEmail(String email);
}
