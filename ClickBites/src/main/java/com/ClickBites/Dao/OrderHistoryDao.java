package com.ClickBites.Dao;

import java.util.List;

import com.ClickBites.Model.OrderHistory;

public interface OrderHistoryDao {
	void addOrderHistory(OrderHistory orderHistory);
	void updateOrderHistory(OrderHistory orderHistory);
	OrderHistory getOrderHistory(int orderHistoryId);
	List<OrderHistory> getAllOrderHistory();
	void deleteOrderHistory(int orderHistoryId);
}
