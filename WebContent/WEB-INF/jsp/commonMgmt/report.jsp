<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
	#tabMenu {width:190px;} /* 메뉴가 늘어나면 폭도 늘려야 함 */
	#tabMenu ul {list-style-type:none; margin:0px; padding:0px;}
	#tabMenu li {float:left; padding:20px 2px 0px 0px;}
	#tabMenu li	span {border:1px solid #ddd; border-bottom:0px; padding-top:8px; cursor:pointer;}
	#tabMenu li.on span {border:1px solid #aaa; border-bottom:0px; padding-bottom:1px; background:#f5f5f5; font-weight:bold;}
	
	#tabMenu div {border:1px solid #aaa; background:#f5f5f5; display:none; clear:both; height:320px;}
</style>
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
		
		$("#tabMenu li").click(function() {
			$(this).parent().parent().find("div").hide();
			$(this).parent().parent().find("div").eq($(this).index()).show();
			$(this).parent().find("li").removeClass("on");
			$(this).addClass("on");
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
		<div id="tabMenu">
			<ul>
				<li class="on"><span>A Menu</span></li>
				<li><span>B Menu</span></li>
				<li><span>C Menu</span></li>
			</ul>
			<div class="apple" style="display:block;">Apple</div>
			<div class="book">Book</div>
			<div class="can">Can</div>
		</div>
	</form>
</div>