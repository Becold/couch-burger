package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.model.Promotion;
import com.spring.henallux.templatesSpringProject.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;

@Controller
public class PromotionController {

    private PromotionService promotionService;
    private MessageSource messageSource;

    @Autowired
    public PromotionController(PromotionService promotionService,
                               MessageSource messageSource) {
        this.promotionService = promotionService;
        this.messageSource = messageSource;
    }

    @RequestMapping(value = "/promotions",
                    method = RequestMethod.GET)
    public String getPromotions(Model model,
                                Locale locale) {
        ArrayList<Promotion> promotions = this.promotionService.findCurrentPromotions(new GregorianCalendar());
        model.addAttribute("promotions", promotions);
        model.addAttribute("title",  messageSource.getMessage("title.promotion",null,locale));
        return "integrated:promotions";
    }
}
