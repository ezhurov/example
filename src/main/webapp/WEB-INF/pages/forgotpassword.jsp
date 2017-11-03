<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title><st:message code = "forgotpassword" /></title>
		
		<c:url value="static_context/js/script.js" var="script"></c:url>
		<script src="${script}"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	</head>
	<body onkeydown="clickCtrlEnter()">
		<form method="post" action="send_email.html">
			<table width=100%>
				<tr>
					<td width=10%><st:message code = "email" /></td>
					<td><input type="email" name="email" id="email" size="20" maxlength="255" required></td>
				</tr>
				<tr>
					<td><input type="submit" name="ok" id="ok" value="OK" style="height: 30px; width: 120px"></td>
				</tr>
			</table>
		</form>
	</body>
</html>