package todo_list_web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.model.Agenda;
import todo_list_web.model.Task;
import todo_list_web.service.Interactor;

@WebServlet(urlPatterns = { "/tasks" })
public class Taskservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer agendaId = Integer.parseInt(req.getParameter("agenda_id"));
//		Agenda currentAgenda = (Agenda) req.getSession().getAttribute("currentAgenda");
//		System.out.println(currentAgenda);
		if (agendaId != null) {
			try {
				Agenda a = Interactor.getAgenda(agendaId);
				List<Task> tasksList = Interactor.getAgendaTasks(a);
				req.setAttribute("tasks", tasksList);
				RequestDispatcher rd = req.getRequestDispatcher("restrict/listatasks.jsp");
				rd.forward(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
