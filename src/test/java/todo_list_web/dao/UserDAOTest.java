package todo_list_web.dao;


import java.sql.Connection;
import java.sql.SQLException;

import todo_list_web.factory.ConnectionFactory;
import todo_list_web.model.User;
import todo_list_web.util.BCrypt;

public class UserDAOTest {

	public void testAdd() {

		String salt = BCrypt.gensalt();

		User u = new User();
		u.setName("Marina");
		u.setEmail("marinagata@gmail.com");
		u.setLogin("Marinar");
		u.setPassword(BCrypt.hashpw("vasodeflor", salt));
		u.setSalt(salt);
		u.setGender('F');

		UserDAO dao;
		try {
			Connection con = ConnectionFactory.getConnection();
			dao = new UserDAO(con);
			dao.add(u);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void testSearchById() {

		int id = 6;

		User u = null;

		UserDAO dao;
		try {
			Connection con = ConnectionFactory.getConnection();
			dao = new UserDAO(con);
			u = dao.searchById(id);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

		System.out.println(u.toString());
	}

	
	public void testEdit() {
		String salt = BCrypt.gensalt();

		User u = new User();
		u.setName("Maria Silva");
		u.setEmail("mariaslv@gmail.com");
		u.setLogin("mariaslv");
		u.setPassword(BCrypt.hashpw("vasodeflor", salt));
		u.setSalt(salt);
		u.setGender('F');
		u.setId(2);

		UserDAO dao;
		try {
			Connection con = ConnectionFactory.getConnection();
			dao = new UserDAO(con);
			dao.edit(u);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}
	

	public void testDelete() {
		int id = 2;
		
		UserDAO dao;
		try {
			Connection con = ConnectionFactory.getConnection();
			dao = new UserDAO(con);
			dao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	
	
}
