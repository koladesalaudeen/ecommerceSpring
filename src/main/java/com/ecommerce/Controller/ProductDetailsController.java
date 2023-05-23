package com.ecommerce.Controller;

import com.ecommerce.DTO.CategoryDTO;
import com.ecommerce.DTO.MediaDTO;
import com.ecommerce.DTO.ProductDTO;
import com.ecommerce.DTO.ProductDetailsDTO;
import com.ecommerce.Entity.ProductDetails;
import com.ecommerce.Repository.ProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductDetailsController {
    private ProductDetailsRepository productDetailsRepository;
    @Autowired
    private ProductDetailsController(ProductDetailsRepository productDetailsRepository){
        this.productDetailsRepository = productDetailsRepository;
    }
    @PostMapping("/add-productDetails")
    public ModelAndView addDetails(@ModelAttribute("productDetails")ProductDetailsDTO productDetailsDTO){
        ProductDetails productDetails = new ProductDetails(productDetailsDTO);
        productDetailsRepository.save(productDetails);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("media", new MediaDTO());
        modelAndView.addObject("category",new CategoryDTO());
        modelAndView.addObject("product",new ProductDTO());
        modelAndView.addObject("productDetails", new ProductDetailsDTO());
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
}
