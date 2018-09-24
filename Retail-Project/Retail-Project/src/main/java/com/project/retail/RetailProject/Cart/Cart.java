package com.project.retail.RetailProject.Cart;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.retail.RetailProject.lineitem.LineItems;
import com.project.retail.RetailProject.shop.Shop;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private Integer orderId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
	private Shop shops;
	
	
	@OneToMany(
	        mappedBy = "orders", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	private List<LineItems> lineitems = new ArrayList<>();
	
	private String orderDate;
	private String orderTime;
	private Double orderTotal;
	
	public Cart(){
		super();
	}

	public Cart(Integer orderId, Shop shops, String orderDate, String orderTime, Double orderTotal) {
		super();
		this.orderId = orderId;
		this.shops = shops;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.orderTotal = orderTotal;
	}

	public List<LineItems> getLineitems() {
		return lineitems;
	}

	public void setLineitems(List<LineItems> lineitems) {
		this.lineitems = lineitems;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@JsonIgnore
	public Shop getShops() {
		return shops;
	}

	@JsonProperty
	public void setShops(Shop shops) {
		this.shops = shops;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	
}
