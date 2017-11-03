<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title><st:message code="index" /></title>
		
		<c:url value="static_context/js/script.js" var="script"></c:url>
		<script src="${script}"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<script type="text/javascript">
			var areYouSure="<st:message code="areyousure" />";
		</script>
	</head>
	<body>
		<table width=100%>
			<tr>
				<td align="left"><a id="registration" href="registration.html" style="display:${registration_visibility}"><st:message code="registration" /> |</a>
					<a id="authorization" href="authorization.html" style="display:${authorization_visibility}"><st:message code="authorization" /> |</a>
					<a id="changepassword" href="change_password.html" style="display:${change_password_visibility}"><st:message code="changepassword" /> |</a>
					<a id="deleteaccount" href="delete_account.html" style="display:${delete_visibility}" onclick="confirmDialog()"><st:message code="deleteaccount" /> |</a>
					<a id="managementofusers" href="management_of_all_users.html" style="display:${management_of_users_visibility}"><st:message code="managementofusers" /> |</a>
					<a href="<c:url value="/j_spring_security_logout" />" style="display:${logout_visibility}"><st:message code="logout" /> |</a></td>
				<td align="right"><a href="?lang=en">en</a> | <a href="?lang=ru">ru</a></td>	
			</tr>
		</table>	
		<hr>
		<p><h2><center>Hello World!</center></h2></p>
	</body>
</html>
