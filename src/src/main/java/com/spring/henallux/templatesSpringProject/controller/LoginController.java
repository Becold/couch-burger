package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.configuration.WebSecurityConfiguration;
import com.spring.henallux.templatesSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.templatesSpringProject.service.UserDetailsServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value=WebSecurityConfiguration.LOGIN_REQUEST)
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model,
                       @ModelAttribute(value=Constants.USER_DETAILS) UserEntity userDetails,
                       BindingResult errors) {
        for (FieldError error : errors.getFieldErrors() ) {
            System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
        }

        model.addAttribute("title", "Connexion");
        return "integrated:login";
    }
}
