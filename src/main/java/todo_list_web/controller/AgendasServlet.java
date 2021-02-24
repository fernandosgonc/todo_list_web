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

@WebServlet(urlPatterns = { "/agendas",  "/createAgenda", "/deleteAgenda", "/updateAgenda", "/editAgenda"})
public class AgendasServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String URI = req.getRequestURI();
		
		if(URI.contains("/agendas")) {
			showAgendas(req, resp);
		}else if(URI.contains("/deleteAgenda")) {
			delete(req, resp);
		}else if(URI.contains("/editAgenda")) {
			prepareUpdate(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getRequestURI().contains("/createAgenda")) {
			create(req, resp);
		}else if(req.getRequestURI().contains("/updateAgenda")) {
			update(req, resp);
		}
	}
	
	
	public void showAgendas(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User owner = (User) req.getSession().getAttribute("loggedUser");
		try {
			if (owner != null) {

				List<Agenda> agendas = Interactor.getUserAgendas(owner);
				if (agendas != null) {
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
	
	public void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User owner = (User) req.getSession().getAttribute("loggedUser");
		String agendaName = req.getParameter("name");
		
		try {
			Interactor.createAgenda(agendaName, owner);
			resp.sendRedirect("agendas");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void prepareUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer agendaId = Integer.parseInt(req.getParameter("agenda_id"));
		
		try {
			Agenda a = Interactor.getAgenda(agendaId);
			req.setAttribute("agenda", a);
			RequestDispatcher rd = req.getRequestDispatcher("restrict/editAgenda.jsp");
			rd.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer agendaId = Integer.parseInt(req.getParameter("agenda_id"));
		String agendaName = req.getParameter("name");
		
		try {
			Interactor.updateAgenda(agendaId, agendaName);
			resp.sendRedirect("agendas");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer agendaId = Integer.parseInt(req.getParameter("agenda_id"));
		
		try {
			Interactor.deleteAgenda(agendaId);
			resp.sendRedirect("agendas");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
