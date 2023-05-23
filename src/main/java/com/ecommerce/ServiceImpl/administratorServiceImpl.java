package com.ecommerce.ServiceImpl;

import com.ecommerce.Entity.Product;
import com.ecommerce.Repository.administratorRepository;
import com.ecommerce.Service.administratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class administratorServiceImpl implements administratorService {
    administratorRepository adminRepo;
    @Autowired
    public administratorServiceImpl(administratorRepository adminRepo){
        this.adminRepo = adminRepo;
    }
    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product removeProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProductPrice(Integer id) {
        return null;
    }

    @Override
    public Product updateProductQuantity(Integer id) {
        return null;
    }

    @Override
    public Product lockProduct(Integer Id) {
        return null;
    }

    @Override
    public Product displayProduct(String name) {
        return null;
    }

    @Override
    public List<Product> displayAllProducts() {
        return null;
    }

    @Override
    public List<Product> displayProductByCategory(String category) {
        return null;
    }
}
