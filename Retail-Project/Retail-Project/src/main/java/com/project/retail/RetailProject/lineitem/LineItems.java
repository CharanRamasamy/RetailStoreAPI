package com.project.retail.RetailProject.lineitem;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.retail.RetailProject.Cart.Cart;
import com.project.retail.RetailProject.product.Product;

@Entity
public class LineItems {
	@Id
	@GeneratedValue
	private Integer itemId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
	private Cart orders;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
	private Product products;
	
	private Integer itemQuantity;
	private Double itemTotal;
	
	public LineItems(){
		super();
	}

	public LineItems(Integer itemId, Cart orders, Product products, Integer itemQuantity, Double itemTotal) {
		super();
		this.itemId = itemId;
		this.orders = orders;
		this.products = products;
		this.itemQuantity = itemQuantity;
		this.itemTotal = itemTotal;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@JsonIgnore
	public Cart getOrders() {
		return orders;
	}

	@JsonProperty
	public void setOrders(Cart orders) {
		this.orders = orders;
	}

	@JsonIgnore
	public Product getProducts() {
		return products;
	}

	@JsonProperty
	public void setProducts(Product products) {
		this.products = products;
	}

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(Double itemTotal) {
		this.itemTotal = itemTotal;
	}
	
	
}
