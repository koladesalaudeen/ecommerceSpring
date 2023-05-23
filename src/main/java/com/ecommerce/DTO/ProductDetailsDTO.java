package com.ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsDTO {
    private String productName;
    private String description;
    private String color;
    private String size;
    private Double price;
    private Long media;
}
