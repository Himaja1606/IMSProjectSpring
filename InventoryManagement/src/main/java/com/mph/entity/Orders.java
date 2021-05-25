package com.mph.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author VARDHINI
 * @version 1.0
 *
 */

@Entity
@Table(name = "Orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_Id")
	@NotEmpty(message = "order id cannot be empty")
	private int orderId;
	@Column
	private String orderDate;
	@Column
	@NotEmpty(message = "order quantity cannot be empty")
	private int orderQuantity;
	@Column
	@NotEmpty(message = "order price cannot be empty")
	private double orderPrice;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 * @param orderId new orderId
	 * @param orderDate new orderDate
	 * @param orderQuantity new orderQuantity
	 * @param orderPrice new orderPrice
	 * @param customer new customer
	 */
	public Orders(int orderId, String orderDate, int orderQuantity, double orderPrice, Customer customer) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
		this.customer = customer;
	}
	
	
	/**
	 * Gets the orderId
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	
	
	/**
	 * Sets the orderId
	 * @param orderId new orderId
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	/**
	 * Gets the orderDate
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}
	
	/**
	 *  Sets the orderDate
	 * @param orderDate new orderDate
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
	/**
	 * Gets the orderQuantity
	 * @return the orderQuantity
	 */
	public int getOrderQuantity() {
		return orderQuantity;
	}
	
	
	/** 
	 * Sets the orderQuantity
	 * @param orderQuantity new orderQuantity
	 */
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	
	/**
	 * Gets the orderPrice
	 * @return the orderPrice
	 */
	public double getOrderPrice() {
		return orderPrice;
	}
	
	
	/**
	 * Sets the orderPrice
	 * @param orderPrice new orderPrice
	 */
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	
	/**
	 * Gets the customer
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	
	/**
	 * Sets the customer
	 * @param customer new customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", orderQuantity=" + orderQuantity
				+ ", orderPrice=" + orderPrice + ", customer=" + customer + "]";
	}
	
}