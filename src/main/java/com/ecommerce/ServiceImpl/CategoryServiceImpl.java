package com.ecommerce.ServiceImpl;

import com.ecommerce.DTO.CategoryDTO;
import com.ecommerce.Entity.Category;
import com.ecommerce.Repository.CategoryRepository;
import com.ecommerce.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;
    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void save(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO);
        categoryRepository.save(category);
    }
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

}
