package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.model.Category;
import com.spring.henallux.templatesSpringProject.model.TranslationCategory;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductCart;
import com.spring.henallux.templatesSpringProject.service.CategoryService;
import com.spring.henallux.templatesSpringProject.service.TranslationCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping (value="/")
public class WelcomeController {

    private TranslationCategoryService translationCategoryService;
    private MessageSource messageSource;


    @Autowired
    public WelcomeController(TranslationCategoryService translationCategoryService,MessageSource messageSource) {
        this.translationCategoryService = translationCategoryService;
        this.messageSource=messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model,
                       Locale locale) {
        model.addAttribute("title",  messageSource.getMessage("title.welcome",null,locale));
        model.addAttribute("classCss", "home");
        model.addAttribute("translations", translationCategoryService.findByLanguageName(locale.getLanguage()));
        return "integrated:welcome";
    }
}
