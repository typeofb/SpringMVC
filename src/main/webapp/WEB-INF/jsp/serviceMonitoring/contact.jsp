<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
<script type="text/javascript">
function fnSubmit() {
	$.ajax({
		type: "POST",
		url: "addContact.do",
		data: $("#contactForm").serializeArray(),
		success: function(result) {
			$("#contactForm").html(result);
		}
	});
}
</script>
<h2>Contact Manager</h2>
<form:form id="contactForm" commandName="contact">
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
			<td><form:label path="email">Email</form:label></td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td><form:label path="telephone">Telephone</form:label></td>
			<td><form:input path="telephone" /></td>
		</tr>
		<tr>
			<td>체크박스</td>
			<td><form:checkboxes path="hobbies" items="${hobbyList}" /></td>
		</tr>
		<tr>
			<td>라디오버튼</td>
			<td><form:radiobuttons path="hobbies" items="${hobbyList}" /></td>
		</tr>
		<tr>
			<td>셀렉트태그</td>
			<td>
				<form:select path="country">
					<form:option value="NONE" label="--- Select ---" />
					<form:options items="${countryList}" />
				</form:select>
			</td>
		</tr>
	</table>
	<div class="btn"><a class="btnB" href="javascript:;" onclick="fnSubmit();"><span>Add Contact</span></a></div>
	<div class="btn"><a class="btnG" href="javascript:;" onclick="fnSubmit();"><span>Add Contact</span></a></div>
	<div class="btn"><a class="btnK" href="javascript:;" onclick="fnSubmit();"><span>Add Contact</span></a></div>
	<div class="btn"><a class="btnT" href="javascript:;" onclick="fnSubmit();"><span>Add Contact</span></a></div>
</form:form>