package com.ClickBites.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ClickBites.Dao.UserDao;
import com.ClickBites.Model.User;

public class UserDaoImpl implements UserDao {

	final static String INSERT_QUERY = "INSERT INTO `user` (`name`,`email`, `phoneNumber`, `address`,`username`,`password`,`role`)"
			+ "VALUES (?,?,?,?,?,?,?)";

	final static String SELECT_QUERY = "SELECT * FROM `user` WHERE `userId` = ?";

	final static String UPDATE_QUERY = "UPDATE `user` SET `name`=?, `email`=?, `phoneNumber`=?, `address`=?"
			+ "`userName`=?, `password`=?, `role`=? WHERE `userId` = ?";

	final static String DELETE_QUERY = "DELETE FROM `user` WHERE `userId`=?";

	final static String SELECT_ALL_QUERY = "SELECT * FROM `user`";

	private Connection con;

//	Constructor
	public UserDaoImpl() {
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

//	Methods
	@Override
	public void addUser(User user) {

		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhoneNumber());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getUserName());
			pstmt.setString(6, user.getPassword());
			pstmt.setString(7, user.getRole());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(int userId) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		User user = null;

		try {
			pstmt = con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, userId);

			res = pstmt.executeQuery();

			if (res.next()) {
				String name = res.getString("name");
				String email = res.getString("email");
				String phoneNumber = res.getString("phoneNumber");
				String address = res.getString("address");
				String username = res.getString("username");
				String password = res.getString("password");
				String role = res.getString("role");
				LocalDateTime createdDate = (res.getTimestamp("createdDate")).toLocalDateTime();
				LocalDateTime lastLogin = (res.getTimestamp("lastLogin")).toLocalDateTime();
				user = new User(userId, name, email, phoneNumber, address, username, password, role, createdDate,
						lastLogin);
			}

			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAllUser() {
		Statement stmt = null;
		ResultSet res = null;
		User user = null;
		List<User> usersList = new ArrayList<>();

		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {
				int userId = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				String phoneNumber = res.getString("phoneNumber");
				String address = res.getString("address");
				String username = res.getString("username");
				String password = res.getString("password");
				String role = res.getString("role");
				LocalDateTime createdDate = (res.getTimestamp("createdDate")).toLocalDateTime();
				LocalDateTime lastLogin = (res.getTimestamp("lastLogin")).toLocalDateTime();
				user = new User(userId, name, email, phoneNumber, address, username, password, role, createdDate,
						lastLogin);

				usersList.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usersList;
	}

	@Override
	public void updateUser(User user) {
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhoneNumber());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getUserName());
			pstmt.setString(6, user.getPassword());
			pstmt.setString(7, user.getRole());
			pstmt.setInt(8, user.getUserId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int id) {
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(DELETE_QUERY);

			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
