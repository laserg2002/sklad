package com.eco.sklad.repository;

import com.eco.sklad.domain.SupplyLines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyLinesRepository extends JpaRepository<SupplyLines, Integer> {

    SupplyLines save(SupplyLines supplyLines);
}
