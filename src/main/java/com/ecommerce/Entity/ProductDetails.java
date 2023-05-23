package com.ecommerce.Entity;

import com.ecommerce.DTO.ProductDetailsDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "productDetails")
    private Product productList;
    private String productName;
    private String description;
    private String color;
    private String size;
    private Double price;
    @OneToOne
    @JoinColumn(name="product_media")
    private Media media;
    @OneToMany(mappedBy = "comment")
    private List<Review> reviews = new ArrayList<>();

    public ProductDetails(ProductDetailsDTO productDetailsDTO){
        this.productName = productDetailsDTO.getProductName();
        this.description = productDetailsDTO.getDescription();
        this.color = productDetailsDTO.getColor();
        this.size = productDetailsDTO.getSize();
        this.price = productDetailsDTO.getPrice();
        this.media = new Media(productDetailsDTO.getMedia());
    }
    public ProductDetails(Long Id){
        this.id = Id;
    }
}
