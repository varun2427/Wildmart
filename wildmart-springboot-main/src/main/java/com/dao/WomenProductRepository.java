package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.WomenProduct;

@Repository
	public interface WomenProductRepository extends JpaRepository<WomenProduct, Integer> {
	}
	

