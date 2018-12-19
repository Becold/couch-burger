package com.spring.henallux.templatesSpringProject.dataAccess.repository;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer> {
}
