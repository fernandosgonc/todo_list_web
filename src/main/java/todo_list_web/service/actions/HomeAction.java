package todo_list_web.service.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.model.User;

public class HomeAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		
		User currentUser = (User) req.getSession().getAttribute("loggedUser");
		
		if(currentUser!=null) {
			return "/WEB-INF/welcome.jsp";
		}else {
			return "../homepage2.jsp";
		}
		
	}

}
