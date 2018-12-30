package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.UserEntity;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping (value="/authenticated")
public class AuthenticatedController {
    private MessageSource messageSource;

    public AuthenticatedController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model,
                       Locale locale,
                       Authentication authentication) {
        UserEntity userDetails = (UserEntity) authentication.getPrincipal();
        model.addAttribute("title",  messageSource.getMessage("menu.profile",null,locale));

        return "integrated:profil";
    }

    @RequestMapping(value = "/profil/changeAddress", method = RequestMethod.POST)
    public String postChangeAddress(Model model,
                                    BindingResult errors) {
        return "integrated:profil";
    }

    @RequestMapping(value = "/profil/changePassword", method = RequestMethod.POST)
    public String postChangePassword(Model model,
                                    BindingResult errors) {
        return "integrated:profil";
    }
}
