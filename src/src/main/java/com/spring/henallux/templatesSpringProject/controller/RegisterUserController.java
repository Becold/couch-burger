package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.model.User;
import com.spring.henallux.templatesSpringProject.model.form.register.RegisterForm;
import com.spring.henallux.templatesSpringProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import java.util.Locale;

@Controller
@RequestMapping(value="/register")
public class RegisterUserController {

    private UserService userService;
    private MessageSource messageSource;

    @Autowired
    public RegisterUserController(UserService userService,MessageSource messageSource) {
        this.userService = userService;
        this.messageSource=messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model,
                       Locale locale,
                       @ModelAttribute(Constants.USER_REGISTERING_DETAILS) RegisterForm userRegister,
                       BindingResult errors) {


        model.addAttribute("title",  messageSource.getMessage("menu.register",null,locale));
        return "integrated:register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(Constants.USER_REGISTERING_DETAILS) RegisterForm userRegister,
                              BindingResult errors) {

        if (!userRegister.getPassword().equals(userRegister.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "invalid.register.differentPassword");
        }

        if (this.userService.existsByUsername(userRegister.getUsername())) {
            errors.rejectValue("username", "invalid.register.usernameTaken");
        }

        if(!userRegister.getSexe().equals("M") &&!userRegister.getSexe().equals("F")){
            errors.rejectValue("sexe", "invalid.register.sexe");
        }

        if (errors.hasErrors()) {
            return "integrated:register";
        }

        User newUser = new User();
        newUser.setUsername(userRegister.getUsername());
        newUser.setPassword(userRegister.getPassword());
        newUser.setEmail(userRegister.getEmail());
        newUser.setFirstname(userRegister.getFirstname());
        newUser.setName(userRegister.getName());
        newUser.setAddressStreetName(userRegister.getAddressStreetName());
        newUser.setAddressNumber(userRegister.getAddressNumber());
        newUser.setAddressLocality(userRegister.getAddressLocality());
        newUser.setAddressPostalCode(userRegister.getAddressPostalCode());
        newUser.setPhoneNumber(userRegister.getPhoneNumber());
        newUser.getAuthorities().add(new SimpleGrantedAuthority("ROLE_USER"));
        newUser.setAccountNonExpired(true);
        newUser.setAccountNonLocked(true);
        newUser.setCredentialsNonExpired(true);
        newUser.setEnabled(true);
        userService.save(newUser);

        return "redirect:/";
    }
}
