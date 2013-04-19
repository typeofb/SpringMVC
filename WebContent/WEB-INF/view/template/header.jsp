<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#masterHeader {background:url(image/top_bg_c_11.gif) no-repeat right bottom;}
	#topNavi {width:800px; height:50px; background:url(image/top_bg_l_11.gif) no-repeat left bottom;}
</style>
</head>
<body>
	<span style="float:left; margin-left:10px;"><%= request.getSession().getAttribute("token") %></span>
	<span style="float:right; margin-right:10px;"><a href="logout.do">Logout</a></span><br />
	<div id="masterHeader">
		<div id="topNavi" />
	</div>
</body>
</html>