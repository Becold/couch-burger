package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.exception.ProductNotFoundException;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductForm;
import com.spring.henallux.templatesSpringProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
public class ProductController {

    private ProductService productService;
    private MessageSource messageSource;

    @Autowired
    public ProductController(ProductService productService,MessageSource messageSource) {
        this.productService = productService;
        this.messageSource=messageSource;
    }

    @RequestMapping(value = "/product/{productId}",
                    method = RequestMethod.GET)
    public String getProduct(Model model,
                             Locale locale,
                             @PathVariable ("productId") Integer productId,
                             @ModelAttribute(Constants.PRODUCT_TO_CART_FORM) ProductForm productForm) {
        try {
            Product product = productService.findOne(productId);
            model.addAttribute("product", product);
            model.addAttribute("title",  messageSource.getMessage("title.articles",null,locale));
            return "integrated:product";
        }
        catch (ProductNotFoundException exception) {
            // TODO Afficher "Produit non trouvé"
            return "integrated:keyError";
        }
    }
}
