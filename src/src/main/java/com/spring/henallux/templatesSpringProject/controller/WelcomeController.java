package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.model.Category;
import com.spring.henallux.templatesSpringProject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping (value="/")
public class WelcomeController {

    private CategoryService categoryService;

    @Autowired
    public WelcomeController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("title", "Bienvenue sur la page d'accueil");
        model.addAttribute("password", new BCryptPasswordEncoder().encode("1234"));

        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "integrated:welcome";
    }
}
