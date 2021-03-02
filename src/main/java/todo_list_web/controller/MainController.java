package todo_list_web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.service.actions.Action;
import todo_list_web.service.actions.ActionFactory;

@WebServlet("/mvc/*")
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("DENTRO DO DOGET");
		System.out.println(req.getMethod() + req.getPathInfo());

		
		Action action = ActionFactory.getAction(req);
		System.out.println("ACTION: " + action);

		try {
			String page = action.execute(req, resp);
			System.out.println("Page: " + page);

			
			if(req.isRequestedSessionIdValid()) {				
				req.getRequestDispatcher(page).forward(req, resp);
			}else {
				resp.sendRedirect(page);
			}
			
//			resp.sendRedirect(page);

		} catch (Exception e) {
			throw new ServletException("A logica de negocios causou uma exececao", e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("DENTRO DO DOPOST");
		System.out.println(req.getMethod() + req.getPathInfo());

		Action action = ActionFactory.getAction(req);
		System.out.println("ACTION: " + action);

		try {
			String page = action.execute(req, resp);
			System.out.println("Page: " + page);

			if (page.contains("/WEB-INF/")) {
				req.getRequestDispatcher(page).forward(req, resp);
			} else {
				resp.sendRedirect(page);
			}

		} catch (Exception e) {
			throw new ServletException("A logica de negocios causou uma exececao", e);
		}

	}

}
