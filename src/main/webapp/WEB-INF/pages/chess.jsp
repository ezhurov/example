<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title><st:message code="chess" /></title>
		
		<script src="<c:url value="static_context/js/script.js" />"></script>
		<script src="<c:url value="static_context/js/websocket.js" />"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<script type="text/javascript">
			var areYouSure="<st:message code="areyousure" />";
		</script>
	</head>
	<body>
		<table id="chess" width="100%">
			<tr>
				<td width="10%">
					<textarea id="chat" cols="20" rows="20" readonly></textarea>
					<hr>
					<textarea id="message" cols="20" rows="1"></textarea>
					<p><input type="button" id="send" value="<st:message code="send" />" style="height: 30px; width: 160px"></p>
					<p><input type="button" id="disconnect" value="<st:message code="disconnect" />" style="height: 30px; width: 160px"></p>
				</td>
				<td align="center" width="70%">
					<table id="board" border="1">

					</table>
				</td>
			<tr>
		</table>
	</body>
</html>
