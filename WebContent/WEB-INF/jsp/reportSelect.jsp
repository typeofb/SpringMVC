<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select>
	<c:forEach var="x" items="${result}">
		<option value="${x.LOC_NM}" selected>${x.LOC_NM}</option>
	</c:forEach>
</select>