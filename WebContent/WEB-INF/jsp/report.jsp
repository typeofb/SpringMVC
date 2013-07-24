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
		fnSelectTag();
		
		$("#btnDetail").click(function() {
			/*$.post("reportAjax.do", $("#reportForm").serialize(), // data
				// success callback function
				function(data) {
					document.reportForm.result.value = data;
					$("#indexPage").load("reportDetail.do", $("#reportForm").serialize());
				}
			);*/
			// ajax 한글깨짐 개선
			$.ajax({
				type: "POST",
				url: "reportAjax.do",
				data: $("#reportForm").serializeArray(),
				success: function(data) {
					document.reportForm.result.value = data;
					$("#indexPage").load("reportDetail.do", $("#reportForm").serializeArray());
				}
			});
			return false;
		});
	});
	
	function fnSelectTag() {
		$.ajax({
			type: "POST",
			url: "reportSelect.do",
			data: $("#reportForm").serializeArray(),
			success: function(data) {
				$("#selectTag").html(data);
			}
		});
	}
</script>
</head>
<body>
	<div id="indexPage">
		<form id="reportForm" name="reportForm" method="post">
			<input type="hidden" name="token" value="${sessionScope.token}" />
			<input type="hidden" name="result" />
			<h4>Report Index Page</h4><br />
			<div>Ajax Move for this body</div><br />
			<input type="text" name="txtInput" />
			<input type="button" id="btnDetail" value="Click" />
			<div id="selectTag"></div>
		</form>
	</div>
</body>
</html>