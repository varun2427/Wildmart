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

import com.dao.WomenProductDAO;
import com.dto.WomenProduct;

@RestController
public class WomenProductController {

	// Dependency Injection
	@Autowired
	WomenProductDAO wpDAO;

	@PostMapping("/addWomenProduct")
	public WomenProduct addWomenProduct(@RequestBody WomenProduct womenproduct) {

		return wpDAO.addWomenProduct(womenproduct);

	}

	@GetMapping("/getAllWomenProduct")
	public List<WomenProduct> getAllWomenProduct() {
		return wpDAO.getAllWomenProduct();
	}

	@PutMapping("/updateWomenProduct")
	public WomenProduct updateWomenProduct(@RequestBody WomenProduct womenproduct) {
		return wpDAO.addWomenProduct(womenproduct);
	}

	@DeleteMapping("/deleteWomenProduct/{id}")
	public String deleteWomenProduct(@PathVariable("id") int productId) {
		wpDAO.deleteWomenProduct(productId);
		return "Product Deleted!!!";
	}

	@PostMapping("/addWomenProducttHC")
	public String addWomenProducttHC() {
		WomenProduct mp1 = new WomenProduct(2001, "Prada", 2500.00, 1500.00, "No Cost EMI Applicable",
				"assets/images/w4.jpeg");
		WomenProduct mp2 = new WomenProduct(2002, "Dolce & Gabbana", 3000.00, 2500.00, "No Cost EMI Applicable",
				"assets/images/w5.jpeg");
		WomenProduct mp3 = new WomenProduct(2003, "Burberry", 3000.00, 1500.00, "No Cost EMI Applicable",
				"assets/images/w3.jpeg");
		WomenProduct mp4 = new WomenProduct(2004, "Balenciaga", 4000.00, 2000.00, "No Cost EMI Applicable",
				"assets/images/w6.jpeg");

		wpDAO.addWomenProduct(mp1);
		wpDAO.addWomenProduct(mp2);
		wpDAO.addWomenProduct(mp3);
		wpDAO.addWomenProduct(mp4);
		return "Women's Product added Successfully";

	}
}
