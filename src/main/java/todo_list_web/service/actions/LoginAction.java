package todo_list_web.service.actions;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.dao.UserDAO;
import todo_list_web.model.User;
import todo_list_web.util.BCrypt;

public class LoginAction implements Action {
	
	public LoginAction() {
		System.out.println("LoginAction instanciado");
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		
		System.out.println("EXECUTE do loginaction");
		
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		
		Connection connection = (Connection) req.getAttribute("connection");
		System.out.println("ESTADO CONEXAO ->"+connection.isClosed());
		UserDAO userDAO = new UserDAO(connection);
		String salt = userDAO.getSalt(login);
		
		String hashedPassword = password;
		if(salt!=null) {
			hashedPassword = BCrypt.hashpw(password, salt);	
		}		
		
		System.out.println("ESTADO CONEXAO ->"+connection.isClosed());
		User user = userDAO.verifyLogin(login, hashedPassword);
		
		if(user!=null) {
			req.getSession().setAttribute("loggedUser", user);
			return "home";
		}else {
			req.setAttribute("error", "Username/password incorrect.");
			return req.getContextPath()+"/signin.jsp";
		}
		
		
	}

	
	
}
