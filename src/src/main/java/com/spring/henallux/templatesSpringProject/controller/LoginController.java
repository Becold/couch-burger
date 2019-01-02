package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.configuration.WebSecurityConfiguration;
import com.spring.henallux.templatesSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.templatesSpringProject.service.UserDetailsServiceImplementation;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Member;
import java.util.Locale;

@Controller
@RequestMapping (value=WebSecurityConfiguration.LOGIN_REQUEST)
public class LoginController {
    private MessageSource messageSource;

    public LoginController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model,
                       Locale locale,
                       @ModelAttribute(value=Constants.USER_DETAILS) UserEntity userDetails,
                       BindingResult errors) {
        model.addAttribute("title",  messageSource.getMessage("menu.login",null,locale));
        return "integrated:login";
    }
}
