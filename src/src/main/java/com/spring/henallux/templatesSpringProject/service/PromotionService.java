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

    public List<Promotion> findByProductProductId(Integer productId) {
        return this.promotionDAO.findByProductProductId(productId);
    }

    public List<Promotion> findCurrentPromotions(GregorianCalendar currentDate, Integer productId, Integer categoryId) {
        return this.promotionDAO.findCurrentPromotions(currentDate, productId, categoryId);
    }

    public Promotion findBestPromotionForProduct(Promotion promoPourc,Promotion promoFix,Product product){
        //TODO créer une promotion bidon pour remplzcer les null
        Promotion bestPromo=((product.getUnitPrice()-product.getUnitPrice()*promoPourc.getAmountReduction())>=product.getUnitPrice()-promoFix.getAmountReduction()?promoFix:promoPourc);
        Promotion bestPromoProd;
        double bestPriceCate=(bestPromo.getTypeReduction().equals(0)?product.getUnitPrice()-bestPromo.getAmountReduction():product.getUnitPrice()-product.getUnitPrice()*bestPromo.getAmountReduction());
        double bestPriceProd;
        // On récupère les promotions propres à ce produit uniquement
        List<Promotion> promotions =findCurrentPromotions(new GregorianCalendar(),product.getProductId(),null);
        double pourcMax=0;
        double fixMax=0;
        Promotion promoFixProd = null;
        Promotion promoPourcProd = null;
        for (Promotion promo:
                promotions) {
            if(promo.getTypeReduction().equals(0)){
                if(promo.getAmountReduction()>=fixMax){
                    fixMax=promo.getAmountReduction();
                    promoFixProd=promo;
                }
            }
            else{
                if(promo.getAmountReduction()>=pourcMax){
                    pourcMax=promo.getAmountReduction();
                    promoPourcProd=promo;
                }
            }
        }
        bestPromoProd=((product.getUnitPrice()-product.getUnitPrice()*promoPourcProd.getAmountReduction())>=product.getUnitPrice()-promoFixProd.getAmountReduction()?promoFixProd:promoPourcProd);
        bestPriceProd=(bestPromoProd.getTypeReduction().equals(0)?product.getUnitPrice()-bestPromoProd.getAmountReduction():product.getUnitPrice()-product.getUnitPrice()*bestPromoProd.getAmountReduction());
        if(bestPriceCate>=bestPriceProd){
            bestPromo=bestPromoProd;
        }

        return bestPromo;
    }
}
