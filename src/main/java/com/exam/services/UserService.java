package com.exam.services;

import java.util.List;
import java.util.Set;

import com.exam.model.Role;
import com.exam.model.User;

public interface UserService {
    public User createUser(User user) throws Exception;
    public User getUser(String uname);
    public User getUserById(Long userId);
    public void deleteUser(Long userId);
    List<User> getAllUser();
}
