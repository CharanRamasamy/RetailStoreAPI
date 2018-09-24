package com.project.retail.RetailProject.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.retail.RetailProject.Cart.Cart;
import com.project.retail.RetailProject.lineitem.LineItems;
import com.project.retail.RetailProject.shop.Shop;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer productId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
	private Shop shops;
	
	@OneToMany(
	        mappedBy = "products", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	private List<LineItems> lineitems = new ArrayList<>();
	
	private String productName;
	private String productCategory;
	private String productDescription;
	private Double productPrice;
	private Integer quantityInStock;
	
	public Product() {
		super();
	}

	public Product(Integer productId, Shop shop ,String productName, String productCategory, String productDescription,
			Double productPrice, Integer quantityInStock) {
		super();
		this.productId = productId;
		this.shops = shop;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.quantityInStock = quantityInStock;
	}
	
	public List<LineItems> getLineitems() {
		return lineitems;
	}

	public void setLineitems(List<LineItems> lineitems) {
		this.lineitems = lineitems;
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

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	
}
