package com.mph.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Customer;
import com.mph.entity.Orders;

/**
 * 
 * @author VARDHINI
 *
 * @version 1.0
 */
@Repository
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * This method is used to insert orders in database.
	 * 
	 * @param orders Orders object is passed as first parameter to create orders
	 * 
	 */
	@Override
	public void createOrders(Orders orders, int customerId) {
		System.out.println(orders);
		getSession().saveOrUpdate(orders);
		System.out.println("Orders Stored in DB Successfully !!!");

	}

	/**
	 * This method is used to get the orders list from the database.
	 * 
	 * @return list of orders
	 */
	@Override
	public List<Orders> getOrdersList() {
		Query query = getSession().createQuery("select ord from Orders ord");
		List<Orders> catList = query.list();
		return catList;
	}

	/**
	 * This method is used to get the orders from the database.
	 * 
	 * @return orders
	 */

	@Override
	public Orders getOrders(Orders orders) {
		Criteria c = getSession().createCriteria(Orders.class);
		c.add(Restrictions.eq("orderQuantity", orders.getOrderQuantity()));
		Orders cat = (Orders) c.uniqueResult();
		return cat;
	}

	/**
	 * This method is used to update orders in database.
	 * 
	 * @return orders list
	 */
	@Override
	public List<Orders> updateOrders(Orders orders) {
		System.out.println("update");
		getSession().update(orders);
		return getOrdersList();
	}

	/**
	 * This method is used to delete orders in database.
	 * 
	 * @return orders list
	 */
	@Override
	public List<Orders> deleteOrders(int orderId) {
		Query query = getSession().createQuery("delete Orders ord where orderId =:orderId");
		query.setParameter("orderId", orderId);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		return getOrdersList();
	}

	@Override
	public Orders Orders(int orderId) {
		return (Orders) getSession().get(Orders.class, orderId);
	}

	/**
	 * This method is used to get orders based on the specified orderId in database.
	 * 
	 * @return orders list
	 */
	@Override
	public Orders getOrdersById(int orderId) {
		Criteria criteria = getSession().createCriteria(Orders.class);
		criteria.add(Restrictions.eq("orderId", orderId));
		Orders orders = (Orders) criteria.uniqueResult();
		return orders;
	}

}