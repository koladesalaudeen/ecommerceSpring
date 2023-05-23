package com.ecommerce.Service;

import com.ecommerce.Entity.ProductDetails;

import java.util.List;

public interface ProductDetailsService {
    List<ProductDetails> findAllProducts();
}
