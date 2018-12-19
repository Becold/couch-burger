package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.dataAccess.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionDAO {

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionDAO(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }
}
