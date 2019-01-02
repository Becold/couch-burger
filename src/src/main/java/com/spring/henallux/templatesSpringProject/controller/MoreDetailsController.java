package com.spring.henallux.templatesSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class MoreDetailsController {

    private final MessageSource messageSource;

    @Autowired
    public MoreDetailsController(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    @RequestMapping(value = "/more_details",
            method = RequestMethod.GET)
    public String home(Model model,
                       Locale locale){
        model.addAttribute("title", messageSource.getMessage("more.title",null,locale));
        return "integrated:moreDetails";
    }
}
