package com.sandbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandbox.entity.User;
import com.sandbox.repository.UserRepository;
import com.sandbox.repository.UserExtensionsRepository;

@Service
public class UserService {
   
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserExtensionsRepository repositoryExtension;
   
    public List<User> findUsers(String userName, String groupName) {
        List<User> result;
    
        if ("".equals(userName) && "".equals(groupName)) {
            result = repository.findAll();
        } else {
            result = repositoryExtension.findUsers(userName, groupName);
        }
        
        return result;
    }
    
    public User findByUser(Integer userId) {
        return repository.findByUserId(userId);
    }
    
    public boolean updateUser(Integer userId, String userName) {
        return repositoryExtension.updateUser(userId, userName);
    }
}