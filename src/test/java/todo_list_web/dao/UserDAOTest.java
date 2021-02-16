package todo_list_web.dao;


import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import todo_list_web.model.Agenda;
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

			dao = new UserDAO();
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
			dao = new UserDAO();
			u = dao.searchById(id);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

		System.out.println(u.toString());
	}

//	@Test
	public void testSearch() {
		String login = "fernandosgonc";
		String password = "";
		User u = null;
		
		UserDAO dao;
		try {
			dao = new UserDAO();
			u = dao.verifyLogin(login, password);
			System.out.println(u);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
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

			dao = new UserDAO();
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

			dao = new UserDAO();
			dao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Test
	public void getSaltTest() {
		
		String login = "jeff2";
		UserDAO dao = new UserDAO();
		try {
			String sal = dao.getSalt(login);
			System.out.println(sal);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	
}
