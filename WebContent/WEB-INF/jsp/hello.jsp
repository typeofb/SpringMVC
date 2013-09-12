<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>www.androider.co.kr</title>
<script src="js/jquery-1.4.3.min.js"></script>
<script src="js/jquery.form.js"></script>
<script src="js/json2.js"></script>
<script src="<c:url value='/js/jquery.MultiFile.js'/>" type="text/javascript"></script>
<script>
	/*$(document).ready(function() {
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
	});*/
	
	$(document).ready(function() {
		$("#attachFile").MultiFile({
			accept : 'gif|jpg|bmp|png|jpeg', //허용할 확장자(지정하지 않으면 모든확장자 허용)
			max : 5, //업로드 최대파일갯수(지정하지 않으면 무제한)
			list: '#result', //파일목록을 보여줄 div id(지정하지 않으면 input 뒤에 붙는다.)
			STRING : {
				remove : '제거',
				selected : 'Selecionado: $file',
				denied : '$ext 는(은) 업로드 할 수 없는 파일확장자 입니다.',
				duplicate : '$file 는(은) 이미 추가된 파일입니다.'
			}/*,
			onFileRemove: function(element, value, master_element) {
				$('#result').append('<div>onFileRemove - '+value+'</div>');
			},
			afterFileRemove: function(element, value, master_element) {
				$('#result').append('<div>afterFileRemove - '+value+'</div>');
			},
			onFileAppend: function(element, value, master_element) {
				$('#result').append('<div>onFileAppend - '+master_element+'</div>');
			},
			afterFileAppend: function(element, value, master_element) {
				$('#result').append('<div>afterFileAppend - '+value+'</div>');
			},
			onFileSelect: function(element, value, master_element) {
				$('#result').append('<div>onFileSelect - '+value+'</div>');
			},
			afterFileSelect: function(element, value, master_element) {
				$('#result').append('<div>afterFileSelect - '+value+'</div>');
			}*/
		});
	});
	
	function fnUpload() {
		var options = {
			beforeSubmit:function() {
				var result = document.getElementById("result").innerHTML = "<img src='image/loading.gif' alt='' />";
				result.display = "block";
			},
			success:function(data) {
				result.display = "none";
				var json = jQuery.parseJSON(data);
				$('#result').html(json.jsonResult);
				for ( var i = 0; i < json.fileName.length; i++) {
					$('#resultDown').append("<a href='#'><div onclick='fnDownload(this); return false;'>" + json.fileName[i] + "</div></a>");
				}
			},
			url : "fileUpload.do",
			contentType : "multipart/form-data",
			dataType : "html"  /* xml, html, script, json */
		};
		$('#uploadForm').ajaxSubmit(options);
	}

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
	<form id="uploadForm" method="post">
		<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
		<table>
			<tr>
				<td><input type="file" id="attachFile" name="attachFile" /></td>
				<td><input type="button" value="Upload" onclick="fnUpload()" /></td>
			</tr>
		</table>
	</form>
	<div id="result"></div>
	
	<h2>File Download</h2>
	<form name="downloadForm" method="post">
		<input type="hidden" name="token" value="<%= session.getAttribute("token") %>" />
		<input type="hidden" name="fileName" />
		<div id="resultDown"></div>
	</form>
</body>
</html>