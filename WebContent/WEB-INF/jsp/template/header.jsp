<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
			<script type="text/javascript">
				// 추후에 menuNo를 db에서 검색
				function fnMoveHeader(menuId, parentMenuId) {
					document.headerForm.menuId.value = menuId;
					document.headerForm.parentMenuId.value = parentMenuId;
			//		document.headerForm.action = "navigator.do";
					document.headerForm.submit();
				}
			
				function fnMenuToggle(obj) { }
			</script>
			
			<form name="headerForm" method="post">
				<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
				<input type="hidden" name="menuId" />
				<input type="hidden" name="parentMenuId" />
				
				<span style="float:left; margin-left:10px;"><%= session.getAttribute("username") %></span>
				<span style="float:right; margin-right:10px;"><a href="logout.do">Logout</a></span><br />
				<div id="masterHeader">
					<div id="topNavi">
						<ul id="mainMenu">
							<c:forEach items="${menu}" var="menuEntry">
								<li><span><a href="javascript:fnMoveHeader('${menuEntry.menuId}', '${menuEntry.parentMenuId}');" onclick="fnMenuToggle(this);">${menuEntry.menuName}</a></span></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</form>