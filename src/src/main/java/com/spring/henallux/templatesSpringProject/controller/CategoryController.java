package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.exception.CategoryNotFoundException;
import com.spring.henallux.templatesSpringProject.exception.NoProductInCategoryException;
import com.spring.henallux.templatesSpringProject.model.Category;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.form.cart.AddProductForm;
import com.spring.henallux.templatesSpringProject.service.CategoryService;
import com.spring.henallux.templatesSpringProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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
                              @RequestParam Integer id,
                              @ModelAttribute(Constants.ADD_PRODUCT_TO_CART_FORM) AddProductForm addProductForm) {
        Category category = null;
        try {
            category = categoryService.find(id);
            model.addAttribute("category", category);

            List<Product> products = this.productsService.findByCategoryId(id);
            if (products.isEmpty()){
                throw new NoProductInCategoryException();
            }

            model.addAttribute("products", products);
            model.addAttribute("title", "Category");
            return "integrated:category";
        } catch (CategoryNotFoundException e) {
            // TODO Erreur : Cette catégorie n'existe pas.
            return "redirect:/";
        } catch (NoProductInCategoryException e) {
            // TODO Erreur : Il n'y a pas de produit dans cette catégorie.
            return "redirect:/";
        }
    }
}
