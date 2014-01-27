<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<select id="selLoc" name="selLoc">
	<c:forEach var="x" items="${result}">
		<option value="${x.LOC_CD}">${x.LOC_NM}</option>
	</c:forEach>
</select>