package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.model.Category;
import com.spring.henallux.templatesSpringProject.model.TranslationCategory;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductCart;
import com.spring.henallux.templatesSpringProject.service.CategoryService;
import com.spring.henallux.templatesSpringProject.service.TranslationCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
// @SessionAttributes({Constants.CART})
public class WelcomeController {

    private TranslationCategoryService translationCategoryService;

    /*
    @ModelAttribute(Constants.CART)
    public HashMap<Integer, ProductCart> cart() {
        return new HashMap<>();
    }
    */

    @Autowired
    public WelcomeController(TranslationCategoryService translationCategoryService) {
        this.translationCategoryService = translationCategoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model,
                       Locale locale) {
                       //@ModelAttribute(Constants.CART) HashMap<Integer, ProductCart> cart) {
        model.addAttribute("title", "Bienvenue sur la page d'accueil");
        model.addAttribute("classCss", "home");
        //model.addAttribute("cartSize", cart.size());
        model.addAttribute("translations", translationCategoryService.findByLanguageName(locale.getLanguage()));
        return "integrated:welcome";
    }
}
