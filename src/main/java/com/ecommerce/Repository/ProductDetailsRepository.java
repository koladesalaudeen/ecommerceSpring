package com.ecommerce.Repository;

import com.ecommerce.Entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails,Long> {
}
