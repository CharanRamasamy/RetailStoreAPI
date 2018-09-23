package com.project.retail.RetailProject.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.project.retail.RetailProject.Cart.Cart;
import com.project.retail.RetailProject.product.Product;

@Entity
public class Shop {
	@Id
	@GeneratedValue
	private Integer shopId;
	private String shopName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String province;
	private String country;
	private String postalcode;
	private String phone;
	
	@OneToMany(
	        mappedBy = "shops", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	private List<Product> products = new ArrayList<>();
	
	@OneToMany(
	        mappedBy = "shops", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	private List<Cart> orders = new ArrayList<>();
	
	
	public Shop() {
		super();
	}

	public Shop(Integer shopId, String shopName, String city, String country, String province, String postalcode,
			String phone, String addressLine1, String addressLine2) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.city = city;
		this.country = country;
		this.province = province;
		this.postalcode = postalcode;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}

	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

}
