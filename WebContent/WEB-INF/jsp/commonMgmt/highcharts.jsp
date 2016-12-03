<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="js/jquery-1.4.3.min.js"></script>
<script src="js/highcharts.js"></script>
<!-- <script src="http://code.highcharts.com/highcharts-more.js"></script>
<script src="http://code.highcharts.com/modules/data.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script> -->
<script>
$(document).ready(function(){
	$("#tabMenu li").click(function() {
		$(this).parent().find("li").removeClass("on");
		$(this).addClass("on");

		if ($(this).index() == 0) {
			$(".tab_m1").show();
			$(".tab_m2").hide();
			$(".tab_m3").hide();
		} else if ($(this).index() == 1) {
			$(".tab_m2").show();
			$(".tab_m1").hide();
			$(".tab_m3").hide();
		} else if ($(this).index() == 2) {
			$(".tab_m3").show();
			$(".tab_m1").hide();
			$(".tab_m2").hide();
		}
	});
});
</script>
<%@ include file="areachart.jsp"%>
<%@ include file="piechart.jsp"%>

<form id="hForm" name="hForm" method="post">
	<input type="hidden" id="token" name="token" value="${sessionScope.token}" />
</form>
<div id="tabMenu">
	<ul>
		<li class="on"><span>Area chart</span></li>
		<li><span>Pie chart</span></li>
		<li><span>Another</span></li>
	</ul>
	<div id="areachartDiv" class="tab_m1" style="display: block;"></div>
	<div id="piechartDiv" class="tab_m2" style="display: none;"></div>
	<div class="tab_m3" style="display: none;">Another</div>
</div>