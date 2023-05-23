package com.ecommerce.ServiceImpl;

import com.ecommerce.Entity.ProductDetails;
import com.ecommerce.Repository.ProductDetailsRepository;
import com.ecommerce.Service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {
    private ProductDetailsRepository productDetailsRepository;
    @Autowired
    public ProductDetailsServiceImpl(ProductDetailsRepository productDetailsRepository){
        this.productDetailsRepository = productDetailsRepository;
    }
    @Override
    public List<ProductDetails> findAllProducts() {
        return productDetailsRepository.findAll();
    }
}
