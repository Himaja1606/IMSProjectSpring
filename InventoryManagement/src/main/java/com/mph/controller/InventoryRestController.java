package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mph.entity.WareHouse;
import com.mph.service.WareHouseService;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author KEERTHI
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = "*", allowCredentials = "false", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*")
public class InventoryRestController {

	/**
	 * WareHouse Service
	 */
	@Autowired
	WareHouseService warehouseService;
	WareHouse ware;

	private static final Logger logger = Logger.getLogger("InventoryRestController.class");
	

    /**
     * Gets the inventory List
     *
     * @return the inventory List
     */
	 @GetMapping("/allware")
	    public  ResponseEntity<List<WareHouse>> allWareHouse() {
	         List<WareHouse> warehouselist = warehouseService.getWareHouseList();
	         PropertyConfigurator.configure(SupplierDetailsRestController.class.getClassLoader().getResource("log4j.properties"));

		logger.info("Getting All SupplierDetails");
	         System.out.println("warehouse List : " + warehouselist);
	        
	        if(warehouselist.isEmpty())
	        {
	            return new ResponseEntity<List<WareHouse>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<WareHouse>>(warehouselist,HttpStatus.OK);
	        
	    }
	 /**
	     * Gets the warehouse  
	     * 
	     * @param inventoryId this parameter includes the  inventoryId of warehouse that is to be retrieved
	     * 
	     * @return the inventory details with specified inventoryId
	     */
	    
	    @GetMapping("/getWareHouse/{inventoryId}")
		public ResponseEntity<WareHouse> getWareHouse(@PathVariable("inventoryId") int inventoryId)
		{
			logger.info("Getting WareHouse with ID : " + inventoryId);

			WareHouse warehouse=warehouseService.getWareHouseById(inventoryId);
			return new ResponseEntity<WareHouse>(warehouse,HttpStatus.OK);
		}

	    /**
	     *  creates the inventory
	     * @param warehouse this parameter includes the  inventoryId of warehouse
	     * @return the inventory details 
	     */
	@PostMapping("/createinventory")
	public WareHouse createWareHouse(@RequestBody WareHouse warehouse) {
		// Product product = warehousedao.getproduct(pid);
		// warehousedao.setproductid(id);
		System.out.println(warehouse);
		logger.info("Creating warehouse : " + warehouse.getInventoryId());
		warehouseService.createWareHouse(warehouse);
		return warehouse;
	}
	/**
	 * Delete the inventoryId
	 * @param inventoryId this parameter includes the  inventoryId that can be deleted
	 * @return the inventoryId
	 */
	@DeleteMapping("/deleteware/{inventoryId}")
	public ResponseEntity<List<WareHouse>> deleteWareHouse(@PathVariable("id") int inventoryId) {

		List<WareHouse> warehouselist = warehouseService.deleteWareHouse(inventoryId);
		System.out.println("WareHouse List : " + warehouselist);
		logger.info("Deleting WareHouse : " + inventoryId);
		if (warehouselist.isEmpty()) {
			return new ResponseEntity<List<WareHouse>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<WareHouse>>(warehouselist, HttpStatus.OK);

	}
	/**
	 * updates the Warehouse
	 *
	 * @param ware this parameter includes the  warehouse list  that can be updated
	 * 
	 * @return the Warehouse
	 */
	@PutMapping("/updatewarehouse")
	public ResponseEntity<List<WareHouse>> updateWareHouse(@RequestBody WareHouse ware) {

		List<WareHouse> warehouselist = warehouseService.updateWareHouse(ware);
		System.out.println("WareHouse List : " + warehouselist);
		logger.info("Updating WareHouse : " + ware.getInventoryId());
		if (warehouselist.isEmpty()) {
			return new ResponseEntity<List<WareHouse>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<WareHouse>>(warehouselist, HttpStatus.OK);

	}

}
