package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.model.Promotion;
import com.spring.henallux.templatesSpringProject.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.GregorianCalendar;

@Controller
public class PromotionController {

    private PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @RequestMapping(value = "/promotions",
                    method = RequestMethod.GET)
    public String getPromotions(Model model) {
        ArrayList<Promotion> promotions = this.promotionService.findCurrentPromotions(new GregorianCalendar());
        model.addAttribute("promotions", promotions);
        return "integrated:promotions";
    }
}
