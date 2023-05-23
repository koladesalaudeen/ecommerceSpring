package com.ecommerce.Controller;

import com.ecommerce.DTO.CategoryDTO;
import com.ecommerce.DTO.MediaDTO;
import com.ecommerce.DTO.ProductDTO;
import com.ecommerce.DTO.ProductDetailsDTO;
import com.ecommerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @PostMapping("/add-category")
    public ModelAndView addCategory(@ModelAttribute("category")CategoryDTO categoryDTO){
        categoryService.save(categoryDTO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("media", new MediaDTO());
        modelAndView.addObject("category",new CategoryDTO());
        modelAndView.addObject("product",new ProductDTO());
        modelAndView.addObject("productDetails", new ProductDetailsDTO());
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
}
