package com.mph.dao;

import java.util.List;

import com.mph.entity.Customer;

public interface CustomerDao {
	public void createCustomer(Customer customer);

	public List<Customer> getCustomerList();

	public Customer getCustomer(Customer customer);

	public List<Customer> updateCustomer(Customer customer);

	public List<Customer> deleteCustomer(int customerId);

	public Customer Customer(int customerId);

	public Customer getCustomerById(int customerId);
	
	public Customer getCustomerByEmail(String customerEmail);
}