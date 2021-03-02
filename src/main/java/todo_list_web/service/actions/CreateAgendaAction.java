package todo_list_web.service.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.dao.AgendaDAO;
import todo_list_web.model.Agenda;
import todo_list_web.model.User;

public class CreateAgendaAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		
		User owner = (User) req.getSession().getAttribute("loggedUser");
		String agendaName = req.getParameter("name");
		
		Agenda agenda = new Agenda();
		agenda.setName(agendaName);
		
		AgendaDAO dao = new AgendaDAO();
		dao.create(agenda, owner);
		
		return "agendas";
		
	}

}
