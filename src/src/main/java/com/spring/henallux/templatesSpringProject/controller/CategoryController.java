package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.exception.CategoryNotFoundException;
import com.spring.henallux.templatesSpringProject.exception.NoProductInCategoryException;
import com.spring.henallux.templatesSpringProject.model.Category;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.Promotion;
import com.spring.henallux.templatesSpringProject.model.TranslationCategory;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductForm;
import com.spring.henallux.templatesSpringProject.service.CategoryService;
import com.spring.henallux.templatesSpringProject.service.ProductService;
import com.spring.henallux.templatesSpringProject.service.PromotionService;
import com.spring.henallux.templatesSpringProject.service.TranslationCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

@Controller
public class CategoryController {

    private CategoryService categoryService;
    private ProductService productService;
    private MessageSource messageSource;
    private TranslationCategoryService translationCategoryService;
    private PromotionService promotionService;

    @Autowired
    public CategoryController(CategoryService categoryService,
                              ProductService productService,
                              MessageSource messageSource,
                              TranslationCategoryService translationCategoryService,
                              PromotionService promotionService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.messageSource=messageSource;
        this.translationCategoryService=translationCategoryService;
        this.promotionService=promotionService;
    }

    @RequestMapping(value = "/category/{categoryId}",
                    method = RequestMethod.GET)
    public String getCategory(Model model,
                              Locale locale,
                              @PathVariable("categoryId") Integer categoryId,
                              @ModelAttribute(Constants.PRODUCT_TO_CART_FORM) ProductForm productForm) {
        try {
            Category category = categoryService.find(categoryId);
            model.addAttribute("category", category);

            TranslationCategory translationCategory=translationCategoryService.findByCategoryCategoryIdAndLanguageName(categoryId,locale.getLanguage());
            model.addAttribute("categoryTrans",translationCategory.getContent());

            ArrayList<Product> products = this.productService.findByCategoryId(categoryId);
            if (products.isEmpty()){
                throw new NoProductInCategoryException();
            }

            model.addAttribute("products", products);
            model.addAttribute("title",  messageSource.getMessage("menu.category",null,locale));
            return "integrated:category";
        } catch (CategoryNotFoundException e) {
            model.addAttribute("errorMessage", "invalid.category.exist");
            return "redirect:/";
        } catch (NoProductInCategoryException e) {
            model.addAttribute("errorMessage", "invalid.quantity.empty");
            return "redirect:/";
        }
    }
}
