<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>Registration page</title>
	</head>
	<body>
		<form method="post" action="adduser.html">
			<table width=100%>
				<tr>
					<td width=10%>username:</td>
					<td><input type="text" id="username" name="username" size="20" maxlength="30" required></td>
				</tr>
				<tr>
					<td width=10%>password:</td>
					<td><input type="password" id="password" name="password" size="20" maxlength="30" required></td>
				</tr>
				<tr>	
					<td><input type="submit" id="ok" name="ok" value="OK" style="height: 30px; width: 120px"></td>
				</tr>	
			</table>
		</form>	
	</body>
</html>
