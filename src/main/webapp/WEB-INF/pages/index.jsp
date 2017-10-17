<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title><st:message code="index" /></title>
		<script src="js/script1.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body>
		<table width=100%>
			<tr>
				<td align="left"><a href="registration.html"><st:message code="registration" /> |</a>
					<a href="authorization.html" style="display:${authorizationvisibility}"><st:message code="authorization" /> |</a>
					<a href="<c:url value="/j_spring_security_logout" />" style="display:${indexvisibility}"><st:message code="logout" /> |</a></td>
				<td align="right"><a href="?lang=en">en</a> | <a href="?lang=ru">ru</a></td>	
			</tr>
		</table>	
		<hr>
		<p><h2><center>Hello World!</center></h2></p>
	</body>
</html>
