package com.ClickBites.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ClickBites.Dao.OrderItemDao;
import com.ClickBites.Model.OrderItem;

public class OrderItemDaoImpl implements OrderItemDao {
	
	final static String INSERT_QUERY = "INSERT INTO `orderItem` (`userId`, `menuId`, `itemName`, `rating`, `quantity`, `price`"
			+ ") VALUES (?,?,?,?,?,?)";
	
	final static String SELECT_QUERY = "SELECT * FROM `orderItem` WHERE `orderItemId` = ?";
	
	final static String SELECT_ALL_QUERY = "SELECT * FROM `orderItem`";
	
	final static String UPDATE_QUERY = "UPDATE `orderItem` SET `userId`=?, `menuId`=?, `itemName`=?,"
			+ "`rating`=?, `quantity`=?, `price`=?";
	
	final static String DELETE_QUERY = "DELETE FROM `orderItem` WHERE `orderItemId` = ?";
	
	Connection connection;
	
	public OrderItemDaoImpl() {
		
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

	@Override
	public void addOrderItem(OrderItem orderItem) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(INSERT_QUERY);
			
			pstmt.setInt(1, orderItem.getUserId());
			pstmt.setInt(2, orderItem.getMenuId());
			pstmt.setString(3, orderItem.getItemName());
			pstmt.setFloat(4, orderItem.getRating());
			pstmt.setInt(5, orderItem.getQuantity());
			pstmt.setInt(6, orderItem.getPrice());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public OrderItem selectOrderItem(int orderItemId) {
		OrderItem orderItem = null;
		ResultSet res = null;
		
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(SELECT_QUERY);
			
			pstmt.setInt(1, orderItemId);
			
			res = pstmt.executeQuery();
			
			if(res.next()) {
				int userId = res.getInt("userId");
				int menuId = res.getInt("menuId");
				String itemName = res.getString("itemName");
				float rating = res.getFloat("rating");
				int quantity = res.getInt("quantity");
				int price = res.getInt("price");
				
				orderItem = new OrderItem(orderItemId, userId, menuId, itemName, rating, quantity, price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderItem;
	}

	@Override
	public List<OrderItem> selectAllOrderItems() {
		ResultSet res = null;
		Statement stmt = null;
		
		OrderItem orderItem = null;
		List<OrderItem> orderItemsList = new ArrayList<>();
		
		try {
			stmt = connection.createStatement();
			
			res = stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next()) {
				int orderItemId = res.getInt("orderItemId");
				int userId = res.getInt("userId");
				int menuId = res.getInt("menuId");
				String itemName = res.getString("itemName");
				float rating = res.getFloat("rating");
				int quantity = res.getInt("quantity");
				int price = res.getInt("price");
				
				orderItem = new OrderItem(orderItemId, userId, menuId, itemName, rating, quantity, price);
				orderItemsList.add(orderItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderItemsList;
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(UPDATE_QUERY);
			
			pstmt.setInt(1, orderItem.getUserId());
			pstmt.setInt(2, orderItem.getMenuId());
			pstmt.setString(3, orderItem.getItemName());
			pstmt.setFloat(4, orderItem.getRating());
			pstmt.setInt(5, orderItem.getQuantity());
			pstmt.setInt(6, orderItem.getPrice());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(DELETE_QUERY);
			
			pstmt.setInt(1, orderItemId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
