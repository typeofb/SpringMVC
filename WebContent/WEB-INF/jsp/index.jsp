<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
function fnSubmit() {
	var x = document.forms["myForm"]["username"].value;
	if (x == null || x == "") {
		alert("Username must be filled out");
		return false;
	}
}
</script>

<h2>Login</h2>
<form name="myForm" method="post" action="login.do" onsubmit="return fnSubmit()">
	<table>
		<tr>
			<td><label>Username</label></td>
			<td><input name="username" value="typeofb" /></td>
		</tr>
		<tr>
			<td><label>Password</label></td>
			<td><input name="password" type="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login" /></td>
		</tr>
	</table>
</form>