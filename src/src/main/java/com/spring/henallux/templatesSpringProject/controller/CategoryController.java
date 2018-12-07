package com.spring.henallux.templatesSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

    /*
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
     */

    // Est-ce que l'on fait une page qui va afficher toutes les catégories ?
    @RequestMapping(value = "/category",
                    method = RequestMethod.GET)
    public String getCategories(Model model) {
        /*
        ArrayList<Category> categories = categoryService.all();
        model.addAttribute("categories", categories);
         */
        model.addAttribute("title", "Categories");
        return "integrated:categories"; // TODO Template categories.jsp
    }

    @RequestMapping(value = "/category",
                    params={"id"},
                    method = RequestMethod.GET)
    public String getCategory(Model model,
                              @RequestParam String id) {
        /*
        Category category = categoryService.find(id);
        model.addAttribute("category", category);
         */
        model.addAttribute("title", "Category");
        return "integrated:category"; // TODO Template category.jps
    }
}
