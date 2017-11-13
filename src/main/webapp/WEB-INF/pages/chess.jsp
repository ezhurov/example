<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title><st:message code="chess" /></title>
		
		<script src="<c:url value="static_context/js/script.js" />"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	</head>
	<body>
		<table id="chess" width="100%">
			<tr>
				<td width="10%">
					<p><st:message code="chat" /></p>
					<textarea id="chat" cols="20" rows="20"></textarea>
					<hr>
					<textarea id="message" cols="20" rows="1"></textarea>
					<p />
					<input type="button" id="addMessageToChat" value="OK" style="height: 30px; width: 160px">
				</td>
				<td align="center" width="70%">
					<table id="board" border="1">
						<tr><td/><td/><td/><td/><td/><td/><td/><td/></tr>
						<tr><td/><td/><td/><td/><td/><td/><td/><td/></tr>
						<tr><td/><td/><td/><td/><td/><td/><td/><td/></tr>
						<tr><td/><td/><td/><td/><td/><td/><td/><td/></tr>
						<tr><td/><td/><td/><td/><td/><td/><td/><td/></tr>
						<tr><td/><td/><td/><td/><td/><td/><td/><td/></tr>
						<tr><td/><td/><td/><td/><td/><td/><td/><td/></tr>
						<tr><td/><td/><td/><td/><td/><td/><td/><td/></tr>
					</table>
				</td>
				<td width="20%">
					<p><a id="offerdraw"><st:message code="offerdraw" /></a></p>
					<p><a id="throwtowel"><st:message code="throwtowel" /></a></p>
				</td>
			<tr>
		</table>
	</body>
</html>
