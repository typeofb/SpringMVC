<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<script type="text/javascript">
	function fnMovePage(menuId, parentMenuId) {
		document.sidebarForm.menuId.value = menuId;
		document.sidebarForm.parentMenuId.value = parentMenuId;
//		document.sidebarForm.action = "navigator.do";
		document.sidebarForm.submit();
	}
</script>
</head>
<body>
	<form name="sidebarForm" method="post">
		<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
		<input type="hidden" name="menuId" />
		<input type="hidden" name="parentMenuId" />
		
		<ul id="sidebar">
			<c:forEach items="${sidebar}" var="sidebarEntry">
				<li><a href="#" onclick="fnMovePage('${sidebarEntry.menuId}', '${sidebarEntry.parentMenuId}'); return false;">${sidebarEntry.menuName}</a></li>
			</c:forEach>
		</ul>
	</form>
</body>
</html>