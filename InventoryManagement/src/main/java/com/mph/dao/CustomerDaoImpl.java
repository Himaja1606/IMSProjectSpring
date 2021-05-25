package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.mph.entity.Customer;

/**
 * 
 * @author HIMAJA
 * @version 1.0
 * 
 */
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * This method is used to create Customer table in database.
	 * 
	 * @param customer This is the first parameter to createCustomer method
	 * 
	 */

	public void createCustomer(Customer customer) {
		getSession().saveOrUpdate(customer);
		System.out.println("Customer Stored in DB Successfully !!!");

	}

	/**
	 * This method is used to get customer list from database.
	 *
	 * @return list of customer
	 */

	public List<Customer> getCustomerList() {
		Query query = getSession().createQuery("select ce from Customer ce");
		List<Customer> cusList = query.list();
		return cusList;

	}

	/**
	 * This method is used to get single customer record from database.
	 *
	 * @return customer
	 */
	public Customer getCustomer(Customer customer) {
		Criteria c = getSession().createCriteria(Customer.class);
		c.add(Restrictions.eq("customerEmail", customer.getCustomerEmail()));
		c.add(Restrictions.eq("customerPassword", customer.getCustomerPassword()));
		Customer cus = (Customer) c.uniqueResult();
		return cus;

	}

	/**
	 * This method is used to update customer record in database.
	 * 
	 * @return list of customer
	 */
	public List<Customer> updateCustomer(Customer customer) {
		Query query = getSession().createQuery(
				"update Customer ce set customerName=:customerName,customerPhoneno=:customerPhoneno,customerEmail=:customerEmail where customerId =:customerId");
		query.setParameter("customerId", customer.getCustomerId());
		query.setParameter("customerName", customer.getCustomerName());
		query.setParameter("customerPhoneno", customer.getCustomerPhoneno());
		query.setParameter("customerEmail", customer.getCustomerEmail());

		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + "rows. ");
		}
		return getCustomerList();
	}

	/**
	 * This method is used to delete customer record in database.
	 * 
	 * @return list of customer
	 */
	public List<Customer> deleteCustomer(int customerId) {
		Query query = getSession().createQuery("delete Customer ce where customerId=:customerId");
		query.setParameter("customerId", customerId);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}

		return getCustomerList();
	}

	@Override
	public Customer Customer(int customerId) {
		return (Customer) getSession().get(Customer.class, customerId);
	}

	/**
	 * This method is used to get the customer record from database based on
	 * customerId
	 * 
	 * @return customer with specified customerId
	 */
	public Customer getCustomerById(int customerId) {
		Criteria criteria = getSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("customerId", customerId));
		Customer customer = (Customer) criteria.uniqueResult();
		return customer;
	}

	/**
	 * This method is used to get the customer record from database based on
	 * customerEmail
	 * 
	 * @return customer with specified customerEmail
	 */
	public Customer getCustomerByEmail(String customerEmail) {
		Criteria criteria = getSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("customerEmail", customerEmail));
		Customer customer = (Customer) criteria.uniqueResult();
		System.out.println(customer);
		return customer;
	}
}