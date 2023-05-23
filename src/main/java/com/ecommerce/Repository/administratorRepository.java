package com.ecommerce.Repository;

import com.ecommerce.Entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface administratorRepository extends JpaRepository<Administrator,Long> {
}
