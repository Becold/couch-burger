package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.templatesSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDAO {

    private UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        UserEntity userEntity = new ProviderConverter().userModelToUserEntity(user);
        UserEntity newUser = this.userRepository.save(userEntity);
        return new ProviderConverter().userEntityToUserModel(newUser);
    }

    public User findByUsername(String username) {
        UserEntity userEntity = this.userRepository.findByUsername(username);
        User user = new ProviderConverter().userEntityToUserModel(userEntity);
        return user;
    }

    public boolean existsByUsername(String username) {
        return this.userRepository.existsByUsername(username);
    }
}
