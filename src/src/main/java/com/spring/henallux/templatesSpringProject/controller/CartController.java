package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@SessionAttributes({Constants.CART})
public class CartController {

    @ModelAttribute
    public HashMap<Integer, Product> cart() {
        return new HashMap<>();
    }

    public CartController() { }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    // public String getCart(Model model, @ModelAttribute(Constants.CART)HashMap<Integer, Product> cart) {
    public String getCart(Model model) {
            return "integrated:basket";
    }

    @RequestMapping(value = "/cart/confirm", method = RequestMethod.POST)
    public String postCartConfirm(Model model, BindingResult errors) {
        return "integrated:basket";
    }
}
