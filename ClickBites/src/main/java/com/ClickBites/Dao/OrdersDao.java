package com.ClickBites.Dao;

import java.util.List;

import com.ClickBites.Model.Orders;

public interface OrdersDao {
	void addOrder(Orders order);
	void updateOrder(Orders order);
	void deleteOrder(int orderId);
	Orders getOrder(int orderId);
	List<Orders> getAllOrders();
}
