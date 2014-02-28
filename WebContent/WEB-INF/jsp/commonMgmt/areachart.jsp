<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
var areaChart;

$(document).ready(function(){
	areaChart = new Highcharts.Chart({
		chart: {
			plotBorderWidth: 1,
			renderTo: 'areachartDiv',
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
			text: 'title',
			style: {
                fontSize: '15px',
	            fontWeight: 'bold',
	            letterSpacing: '-1px',
				color: '#ae0141'
			}
		},
		xAxis: {
			type: 'datetime',
			id: 'xAxis',
			dateTimeLabelFormats: {
				minute: '%H:%M',
				hour: '%H:%M'
			},
			plotLines: [{
				color: '#ff0000',
				width: 1
			}, {
				color: '#0000ff',
				width: 1
			}]
		},
		yAxis: {
			title: {
				text: 'kW',
				style: {
					color: '#ae0141'
				}
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
						[0, Highcharts.getOptions().colors[3]],
						[1, Highcharts.Color(Highcharts.getOptions().colors[3]).setOpacity(0).get('rgba')]
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
		}, {
			color: '#00ff00',
			type: 'spline',
			name: '추정전력',
			data: []
		}]
	});
});

$(window).load(function(){
	areaChart.showLoading();
	var xAxis = areaChart.get('xAxis');
	
	var plots = xAxis['plotLinesAndBands'];
	var plot = plots[0]['options'];
	var plot2 = plots[1]['options'];
	var series = areaChart.series[0];
	var series2 = areaChart.series[1];

	$.ajax({
		url : "<c:url value='highchartsAjax.do' />",
		data: $("#hForm").serializeArray(),
		success : function(result) {
			areaChart.hideLoading();
			areaChart.setTitle({text: "RMU 전력합계"});
			
			var points = JSON.parse(result);
			plot['value'] = points.plot;
			plot2['value'] = points.plot2;
			series.setData(eval(points.data));
			series2.setData(eval(points.data2));
		},
		cache : false
	});
});
</script>
