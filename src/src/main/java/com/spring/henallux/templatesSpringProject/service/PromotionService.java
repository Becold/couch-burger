package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.dataAccess.dao.PromotionDAO;
import com.spring.henallux.templatesSpringProject.dataAccess.entity.PromotionEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PromotionService {

    private PromotionDAO promotionDAO;

    @Autowired
    public PromotionService(PromotionDAO promotionDAO) {
        this.promotionDAO = promotionDAO;
    }

    public ArrayList<Promotion> findByProductProductId(Integer productId) {
        return this.promotionDAO.findByProductProductId(productId);
    }

    public ArrayList<Promotion> findCurrentPromotions(GregorianCalendar currentDate, Integer productId, Integer categoryId) {
        return this.promotionDAO.findCurrentPromotions(currentDate, productId, categoryId);
    }

    public ArrayList<Promotion> findCurrentPromotions(GregorianCalendar currentDate) {
        return this.promotionDAO.findCurrentPromotions(currentDate);
    }
}
