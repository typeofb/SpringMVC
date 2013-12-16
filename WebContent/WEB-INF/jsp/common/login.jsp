<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form name="loginForm" method="post" action="navigator.do">
	<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
</form>
<script>
	document.loginForm.submit();
</script>