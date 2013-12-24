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
		<tr>
			<td colspan="2"><a href="javascript:;" onclick="fnSubmit();"><span class="btn">Add Contact</span></a></td>
		</tr>
	</table>
</form:form>