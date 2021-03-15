package todo_list_web.service.actions;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.dao.UserDAO;
import todo_list_web.model.User;
import todo_list_web.util.BCrypt;

public class SignUpAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		
		String salt = BCrypt.gensalt();
		String hashedPassword = BCrypt.hashpw(password, salt);
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setLogin(login);
		user.setPassword(hashedPassword);
		user.setGender(gender.charAt(0));
		user.setSalt(salt);
		
		Connection connection = (Connection) req.getAttribute("connection");
		
		UserDAO userDAO = new UserDAO(connection);
		
		
		userDAO.add(user);
		String ret = "";
		try{
			ret = "signin";
		}catch (Exception e) {
			ret = req.getContextPath()+"signup2.jsp";
			throw new SQLException("Unable to register", e);
		}
		
		return ret;
		
	
	}

}
