<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title><st:message code="changepassword" /></title>
		
		<c:url value="static_context/js/script.js" var="script"></c:url>
		<script src="${script}"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	</head>
	<body onkeypress="clickCtrlEnter()">
		<form method="post" action="changing_password.html">
			<table width=100%>
				<tr>
					<td width=10%><st:message code="oldpassword" /></td>
					<td><input type="password" id="oldpassword" name="oldpassword" size="20" maxlength="30" required onblur="checkOldPassword()">
					<span id="erroroldpassword" style="color:red"></span></td>
				</tr>
				<tr>
					<td width=10%><st:message code="newpassword" /></td>
					<td><input type="password" id="newpassword" name="newpassword" size="20" maxlength="30" required></td>
				</tr>
				<tr>	
					<td><input type="submit" id="ok" name="ok" value="OK" style="height: 30px; width: 120px"></td>
				</tr>	
			</table>
		</form>	
	</body>
</html>
