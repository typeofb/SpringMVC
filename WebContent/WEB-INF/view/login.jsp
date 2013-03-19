<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type="text/javascript">
function fnSubmit() {
	var x = document.forms["myForm"]["username"].value;
	if (x == null || x == "") {
		alert("Username must be filled out");
		return false;
	}
}
</script>
</head>
<body>
	<h2>Login</h2>
	<form name="myForm" method="post" action="login.do" onsubmit="return fnSubmit()">
		<table>
			<tr>
				<td><label>Username</label></td>
				<td><input name="username" /></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>