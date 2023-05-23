package com.ecommerce.DTO;

import lombok.Data;

@Data
public class CartDTO {
    private Long productId;
    private Long userId;
    private String productName;
    private Integer productQuantity;
    private Double productPrice;
}
