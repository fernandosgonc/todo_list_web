package todo_list_web.service;

import java.sql.SQLException;

import todo_list_web.dao.UserDAO;
import todo_list_web.model.User;
import todo_list_web.util.BCrypt;

public class LoginValidator {
	
//	SIGN UP
//	pega dados do form 
//	verifica se email e login estao disponiveis (unicos no DB)
//	estando livre: passa a senha pelo HASH e realiza o insert 
//	caso realizado o insert, realiza o login
//	estando ocupado: retorna para o controller mensagem de erro 
	
	
//	LOGIN
//	pega os dados do form que vieram do controller
//	passa a senha do user pelo metodo de HASH, guardando o salt
//	passa esses dados pra um DAO que busca  user no DB
//	Encontrando: DB retorna user completo e service pega esse user
//	envia user para o controller 
//	Não encontrando: retorna para o controller mensagem de erro 
	
	
	private static UserDAO userDAO = null;
	
	
//	SIGNUP
	public static boolean isAvailable(String email, String login) throws SQLException {
		
		userDAO = new UserDAO();
		boolean isAvailable = userDAO.verifyDisponibility(email, login);
		
		if(isAvailable) {
			return true;
		}else {
			return false;
		}
		
	}

	public static void register(String name, String email, String login, String password, char gender) throws SQLException {
		
		String salt = BCrypt.gensalt();
		String hashedPassword = BCrypt.hashpw(password, salt);
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setLogin(login);
		user.setPassword(hashedPassword);
		user.setGender(gender);
		user.setSalt(salt);
		
		userDAO = new UserDAO();
		userDAO.add(user);
		
	}

	
//	LOGIN
	public static User authenticate(String login, String password) throws SQLException {
	
		userDAO = new UserDAO();
		String salt = userDAO.getSalt(login);
		
		String hashedPassword = password;
		if(salt!=null) {
			hashedPassword = BCrypt.hashpw(password, salt);	
		}else {
			System.out.println("usuario nao encontrado");
		}
		
		User user = userDAO.verifyLogin(login, hashedPassword);
		
		return user;

	
	}
	

	
}
