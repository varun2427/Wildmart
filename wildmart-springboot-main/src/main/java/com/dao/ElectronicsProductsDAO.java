package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.ElectronicsProduct;

@Service
public class ElectronicsProductsDAO {

@Autowired
ElectronicsProductRepository electronicsproductRepository;

public ElectronicsProduct addElectronicsProduct(ElectronicsProduct electronics) {
return electronicsproductRepository.save(electronics);
}

public List<ElectronicsProduct> getAllElectronicsProduct() {
return electronicsproductRepository.findAll();
}

public void deleteElectronicsProduct(int productId) {

electronicsproductRepository.deleteById(productId);

}

}
