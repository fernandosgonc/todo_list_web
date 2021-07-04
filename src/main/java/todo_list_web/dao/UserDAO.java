package todo_list_web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import todo_list_web.factory.ConnectionFactory;
import todo_list_web.model.User;

public class UserDAO {

	private Connection con;
	
	public UserDAO(Connection con) {
		this.con = con;
	}
	

	public void add(User user) throws SQLException {

		String sql = "insert into user (personal_name, email, login, gender, salt, password) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getLogin());
		ps.setString(4, String.valueOf(user.getGender()));
		ps.setString(5, user.getSalt());
		ps.setString(6, user.getPassword());

		ps.execute();

		if (ps != null) {
			ps.close();
		}

	}

	public User searchById(Integer id) throws SQLException {

		String sql = "select * from user where user_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		User user = null;
		while (rs.next()) {
			user = new User();
			user.setId(Integer.parseInt(rs.getString("user_id")));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setLogin(rs.getString("login"));
			user.setPassword(rs.getString("password"));
			user.setSalt(rs.getString("salt"));
		}

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

		return user;
	}

	public User verifyLogin(User user) throws SQLException {

		String sql = "select * from user where login=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getLogin());
		ps.setString(2, user.getPassword());
		ResultSet rs = ps.executeQuery();

		User u = null;
		while (rs.next()) {
			u = new User();
			u.setId(Integer.parseInt(rs.getString("user_id")));
			u.setName(rs.getString("personal_name"));
			u.setEmail(rs.getString("email"));
			u.setLogin(rs.getString("login"));
			u.setGender(rs.getString("gender").charAt(0));
		}

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

		return u;
	}
	
	public String getSalt(User user) throws SQLException {
		

		String sql = "select salt from user where login=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getLogin());
		ResultSet rs = ps.executeQuery();

		String s = null;
		while (rs.next()) {
			s = rs.getString("salt");
		}

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

		return s;
		
	}

	public void edit(User user) throws SQLException {

		String sql = "update user set name=?, email=?, login=?, password=?, gender=?, salt=? where user_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getLogin());
		ps.setString(4, user.getPassword());
		ps.setString(5, String.valueOf(user.getGender()));
		ps.setString(6, user.getSalt());
		ps.setInt(7, user.getId());

		int rowsAffected = ps.executeUpdate();
		System.out.println(rowsAffected + " rows affected");

		if (ps != null) {
			ps.close();
		}
	}

	public void delete(Integer id) throws SQLException {
		con = ConnectionFactory.getConnection();
		String sql = "delete from user where user_id=?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		int rowsAffected = ps.executeUpdate();
		System.out.println(rowsAffected + " rows affected");

		if (ps != null) {
			ps.close();
		}
	}

	public boolean verifyDisponibility(String email, String login) throws SQLException {

		
		String sql = "select email, login from user where email=? or login=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, login);
		
		ResultSet rs = ps.executeQuery();
		
		boolean isAvailable = true;
		
		if(rs.next()) {
			isAvailable = false;
		}

		if(rs!=null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		
		return isAvailable;
		
	}

}
