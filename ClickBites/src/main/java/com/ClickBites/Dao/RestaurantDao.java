package com.ClickBites.Dao;

import java.util.List;

import com.ClickBites.Model.Restaurant;

public interface RestaurantDao {
	public void addRestaurant(Restaurant restaurant);
	public Restaurant getRestaurant(int restaurantId);
	public List<Restaurant> getAllRestaurant();
	public void updateRestaurant(Restaurant restaurant);
	public void deleteRestaurant(int restaurantId);
}
