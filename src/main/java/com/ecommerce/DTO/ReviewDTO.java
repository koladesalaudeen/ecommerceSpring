package com.ecommerce.DTO;

import lombok.Data;

@Data
public class ReviewDTO {
    private Long product_details_id;
    private String user_name;
    private String comment;
    private Long rating;
}
