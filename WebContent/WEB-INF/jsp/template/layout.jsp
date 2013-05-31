<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring 3.0 MVC</title>
<style type="text/css">
	#container	{width:1000px; height:auto; margin:0 auto;}
	/* background: [-color] [-image] [-repeat] [-attachment] [-position]; */
	#header		{width:auto; height:63px;
		font-family:Tahoma, sans-serif;
		font-size:12px;
	}
	#sidebar		{width:175px; height:500px; float:left; background:url(image/left_line.gif) repeat-y right top;
		font-family:Monaco, Verdana, Sans-serif;
		font-size:16px;
		color:#002166;
		line-height:2;
	}
	#body		{width:auto; height:auto; float:left;
		font-family:Lucida Grande, Verdana, Sans-serif;
		font-size:14px;
		color:#4F5155;
	}
	#footer		{width:auto; height:30px; clear:both; background:url(image/left_line.gif) repeat-x left top;
		font-family:Georgia, serif;
		font-size:12px;
		line-height:2em;
		letter-spacing:1px;
		text-align:center;
	}
	a:link {text-decoration:none; color:#000000;}
	a:visited {text-decoration:none; color:#000000;}
	a:hover {text-decoration:underline; color:#000000;}
	a:active {text-decoration:none; color:#000000;}
</style>
</head>
<body>
	<div id="container">
		<div id="header"><tiles:insertAttribute name="header" /></div>
		<div id="sidebar"><tiles:insertAttribute name="sidebar" /></div>
		<div id="body"><tiles:insertAttribute name="body" /></div>
		<div id="footer"><tiles:insertAttribute name="footer" /></div>
	</div>
</body>
</html>