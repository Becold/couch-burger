package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.dataAccess.dao.PromotionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {

    private PromotionDAO promotionDAO;

    @Autowired
    public PromotionService(PromotionDAO promotionDAO) {
        this.promotionDAO = promotionDAO;
    }

}
