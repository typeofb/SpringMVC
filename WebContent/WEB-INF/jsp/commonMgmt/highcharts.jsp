<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="js/jquery-1.4.3.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<!-- <script src="http://code.highcharts.com/highcharts-more.js"></script>
<script src="http://code.highcharts.com/modules/data.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script> -->
<script>
var areaChart;

$(document).ready(function(){
	areaChart = new Highcharts.Chart({
		chart: {
			plotBorderWidth: 1,
			renderTo: 'charDiv',
			type: 'area',
			events: {
				click: function(e) {
					//fnPopup();
				}
			}
		},
		credits: {
			enabled: false
		},
		title: {
			text: 'RMU 전력합계',
			style: {
                fontSize: '15px',
	            fontWeight: 'bold',
	            letterSpacing: '-1px',
				color: '#0c4da2'
			}
		},
		xAxis: {
			type: 'datetime',
			id: 'xAxis',
			dateTimeLabelFormats: {
				minute: '%H:%M',
				hour: '%H:%M'
			}
		},
		yAxis: {
			title: {
				text: 'kW'
			},
			min: 0,
			labels: {
				formatter: function() {
					return Highcharts.numberFormat(this.value, 0, '', ', ');
				}
			}
		},
		plotOptions: {
			spline: {
				lineWidth: 1,
				marker: {
					enabled: false,
					states: {
						hover: {
							enabled: true,
							radius: 5
						}
					}
				},
				shadow: false,
				states: {
					hover: {
						lineWidth: 1
					}
				},
				threshold: null
			},
			area: {
				fillColor: {
					linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1},
					stops: [
						[0, Highcharts.getOptions().colors[0]],
						[1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
					]
				},
				lineWidth: 1,
				marker: {
					enabled: false,
					states: {
						hover: {
							enabled: true,
							radius: 5
						}
					}
				},
				shadow: false,
				states: {
					hover: {
						lineWidth: 1
					}
				},
				threshold: null
			}
		},
		tooltip: {
			formatter: function() {
				return '<b>' + this.series.name + '</b><br/>' +
					Highcharts.dateFormat('%H:%M:%S', this.x) + '<br/>' +
					'<b>' + Highcharts.numberFormat(this.y, 0) + ' kW</b>';
			}
		},
		legend: {
			enabled: false
		},
		exporting: {
			enabled: false
		},
		series: [{
			//pointStart: Date.UTC(2010, 5, 21, 13, 33),
			pointInterval: 60 * 1000, // one minute
			name: '전력',
			data: []
		}]
	});
});

$(window).load(function(){
	areaChart.showLoading();
	var xAxis = areaChart.get('xAxis');
	var plots = xAxis['plotLinesAndBands'];

	$.ajax({
		url : "<c:url value='highchartsAjax.do' />",
		data: $("#hForm").serializeArray(),
		success : function(result) {
			areaChart.hideLoading();
			var chart = areaChart;
			chart.setTitle({text: "title"});
			//chart.xAxis[0].options.tickInterval = 3600 * 1000;
			var points = JSON.parse(result);
			var series = chart.series[0];
			series.setData(eval(points.data));
		},
		cache : false
	});
});
</script>

<h2>Highcharts</h2>
<form id="hForm" name="hForm" method="post">
	<input type="hidden" id="token" name="token" value="${sessionScope.token}" />
</form>
<div id="charDiv" style="width:500px; height:300px;"></div>