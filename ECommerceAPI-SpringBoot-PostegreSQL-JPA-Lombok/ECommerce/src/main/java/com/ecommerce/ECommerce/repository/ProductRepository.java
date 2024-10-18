package com.ecommerce.ECommerce.repository;

import com.ecommerce.ECommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByName(String name);
    List<Product> findByCategory(String category);
    List <Product> findBySeller(String seller);


}
