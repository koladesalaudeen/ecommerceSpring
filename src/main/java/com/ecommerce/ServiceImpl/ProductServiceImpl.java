package com.ecommerce.ServiceImpl;

import com.ecommerce.DTO.ProductDTO;
import com.ecommerce.Entity.Product;
import com.ecommerce.Repository.ProductRepository;
import com.ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public Product addProduct(ProductDTO productDTO){
        Product product = new Product(productDTO);
        productRepository.save(product);
        return product;
    }

    public Product updateProductQuantity(Integer id) {
        return new Product();
    }

    @Override
    public Product updateProductPrice(Integer id) {
        return null;
    }

    @Override
    public Product deleteProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public Product displayProduct(String name) {
        return null;
    }

    @Override
    public Page<Product> displayAllProducts() {
        return new PageImpl(productRepository.findAll());
    }

    @Override
    public List<Product> displayProductByCategory(String category) {
        return null;
    }

    @Override
    public Product lockProduct(Integer Id) {
        return null;
    }
}
