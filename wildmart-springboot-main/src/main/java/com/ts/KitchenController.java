package com.ts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.KitchenProductDAO;
import com.dto.KitchenProduct;

@RestController
public class KitchenController {

	// Dependency Injection
	@Autowired
	KitchenProductDAO kpDAO;

	@PostMapping("/addKitchenProduct")
	public KitchenProduct addKitchenProduct(@RequestBody KitchenProduct kitchenproduct) {

		return kpDAO.addKitchenProduct(kitchenproduct);

	}

	@GetMapping("/getAllKitchenProduct")
	public List<KitchenProduct> getAllKitchenProduct() {
		return kpDAO.getAllKitchenProduct();
	}

	@PutMapping("/updateKitchenProduct")
	public KitchenProduct updatekitchenproduct(@RequestBody KitchenProduct kitchenproduct) {
		return kpDAO.addKitchenProduct(kitchenproduct);
	}

	@DeleteMapping("/deletekitchenProduct/{id}")
	public String deletekitchenProduct(@PathVariable("id") int productId) {
		kpDAO.deleteKitchenProduct(productId);
		return "Product Deleted!!!";
	}

	@PostMapping("/addkitchenProductHC")
	public String addkitchenProductHC() {
		KitchenProduct kp1 = new KitchenProduct(4001, "Gas Stove", 8000.00, 5500.00, "No Cost EMI Applicable",
				"assets/images/k1.jpeg");
		KitchenProduct kp2 = new KitchenProduct(4002, "Rice Cooker(Electric)", 5000.00, 3500.00,
				"No Cost EMI Applicable", "assets/images/k2.jpeg");
		KitchenProduct kp3 = new KitchenProduct(4003, "Induction Stove", 3000.00, 2500.00, "No Cost EMI Applicable",
				"assets/images/k3.jpeg");
		KitchenProduct kp4 = new KitchenProduct(4004, "kitchen Cookware", 1500.00, 1500.00, "No Cost EMI Applicable",
				"assets/images/k4.jpeg");

		kpDAO.addKitchenProduct(kp1);
		kpDAO.addKitchenProduct(kp2);
		kpDAO.addKitchenProduct(kp3);
		kpDAO.addKitchenProduct(kp4);
		return "Kitchen's Product added Successfully";

	}

}
