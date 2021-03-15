package todo_list_web.service.actions;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.dao.AgendaDAO;
import todo_list_web.model.Agenda;

public class EditAgendaAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		
		Integer agendaId = Integer.parseInt(req.getParameter("agenda_id"));
		String agendaName = req.getParameter("name");
		
		Agenda agenda = new Agenda();
		agenda.setId(agendaId);
		agenda.setName(agendaName);
		
		Connection connection = (Connection) req.getAttribute("connection");
		AgendaDAO dao = new AgendaDAO(connection);
		dao.edit(agenda);
		
		return "viewAgenda?agenda_id="+agendaId;
		
	}

}
