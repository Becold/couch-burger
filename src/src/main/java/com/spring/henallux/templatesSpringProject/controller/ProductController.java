package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.exception.ProductNotFoundException;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductForm;
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

    @RequestMapping(value = "/product/{productId}",
                    method = RequestMethod.GET)
    public String getProduct(Model model,
                             @PathVariable ("productId") Integer productId,
                             @ModelAttribute(Constants.PRODUCT_TO_CART_FORM) ProductForm productForm) {
        try {
            Product product = productService.findOne(productId);
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
