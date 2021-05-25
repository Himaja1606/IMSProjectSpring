package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.OrdersDao;
import com.mph.entity.Customer;
import com.mph.entity.Orders;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	OrdersDao ordersDao;

	@Override
	public void createOrders(Orders orders, int customerId) {
		ordersDao.createOrders(orders, customerId);;

	}

	@Override
	public List<Orders> getOrdersList() {

		return ordersDao.getOrdersList();
	}

	@Override
	public Orders getOrders(Orders orders) {

		return ordersDao.getOrders(orders);
	}

	@Override
	public List<Orders> updateOrders(Orders ord) {

		return ordersDao.updateOrders(ord);
	}

	@Override
	public List<Orders> deleteOrders(int ordersId) {

		return ordersDao.deleteOrders(ordersId);
	}

	@Override
	public Orders getOrdersById(int orderId) {
		return ordersDao.getOrdersById(orderId);
	}

	@Override
	public Orders Orders(int ordersId) {
		return ordersDao.Orders(ordersId);
	}

}
