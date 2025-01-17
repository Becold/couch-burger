package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.PromotionEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.repository.PromotionRepository;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.templatesSpringProject.model.Promotion;
import com.spring.henallux.templatesSpringProject.util.DateProviderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PromotionDAO {

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionDAO(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public ArrayList<Promotion> findByProductProductId(Integer productId) {
        ArrayList<Promotion> promotions = new ArrayList<>();
        ArrayList<PromotionEntity> promotionEntities = this.promotionRepository.findByProductProductId(productId);
        for (PromotionEntity promotionEntity : promotionEntities) {
            promotions.add(new ProviderConverter().promotionEntityToPromotionModel(promotionEntity));
        }
        return promotions;
    }

    public ArrayList<Promotion> findCurrentPromotions(GregorianCalendar currentDate, Integer productId, Integer categoryId) {
        Date currentDateDate = DateProviderConverter.gregorianCalendarToSqlDate(currentDate);
        ArrayList<Promotion> promotions = new ArrayList<>();
        ArrayList<PromotionEntity> promotionEntities = this.promotionRepository.findByStartDateBeforeAndEndDateAfterAndProductProductIdOrStartDateBeforeAndEndDateAfterAndCategoryCategoryId(currentDateDate, currentDateDate, productId, currentDateDate, currentDateDate, categoryId);
        for (PromotionEntity promotionEntity : promotionEntities) {
            promotions.add(new ProviderConverter().promotionEntityToPromotionModel(promotionEntity));
        }
        return promotions;
    }

    public ArrayList<Promotion> findCurrentPromotions(GregorianCalendar currentDate) {
        Date currentDateDate = DateProviderConverter.gregorianCalendarToSqlDate(currentDate);
        ArrayList<Promotion> promotions = new ArrayList<>();
        ArrayList<PromotionEntity> promotionEntities = this.promotionRepository.findByStartDateBeforeAndEndDateAfter(currentDateDate, currentDateDate);
        for (PromotionEntity promotionEntity : promotionEntities) {
            promotions.add(new ProviderConverter().promotionEntityToPromotionModel(promotionEntity));
        }
        return promotions;
    }
}
