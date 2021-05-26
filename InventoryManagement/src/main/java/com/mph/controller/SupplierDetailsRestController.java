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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.mph.entity.Customer;
import com.mph.entity.SupplierDetails;
import com.mph.service.SupplierDetailsService;

/**
 * 
 * @author KARTHIKEYAN
 * @version 1.0
 */
@RestController

@CrossOrigin(origins = "*", allowCredentials = "false", methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*")
public class SupplierDetailsRestController {

	/**
	 * the supplierDetails Service
	 */

	@Autowired
	SupplierDetailsService supplierdetailsService;

	private static final Logger logger = Logger.getLogger("SupplierDetailsRestController.class");

	/**
	 * Gets the supplier details list
	 *
	 * @return the supplier details list
	 */
	@GetMapping("/allsup")
	private ResponseEntity<List<SupplierDetails>> allSupplierDetails() {
		List<SupplierDetails> supplierdetailslist = supplierdetailsService.getSupplierDetailsList();
		PropertyConfigurator
				.configure(SupplierDetailsRestController.class.getClassLoader().getResource("log4j.properties"));

		logger.info("Getting All SupplierDetails");
		System.out.println("supplierdetailslist : " + supplierdetailslist);

		if (supplierdetailslist.isEmpty()) {
			return new ResponseEntity<List<SupplierDetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SupplierDetails>>(supplierdetailslist, HttpStatus.OK);
	}

	/**
	 * Gets the supplier details based on supplierId
	 *
	 * @return the supplier details based on supplierId
	 */
	@GetMapping("/getSupplierDetails/{supplierId}")
	public ResponseEntity<SupplierDetails> getSupplierDetails(@PathVariable("supplierId") int supplierId) {
		logger.info("Getting SupplierDetails with ID : " + supplierId);
		SupplierDetails supplierdetails = supplierdetailsService.getSupplierDetailsById(supplierId);
		return new ResponseEntity<SupplierDetails>(supplierdetails, HttpStatus.OK);
	}

	/**
	 * Create the Supplier
	 *
	 * @param supplierdetails this parameter includes the supplier id of
	 *                        SupplierDetails
	 * 
	 * @return the supplier details
	 */
	@PostMapping("/createsupplierdetails")
	public SupplierDetails createSupplierDetails(@RequestBody SupplierDetails supplierdetails) {
		logger.info("Creating supplier : " + supplierdetails.getSupplierName());

		supplierdetailsService.createSupplierDetails(supplierdetails);
		return supplierdetails;
	}

	/**
	 * Delete the supplier
	 * 
	 * @param supplierdetailsId this parameter includes the supplier id of
	 *                          SupplierDetails that are to be deleted
	 * 
	 * @return the SupplierDetailsList
	 */
	@DeleteMapping("/deletesupplier/{supplierId}")
	public ResponseEntity<List<SupplierDetails>> deleteSupplierDetails(@PathVariable("supplierId") int supplierId) {

		List<SupplierDetails> supplierdetailslist = supplierdetailsService.deleteSupplierDetails(supplierId);
		logger.info("Deleting SupplierDetails : " + supplierId);
		System.out.println("SupplierDetailsList : " + supplierdetailslist);

		if (supplierdetailslist.isEmpty()) {
			return new ResponseEntity<List<SupplierDetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SupplierDetails>>(supplierdetailslist, HttpStatus.OK);
	}

	/**
	 * Update the supplier
	 *
	 * @param supplier this parameter includes the supplier id of SupplierDetails
	 *                 that are to be updated
	 * 
	 * @return SupplierDetailsList
	 */
	@PutMapping("/updatesupplier")
	public ResponseEntity<List<SupplierDetails>> updateSupplierDetails(@RequestBody SupplierDetails supplierdetails) {

		List<SupplierDetails> supplierdetailslist = supplierdetailsService.updateSupplierDetails(supplierdetails);
		System.out.println("SupplierDetailsList : " + supplierdetailslist);
		logger.info("Updating SupplierDetails : " + supplierdetails.getSupplierId());
		if (supplierdetailslist.isEmpty()) {
			return new ResponseEntity<List<SupplierDetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SupplierDetails>>(supplierdetailslist, HttpStatus.OK);
	}

}
