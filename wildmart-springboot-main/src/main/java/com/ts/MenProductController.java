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

import com.dao.MenProductDAO;

import com.dto.MenProduct;

@RestController
public class MenProductController {

	// Dependency Injection
	@Autowired
	MenProductDAO mpDAO;

	@PostMapping("/addMenProduct")
	public MenProduct addMenProduct(@RequestBody MenProduct menproduct) {
		
		return mpDAO.addMenProduct(menproduct);

	}

	@GetMapping("/getAllMenProduct")
	public List<MenProduct> getAllMenProduct() {
		return mpDAO.getAllMenProduct();
	}

	@PutMapping("/updateMenProduct")
	public MenProduct updateMenProduct(@RequestBody MenProduct menproduct) {
		return mpDAO.addMenProduct(menproduct);
	}

	@DeleteMapping("/deleteMenProduct/{id}")
	public String deleteMenProduct(@PathVariable("id") int productId) {
		mpDAO.deleteMenProduct(productId);
		return "Product Deleted!!!";
	}

	@PostMapping("/addMenProductHC")
	public String addMenProductHC() {
		MenProduct mp1 = new MenProduct(1001, "Rare Rabbit", 2500.00, 1500.00, "No Cost EMI Applicable",
				"assets/images/shirt6.jpeg.jpg");
		MenProduct mp2 = new MenProduct(1002, "Peter England", 3000.00, 2500.00, "No Cost EMI Applicable",
				"assets/images/shirt1.jpeg.jpg");
		MenProduct mp3 = new MenProduct(1003, "Twills", 2500.00, 1500.00, "No Cost EMI Applicable",
				"assets/images/shirt3.jpeg.jpg");
		MenProduct mp4 = new MenProduct(1004, "Flying Machine", 2500.00, 1500.00, "No Cost EMI Applicable",
				"assets/images/shirt8.jpeg.jpg");

		mpDAO.addMenProduct(mp1);
		mpDAO.addMenProduct(mp2);
		mpDAO.addMenProduct(mp3);
		mpDAO.addMenProduct(mp4);
		return "Men's Product added Successfully";

	}
}
