package todo_list_web.service.actions;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.dao.AgendaDAO;
import todo_list_web.dao.TaskDAO;
import todo_list_web.model.Agenda;
import todo_list_web.model.Task;
import todo_list_web.model.User;

public class PrepareEditAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {

		String parameter = req.getQueryString();

		if (parameter.contains("agenda_id")) {
			Integer agendaId = Integer.parseInt(req.getParameter("agenda_id"));

			AgendaDAO dao = new AgendaDAO();
			Agenda agenda = dao.retrieve(agendaId);

			if (agenda != null) {
				req.setAttribute("agenda", agenda);
			}

			return "/WEB-INF/editAgenda.jsp";

		} else if (parameter.contains("task_id")) {
			Integer taskId = Integer.parseInt(req.getParameter("task_id"));

			TaskDAO dao = new TaskDAO();
			Task task = dao.retrieve(taskId);
			Agenda agenda = dao.retrieveAgendaRelatedToTask(task);
			List<Agenda> allAgendas = new AgendaDAO().retrieveAll((User) req.getSession().getAttribute("loggedUser"));

			if (task != null) {
				req.setAttribute("allAgendas", allAgendas);
				req.setAttribute("agenda", agenda);
				req.setAttribute("task", task);
			}
			
			return "/WEB-INF/editTask.jsp";
		}

		else {
			req.setAttribute("error", "This is not a valid operation.");
			return "error";
		}

	}

}
