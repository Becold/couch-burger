package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.model.Category;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.service.CategoryService;
import com.spring.henallux.templatesSpringProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {

    private CategoryService categoryService;
    private ProductService productsService;

    @Autowired
    public CategoryController(CategoryService categoryService,
                              ProductService productsService) {
        this.categoryService = categoryService;
        this.productsService = productsService;
    }

    @RequestMapping(value = "/category",
                    params={"id"},
                    method = RequestMethod.GET)
    public String getCategory(Model model,
                              @RequestParam Integer id) {
        Category category = categoryService.find(id);
        if (category != null) {
            model.addAttribute("category", category);

            List<Product> products = this.productsService.findByCategoryId(id);
            model.addAttribute("products", products);
            // TODO Gérer quand la catégorie ne possède pas de produits à afficher

            model.addAttribute("title", "Category");
            return "integrated:category";
        }
        else {
            // TODO Erreur : Cette catégorie n'existe pas
            return "redirect:/";
        }
    }
}
