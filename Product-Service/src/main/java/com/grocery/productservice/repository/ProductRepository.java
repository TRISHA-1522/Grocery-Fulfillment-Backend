package com.grocery.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grocery.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}