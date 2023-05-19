<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" import="cys.session.util.ConnectionUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>

	<header> </header>
	<br>
	<form action="Second" method="get">
		<div class="row">
			<%
			String uname = (String) session.getValue("username");
			%>
			User Name is
			<%=uname%>
			<div class="container">
				<h3 class="text-center">List</h3>
				<hr>
				<br>

				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th></th>
							<th>Name</th>
							<th></th>
							<th>email</th>
							<th></th>
							<th>phone number</th>
							<th></th>
							<th>password</th>
						</tr>
					</thead>
					<tbody>


						<%
						Connection con = ConnectionUtil.getConnection();
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("select id,user_name,email,phone_number,password from customer");
						while (rs.next()) {
							int id = rs.getInt(1);
							String name = rs.getString(2);
							String email = rs.getString(3);
							Long phone = rs.getLong(4);
							String password = rs.getString(5);
						%>
						<tr>
							<td><%=id%></td>
							<td></td>
							<td><%=name%></td>
							<td></td>
							<td><%=email%></td>
							<td></td>
							<td><%=phone%></td>
							<td></td>
							<td><%=password%></td>
						</tr>

						<%
						}
						%>

					</tbody>

				</table>

				<input type="submit" value="Back">
			</div>
		</div>
	</form>
</body>
</html>