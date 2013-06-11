<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" method="post" action="navigator.do">
		<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
	</form>
	<script>
		document.loginForm.submit();
	</script>
</body>
</html>