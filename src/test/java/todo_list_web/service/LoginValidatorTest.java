package todo_list_web.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import todo_list_web.dao.UserDAO;
import todo_list_web.model.User;

public class LoginValidatorTest {

//	@Test
	public void testIsAvailable() {
		
		try {
			boolean av = LoginValidator.isAvailable("gabriela@gmail.com", "gabriel8");
			System.out.println(av);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

//	@Test
	public void testRegister() {
		
		try {
			LoginValidator.register("José", "jose@mail.com", "josefsg", "12345", "O");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
//	@Test
	public void testSignUp() {
		
		String name = "José";
		String email = "jeff@gmail.com";
		String login = "jeff2";
		String password = "12345";
		String gender = "M";
		
		try {
			boolean av = LoginValidator.isAvailable(email, login);
			System.out.println("av:" +av);
			if(av) {
				LoginValidator.register(name, email, login, password, gender);
				System.out.println("saved");
			}else {
				System.out.println("Unavailable");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	

	@Test
	public void authenticateTest() {
		
		String login = "jeff2";
		String password = "123485";
		try {
			User u = LoginValidator.authenticate(login, password);
			System.out.println(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
