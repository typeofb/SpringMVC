<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.androider.co.kr</title>
<script src="js/jquery-1.4.3.min.js"></script>
<script src="js/jquery.form.js"></script>
<script src="js/json2.js"></script>
<script>
	$(document).ready(function() {
		$('#uploadForm').ajaxForm({
			beforeSubmit:function() {
				var result = document.getElementById("result").innerHTML = "<img src='image/loading.gif' alt='' />";
				result.display = "block";
			},
			success:function(data) {
				result.display = "none";
				var json = jQuery.parseJSON(data);
				$('#result').html(json.jsonResult);
				$('#fileDown').html(json.fileName);
			}
		});
	});

	function fnDownload(spanText) {
		document.downloadForm.fileName.value = spanText.innerText;
		document.downloadForm.action = "fileDownload.do";
		document.downloadForm.submit();
	}
</script>
</head>
<body>
	<div>${message}</div>
	<h2>File Upload</h2>
	<form id="uploadForm" method="post" enctype="multipart/form-data" action="fileUpload.do">
		<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
		<table>
			<tr>
				<td><input type="file" name="attachFile" /></td>
				<td><input type="submit" value="Upload" /></td>
			</tr>
		</table>
	</form>
	<div id="result"></div>
	
	<h2>File Download</h2>
	<form name="downloadForm" method="post">
		<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
		<input type="hidden" name="fileName" />
		<a href="#"><span id="fileDown" onclick="fnDownload(this); return false;"></span></a>
	</form>
</body>
</html>