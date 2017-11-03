<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title></title>
		
		<c:url value="static_context/js/script.js" var="script"></c:url>
		<c:url value="static_context/css/chess.css" var="css"></c:url>
		<script src="${script}"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<link href="${scc}" rel="stylesheet">
	</head>
	<body>
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
	</body>
</html>
