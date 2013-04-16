<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring 3.0 MVC</title>
<style type="text/css">
	#container	{width:800px;}
	/* background: [-color] [-image] [-repeat] [-attachment] [-position]; */
	#header		{width:800px; height:50px; background:url(image/left_line.gif) repeat-x bottom;}
	#menu		{width:150px; height:300px; float:left; background:url(image/left_line.gif) repeat-y right;}
	#body		{width:650px; float:right;}
	#footer		{width:800px; height:50px; clear:both; background:url(image/left_line.gif) repeat-x top;}
</style>
</head>
<body>
	<div id="container">
		<div id="header"><tiles:insertAttribute name="header" /></div>
		<div id="menu"><tiles:insertAttribute name="menu" /></div>
		<div id="body"><tiles:insertAttribute name="body" /></div>
		<div id="footer"><tiles:insertAttribute name="footer" /></div>
	</div>
</body>
</html>