<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript" src="js/jquery-1.4.3.min.js"></script>
<script>
	$(function() {
		$("#btnDetail").click(function() {
			$.post("report.do", $("#reportForm").serialize(), // data
				// success callback function
				function(data) {
					$("#indexPage").load("reportDetail.do", $("#reportForm").serialize());
				}
			);
			return false;
		});
	});
</script>
</head>
<body>
	<div id="indexPage">
		<form id="reportForm" method="post">
			<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
			<h4>Report Index Page</h4><br />
			<div>Ajax Move for this body</div><br />
			<input id="btnDetail" type="button" value="Click" />
		</form>
	</div>
</body>
</html>