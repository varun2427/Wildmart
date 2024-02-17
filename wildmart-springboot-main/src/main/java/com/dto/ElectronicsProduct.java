package com.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ElectronicsProduct {

@Id
private int productId;
private String productName;
private double price;
private double price1;
private String description;
private String productImage;

public ElectronicsProduct() {
super();

}

public ElectronicsProduct(int productId, String productName, double price, double price1, String description,
String productImage) {
super();
this.productId = productId;
this.productName = productName;
this.price = price;
this.price1 = price1;
this.description = description;
this.productImage = productImage;
}

public int getProductId() {
return productId;
}

public void setProductId(int productId) {
this.productId = productId;
}

public String getProductName() {
return productName;
}

public void setProductName(String productName) {
this.productName = productName;
}

public double getPrice() {
return price;
}

public void setPrice(double price) {
this.price = price;
}

public double getPrice1() {
return price1;
}

public void setPrice1(double price1) {
this.price1 = price1;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getProductImage() {
return productImage;
}

public void setProductImage(String productImage) {
this.productImage = productImage;
}

@Override
public String toString() {
return "ElectronicsProduct [productId=" + productId + ", productName=" + productName + ", price=" + price
+ ", price1=" + price1 + ", description=" + description + ", productImage=" + productImage + "]";
}

}