package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mph.entity.Customer;
import com.mph.service.CustomerService;

@Controller
public class CustomerController {

	Customer customer;

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView sigin() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView sigup(@RequestParam("txtcustomerName") String customerName,
			@RequestParam("customerPhoneno") long customerPhoneno,
			@RequestParam("txtcustomerEmail") String customerEmail,
			@RequestParam("txtcustomerPassword") String customerPassword) {

		System.out.println(customerName + " " + customerPhoneno + customerEmail);
		customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setCustomerPhoneno(customerPhoneno);
		customer.setCustomerEmail(customerEmail);
		customer.setCustomerPassword(customerPassword);
		customerService.createCustomer(customer);

		return new ModelAndView("login");
	}

	public ModelAndView allCustomer() {
		List<Customer> li = customerService.getCustomerList();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("cuslist", li);
		return mv;
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signin(@RequestParam("txtemail") String Email, @RequestParam("txtpassword") String Password) {

		customer = new Customer();
		customer.setCustomerEmail(Email);
		customer.setCustomerPassword(Password);

		Customer cus = customerService.getCustomer(customer);
		if (cus == null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("msg", "Customer Not Found !!!");
			return mv;
		} else {
			return allCustomer();
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(Customer customer) {
		List<Customer> cuslist = customerService.deleteCustomer(customer.getCustomerId());

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("cuslist", cuslist);
		return mv;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editcustomer(Customer customer) {
		return new ModelAndView("edit");

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute Customer customer) {
		customerService.updateCustomer(customer);
		return allCustomer();

	}

}