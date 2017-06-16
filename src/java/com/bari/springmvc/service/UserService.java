package com.bari.springmvc.service;

import com.bari.springmvc.model.User;
import java.util.List;

public interface UserService {
    
    public void addUser(User user);

    public void updateUser(User user);

    public List<User> listUser();

    public User getUserById(Integer Id);

    public void removeUser(Integer Id);
    
    public User loginUsers(User user);
    
}
