package com.eco.sklad.repository;

import com.eco.sklad.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    @Query("from Product u where u.shortName=:shortName")
    Optional<Product> findByShortName(@Param("shortName") String shortName);

    Product save(Product product);


}
