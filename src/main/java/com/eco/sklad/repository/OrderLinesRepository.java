package com.eco.sklad.repository;

import com.eco.sklad.domain.OrderLines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLinesRepository extends JpaRepository<OrderLines, Integer>

    {
        OrderLines save(OrderLines orderLines);
    }

