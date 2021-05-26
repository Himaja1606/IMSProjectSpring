package com.mph.dao;

import java.util.List;

import com.mph.entity.Customer;
import com.mph.entity.Orders;

public interface OrdersDao {
	public void createOrders(Orders orders, int customerId);

	public List<Orders> getOrdersList();

	public Orders getOrders(Orders orders);

	public List<Orders> updateOrders(Orders orders);

	public List<Orders> deleteOrders(int orderId);

	public Orders Orders(int orderId);

	public Orders getOrdersById(int orderid);

	
	
}