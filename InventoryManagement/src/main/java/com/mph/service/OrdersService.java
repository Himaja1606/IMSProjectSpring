package com.mph.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mph.entity.Orders;

@Service
public interface OrdersService {
	public void createOrders(Orders orders, int customerId);

	public List<Orders> getOrdersList();

	public Orders getOrders(Orders orders);

	public List<Orders> updateOrders(Orders orders);

	public List<Orders> deleteOrders(int ordersId);

	public Orders getOrdersById(int orderId);

	public Orders Orders(int ordersId);

}