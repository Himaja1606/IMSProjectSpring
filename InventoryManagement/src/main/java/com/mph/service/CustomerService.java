package com.mph.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mph.entity.Customer;

@Service
public interface CustomerService {
	public void createCustomer(Customer customer);

	public List<Customer> getCustomerList();

	public Customer getCustomer(Customer customer);

	public List<Customer> updateCustomer(Customer customer);

	public List<Customer> deleteCustomer(int customerId);

	public Customer Customer(int customerId);

	public Customer getCustomerById(int customerId);

	public Customer getCustomerByEmail(String customerEmail);

}