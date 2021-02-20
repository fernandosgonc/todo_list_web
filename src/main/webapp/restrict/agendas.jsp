<%@page import="java.util.List"%>
<%@page import="todo_list_web.model.Agenda"%>
<%@page import="todo_list_web.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Agendas</title>
</head>
<body>

	<header>
		<%
		User currentUser = (User) session.getAttribute("loggedUser");
		out.print("<h1>Here are your agendas, " + currentUser.getName() + "</h1>");
		%>

	</header>

	<main>

		<table border="1">
			<thead>
				<th>Id</th>
				<th>Name</th>
				<th>Creation date</th>
				<th>See tasks</th>
			</thead>

			<tbody>
				<%
				List<Agenda> agendas = (List<Agenda>) session.getAttribute("agendas");
				for (Agenda a : agendas) {
				%>

				<tr>
					<td>
						<%
						out.print(a.getId());
						%>
					</td>
					<td>
						<%
						out.print(a.getName());
						%>
					</td>
					<td>
						<%
						out.print(a.getCreationDate());
						%>
					</td>
					<td>
						<%--<% session.setAttribute("currentAgenda", a);--%> <%
 String url = "../tasks?agenda_id=" + a.getId();
 %>
						<a href="<%=url%>">Open</a>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>

		</table>

		<a href="signout.jsp">Sign out</a>
	</main>






</body>
</html>