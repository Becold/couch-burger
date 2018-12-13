package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.model.User;
import com.spring.henallux.templatesSpringProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/register")
public class RegisterUserController {

    private UserService userService;

    @Autowired
    public RegisterUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model,
                       @ModelAttribute(Constants.USER_REGISTERING_DETAILS) User userRegister,
                       BindingResult errors) {
        userRegister.setUsername("Graham");
        userRegister.setPassword("1234");
        userRegister.setConfirmPassword("1234");
        userRegister.setEmail("gr@gr.com");
        userRegister.setFirstname("Graham");
        userRegister.setName("Berger");
        userRegister.setAddressStreetName("Rue du nord");
        userRegister.setAddressNumber(50);
        userRegister.setAddressLocality("Bruxelles");
        userRegister.setAddressPostalCode("1000");
        userRegister.setPhoneNumber("0123456789");

        model.addAttribute("title", "Inscription");
        return "integrated:register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(Constants.USER_REGISTERING_DETAILS) User userRegister,
                              BindingResult errors) {

        for (FieldError error : errors.getFieldErrors() ) {
            System.out.println (error.getField() + " - " + error.getDefaultMessage());
        }

        if (!userRegister.getPassword().equals(userRegister.getConfirmPassword())) {
            // TODO Erreur personnalisée/traduites
            // errors.rejectValue("confirmPassword", "invalid.register.differentPassword");
        }

        if (this.userService.existsByUsername(userRegister.getUsername())) {
            ObjectError error = new ObjectError("username", "Le pseudonyme existe déjà en base de données.");
            errors.addError(error);
        }

        if (errors.hasErrors()) {
            return "integrated:register";
        }

        // userRegister.setPassword(new BCryptPasswordEncoder().encode(userRegister.getPassword()));
        userRegister.getAuthorities().add(new SimpleGrantedAuthority("ROLE_USER"));
        userRegister.setAccountNonExpired(true);
        userRegister.setAccountNonLocked(true);
        userRegister.setCredentialsNonExpired(true);
        userRegister.setEnabled(true);
        userService.save(userRegister);
        return "redirect:/";
    }
}
