package com.sandbox.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import com.sandbox.repository.UserExtensionsRepository;
import com.sandbox.entity.User;

@Component
public class UserExtensionsImplementsRepository implements UserExtensionsRepository {

    @Autowired
    EntityManager manager;

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findUsers(String userName, String groupName) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT u FROM User u");
        Query query = null;
       
        if (!"".equals(userName) && userName != null) {
            sql.append(" WHERE u.userName LIKE :userName");
            query = manager.createQuery(sql.toString());
            query.setParameter("userName", "%" + userName + "%");
        } else if (!"".equals(groupName) && groupName != null) {
            sql.append(" WHERE u.group.groupName LIKE :groupName");
            query = manager.createQuery(sql.toString());
            query.setParameter("groupName", "%" + groupName + "%");
        } else {
            query = manager.createQuery(sql.toString());
        }

        return query.getResultList();
    }
    
    @Modifying
    @Transactional
    public boolean updateUser(Integer userId, String userName) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE User u set u.userName = :userName WHERE u.userId = :userId");
       
        Query query = manager.createQuery(sql.toString());
        query.setParameter("userName", userName);
        query.setParameter("userId", userId);
        query.executeUpdate();
        
        return true;
    }
}
