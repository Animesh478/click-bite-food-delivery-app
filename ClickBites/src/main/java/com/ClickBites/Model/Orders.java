package com.ClickBites.Model;

public class Orders {
	private int orderId;
	private int restaurantId;
	private int userId;
	private int totalAmount;
	private String modeOfPayment;
	private String orderStatus;
	
	public Orders() {
		
	}
	
	public Orders(int orderId, int restaurantId, int userId, int totalAmount, String modeOfPayment,
			String orderStatus) {

		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
	
	
}


