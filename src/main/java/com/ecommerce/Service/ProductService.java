package com.ecommerce.Service;

import com.ecommerce.DTO.ProductDTO;
import com.ecommerce.Entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product addProduct(ProductDTO productDTO);
    Product updateProductQuantity(Integer id);
    Product updateProductPrice(Integer id);
    Product deleteProduct(ProductDTO productDTO);
    Product displayProduct(String name);
    Page<Product> displayAllProducts();
    List<Product> displayProductByCategory(String category);
    Product lockProduct(Integer Id);
}
