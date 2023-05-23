package com.ecommerce.DTO;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;

@Data
public class ProductDTO {
    private String product_name;
    private String description;
    private String category;
    private Integer price;
    private String imageUrl;
    private Integer quantity;
    private Long productDetails;
}
