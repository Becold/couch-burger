package com.spring.henallux.templatesSpringProject.dataAccess.repository;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUsername(String userName);
    boolean existsByUsername(String username);
}
