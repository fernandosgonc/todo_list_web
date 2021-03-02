package todo_list_web.service.actions;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.dao.AgendaDAO;
import todo_list_web.dao.TaskDAO;
import todo_list_web.model.Agenda;
import todo_list_web.model.Task;

public class OpenAgendaAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		
		Integer agendaId = Integer.parseInt(req.getParameter("agenda_id"));
		
		Agenda agenda = new Agenda();
		agenda.setId(agendaId);
		
		agenda = new AgendaDAO().retrieve(agendaId);
		
		List<Task> taskList = new TaskDAO().retrieveAllFromAgenda(agenda);
		
		if(taskList!=null) {
			req.setAttribute("agenda", agenda);
			req.setAttribute("taskList", taskList);
			return "/WEB-INF/viewTasks.jsp";
		}else {
			req.setAttribute("error", "You don't have any tasks in this agenda");
			return "error";
		}
		
	}

}
