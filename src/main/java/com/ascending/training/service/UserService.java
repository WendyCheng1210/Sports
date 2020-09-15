package com.ascending.training.service;

import com.ascending.training.model.Role;
import com.ascending.training.model.Team;
import com.ascending.training.model.User;
import com.ascending.training.repository.RoleDao;
import com.ascending.training.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User save(User user){return userDao.save(user);}

    public User getUserByEmail(String email){return userDao.getUserByEmail(email);}

    public User getUserByCredentials(String email, String password){
        return userDao.getUserByCredentials(email,password);
    }

    public User findByID(Long Id){return userDao.findByID(Id);}

    public List<User> getAllUsers(){
        List<User> userList = userDao.findAllUsers();
        return userList;
    }
}
