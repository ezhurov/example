<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title><st:message code="authorization" /></title>
		
		<script src="<c:url value="static_context/js/script.js" />"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	</head>
	<body onkeypress="clickCtrlEnter()">
		<form method="post" action="<c:url value='/j_spring_security_check' />">
			<table width=100%>
				<tr>
					<td width=10%><st:message code="username" /></td>
					<td><input type="text" id="username" name="username" size="20" maxlength="30" required>
					<span style="color:red; display:${error_username_visibility}"><st:message code="errorauthorization" /></span>
				</tr>
				<tr>
					<td width=10%><st:message code="password" /></td>
					<td><input type="password" id="password" name="password" size="20" maxlength="30" required></td>
				</tr>
				<tr>
					<td width=10%><input type="checkbox" id="remember-me" name="remember-me"><label for="remember-me"><st:message code="rememberme" /></label></td>
				</tr>
				<tr>	
					<td><input type="submit" id="ok" name="ok" value="OK" style="height: 30px; width: 120px"></td>
				</tr>	
			</table>
		</form>	
	</body>
</html>
