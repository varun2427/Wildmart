package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.ElectronicsProduct;


@Repository
public interface ElectronicsProductRepository extends JpaRepository<ElectronicsProduct, Integer> {

}
