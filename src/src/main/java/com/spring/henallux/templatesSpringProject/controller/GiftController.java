package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.model.User;
import com.spring.henallux.templatesSpringProject.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/gift")
@SessionAttributes({Constants.CURRENT_USER})
public class GiftController {

    private GiftService giftService;

    @Autowired
    public GiftController(GiftService giftService) {

        this.giftService = giftService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String inscription(Model model,
                              @ModelAttribute(value=Constants.CURRENT_USER) User user)
    {
        String gift = this.giftService.chooseGift(user.getHobby(), user.getAge());
        model.addAttribute("gift", gift);
        return "integrated:gift";
    }

}
