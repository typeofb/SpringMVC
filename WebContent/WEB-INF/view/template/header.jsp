<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#masterHeader {background:url(image/top_bg_c_11.gif) no-repeat right bottom;}
	#topNavi {width:2000px; height:44px; background:url(image/top_bg_l_11.gif) no-repeat left bottom;}
	#mainMenu {margin:5px; padding:5px;}
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
	function fnMovePage(menuNo) { }

	function fnMenuToggle(obj) { }
</script>
</head>
<body>
	<span style="float:left; margin-left:10px;"><%= request.getSession().getAttribute("token") %></span>
	<span style="float:right; margin-right:10px;"><a href="logout.do">Logout</a></span><br />
	<div id="masterHeader">
		<div id="topNavi">
			<ul id="mainMenu">
				<li><span><a href="javascript:fnMovePage('1000000');" onclick="fnMenuToggle(this);">User Mgmt</a></span></li>
				<li><span><a href="javascript:fnMovePage('2000000');" onclick="fnMenuToggle(this);">Service Mgmt</a></span></li>
				<li><span><a href="javascript:fnMovePage('3000000');" onclick="fnMenuToggle(this);">Service Monitoring</a></span></li>
				<li><span><a href="javascript:fnMovePage('4000000');" onclick="fnMenuToggle(this);">Common Mgmt</a></span></li>
			</ul>
		</div>
	</div>
</body>
</html>