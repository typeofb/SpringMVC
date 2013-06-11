<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#masterHeader {margin:7px; background:url(image/top_bg_c_11.gif) no-repeat right top;}
	#topNavi {width:2000px; height:44px; background:url(image/top_bg_l_11.gif) no-repeat left top;}
	#mainMenu {margin:0px; padding:0px 6px 0px 16px;}
	#mainMenu li {
		background:url(image/m_tab_l_on1.gif) no-repeat;
		padding:10px 0px 10px 15px;
		list-style:none;
		float:left;
	}
	#mainMenu li span {
		background:url(image/m_tab_r_on1.gif) no-repeat right top;
		padding:10px 30px 10px 20px;
	}
	#mainMenu li span a {color:#AE0141; font-weight:bold;}
</style>
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
</head>
<body>
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
</body>
</html>