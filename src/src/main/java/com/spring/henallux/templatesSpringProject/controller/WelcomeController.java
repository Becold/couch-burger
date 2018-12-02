package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.dataAccess.dao.MagicKeyDAO;
import com.spring.henallux.templatesSpringProject.model.MagicKeyForm;
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

    private MagicKeyDAO magicKeyDAO;

    @Autowired
    public WelcomeController(MagicKeyDAO magicKeyDAO)
    {
        this.magicKeyDAO = magicKeyDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("title", "Bienvenue sur la page d'accueil");
        model.addAttribute("password", new BCryptPasswordEncoder().encode("1234"));
        model.addAttribute("magicKeyForm", new MagicKeyForm());
        return "integrated:welcome";
    }

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="magicKeyForm") MagicKeyForm form) {
        ArrayList<String> validMagicKeys = this.magicKeyDAO.getMagicKeys();

        if (validMagicKeys.contains(form.getMagicKey()))
            return "redirect:/inscription";
        else
            return "integrated:keyError";
    }
}
