<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
			<script type="text/javascript">
				function fnMovePage(menuId, parentMenuId) {
					document.sidebarForm.menuId.value = menuId;
					document.sidebarForm.parentMenuId.value = parentMenuId;
					document.sidebarForm.action = "navigator.do";
					document.sidebarForm.submit();
				}
			</script>
			
			<form name="sidebarForm" method="post">
				<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
				<input type="hidden" name="menuId" />
				<input type="hidden" name="parentMenuId" />
				
				<ul id="sidebar">
					<c:forEach items="${sidebar}" var="sidebarEntry">
						<li><a href="javascript:;" onclick="fnMovePage('${sidebarEntry.menuId}', '${sidebarEntry.parentMenuId}'); return false;">${sidebarEntry.menuName}</a></li>
					</c:forEach>
				</ul>
			</form>