package com.ClickBites.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ClickBites.Dao.OrdersDao;
import com.ClickBites.Model.Orders;

public class OrdersDaoImpl implements OrdersDao {
	
	final static String INSERT_QUERY = "INSERT INTO `orders` (`restaurantId`,`userId`,`totalAmount`,`modeOfPayment`,`orderStatus`)"+
	"VALUES (?,?,?,?,?)";
	final static String SELECT_QUERY ="SELECT * FROM `orders` WHERE `orderId` = ?";
	final static String SELECT_ALL_QUERY ="SELECT * FROM `orders`";
	final static String UPDATE_QUERY = "UPDATE `orders` set `restaurantId`=?, `userId`=?, `totalAmount`=?, `modeOfPayment`=?, `orderStatus`=?";
	final static String DELETE_QUERY = "DELETE FROM `orders` WHERE `orderId` = ?";
	
	Connection con;
	
	public OrdersDaoImpl() {
		
		String url = "jdbc:mysql://localhost:3306/food_delivery_app";
		String username = "root";
		String password = "Century@dell96";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrder(Orders order) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			
			pstmt.setInt(1, order.getRestaurantId());
			pstmt.setInt(2, order.getUserId());
			pstmt.setInt(3, order.getTotalAmount());
			pstmt.setString(4, order.getModeOfPayment());
			pstmt.setString(5, order.getOrderStatus());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public void updateOrder(Orders order) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			
			pstmt.setInt(1, order.getRestaurantId());
			pstmt.setInt(2, order.getUserId());
			pstmt.setInt(3, order.getTotalAmount());
			pstmt.setString(4, order.getModeOfPayment());
			pstmt.setString(5, order.getOrderStatus());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrder(int orderId) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			
			pstmt.setInt(1, orderId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Orders getOrder(int orderId) {
		Orders order = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			pstmt = con.prepareStatement(SELECT_QUERY);
			
			pstmt.setInt(1, orderId);
			
			res = pstmt.executeQuery();
			
			if(res.next()) {
				int restaurantId = res.getInt("restaurantId");
				int userId = res.getInt("userId");
				int totalAmount = res.getInt("totalAmount");
				String modeOfPayment = res.getString("modeOfPayment");
				String orderStatus = res.getString("orderStatus");
				
				order = new Orders(orderId, restaurantId, userId, totalAmount, modeOfPayment, orderStatus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
	}

	@Override
	public List<Orders> getAllOrders() {
		List<Orders> ordersList = new ArrayList<>();
		Statement stmt = null;
		ResultSet res = null;
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next()) {
				int orderId = res.getInt("orderId");
				int restaurantId = res.getInt("restaurantId");
				int userId = res.getInt("userId");
				int totalAmount = res.getInt("totalAmount");
				String modeOfPayment = res.getString("modeOfPayment");
				String orderStatus = res.getString("orderStatus");
				
				Orders order = new Orders(orderId, restaurantId, userId, totalAmount, modeOfPayment, orderStatus);
				ordersList.add(order);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}

}
