package com.spring.henallux.templatesSpringProject.dataAccess.util;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.templatesSpringProject.model.User;

public class ProviderConverter {

    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
//        userEntity.setAge(user.getAge());
//        userEntity.setHobby(user.getHobby());
//        userEntity.setMale(user.getMale());
//        userEntity.setName(user.getName());
        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity) {
        User user = new User();
//        user.setAge(userEntity.getAge());
//        user.setHobby(userEntity.getHobby());
//        user.setMale(userEntity.getMale());
//        user.setName(userEntity.getName());
        return user;
    }
}
