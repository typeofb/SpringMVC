<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form:form id="contactForm" method="post" action="addContact.do">
	<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
	<table>
		<tr>
			<td><form:label path="firstname">First Name</form:label></td>
			<td><form:input path="firstname" /></td>
		</tr>
		<tr>
			<td><form:label path="lastname">Last Name</form:label></td>
			<td><form:input path="lastname" /></td>
		</tr>
		<tr>
			<td><form:label path="lastname">Email</form:label></td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td><form:label path="lastname">Telephone</form:label></td>
			<td><form:input path="telephone" /></td>
		</tr>
	</table>
	<div class="btn"><a class="btnB" href="javascript:;" onclick="fnSubmit();"><span>Add Contact</span></a></div>
	<div class="btn"><a class="btnG" href="javascript:;" onclick="fnSubmit();"><span>Add Contact</span></a></div>
	<div class="btn"><a class="btnK" href="javascript:;" onclick="fnSubmit();"><span>Add Contact</span></a></div>
	<div class="btn"><a class="btnT" href="javascript:;" onclick="fnSubmit();"><span>Add Contact</span></a></div>
</form:form>