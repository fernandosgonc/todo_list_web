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
import todo_list_web.model.User;
import todo_list_web.service.Interactor;

@WebServlet(urlPatterns = { "/agendas" })
public class AgendasServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User owner = (User) req.getSession().getAttribute("loggedUser");
		try {
			if (owner != null) {

				List<Agenda> agendas = Interactor.getUserAgendas(owner);
				if (agendas != null) {
//					req.getSession().setAttribute("agendas", agendas);
//					resp.sendRedirect("restrict/agendas.jsp");
					req.setAttribute("agendas", agendas);
					RequestDispatcher rd = req.getRequestDispatcher("restrict/lista.jsp");
					rd.forward(req, resp);
					
				} else {
					resp.getWriter().print("You don't have any agendas :(");
				}
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("login");
				rd.forward(req, resp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
