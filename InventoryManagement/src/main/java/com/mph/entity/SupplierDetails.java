package com.mph.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 
 * @author KARTHIKEYAN
 * @version 1.0
 *
 */



@Entity
@Table(name = "SupplierDetails")
public class SupplierDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "supplier_Id")
	@NotEmpty(message = "supplier id cannot be empty")
	private int supplierId;
	@NotEmpty(message = "supplier name cannot be empty")
	@Column
	@Size(min = 5, max = 10, message = "supplier name has to be 5-15 characters long")
	private String supplierName;
	@Column
	private int suppliedQuantity;

	public SupplierDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 * @param supplierId new supplierId
	 * @param supplierName new supplierName
	 * @param suppliedQuantity new suppliedQuantity
	 */
	public SupplierDetails(int supplierId, String supplierName, int suppliedQuantity) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.suppliedQuantity = suppliedQuantity;
	}
	
	/**
	 * Gets the supplierId
	 * @return the supplierId
	 */
	public int getSupplierId() {
		return supplierId;
	}
	
	
	/**
	 * Sets the supplierId
	 * @param supplierId new supplierId
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	
	/**
	 * Gets the supplierName
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}
	
	
	/**
	 * Sets the supplierName
	 * @param supplierName new supplierName
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	
	/**
	 * Gets the suppliedQuantity
	 * @return the suppliedQuantity
	 */
	public int getSuppliedQuantity() {
		return suppliedQuantity;
	}
	
	
	
	/**
	 * Sets the suppliedQuantity
	 * @param suppliedQuantity new suppliedQuantity
	 */
	public void setSuppliedQuantity(int suppliedQuantity) {
		this.suppliedQuantity = suppliedQuantity;
	}
	@Override
	public String toString() {
		return "SupplierDetails [supplierId=" + supplierId + ", supplierName=" + supplierName + ", suppliedQuantity="
				+ suppliedQuantity + "]";
	}
}
	