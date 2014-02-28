<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
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
					document.reportForm.result.value = $("select[id='selArea'] option:selected").text() + ", " + $("select[id='selLoc'] option:selected").text();
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
				fnSelectTag2();
			}
		});
	}
	
	function fnSelectTag2() {
		$.ajax({
			type: "POST",
			url: "reportSelect2.do",
			data: $("#reportForm").serializeArray(),
			success: function(data) {
				$("#selectTag2").html(data);
				$("#selLoc").val(5570);  // default local
			}
		});
	}
</script>

<div id="indexPage">
	<form id="reportForm" name="reportForm" method="post">
		<input type="hidden" name="token" value="${sessionScope.token}" />
		<input type="hidden" name="result" />
		<h4>Report Index Page</h4>
		<div>Ajax Move for this body</div>
		<input type="text" name="txtInput" />
		<input type="button" id="btnDetail" value="Ajax Proxy" />
		<div>
			<span id="selectTag"></span>
			<span id="selectTag2"></span>
		</div>
	</form>
</div>