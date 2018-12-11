package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.model.User;

public interface IUserDAO {
    User save(User user);
    User findByUsername(String username);
    boolean existsByUsername(String username);
}
