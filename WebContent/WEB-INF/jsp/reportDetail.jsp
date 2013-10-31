<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script language="JavaScript" src="js/jquery-1.4.3.min.js"></script>
<script>
//$(window).load(function() {
$(function() {
	changeWeather();
	
	$("select").change(function() {
		changeWeather();
	});
	
	function changeWeather() {
		$.ajax({
			type: "POST",
			url: "reportProxy.do",
			data: {value:$("select option:selected").val()},
			success: function(data) {
				data = data.replace(/\.\.\//g, "http://www.e-kepco.co.kr/WEATHER/");
				$("#weather").html(data);
			}
		});
	}
});
</script>
<h4>Report Detail Page</h4><br />
<div>${message}</div>
<select>
	<option value="1">서울</option>
	<option value="2">경남지역본부</option>
	<option value="3">경북</option>
	<option value="4">제주</option>
	<option value="5">인천</option>
	<option value="6">경기도</option>
	<option value="7">광주전남</option>
	<option value="8">대전충남</option>
	<option value="9">충북</option>
	<option value="10">전북</option>
	<option value="11">부산</option>
	<option value="12">강원도</option>
	<option value="13">경기북부</option>
</select>
<div id="weather"></div>