<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>message.jsp</title>
	<jsp:include page="/include/bs5.jsp"/>
	<script>
		'use strict';
		
		if('${message}' != "") alert("${message}")
		location.href = "${url}"
	</script>
</head>
<body>
<p><br/></p>
<div class="container">
	
</div>
</body>
</html>