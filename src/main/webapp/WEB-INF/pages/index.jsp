<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title><st:message code="index" /></title>
		
		<script src="<c:url value="static_context/js/script.js" />"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<script type="text/javascript">
			var areYouSure="<st:message code="areyousure" />";
			var play="<st:message code="play" />";
			var white="<st:message code="white" />";
			var black="<st:message code="black" />";
		</script>
	</head>
	<body onload="autoUpdatePendingGames()">
		<table id="menu" width=100%>
			<tr style="display: ${statistic_visibility}">
				<td width="100%"> <st:message code="hello" />, ${username} 
				<st:message code="wins" />: ${wins} | <st:message code="fails" />: ${fails} | <st:message code="draws" />: ${draws} </td>
			</tr>
			<tr>
				<td align="left" width="90%"><a id="registration" href="registration.html" style="display:${registration_visibility}"><st:message code="registration" /> |</a>
					<a id="authorization" href="authorization.html" style="display:${authorization_visibility}"><st:message code="authorization" /> |</a>
					<a id="creategame" href="" style="display:${create_game_visibility}" onclick="clickCreateGame()"><st:message code="creategame" /> |</a>
					<a id="changepassword" href="change_password.html" style="display:${change_password_visibility}"><st:message code="changepassword" /> |</a>
					<a id="deleteaccount" href="delete_account.html" style="display:${delete_visibility}" onclick="confirmDialog()"><st:message code="deleteaccount" /> |</a>
					<a id="managementofusers" href="management_of_all_users.html" style="display:${management_of_users_visibility}"><st:message code="managementofusers" /> |</a>
					<a href="<c:url value="/j_spring_security_logout" />" style="display:${logout_visibility}"><st:message code="logout" /> |</a></td>
				<td align="right" width="10%"><a href="?lang=en">en</a> | <a href="?lang=ru">ru</a></td>	
			</tr>
		</table>	
		<hr>
		<div id="popup" style="display:none">
			<p><input type="radio" name="color" id="white" value="white" checked><label for="white"><st:message code="white" /></label>
			<input type="radio" name="color" id="black" value="black"><label for="black"><st:message code="black" /></label></p>
			<input type="button" id="creategamebutton" value="OK" onclick="clickCreateGameButton()" style="height: 30px; width: 120px">
			<hr>
		</div>
		<table id="games" width=60% border="1" align="center" style="display:${pending_games_visibility}">
			<c:forEach items="${pendingGames}" var="pendingGame">
				<tr>
					<c:if test="${not empty pendingGame.white_id}">
					    <td width="20%"></td>
					    <td width="20%"><st:message code="black" /></td>
					</c:if>
					<c:if test="${not empty pendingGame.black_id}">
					    <td width="20%"></td>
					    <td width="20%"><st:message code="white" /></td>
					</c:if>
					<td width="20%"><a id="play" href=""><st:message code="play" /></a></td>
				</tr>
			</c:forEach>
		</table>	
	</body>
</html>
