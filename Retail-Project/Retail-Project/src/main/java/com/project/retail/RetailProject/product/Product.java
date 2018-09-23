package com.project.retail.RetailProject.product;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.retail.RetailProject.shop.Shop;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer productId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
	private Shop shops;
	
	private String productName;
	private String productCategory;
	private String productDescription;
	private String productPrice;
	private String quantityInStock;
	
	public Product() {
		super();
	}

	public Product(Integer productId, Shop shop ,String productName, String productCategory, String productDescription,
			String productPrice, String quantityInStock) {
		super();
		this.productId = productId;
		this.shops = shop;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.quantityInStock = quantityInStock;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@JsonIgnore
	public Shop getShops() {
		return shops;
	}

	@JsonProperty
	public void setShops(Shop shops) {
		this.shops = shops;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(String quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	
}
