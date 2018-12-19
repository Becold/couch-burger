package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.exception.ProductNotFoundException;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.form.cart.AddProductForm;
import com.spring.henallux.templatesSpringProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/product",
                    params={"id"},
                    method = RequestMethod.GET)
    public String getProduct(Model model,
                             @RequestParam Integer id,
                             @ModelAttribute(Constants.ADD_PRODUCT_TO_CART_FORM) AddProductForm addProductForm) {
        try {
            Product product = productService.findOne(id);
            model.addAttribute("product", product);
            model.addAttribute("title", "Article");
            return "integrated:product";
        }
        catch (ProductNotFoundException exception) {
            // TODO Afficher "Produit non trouvé"
            return "integrated:keyError";
        }
    }
}
