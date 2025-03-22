package com.ClickBites.Dao;

import java.util.List;

import com.ClickBites.Model.OrderItem;

public interface OrderItemDao {
	void addOrderItem(OrderItem orderItem);
	OrderItem selectOrderItem(int orderItemId);
	List<OrderItem> selectAllOrderItems();
	void updateOrderItem(OrderItem orderItem);
	void deleteOrderItem(int orderItemId);
	
}
