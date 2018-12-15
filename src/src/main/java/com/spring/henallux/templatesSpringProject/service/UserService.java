package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.templatesSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User save(User user) {
        return this.userDAO.save(user);
    }

    public User findByUsername(String username) {
        return this.userDAO.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return this.userDAO.existsByUsername(username);
    }
}
