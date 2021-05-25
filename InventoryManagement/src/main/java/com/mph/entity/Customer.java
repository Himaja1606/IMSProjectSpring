package com.mph.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author HIMAJA
 * @version 1.0
 *
 */


@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerId")
	private int customerId;
	
	@Column
	@NotEmpty(message = "customer name cannot be empty")
	@Size(min=5, max=10, message="customer name has to be 5-15 characters long")
	private String customerName;
	
	@Column
	@NotNull(message = "customer phoneno cannot be empty")
	private long customerPhoneno;
	
	@Column
	@Email(message = "customer email should be valid")
	private String customerEmail;
	
	@Column
	@NotEmpty
	@Size(min=5, max=10, message="password has to be 5-15 characters long")
	private String customerPassword;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "orderId", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Orders> orders;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param customerId new customerId
	 * @param customerName new customerName
	 * @param customerPhoneno new customerPhoneno
	 * @param customerEmail new customerEmail
	 * @param customerPassword new customerPassword
	 * @param orders new orders
	 */
	
	
	public Customer(int customerId,
			@NotEmpty(message = "customer name cannot be empty") @NotEmpty(message = "customer name cannot be empty") @Size(min = 5, max = 10, message = "customer name has to be 5-15 characters long") String customerName,
			@NotNull(message = "customer phoneno cannot be empty") long customerPhoneno,
			@Email(message = "customer email should be valid") String customerEmail,
			@NotEmpty @Size(min = 5, max = 10, message = "password has to be 5-15 characters long") String customerPassword,
			List<Orders> orders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhoneno = customerPhoneno;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.orders = orders;
	}
	
	/**
	 * Gets the customer id
	 * @return the customer id
	 */
	public int getCustomerId() {
		return customerId;
	}
	
	
	/**
	 * Sets the customer id
	 * @param  customerId new customerId
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * Get the customer name
	 * @return the customer name
	 */
	
	
	public String getCustomerName() {
		return customerName;
	}
	
	/**
	 * sets the customer name
	 * @param  customerName new customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	/**
	 * Gets the customerPhoneno
	 * @return the customerPhoneno
	 */
	
	public long getCustomerPhoneno() {
		return customerPhoneno;
	}
	
	/**
	 * Sets the customerPhoneno
	 * @param  customerPhoneno new customerPhoneno
	 */
	public void setCustomerPhoneno(long customerPhoneno) {
		this.customerPhoneno = customerPhoneno;
	}
	
	
	/**
	 * Gets the customerEmai
	 * @return the customerEmai
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	/**
	 * Sets the customerEmail
	 * @param customerEmail new customerEmail
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	/**
	 * Gets the customerPassword
	 * @return the customerPassword
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}
	
	/**
	 * Sets the customer Password
	 * @param customerPassword new customerPassword
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	
	/**
	 * Gets the orders 
	 * @return the orders 
	 */
	public List<Orders> getOrders() {
		return orders;
	}
	
	/**
	 * Sets the orders
	 * @param orders new orders
	 */
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPhoneno="
				+ customerPhoneno + ", customerEmail=" + customerEmail + ", customerPassword=" + customerPassword
				+ ", orders=" + orders + "]";
	}
	
	
}