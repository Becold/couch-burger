package com.spring.henallux.templatesSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping (value="/")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("title", "Bienvenue sur la page d'accueil");
        model.addAttribute("password", new BCryptPasswordEncoder().encode("1234"));
        return "integrated:welcome";
    }
}
