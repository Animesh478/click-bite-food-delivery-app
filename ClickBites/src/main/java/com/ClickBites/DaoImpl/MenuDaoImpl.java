package com.ClickBites.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ClickBites.Dao.MenuDao;
import com.ClickBites.Model.Menu;

public class MenuDaoImpl implements MenuDao {
	
	final static String INSERT_QUERY = "INSERT INTO `menu` (`name`,`price`,`description`,`imagePath`,`isAvailable`,"+
	"`rating`,`restaurantId`) VALUES (?,?,?,?,?,?,?)";
	
	final static String SELECT_QUERY = "SELECT * FROM `menu` WHERE `menuId` = ?";
	
	final static String SELECT_ALL_QUERY = "SELECT * FROM `menu`";
	
	final static String UPDATE_QUERY = "UPDATE `menu` SET `name`=?, `price`=?,`description`=?,`imagePath`=?,`isAvailable`"+
	"`rating`=?,`restaurantId`=?";
	
	final static String DELETE_QUERY = "DELETE FROM `menu` WHERE `menuId`=?";
	
	Connection connection;
	
	public MenuDaoImpl() {
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
	public void addMenu(Menu menu) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(INSERT_QUERY);
			
			pstmt.setString(1, menu.getName());
			pstmt.setInt(2, menu.getPrice());
			pstmt.setString(3, menu.getDescription());
			pstmt.setString(4, menu.getImagePath());
			pstmt.setBoolean(5, menu.isAvailable());
			pstmt.setFloat(6, menu.getRating());
			pstmt.setInt(7, menu.getRestaurantId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Menu getMenu(int menuId) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Menu menu = null;
		
		try {
			pstmt = connection.prepareStatement(SELECT_QUERY);
			
			pstmt.setInt(1, menuId);
			
			res = pstmt.executeQuery();
			
			if(res.next()) {
				String name = res.getString("name");
				int price = res.getInt("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				boolean isAvailable = res.getBoolean("isAvailable");
				float rating = res.getFloat("rating");
				int restaurantId = res.getInt("restaurantId");
				
				menu = new Menu(menuId, name, price, description, imagePath, isAvailable, rating, restaurantId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menu;
	}

	@Override
	public List<Menu> getAllMenu() {
		List<Menu> menuList = new ArrayList<>();
		Menu menu = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			stmt = connection.createStatement();
			
			res = stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next()) {
				int menuId = res.getInt("menuId");
				String name = res.getString("name");
				int price = res.getInt("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				boolean isAvailable = res.getBoolean("isAvailable");
				float rating = res.getFloat("rating");
				int restaurantId = res.getInt("restaurantId");
				
				menu = new Menu(menuId, name, price, description, imagePath, isAvailable, rating, restaurantId);
				menuList.add(menu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menuList;
	}

	@Override
	public void updateMenu(Menu menu) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(UPDATE_QUERY);
			
			pstmt.setString(1, menu.getName());
			pstmt.setInt(2, menu.getPrice());
			pstmt.setString(3, menu.getDescription());
			pstmt.setString(4, menu.getImagePath());
			pstmt.setBoolean(5, menu.isAvailable());
			pstmt.setFloat(6, menu.getRating());
			pstmt.setInt(7, menu.getRestaurantId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMenu(int menuId) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = connection.prepareStatement(DELETE_QUERY);
			
			pstmt.setInt(1, menuId);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
