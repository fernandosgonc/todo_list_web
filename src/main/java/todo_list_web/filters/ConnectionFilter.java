package todo_list_web.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import todo_list_web.factory.ConnectionFactory;

@WebFilter("/*")
public class ConnectionFilter implements javax.servlet.Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init Connection Filter");
	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			Connection con = ConnectionFactory.getConnection();
			
			request.setAttribute("connection", con);
			
			chain.doFilter(request, response);
			
			
			con.close();
			
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("Destroy Connection Filter");
	}

}
