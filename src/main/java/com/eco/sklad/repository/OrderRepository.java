package com.eco.sklad.repository;

import com.eco.sklad.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {


//        @Query("from Supplies u where u.shortName=:shortName")
//        Optional<Product> findByShortName(@Param("shortName") String shortName);

        Order save(Order order);
    }


