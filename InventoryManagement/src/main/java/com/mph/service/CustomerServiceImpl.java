package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.CustomerDao;
import com.mph.entity.Customer;
import com.mph.exception.DataAlreadyExistsException;
import com.mph.exception.DataNotFoundException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao customerDao;

	@Override
	public void createCustomer(Customer customer) {
		if (getCustomerById(customer.getCustomerId()) != null)
			throw new DataAlreadyExistsException("Customer with ID: " + customer.getCustomerId() + "already exists");
		else
			customerDao.createCustomer(customer);

	}

	@Override
	public List<Customer> getCustomerList() {

		return customerDao.getCustomerList();
	}

	@Override
	public Customer getCustomer(Customer customer) {

		return customerDao.getCustomer(customer);
	}

	@Override
	public List<Customer> updateCustomer(Customer cus) {
		if (getCustomerById(cus.getCustomerId()) == null)
			throw new DataNotFoundException("Customer with ID: " + cus.getCustomerId() + "not found");
		else
			return customerDao.updateCustomer(cus);
	}

	@Override
	public List<Customer> deleteCustomer(int customerId) {
		if (getCustomerById(customerId) == null)
			throw new DataNotFoundException("Customer with ID: " + customerId + "not found");
		else
			return customerDao.deleteCustomer(customerId);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return customerDao.getCustomerById(customerId);
	}

	@Override
	public Customer Customer(int customerId) {
		return customerDao.Customer(customerId);
	}

	@Override
	public Customer getCustomerByEmail(String customerEmail) {
		return customerDao.getCustomerByEmail(customerEmail);
	}
}
