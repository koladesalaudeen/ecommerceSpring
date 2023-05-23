package com.ecommerce.Entity;

import com.ecommerce.DTO.CategoryDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
    public Category(Long id){this.id = id;}
    public Category(CategoryDTO categoryDTO){this.name = categoryDTO.getName();}
}
