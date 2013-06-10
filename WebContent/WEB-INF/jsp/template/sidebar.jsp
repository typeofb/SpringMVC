<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#sidebar {
		margin:0;
		padding:0;
		list-style-type:none;
	}
	#sidebar li {background:url(image/bullet_pro_red01.gif) no-repeat 5% center; padding-left:20px;}
    #sidebar li a:hover {background-color:#2a75b5; color:#e7f1fa;}
</style>
<script type="text/javascript">
	function fnMovePage(sidebarName) {
		document.sidebarForm.action = sidebarName;
		document.sidebarForm.submit();
	}
</script>
</head>
<body>
	<form name="sidebarForm" method="post">
		<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
		<ul id="sidebar">
			<li><a href="#" onclick="fnMovePage('hello.do'); return false;">Say Hello</a></li>
			<li><a href="#" onclick="fnMovePage('app.do'); return false;">Retrieve App</a></li>
			<li><a href="#" onclick="fnMovePage('contact.do'); return false;">Contact</a></li>
			<li><a href="#" onclick="fnMovePage('report.do'); return false;">Report Page</a></li>
		</ul>
	</form>
</body>
</html>