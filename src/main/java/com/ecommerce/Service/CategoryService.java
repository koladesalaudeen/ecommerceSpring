package com.ecommerce.Service;

import com.ecommerce.DTO.CategoryDTO;
import com.ecommerce.Entity.Category;

import java.util.List;

public interface CategoryService {
    public void save(CategoryDTO categoryDTO);
    public List<Category> findAll();
}
