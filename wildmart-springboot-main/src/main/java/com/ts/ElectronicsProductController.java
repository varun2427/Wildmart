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

import com.dao.ElectronicsProductsDAO;
import com.dto.ElectronicsProduct;

@RestController
public class ElectronicsProductController {

// Dependency Injection
@Autowired
ElectronicsProductsDAO epDAO;

@PostMapping("/addElectronicsProduct")
public ElectronicsProduct addElectronicsProduct(@RequestBody ElectronicsProduct electronicsproduct) {

return epDAO.addElectronicsProduct(electronicsproduct);

}

@GetMapping("/getAllElectronicsProduct")
public List<ElectronicsProduct> getAllElectronicsProduct() {
return epDAO.getAllElectronicsProduct();
}

@PutMapping("/updateElectronicsProduct")
public ElectronicsProduct updateElectronicsProduct(@RequestBody ElectronicsProduct electronicsproduct ) {
return epDAO.addElectronicsProduct(electronicsproduct);
}

@DeleteMapping("/deleteElectronicsProduct/{id}")
public String deleteElectronicsProduct(@PathVariable("id") int productId) {
epDAO.deleteElectronicsProduct(productId);
return "Product Deleted!!!";
}

@PostMapping("/addElectronicsProductHC")
public String addElectronicsProductHC() {
ElectronicsProduct ep1 = new ElectronicsProduct(3001, "Iphone14 pro max", 114999.00, 110000.00, "No Cost EMI Applicable",
"assets/images/iphone-2.jpeg");
ElectronicsProduct ep2 = new ElectronicsProduct(3002, "One Plus", 29999.00, 25000.00, "No Cost EMI Applicable",
"assets/images/phone-3.jpeg");
ElectronicsProduct ep3 = new ElectronicsProduct(3003, "Samsung", 100000.00, 80000.00, "No Cost EMI Applicable",
"assets/images/phone-10.jpeg");
ElectronicsProduct ep4 = new ElectronicsProduct(3004, "Nothing", 34999.00, 30000.00, "No Cost EMI Applicable",
"assets/images/phone-7.jpeg");

epDAO.addElectronicsProduct(ep1);
epDAO.addElectronicsProduct(ep2);
epDAO.addElectronicsProduct(ep3);
epDAO.addElectronicsProduct(ep4);
return "Electronics's Product added Successfully";

}

}