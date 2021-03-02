package todo_list_web.service.actions;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.dao.AgendaDAO;
import todo_list_web.model.Agenda;
import todo_list_web.model.User;

public class ListAgendasAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		
		AgendaDAO dao = new AgendaDAO();
		User owner = (User) req.getSession().getAttribute("loggedUser");
		List<Agenda> list =  dao.retrieveAll(owner);
		
		if(list!=null) {
			req.setAttribute("listAgendas", list);
			return "/WEB-INF/agendas.jsp";
		}else {
			req.setAttribute("error", "You don't have any agendas");
			return "home.jsp";
		}
	}
	

	
	
}
