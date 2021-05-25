package com.mph.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * 
 * @author KEERTHI
 * @version 1.0
 *
 */



@Entity
@Table(name = "WareHouse")
public class WareHouse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inventory_Id")
	@NotEmpty(message = "inventory id cannot be empty")
	private int inventoryId;
	@Column
	@NotEmpty(message = "inventory received cannot be empty")
	private int inventoryReceived;
	@Column
	@NotEmpty(message = "inventory shipped cannot be empty")
	private int inventoryShipped;
	@Column
	@NotEmpty(message = "inventory onhand cannot be empty")
	private int inventoryOnhand;
	public WareHouse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 * @param inventoryId new inventoryId
	 * @param inventoryReceived new inventoryReceived
	 * @param inventoryShipped new inventoryShipped
	 * @param inventoryOnhand new inventoryOnhand
	 */
	public WareHouse(int inventoryId, int inventoryReceived, int inventoryShipped, int inventoryOnhand) {
		super();
		this.inventoryId = inventoryId;
		this.inventoryReceived = inventoryReceived;
		this.inventoryShipped = inventoryShipped;
		this.inventoryOnhand = inventoryOnhand;
	}
	
	
	/**
	 * Gets the inventoryId
	 * @return the inventoryId
	 */
	public int getInventoryId() {
		return inventoryId;
	}
	
	
	/**
	 * Sets the inventoryId
	 * @param inventoryId new inventoryId
	 */
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	
	/**
	 * Gets the inventoryReceived
	 * @return the inventoryReceived
	 */
	public int getInventoryReceived() {
		return inventoryReceived;
	}
	
	
	/**
	 * Sets the inventoryReceived
	 * @param inventoryReceived new inventoryReceived
	 */
	public void setInventoryReceived(int inventoryReceived) {
		this.inventoryReceived = inventoryReceived;
	}
	
	
	/**
	 * Gets the inventoryShipped
	 * @return the inventoryShipped
	 */
	public int getInventoryShipped() {
		return inventoryShipped;
	}
	
	
	/**
	 * Sets the inventoryShipped
	 * @param inventoryShipped new inventoryShipped
	 */
	public void setInventoryShipped(int inventoryShipped) {
		this.inventoryShipped = inventoryShipped;
	}
	
	
	/**
	 * Gets the inventoryOnhand
	 * @return the inventoryOnhand
	 */
	public int getInventoryOnhand() {
		return inventoryOnhand;
	}
	
	
	/**
	 * Sets the inventoryOnhand
	 * @param inventoryOnhand new inventoryOnhand
	 */
	public void setInventoryOnhand(int inventoryOnhand) {
		this.inventoryOnhand = inventoryOnhand;
	}
	@Override
	public String toString() {
		return "WareHouse [inventoryId=" + inventoryId + ", inventoryReceived=" + inventoryReceived
				+ ", inventoryShipped=" + inventoryShipped + ", inventoryOnhand=" + inventoryOnhand + "]";
	}
	
}