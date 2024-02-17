package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.KitchenProduct;

@Repository
public interface KitchenProductRepository extends JpaRepository<KitchenProduct, Integer> {

}