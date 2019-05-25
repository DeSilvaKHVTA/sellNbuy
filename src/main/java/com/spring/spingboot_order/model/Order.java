package com.spring.spingboot_order.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Order")
@EntityListeners(AuditingEntityListener.class)


public class Order {

/***********Attributes***********/	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderId;
	
	@NotBlank
	private String productCode;
	
	@NotBlank
	private float price;
	
	@NotBlank
	private int qty;
	
	@NotBlank
	private String buyerAddress;

	@NotBlank
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date addDate;
	
	
/***********Methods***********/	
	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
		
}
