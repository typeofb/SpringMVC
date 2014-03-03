<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
var pieChart;

$(document).ready(function(){
	pieChart = new Highcharts.Chart({
		chart : {
			renderTo : 'piechartDiv',
			plotBackgroundColor : null,
			plotBorderWidth : null,
			plotShadow : false
		},
		credits : {
			enabled : true,
			href : 'http://www.daumit.com',
			text : 'daumit.com'
		},
		exporting : {
			enabled : false
		},
		title : {
			text : '고객수 비율'
		},
		legend : {
			enabled : false
		},
		tooltip : {
			enabled : false
		},
		plotOptions : {
			pie : {
				allowPointSelect : false,
				dataLabels : {
					enabled : true,
					formatter : function() {
						return '<b>' + this.point.name + '</b> : '
							+ Math.round(this.percentage * 10) / 10 + ' %';
					}
				}
			}
		},
		series : [{
			type: 'pie',
			name : '',
			data : []
		}]
	});
});

$(window).load(function(){
	pieChart.showLoading();
	var series = pieChart.series[0];
	
	$.ajax({
		url : "<c:url value='piechartAjax.do' />",
		data: $("#hForm").serializeArray(),
		success : function(result) {
			pieChart.hideLoading();
			
			var points = JSON.parse(result);
			series.setData(points.data);
		},
		cache : false
	});
});
</script>
