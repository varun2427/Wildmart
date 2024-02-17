package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.KitchenProduct;

@Service
public class KitchenProductDAO {

	@Autowired
	KitchenProductRepository kitchenproductRepository;

	public KitchenProduct addKitchenProduct(KitchenProduct kitchenproduct) {
		return kitchenproductRepository.save(kitchenproduct);
	}

	public List<KitchenProduct> getAllKitchenProduct() {
		return kitchenproductRepository.findAll();
	}

	public void deleteKitchenProduct(int productId) {
		kitchenproductRepository.deleteById(productId);

	}

}
