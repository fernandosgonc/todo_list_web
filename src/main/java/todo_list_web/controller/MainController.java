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

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(req.getMethod() + req.getPathInfo());

		
		Action action = ActionFactory.getAction(req);

		try {
			String page = action.execute(req, resp);

			
			if (page.equals(req.getPathInfo().substring(1))) {
	            req.getRequestDispatcher("/WEB-INF/" + page + ".jsp").forward(req, resp);
	        }
	        else {
	            resp.sendRedirect(page);
	        }


		} catch (Exception e) {
			throw new ServletException("A logica de negocios causou uma exececao", e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(req.getMethod() + req.getPathInfo());

		Action action = ActionFactory.getAction(req);

		try {
			String page = action.execute(req, resp);

				resp.sendRedirect(page);

		} catch (Exception e) {
			throw new ServletException("A logica de negocios causou uma exececao", e);
		}

	}

}
