package todo_list_web.service.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.dao.AgendaDAO;

public class DeleteAgendaAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		
		try {
			
			Integer agendaId = Integer.parseInt(req.getParameter("agenda_id"));
			
			AgendaDAO dao = new AgendaDAO();
			dao.delete(agendaId);
			
			return "agendas";
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return "error";
		
	}

}
