package com.spring.henallux.templatesSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    /*
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
     */

    @RequestMapping(value = "/product/{productId}",
            method = RequestMethod.GET)
    public String getProduct(Model model,
                             @PathVariable("productId") int id) {
        /*
        Product product = productService.find(id);
        model.addAttribute("product", product);
         */
        model.addAttribute("title", "Article");
        return "integrated:product"; // TODO Template category.jsp.jsp
    }
}
