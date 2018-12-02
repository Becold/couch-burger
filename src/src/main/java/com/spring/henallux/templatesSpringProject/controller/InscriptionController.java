package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.templatesSpringProject.model.User;
import com.spring.henallux.templatesSpringProject.service.HobbiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/inscription")
@SessionAttributes({Constants.CURRENT_USER})
public class InscriptionController {

    @ModelAttribute(Constants.CURRENT_USER)
    public User user()
    {
        return new User();
    }

    private HobbiesService hobbiesService;
    private UserDAO userDAO;

    @Autowired
    public InscriptionController(HobbiesService hobbiesService,
                                 UserDAO userDAO) {
        this.hobbiesService = hobbiesService;
        this.userDAO = userDAO;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String inscription(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("hobbies", hobbiesService.getHobbies());
        return "integrated:userInscription";
    }

    @RequestMapping(method= RequestMethod.POST)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(value=Constants.CURRENT_USER) User userForm,
                              BindingResult errors) {
        for (FieldError error : errors.getFieldErrors() ) {
            System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
        }

        if (!errors.hasErrors()) {
            this.userDAO.save(userForm);
            return "redirect:/gift";
        }
        else {
            model.addAttribute("errors", errors.getFieldErrors());
            return "integrated:keyError";
        }
    }
}
