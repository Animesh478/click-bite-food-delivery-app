package com.ClickBites.Model;

public class Restaurant {
	private int restaurantId;
	private String restaurantName;
	private String imagePath;
	private float rating;
	private int deliveryTime;
	private String cuisineType;
	private String address;
	private boolean isActive;
	private int restaurantOwnerId;
	
	public Restaurant() {
		
	}
	
	public Restaurant(int restaurantId, String restaurantName, String imagePath, float rating, int deliveryTime,
			String cuisineType, String address, boolean isActive, int restaurantOwnerId) {
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.imagePath = imagePath;
		this.rating = rating;
		this.deliveryTime = deliveryTime;
		this.cuisineType = cuisineType;
		this.address = address;
		this.isActive = isActive;
		this.restaurantOwnerId = restaurantOwnerId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getRestaurantOwnerId() {
		return restaurantOwnerId;
	}

	public void setRestaurantOwnerId(int restaurantOwnerId) {
		this.restaurantOwnerId = restaurantOwnerId;
	}
	
	
}
