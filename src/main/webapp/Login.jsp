<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<style>
#tab1 {
	margin-top: 20%;
	margin-left: 40%
}
</style>
</head>
<body>
	<form action="LoginProcess" method="get">
		<table id="tab1">
			<tr>
				<td>user name:</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
			<tr>
				<td><a href="RegisterPage.jsp">register</a></td>
			</tr>

		</table>
	</form>
</body>
</html>