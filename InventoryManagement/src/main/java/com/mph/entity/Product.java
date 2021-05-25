package com.mph.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author VARDHINI
 * @version 1.0
 *
 */


@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	@Column
	private String productName;
	@Column
	private double productPrice;
	@Column
	private int productQuantity;
	@Column
	private String productDescription;
	
	
	/**
	 * 
	 * @param productId new productId
	 * @param productName new productName
	 * @param productPrice new productPrice
	 * @param productQuantity new productQuantity
	 * @param productDescription new productDescription+++++6
	 */
	public Product(int productId, String productName, double productPrice, int productQuantity,
			String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productDescription = productDescription;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Gets the productId
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	
	/**
	 * Sets the productId
	 * @param productId new productId
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	/**
	 * Gets the productName
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * Sets the productName
	 * @param productName new productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	/**
	 * Gets the productPrice
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}
	
	/**
	 * Sets the productPrice
	 * @param productPrice new productPrice
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	/**
	 *  Gets the productQuantity
	 * @return the productQuantity
	 */ 
	public int getProductQuantity() {
		return productQuantity;
	}
	
	/**
	 * Sets the productQuantity
	 * @param productQuantity new productQuantity
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	/**
	 * Gets the productDescription
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}
	
	
	/**
	 * Sets the productDescription
	 * @param productDescription new productDescription
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", productDescription=" + productDescription + "]";
	}
}

	
	