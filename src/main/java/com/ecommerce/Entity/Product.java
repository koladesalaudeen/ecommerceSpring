package com.ecommerce.Entity;

import com.ecommerce.DTO.CategoryDTO;
import com.ecommerce.DTO.ProductDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@Entity
@Table(name = "product_list")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product_name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Integer price;
    private Integer quantity;
    private String imageUrl;
    @OneToOne
    @JoinColumn(name = "product_details_id",referencedColumnName = "id")
    private ProductDetails productDetails;
    public Product(ProductDTO productDTO){
        this.product_name = productDTO.getProduct_name();
        this.description = productDTO.getProduct_name();
        this.price = productDTO.getPrice();
        this.imageUrl = productDTO.getImageUrl();
        this.quantity = productDTO.getQuantity();

        this.category = new Category(Long.valueOf(productDTO.getCategory()));
        this.productDetails = new ProductDetails(Long.valueOf(productDTO.getProductDetails()));
    }
}
