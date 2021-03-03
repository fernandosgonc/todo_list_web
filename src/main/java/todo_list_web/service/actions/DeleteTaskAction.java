package todo_list_web.service.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.dao.TaskDAO;
import todo_list_web.model.Agenda;
import todo_list_web.model.Task;

public class DeleteTaskAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		
		Integer taskId = Integer.parseInt(req.getParameter("task_id"));
		
		Task task = new Task();
		task.setId(taskId);
		
		TaskDAO dao = new TaskDAO();
		Agenda agenda = dao.retrieveAgendaRelatedToTask(task);
		dao.delete(taskId);
		
		return "open?agenda_id="+agenda.getId();
		
		
		
		
	}

}
