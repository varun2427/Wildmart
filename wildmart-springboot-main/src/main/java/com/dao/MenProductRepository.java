package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dto.MenProduct;

@Repository
public interface MenProductRepository extends JpaRepository<MenProduct, Integer> {
	
}