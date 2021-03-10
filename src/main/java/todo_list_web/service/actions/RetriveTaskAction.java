package todo_list_web.service.actions;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.dao.AgendaDAO;
import todo_list_web.dao.TaskDAO;
import todo_list_web.model.Agenda;
import todo_list_web.model.Task;
import todo_list_web.model.User;

public class RetriveTaskAction implements Action{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		
		Integer taskId = Integer.parseInt(req.getParameter("task_id"));
		
		TaskDAO dao = new TaskDAO();
		
		Task task = dao.retrieve(taskId);
		Agenda agenda = dao.retrieveAgendaRelatedToTask(task);
		User currentUser = (User) req.getSession().getAttribute("loggedUser");
		List<Agenda> allAgendas = new AgendaDAO().retrieveAll(currentUser);
		
		if(agenda != null && allAgendas!=null) {
			req.setAttribute("task", task);
			req.setAttribute("agenda", agenda);
			req.setAttribute("allAgendas", allAgendas);
		}
		
		return "viewTask";
	}

}
