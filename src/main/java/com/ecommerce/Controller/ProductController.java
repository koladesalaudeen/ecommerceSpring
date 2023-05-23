package com.ecommerce.Controller;

import com.ecommerce.DTO.CategoryDTO;
import com.ecommerce.DTO.MediaDTO;
import com.ecommerce.DTO.ProductDTO;
import com.ecommerce.DTO.ProductDetailsDTO;
import com.ecommerce.Entity.Product;
import com.ecommerce.Repository.ProductRepository;
import com.ecommerce.Service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    private ProductRepository productRepository;
    private ProductService productService;
    @Autowired
    private ProductController(ProductRepository productRepository,ProductService productService){
        this.productRepository = productRepository;
        this.productService = productService;
    }
    @PostMapping("/add-product")
    public ModelAndView addProduct(@ModelAttribute("product") ProductDTO productDTO){
        Product product = new Product(productDTO);
        productService.addProduct(productDTO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("media", new MediaDTO());
        modelAndView.addObject("category",new CategoryDTO());
        modelAndView.addObject("product",new ProductDTO());
        modelAndView.addObject("productDetails", new ProductDetailsDTO());
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
    @GetMapping("/")
    public ModelAndView viewProducts(@RequestParam(defaultValue = "0")int page, ModelAndView modelAndView){
        Page<Product> allProducts = productService.displayAllProducts();
        PagedListHolder<Product> productPage = new PagedListHolder<Product>(allProducts.getContent());

        productPage.setPage(0);
        productPage.setPageSize(5);

        modelAndView.setViewName("home");
        modelAndView.addObject("products",productPage.getPageList());
        modelAndView.addObject("currentPage",productPage.getPage());
        modelAndView.addObject("totalPages",productPage.getMaxLinkedPages());

        return modelAndView;
    }
}
