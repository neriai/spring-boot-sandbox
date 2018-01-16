package com.sandbox.repository;

import java.util.List;

import com.sandbox.entity.User;

public interface UserExtensionsRepository {
    public List<User> findUsers(String userName, String groupName);
    public boolean updateUser(Integer userId, String userName);
}