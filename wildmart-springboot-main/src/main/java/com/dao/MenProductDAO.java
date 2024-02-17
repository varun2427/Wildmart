package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.MenProduct;

@Service
public class MenProductDAO {

	
	@Autowired
	MenProductRepository menproductRepository ;

	public MenProduct addMenProduct(MenProduct men) {
		
		return menproductRepository.save(men);
	}

	public List<MenProduct> getAllMenProduct() {
		// TODO Auto-generated method stub
		return menproductRepository.findAll();
	}

	public void deleteMenProduct(int productId) {
		// TODO Auto-generated method stub
		 menproductRepository.deleteById(productId);
	}
	
	

	
	

}
