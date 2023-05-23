package com.ecommerce.Service;

import com.ecommerce.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
public interface administratorService {
    Product addProduct(Product product);

    Product removeProduct(Product product);

    Product deleteProduct(Product product);

    Product updateProductPrice(Integer id);

    Product updateProductQuantity(Integer id);
    Product lockProduct(Integer Id);
    Product displayProduct(String name);
    List<Product> displayAllProducts();
    List<Product> displayProductByCategory(String category);
}
