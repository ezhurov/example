<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title><st:message code = "forgotpassword" /></title>
			<c:url value="js/script1.js" var="script1"></c:url>
			<script src="${script1}"></script>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body onkeydown="clickCtrlEnter()">
		<form method="post" action="sendemail.html">
			<table width=100%>
				<tr>
					<td width=10%><st:message code = "email" /></td>
					<td><input type="email" name="email" id="email" required size="20" maxlength="255"></td>
				</tr>
				<tr>
					<td><input type="submit" name="ok" id="ok" value="OK" style="height: 30px; width: 120px"></td>
				</tr>
			</table>
		</form>
	</body>
</html>