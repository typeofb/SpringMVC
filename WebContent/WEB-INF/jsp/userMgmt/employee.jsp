<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- commons-validator tag lib 선언 -->
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator"%>
<!-- for including generated Javascript Code(in validation-rules.xml) -->
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<!-- for including generated Javascript Code(validateEmployee(), formName:validator.xml에서 정의한 form의 이름) -->
<validator:javascript formName="employee" staticJavascript="false" xhtml="true" cdata="false" />

<script src="js/jquery-1.4.3.min.js"></script>
<script type="text/javascript">
	window.onload = function() {
		$(":input").each(function(){
			if ($(this).val() == "0") {
				//alert($(this).attr("id"));  // age, phone
				$(this).val("");
			}
		});
	};

	function save(form) {
		if (!validateEmployee(form)) {
			return;
		} else {
			form.submit();
		}
	}
</script>

<div>${user}</div>
<form:form commandName="employeeCommand" action="saveEmployee.do">
	<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
	<table>
		<tr>
			<th>이름</th>
			<td><form:input path="name" size="20" />
				<form:errors path="name" />
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><form:input path="password" size="20" />
			</td>
		</tr>
		<tr>
			<th>나이</th>
			<td><form:input path="age" size="20" />
				<form:errors path="age" />
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><form:input path="phone" size="20" />
				<form:errors path="phone" />
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><form:input path="email" size="20" />
				<form:errors path="email" />
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
				<!--<input type="submit"/>-->
				<input type="button" value="SAVE" onclick="save(this.form)" /> <!-- client-validation을 위해 바로 submit하지 않고 먼저 validateEmployee 함수를 호출 -->
				<input type="button" value="LIST" onclick="location.href='<c:url value='employee.do' />'" />
			</td>
		</tr>
	</table>
</form:form>