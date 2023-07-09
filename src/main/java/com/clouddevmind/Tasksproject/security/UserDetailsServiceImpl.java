package com.clouddevmind.Tasksproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clouddevmind.Tasksproject.domain.User;
import com.clouddevmind.Tasksproject.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserService userService;

    /**
     * Checks if a user exists in the database given its userName
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService
                .findOneByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("The userName property was not found in the database"));

        return new UserDetailsImpl(user);
    }
    
}
