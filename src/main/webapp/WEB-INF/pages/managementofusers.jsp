<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title><st:message code="managementofusers" /></title>
		
		<c:url value="js/script.js" var="script"></c:url>
		<script src="${script}"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<script type="text/javascript">
			var setAsAdminUser="<st:message code="setasadminuser" />";
			var lockUnlockAccount="<st:message code="lockunlockaccount" />";
			var deleteAccount="<st:message code="deleteaccount" />";
			var areYouSure="<st:message code="areyousure" />";
		</script>
	</head>
	<body>
		<table id="filters" width="100%">
			<tr>
				<td width="50%"><input type="radio" name="enabled" id="allusers" value="allusers" ${checked_all_users} onclick="locationTo('management_of_all_users.html')"><label for="allusers"><st:message code="allusers" /></label>
				<input type="radio" name="enabled" id="lockedusers" value="lockedusers" ${checked_locked_users} onclick="locationTo('management_of_locked_users.html')"><label for="lockedusers"><st:message code="lockedusers" /></label>
				<input type="radio" name="enabled" id="unlockedusers" value="unlockedusers" ${checked_unlocked_users} onclick="locationTo('management_of_unlocked_users.html')"><label for="unlockedusers"><st:message code="unlockedusers" /></label></td>
				<td width="50%" align="right"><st:message code="searchbyusername" /> <input type="text" id="halfUsername" name="halfUsername" size="20" maxlength="30" onkeypress="liveSearchByHalfUsername()"></td>
			</tr>
		</table>
		<p><center><h3>${table_is_empty}</h3></center></p>
		<table id="users" width="80%" border="1" style="display: ${table_visibility}">
			<c:forEach items="${users}" var="user">
				<tr>
					<td width="15%">${user.username}</td>
					<td width="15%">${user.email}</td>
					<td width="10%">${user.role}</td>
					<td width="5%">${user.enabled}</td>
					<td width="10%"><a onclick="confirmDialog()" id="setasadminuser_${user.id}" href="set_as_admin_user.html?username=${user.username}&role=${user.role}"><st:message code="setasadminuser" /></a></td>
					<td width="10%"><a onclick="confirmDialog()" id="lockunlockaccount_${user.id}" href="lock_account_by_username.html?username=${user.username}&enabled=${user.enabled}"><st:message code="lockunlockaccount" /></a></td>
					<td width="10%"><a onclick="confirmDialog()" id="deleteaccount_${user.id}" href="delete_account_by_username.html?username=${user.username}"><st:message code="deleteaccount" /></a></td>
				</tr>
			</c:forEach>
		</table>	
	</body>
</html>
