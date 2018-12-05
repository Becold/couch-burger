package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value="/authenticated")
public class AuthenticatedController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model,
                       Authentication authentication) {
        UserEntity userDetails = (UserEntity) authentication.getPrincipal();
        model.addAttribute("title", "Authentifié");

        return "integrated:authenticated";
    }
}
