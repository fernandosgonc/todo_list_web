package todo_list_web.service.actions;

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
		
		UserDAO userDAO = new UserDAO();
		String salt = userDAO.getSalt(login);
		
		String hashedPassword = password;
		if(salt!=null) {
			hashedPassword = BCrypt.hashpw(password, salt);	
		}else {
			System.out.println("usuario nao encontrado");
		}
		
		User user = userDAO.verifyLogin(login, hashedPassword);
		
		if(user!=null) {
			req.getSession().setAttribute("loggedUser", user);
			return "home";
		}else {
			return req.getContextPath()+"/signin.jsp";
		}
		
		
	}

	
	
}
