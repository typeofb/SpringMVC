<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
			<script type="text/javascript">
				// 추후에 menuNo를 db에서 검색
				function fnMoveHeader(menuId, parentMenuId) {
					document.headerForm.menuId.value = menuId;
					document.headerForm.parentMenuId.value = parentMenuId;
					document.headerForm.action = "navigator.do";
					document.headerForm.submit();
				}
				
				function fnMenuToggle(obj) { }
				
				function fnLogout() {
					document.headerForm.action = "logout.do";
					document.headerForm.submit();
				}
			</script>
			
			<form name="headerForm" method="post">
				<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
				<input type="hidden" name="menuId" />
				<input type="hidden" name="parentMenuId" />
				
				<div id="gnb">
					<span><a href="javascript:fnMoveHeader('1', '0');">Home</a></span>
					<ul>
						<li><a href="javascript:fnLogout();">Logout</a></li>
						<li>&nbsp;|&nbsp;</li>
						<li><%= session.getAttribute("username") %>님이 로그인 하셨습니다</li>
						<li>&nbsp;|&nbsp;</li>
						<li id="theDate"></li>
					</ul>
				</div>
				
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
			
			<script type="text/javascript">
			var UnixTimestamp = new Date().getTime() / 1000;
			console.log('unix timestamp: ' + UnixTimestamp);
			var TheDate = new Date(UnixTimestamp * 1000);
			var Result = TheDate.getFullYear() + '/'
					+ (TheDate.getMonth() + 1).toString().padStart(2, "0") + '/'
					+ TheDate.getDate().toString().padStart(2, "0") + " "
					+ TheDate.getHours().toString().padStart(2, "0") + ":"
					+ TheDate.getMinutes().toString().padStart(2, "0");
			
			document.querySelector('#theDate').append(Result);
			</script>