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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.mph.entity.Customer;
import com.mph.entity.Orders;
import com.mph.service.CustomerService;
import com.mph.service.OrdersService;

/**
 * 
 * @author VARDHINI
 * @version 1.0
 *
 */
@RestController

@CrossOrigin(origins = "*", allowCredentials = "false", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*")
public class OrdersRestController {

	Orders ord;
	/**
	 * the Orders service
	 */
	@Autowired
	OrdersService ordersService;
	/**
	 * the Customer service
	 */
	@Autowired
	CustomerService customerService;
	private static final Logger logger = Logger.getLogger("OrdersRestController.class");

	/**
	 * Gets the orders list
	 * 
	 * @return the orders list
	 */
	@GetMapping("/allord")
	public ResponseEntity<List<Orders>> allOrders() {

		List<Orders> orderslist = ordersService.getOrdersList();
		PropertyConfigurator.configure(CustomerRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("orders List : " + orderslist);
		logger.info("Getting All Orders");

		if (orderslist.isEmpty()) {
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(orderslist, HttpStatus.OK);

	}

	/**
	 * Gets the orders with specified customerId
	 * 
	 * @param orderId this parameter includes the order id of orders
	 * 
	 * @return orders with specified customerId
	 */
	@GetMapping("/getOrders/{orderId}")
	public ResponseEntity<Orders> getOrders(@PathVariable("orderId") int orderId) {
		logger.info("Getting Orders with ID : " + orderId);
		{
			Orders orders = ordersService.getOrdersById(orderId);
			return new ResponseEntity<Orders>(orders, HttpStatus.OK);
		}
	}

	/**
	 * create the orders
	 * 
	 * @param orders     this parameter includes the orders id of orders
	 * 
	 * @param customerId this parameter includes the customer id of customer
	 * 
	 * @return orders with specified customerId
	 */
	@PostMapping("/createord/{customerId}")
	public Orders createOrders(@RequestBody Orders orders, @PathVariable("customerId") int customerId) {
		logger.info("Creating Orders : " + orders.getOrderId());
		Customer customer = customerService.getCustomerById(customerId);
		orders.setCustomer(customer);
		System.out.println(orders);
		ordersService.createOrders(orders, customerId);
		return orders;
	}

	/**
	 * Delete the orders
	 *
	 * @param orderId this parameter includes the orderId of orders
	 * 
	 * @return orders list
	 */
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<List<Orders>> deleteOrders(@PathVariable("id") int orderId) {

		List<Orders> orderslist = ordersService.deleteOrders(orderId);
		System.out.println("Orders List : " + orderslist);
		logger.info("Deleting orders : " + orderId);

		if (orderslist.isEmpty()) {
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(orderslist, HttpStatus.OK);

	}

	/**
	 * update the orders
	 *
	 * @param ord this parameter includes the order id of orders
	 * 
	 * @return orders list
	 */
	@PutMapping("/updateOrders")
	public ResponseEntity<List<Orders>> updateOrders(@RequestBody Orders ord) {

		List<Orders> orderslist = ordersService.updateOrders(ord);
		System.out.println("Orders List : " + orderslist);
		logger.info("Updating Orders : " + ord.getOrderId());

		if (orderslist.isEmpty()) {
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(orderslist, HttpStatus.OK);

	}

}