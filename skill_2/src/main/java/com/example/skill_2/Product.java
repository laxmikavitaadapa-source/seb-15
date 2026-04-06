package com.example.skill_2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	
int productID;
String Product_name;
String description;
double price;
int quantity;
public int getProductID() {
	return productID;
}
public void setProductID(int productID) {
	this.productID = productID;
}
public String getProduct_name() {
	return Product_name;
}
public void setProduct_name(String product_name) {
	Product_name = product_name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}


}
