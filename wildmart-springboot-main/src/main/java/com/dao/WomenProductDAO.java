package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.WomenProduct;
@Service
public class WomenProductDAO {

	@Autowired
	WomenProductRepository womenproductRepository ;
	
	public WomenProduct addWomenProduct(WomenProduct women) {
		
		return womenproductRepository.save(women);
	}

	public List<WomenProduct> getAllWomenProduct() {
		
		return womenproductRepository.findAll();
	}

	public void deleteWomenProduct(int productId) {
		womenproductRepository.deleteById(productId);
		
	}

}
