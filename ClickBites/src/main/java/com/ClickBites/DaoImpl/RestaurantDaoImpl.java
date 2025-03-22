package com.ClickBites.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ClickBites.Dao.RestaurantDao;
import com.ClickBites.Model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {
	
	final static String INSERT_QUERY = "INSERT INTO `restaurant` (`restaurantName`,`imagePath`, `rating`,`deliveryTime`,"+
	"`cuisineType`,`address`,`isActive`,`restaurantOwnerId`) VALUES (?,?,?,?,?,?,?,?)";
	
	final static String SELECT_QUERY = "SELECT * FROM `restaurant` WHERE `restaurantId` = ?";
	
	final static String SELECT_ALL_QUERY = "SELECT * FROM `restaurant`";
	
	final static String DELETE_QUERY = "DELETE FROM `restaurant` WHERE `restaurantId` = ?";
	
	final static String UPDATE_QUERY = "UPDATE `restaurant` SET `restaurantName`=?, `imagePath`=?, `rating`=?"+
	", `deliveryTime`=?, `cuisineType`=?, `address`=?, `isActive`=?, `restaurantOwnerId`=?";
	
	Connection connection;
	
	public RestaurantDaoImpl() {
		String url = "jdbc:mysql://localhost:3306/food_delivery_app";
		String username = "root";
		String password = "Century@dell96";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		}

	// Add a new restaurant to the database
	@Override
	public void addRestaurant(Restaurant restaurant) {
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(INSERT_QUERY);
			
			pstmt.setString(1, restaurant.getRestaurantName());
			pstmt.setString(2, restaurant.getImagePath());
			pstmt.setFloat(3, restaurant.getRating());
			pstmt.setInt(4, restaurant.getDeliveryTime());
			pstmt.setString(5, restaurant.getCuisineType());
			pstmt.setString(6, restaurant.getAddress());
			pstmt.setBoolean(7, restaurant.isActive());
			pstmt.setInt(8, restaurant.getRestaurantOwnerId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// Get information about one restaurant
	@Override
	public Restaurant getRestaurant(int restaurantId) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		Restaurant restaurant = null;
		
		try {
			pstmt = connection.prepareStatement(SELECT_QUERY);
			
			pstmt.setInt(1, restaurantId);
			
			res = pstmt.executeQuery();
			
			if(res.next()) {
				String restaurantName = res.getString("restaurantName");
				String imagePath = res.getString("imagePath");
				float rating = res.getFloat("rating");
				int deliveryTime = res.getInt("deliveryTime");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				boolean isActive = res.getBoolean("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");
				
				restaurant = new Restaurant(restaurantId, restaurantName, imagePath, rating, deliveryTime, cuisineType, address, isActive, restaurantOwnerId);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurant;
	}

	// Get the list of all the restaurants in the database
	@Override
	public List<Restaurant> getAllRestaurant() {
		
		Statement stmt = null;
		ResultSet res = null;
		List<Restaurant> restaurantsList = new ArrayList<>();
		Restaurant restaurant = null;
		
		try {
			stmt = connection.createStatement();
			res = stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next()) {
				int restaurantId = res.getInt("restaurantId");
				String restaurantName = res.getString("restaurantName");
				String imagePath = res.getString("imagePath");
				float rating = res.getFloat("rating");
				int deliveryTime = res.getInt("deliveryTime");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				boolean isActive = res.getBoolean("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");
				
				restaurant = new Restaurant(restaurantId, restaurantName, imagePath, rating, deliveryTime, cuisineType, address, isActive, restaurantOwnerId);
				
				restaurantsList.add(restaurant);
				
				
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return restaurantsList;
	}

	// update or make changes to a restaurant
	@Override
	public void updateRestaurant(Restaurant restaurant) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(UPDATE_QUERY);
			
			pstmt.setString(1, restaurant.getRestaurantName());
			pstmt.setString(2, restaurant.getImagePath());
			pstmt.setFloat(3, restaurant.getRating());
			pstmt.setInt(4, restaurant.getDeliveryTime());
			pstmt.setString(5, restaurant.getCuisineType());
			pstmt.setString(6, restaurant.getAddress());
			pstmt.setBoolean(1, restaurant.isActive());
			pstmt.setInt(8, restaurant.getRestaurantOwnerId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// delete a restaurant
	@Override
	public void deleteRestaurant(int restaurantId) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(DELETE_QUERY);
			
			pstmt.setInt(1, restaurantId);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
