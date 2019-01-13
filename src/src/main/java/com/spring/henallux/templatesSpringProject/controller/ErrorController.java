package com.spring.henallux.templatesSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class ErrorController {

    private MessageSource messageSource;

    @Autowired
    public ErrorController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(value = "/errorOccured",
                    method = RequestMethod.GET)
    public String getError(@RequestParam(value = "code", required = false) String errorCode,
                           Model model,
                           Locale locale) {
        String errorMessage = messageSource.getMessage("error.noErrorCode", null, locale);
        if (errorMessage.equals(errorCode) || errorCode != null) {
            errorMessage = messageSource.getMessage(errorCode, null, locale);
        }

        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("title", messageSource.getMessage("error.title", null, locale)); // TODO Traduction
        return "integrated:keyError";
    }

}
