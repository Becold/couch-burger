package com.spring.henallux.templatesSpringProject.dataAccess.repository;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer> {
    ArrayList<PromotionEntity> findByProductProductId(Integer productId);
    ArrayList<PromotionEntity> findByStartDateBeforeAndEndDateAfterAndProductProductIdOrStartDateBeforeAndEndDateAfterAndCategoryCategoryId(Date startDateProduct, Date endDateProduct, Integer productId, Date startDateCategory, Date endDateCategory, Integer categoryId);
}
