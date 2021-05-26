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
import com.mph.service.CustomerService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author HIMAJA
 * @version 1.0
 *
 */
@RestController
@CrossOrigin(origins = "*", allowCredentials = "false", methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*")
@RequestMapping("/api")
@EnableSwagger2
public class CustomerRestController {
	

	/**
	 * customer service
	 */
	
	@Autowired
	private CustomerService customerService;
	
	private static final Logger logger = Logger.getLogger("CustomerRestController.class");


	/**
	 * Gets the customer list
	 * 
	 * @return  returns the customer list
	 */
	@GetMapping("/allcus")
	public ResponseEntity<List<Customer>> allCustomer() {
		 List<Customer> customerlist = customerService.getCustomerList();
		PropertyConfigurator.configure(CustomerRestController.class.getClassLoader().getResource("log4j.properties"));

		 System.out.println("Customer : " + customerlist);
		 logger.info("Getting All Customers");

		 if(customerlist.isEmpty())
		 {
			 return new ResponseEntity<List<Customer>> (HttpStatus.NO_CONTENT);
		 }
		 return new ResponseEntity<List<Customer>> (customerlist,HttpStatus.OK);
	}
	/**
	 * Gets the Customer 
	 * 
	 * @param customerId this parameter includes the customer id of customer
	 *  
	 * @return customer 
	 */
	@GetMapping("/getCustomer/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") int customerId) {
		logger.info("Getting Customer with ID : " + customerId);
	
	{
		Customer customer=customerService.getCustomerById(customerId);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	}
	/**
	 * creates the customer
	 * 
	 * @param customer this parameter includes the customer
	 * 
	 * @return customer
	 */
	@PostMapping("/createcustomer")
	public  Customer createCustomer(@RequestBody Customer customer){
		logger.info("Creating customer : " + customer.getCustomerName());
	{
		customerService.createCustomer(customer);
		return customer;
	}
	}
	/**
	 * Deletes the customer
	 * 
	 * @param customerId this parameter includes the customer id of customer that to be deleted
	
	 * @return customer list
	 */
	@DeleteMapping("/deletecus/{customerId}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("customerId") int customerId) {

		List<Customer> customerlist = customerService.deleteCustomer(customerId);
		logger.info("Deleting Customer : " + customerId);
		System.out.println("CustomerList : " + customerlist);

		if (customerlist.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(customerlist, HttpStatus.OK);
	}
	/**
	 * update the customer 
	 * @param customer this parameter includes the customer list of customer that to be updated
	 * @return customer
	 */
	@PutMapping("/updatecustomer")
	public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer cus) {

		List<Customer> customerlist = customerService.updateCustomer(cus);
		logger.info("Updating Customer : " + cus.getCustomerId());
		System.out.println("CustomerList : " + customerlist);

		if (customerlist.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(customerlist, HttpStatus.OK);
	}
	/**
	 * updates the customer based on the emailId parameter 
	 * @param customer this parameter includes the customer that matches the emailId
	 * @return customer
	 */
	@GetMapping("/getcustomer/{customerEmail}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerEmail") String customerEmail) {
		System.out.println(customerEmail); 
		logger.info("Getting Customer with Email : " + customerEmail);
		Customer customer = customerService.getCustomerByEmail(customerEmail);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
}