package com.ecommerce.Entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user_name;
    private String comment;
    private Long rating;
    @CreatedDate
    private LocalDateTime review_date;
    @ManyToOne
    @JoinColumn(name = "product_details_id")
    private ProductDetails productDetails;
}
