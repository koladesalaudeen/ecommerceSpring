package com.ecommerce.Controller;

import com.ecommerce.DTO.CategoryDTO;
import com.ecommerce.DTO.MediaDTO;
import com.ecommerce.DTO.ProductDTO;
import com.ecommerce.DTO.ProductDetailsDTO;
import com.ecommerce.Entity.Category;
import com.ecommerce.Entity.Media;
import com.ecommerce.Entity.ProductDetails;
import com.ecommerce.Service.CategoryService;
import com.ecommerce.Service.MediaService;
import com.ecommerce.Service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MediaController {
    private MediaService mediaService;
    private CategoryService categoryService;
    private ProductDetailsService productDetailsService;
    @Autowired
    private MediaController(MediaService mediaService,CategoryService categoryService,ProductDetailsService productDetailsService){
        this.mediaService = mediaService;
        this.categoryService = categoryService;
        this.productDetailsService = productDetailsService;
    }
    @GetMapping("/dashboard")
    public ModelAndView dashboard(){
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categoryList = categoryService.findAll();
        List<Media> mediaList = mediaService.findAll();
        List<ProductDetails>productDetailsList  = productDetailsService.findAllProducts();

        modelAndView.addObject("categoryList",categoryList);
        modelAndView.addObject("mediaList",mediaList);
        modelAndView.addObject("detailList",productDetailsList);

        modelAndView.addObject("media", new MediaDTO());
        modelAndView.addObject("category",new CategoryDTO());
        modelAndView.addObject("product",new ProductDTO());
        modelAndView.addObject("productDetails", new ProductDetailsDTO());
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
    @PostMapping("/add-media")
    public ModelAndView addMedia(@ModelAttribute("media")MediaDTO mediaDTO){
        mediaService.save(mediaDTO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");

        modelAndView.addObject("media", new MediaDTO());
        modelAndView.addObject("category",new CategoryDTO());
        modelAndView.addObject("product",new ProductDTO());
        modelAndView.addObject("productDetails", new ProductDetailsDTO());

        return modelAndView;
    }
}
