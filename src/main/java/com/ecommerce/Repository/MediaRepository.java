package com.ecommerce.Repository;

import com.ecommerce.Entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media,Long> {
    List<Media> findByProductName(String name);
}
