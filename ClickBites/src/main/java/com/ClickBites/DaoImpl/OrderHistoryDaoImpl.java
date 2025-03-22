package com.ClickBites.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;	
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ClickBites.Dao.OrderHistoryDao;
import com.ClickBites.Model.OrderHistory;

public class OrderHistoryDaoImpl implements OrderHistoryDao {
	
	final static String INSERT_QUERY = "INSERT INTO `orderHistory` (`userId`, `orderId`) VALUES (?, ?)";
	
	final static String UPDATE_QUERY = "UPDATE TABLE `orderHistory` SET `userId`=?, `orderId`=?";
	
	final static String SELECT_QUERY = "SELECT * FROM `orderHistory` WHERE `orderHistoryId` = ?";
	
	final static String SELECT_ALL_QUERY = "SELECT * FROM `orderHistory`";
	
	final static String DELETE_QUERY = "DELETE FROM `orderHistory` WHERE `orderHistoryId` = ?";
	
	Connection connection;
	
	public OrderHistoryDaoImpl() {
		
		String url = "jdbc:mysql://localhost:3306/food_delivery_app";
		String username = "root";
		String password = "Century@dell96";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addOrderHistory(OrderHistory orderHistory) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(INSERT_QUERY);
			
			pstmt.setInt(1, orderHistory.getUserId());
			pstmt.setInt(2, orderHistory.getOrderId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(UPDATE_QUERY);
			
			pstmt.setInt(1, orderHistory.getUserId());
			pstmt.setInt(2, orderHistory.getOrderId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		OrderHistory orderHistory = null;
		
		try {
			pstmt = connection.prepareStatement(SELECT_QUERY);
			
			pstmt.setInt(1, orderHistoryId);
			
			res = pstmt.executeQuery();
			
			if(res.next()) {
				int userId = res.getInt("userId");
				int orderId = res.getInt("orderId");
				
				orderHistory = new OrderHistory(orderHistoryId, userId, orderId);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderHistory;
	}

	@Override
	public List<OrderHistory> getAllOrderHistory() {
		Statement stmt = null;
		ResultSet res = null;
		
		OrderHistory orderHistory = null;
		List<OrderHistory> orderHistoryList = new ArrayList<>();
		
		try {
			stmt = connection.createStatement();
			
			res = stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next()) {
				int orderHistoryId = res.getInt("orderHistoryId");
				int userId = res.getInt("userId");
				int orderId = res.getInt("orderId");
				
				orderHistory = new OrderHistory(orderHistoryId, userId, orderId);
				orderHistoryList.add(orderHistory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderHistoryList;
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(DELETE_QUERY);
			
			pstmt.setInt(1, orderHistoryId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
