<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>User Register</title>
</head>
<body>
	<form action="user/register" method="POST">
		<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="name" /></td>
			</tr>

			<tr>
				<td>User Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td>User Description</td>
				<td><input type="text" name="description" /></td>
			</tr>
	
			<tr>
				<td></td>
				<td>
					<input type="submit" name="register" value="register">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>